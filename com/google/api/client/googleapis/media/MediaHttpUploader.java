package com.google.api.client.googleapis.media;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ByteStreams;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class MediaHttpUploader {
   public static final String CONTENT_LENGTH_HEADER = "X-Upload-Content-Length";
   public static final String CONTENT_TYPE_HEADER = "X-Upload-Content-Type";
   private MediaHttpUploader$UploadState uploadState;
   static final int MB = 1048576;
   private static final int KB = 1024;
   public static final int MINIMUM_CHUNK_SIZE = 262144;
   public static final int DEFAULT_CHUNK_SIZE = 10485760;
   private final AbstractInputStreamContent mediaContent;
   private final HttpRequestFactory requestFactory;
   private final HttpTransport transport;
   private HttpContent metadata;
   private long mediaContentLength;
   private boolean isMediaContentLengthCalculated;
   private String initiationRequestMethod;
   private HttpHeaders initiationHeaders;
   private HttpRequest currentRequest;
   private InputStream contentInputStream;
   private boolean directUploadEnabled;
   private MediaHttpUploaderProgressListener progressListener;
   String mediaContentLengthStr;
   private long totalBytesServerReceived;
   private int chunkSize;
   private Byte cachedByte;
   private long totalBytesClientSent;
   private int currentChunkLength;
   private byte[] currentRequestContentBuffer;
   private boolean disableGZipContent;
   Sleeper sleeper;

   public MediaHttpUploader(AbstractInputStreamContent mediaContent, HttpTransport transport, HttpRequestInitializer httpRequestInitializer) {
      this.uploadState = MediaHttpUploader$UploadState.NOT_STARTED;
      this.initiationRequestMethod = "POST";
      this.initiationHeaders = new HttpHeaders();
      this.mediaContentLengthStr = "*";
      this.chunkSize = 10485760;
      this.sleeper = Sleeper.DEFAULT;
      this.mediaContent = (AbstractInputStreamContent)Preconditions.checkNotNull(mediaContent);
      this.transport = (HttpTransport)Preconditions.checkNotNull(transport);
      this.requestFactory = httpRequestInitializer == null ? transport.createRequestFactory() : transport.createRequestFactory(httpRequestInitializer);
   }

   public HttpResponse upload(GenericUrl initiationRequestUrl) throws IOException {
      Preconditions.checkArgument(this.uploadState == MediaHttpUploader$UploadState.NOT_STARTED);
      return this.directUploadEnabled ? this.directUpload(initiationRequestUrl) : this.resumableUpload(initiationRequestUrl);
   }

   private HttpResponse directUpload(GenericUrl initiationRequestUrl) throws IOException {
      this.updateStateAndNotifyListener(MediaHttpUploader$UploadState.MEDIA_IN_PROGRESS);
      HttpContent content = this.mediaContent;
      if (this.metadata != null) {
         content = (new MultipartContent()).setContentParts(Arrays.asList(this.metadata, this.mediaContent));
         initiationRequestUrl.put("uploadType", "multipart");
      } else {
         initiationRequestUrl.put("uploadType", "media");
      }

      HttpRequest request = this.requestFactory.buildRequest(this.initiationRequestMethod, initiationRequestUrl, (HttpContent)content);
      request.getHeaders().putAll(this.initiationHeaders);
      HttpResponse response = this.executeCurrentRequest(request);
      boolean responseProcessed = false;

      try {
         if (this.isMediaLengthKnown()) {
            this.totalBytesServerReceived = this.getMediaContentLength();
         }

         this.updateStateAndNotifyListener(MediaHttpUploader$UploadState.MEDIA_COMPLETE);
         responseProcessed = true;
      } finally {
         if (!responseProcessed) {
            response.disconnect();
         }

      }

      return response;
   }

   private HttpResponse resumableUpload(GenericUrl initiationRequestUrl) throws IOException {
      HttpResponse initialResponse = this.executeUploadInitiation(initiationRequestUrl);
      if (!initialResponse.isSuccessStatusCode()) {
         return initialResponse;
      } else {
         GenericUrl uploadUrl;
         try {
            uploadUrl = new GenericUrl(initialResponse.getHeaders().getLocation());
         } finally {
            initialResponse.disconnect();
         }

         this.contentInputStream = this.mediaContent.getInputStream();
         if (!this.contentInputStream.markSupported() && this.isMediaLengthKnown()) {
            this.contentInputStream = new BufferedInputStream(this.contentInputStream);
         }

         while(true) {
            this.currentRequest = this.requestFactory.buildPutRequest(uploadUrl, (HttpContent)null);
            this.setContentAndHeadersOnCurrentRequest();
            new MediaUploadErrorHandler(this, this.currentRequest);
            HttpResponse response;
            if (this.isMediaLengthKnown()) {
               response = this.executeCurrentRequestWithoutGZip(this.currentRequest);
            } else {
               response = this.executeCurrentRequest(this.currentRequest);
            }

            boolean returningResponse = false;

            HttpResponse var6;
            try {
               if (response.isSuccessStatusCode()) {
                  this.totalBytesServerReceived = this.getMediaContentLength();
                  if (this.mediaContent.getCloseInputStream()) {
                     this.contentInputStream.close();
                  }

                  this.updateStateAndNotifyListener(MediaHttpUploader$UploadState.MEDIA_COMPLETE);
                  returningResponse = true;
                  var6 = response;
                  return var6;
               }

               if (response.getStatusCode() == 308) {
                  String updatedUploadUrl = response.getHeaders().getLocation();
                  if (updatedUploadUrl != null) {
                     uploadUrl = new GenericUrl(updatedUploadUrl);
                  }

                  long newBytesServerReceived = this.getNextByteIndex(response.getHeaders().getRange());
                  long currentBytesServerReceived = newBytesServerReceived - this.totalBytesServerReceived;
                  Preconditions.checkState(currentBytesServerReceived >= 0L && currentBytesServerReceived <= (long)this.currentChunkLength);
                  long copyBytes = (long)this.currentChunkLength - currentBytesServerReceived;
                  if (this.isMediaLengthKnown()) {
                     if (copyBytes > 0L) {
                        this.contentInputStream.reset();
                        long actualSkipValue = this.contentInputStream.skip(currentBytesServerReceived);
                        Preconditions.checkState(currentBytesServerReceived == actualSkipValue);
                     }
                  } else if (copyBytes == 0L) {
                     this.currentRequestContentBuffer = null;
                  }

                  this.totalBytesServerReceived = newBytesServerReceived;
                  this.updateStateAndNotifyListener(MediaHttpUploader$UploadState.MEDIA_IN_PROGRESS);
                  continue;
               }

               returningResponse = true;
               var6 = response;
            } finally {
               if (!returningResponse) {
                  response.disconnect();
               }

            }

            return var6;
         }
      }
   }

   private boolean isMediaLengthKnown() throws IOException {
      return this.getMediaContentLength() >= 0L;
   }

   private long getMediaContentLength() throws IOException {
      if (!this.isMediaContentLengthCalculated) {
         this.mediaContentLength = this.mediaContent.getLength();
         this.isMediaContentLengthCalculated = true;
      }

      return this.mediaContentLength;
   }

   private HttpResponse executeUploadInitiation(GenericUrl initiationRequestUrl) throws IOException {
      this.updateStateAndNotifyListener(MediaHttpUploader$UploadState.INITIATION_STARTED);
      initiationRequestUrl.put("uploadType", "resumable");
      HttpContent content = this.metadata == null ? new EmptyContent() : this.metadata;
      HttpRequest request = this.requestFactory.buildRequest(this.initiationRequestMethod, initiationRequestUrl, (HttpContent)content);
      this.initiationHeaders.set("X-Upload-Content-Type", this.mediaContent.getType());
      if (this.isMediaLengthKnown()) {
         this.initiationHeaders.set("X-Upload-Content-Length", this.getMediaContentLength());
      }

      request.getHeaders().putAll(this.initiationHeaders);
      HttpResponse response = this.executeCurrentRequest(request);
      boolean notificationCompleted = false;

      try {
         this.updateStateAndNotifyListener(MediaHttpUploader$UploadState.INITIATION_COMPLETE);
         notificationCompleted = true;
      } finally {
         if (!notificationCompleted) {
            response.disconnect();
         }

      }

      return response;
   }

   private HttpResponse executeCurrentRequestWithoutGZip(HttpRequest request) throws IOException {
      (new MethodOverride()).intercept(request);
      request.setThrowExceptionOnExecuteError(false);
      HttpResponse response = request.execute();
      return response;
   }

   private HttpResponse executeCurrentRequest(HttpRequest request) throws IOException {
      if (!this.disableGZipContent && !(request.getContent() instanceof EmptyContent)) {
         request.setEncoding(new GZipEncoding());
      }

      HttpResponse response = this.executeCurrentRequestWithoutGZip(request);
      return response;
   }

   private void setContentAndHeadersOnCurrentRequest() throws IOException {
      int blockSize;
      if (this.isMediaLengthKnown()) {
         blockSize = (int)Math.min((long)this.chunkSize, this.getMediaContentLength() - this.totalBytesServerReceived);
      } else {
         blockSize = this.chunkSize;
      }

      int actualBlockSize = blockSize;
      Object contentChunk;
      if (this.isMediaLengthKnown()) {
         this.contentInputStream.mark(blockSize);
         InputStream limitInputStream = ByteStreams.limit(this.contentInputStream, (long)blockSize);
         contentChunk = (new InputStreamContent(this.mediaContent.getType(), limitInputStream)).setRetrySupported(true).setLength((long)blockSize).setCloseInputStream(false);
         this.mediaContentLengthStr = String.valueOf(this.getMediaContentLength());
      } else {
         int copyBytes = 0;
         int bytesAllowedToRead;
         if (this.currentRequestContentBuffer == null) {
            bytesAllowedToRead = this.cachedByte == null ? blockSize + 1 : blockSize;
            this.currentRequestContentBuffer = new byte[blockSize + 1];
            if (this.cachedByte != null) {
               this.currentRequestContentBuffer[0] = this.cachedByte;
            }
         } else {
            copyBytes = (int)(this.totalBytesClientSent - this.totalBytesServerReceived);
            System.arraycopy(this.currentRequestContentBuffer, this.currentChunkLength - copyBytes, this.currentRequestContentBuffer, 0, copyBytes);
            if (this.cachedByte != null) {
               this.currentRequestContentBuffer[copyBytes] = this.cachedByte;
            }

            bytesAllowedToRead = blockSize - copyBytes;
         }

         int actualBytesRead = ByteStreams.read(this.contentInputStream, this.currentRequestContentBuffer, blockSize + 1 - bytesAllowedToRead, bytesAllowedToRead);
         if (actualBytesRead < bytesAllowedToRead) {
            actualBlockSize = copyBytes + Math.max(0, actualBytesRead);
            if (this.cachedByte != null) {
               ++actualBlockSize;
               this.cachedByte = null;
            }

            if (this.mediaContentLengthStr.equals("*")) {
               this.mediaContentLengthStr = String.valueOf(this.totalBytesServerReceived + (long)actualBlockSize);
            }
         } else {
            this.cachedByte = this.currentRequestContentBuffer[blockSize];
         }

         contentChunk = new ByteArrayContent(this.mediaContent.getType(), this.currentRequestContentBuffer, 0, actualBlockSize);
         this.totalBytesClientSent = this.totalBytesServerReceived + (long)actualBlockSize;
      }

      this.currentChunkLength = actualBlockSize;
      this.currentRequest.setContent((HttpContent)contentChunk);
      HttpHeaders var10000;
      if (actualBlockSize == 0) {
         var10000 = this.currentRequest.getHeaders();
         String var10002 = String.valueOf(this.mediaContentLengthStr);
         String var10001;
         if (var10002.length() != 0) {
            var10001 = "bytes */".concat(var10002);
         } else {
            String var10003 = new String;
            var10001 = var10003;
            var10003.<init>("bytes */");
         }

         var10000.setContentRange(var10001);
      } else {
         var10000 = this.currentRequest.getHeaders();
         long var10 = this.totalBytesServerReceived;
         long var11 = this.totalBytesServerReceived + (long)actualBlockSize - 1L;
         String var8 = String.valueOf(String.valueOf(this.mediaContentLengthStr));
         var10000.setContentRange((new StringBuilder(48 + var8.length())).append("bytes ").append(var10).append("-").append(var11).append("/").append(var8).toString());
      }

   }

   @Beta
   @Beta
   void serverErrorCallback() throws IOException {
      Preconditions.checkNotNull(this.currentRequest, "The current request should not be null");
      this.currentRequest.setContent(new EmptyContent());
      HttpHeaders var10000 = this.currentRequest.getHeaders();
      String var10002 = String.valueOf(this.mediaContentLengthStr);
      String var10001;
      if (var10002.length() != 0) {
         var10001 = "bytes */".concat(var10002);
      } else {
         String var10003 = new String;
         var10001 = var10003;
         var10003.<init>("bytes */");
      }

      var10000.setContentRange(var10001);
   }

   private long getNextByteIndex(String rangeHeader) {
      return rangeHeader == null ? 0L : Long.parseLong(rangeHeader.substring(rangeHeader.indexOf(45) + 1)) + 1L;
   }

   public HttpContent getMetadata() {
      return this.metadata;
   }

   public MediaHttpUploader setMetadata(HttpContent metadata) {
      this.metadata = metadata;
      return this;
   }

   public HttpContent getMediaContent() {
      return this.mediaContent;
   }

   public HttpTransport getTransport() {
      return this.transport;
   }

   public MediaHttpUploader setDirectUploadEnabled(boolean directUploadEnabled) {
      this.directUploadEnabled = directUploadEnabled;
      return this;
   }

   public boolean isDirectUploadEnabled() {
      return this.directUploadEnabled;
   }

   public MediaHttpUploader setProgressListener(MediaHttpUploaderProgressListener progressListener) {
      this.progressListener = progressListener;
      return this;
   }

   public MediaHttpUploaderProgressListener getProgressListener() {
      return this.progressListener;
   }

   public MediaHttpUploader setChunkSize(int chunkSize) {
      Preconditions.checkArgument(chunkSize > 0 && chunkSize % 262144 == 0, "chunkSize must be a positive multiple of 262144.");
      this.chunkSize = chunkSize;
      return this;
   }

   public int getChunkSize() {
      return this.chunkSize;
   }

   public boolean getDisableGZipContent() {
      return this.disableGZipContent;
   }

   public MediaHttpUploader setDisableGZipContent(boolean disableGZipContent) {
      this.disableGZipContent = disableGZipContent;
      return this;
   }

   public Sleeper getSleeper() {
      return this.sleeper;
   }

   public MediaHttpUploader setSleeper(Sleeper sleeper) {
      this.sleeper = sleeper;
      return this;
   }

   public String getInitiationRequestMethod() {
      return this.initiationRequestMethod;
   }

   public MediaHttpUploader setInitiationRequestMethod(String initiationRequestMethod) {
      Preconditions.checkArgument(initiationRequestMethod.equals("POST") || initiationRequestMethod.equals("PUT") || initiationRequestMethod.equals("PATCH"));
      this.initiationRequestMethod = initiationRequestMethod;
      return this;
   }

   public MediaHttpUploader setInitiationHeaders(HttpHeaders initiationHeaders) {
      this.initiationHeaders = initiationHeaders;
      return this;
   }

   public HttpHeaders getInitiationHeaders() {
      return this.initiationHeaders;
   }

   public long getNumBytesUploaded() {
      return this.totalBytesServerReceived;
   }

   private void updateStateAndNotifyListener(MediaHttpUploader$UploadState uploadState) throws IOException {
      this.uploadState = uploadState;
      if (this.progressListener != null) {
         this.progressListener.progressChanged(this);
      }

   }

   public MediaHttpUploader$UploadState getUploadState() {
      return this.uploadState;
   }

   public double getProgress() throws IOException {
      Preconditions.checkArgument(this.isMediaLengthKnown(), "Cannot call getProgress() if the specified AbstractInputStreamContent has no content length. Use  getNumBytesUploaded() to denote progress instead.");
      return this.getMediaContentLength() == 0L ? 0.0D : (double)this.totalBytesServerReceived / (double)this.getMediaContentLength();
   }
}
