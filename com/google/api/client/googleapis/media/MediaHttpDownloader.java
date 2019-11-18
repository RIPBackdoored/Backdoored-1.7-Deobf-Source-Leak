package com.google.api.client.googleapis.media;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

public final class MediaHttpDownloader {
   public static final int MAXIMUM_CHUNK_SIZE = 33554432;
   private final HttpRequestFactory requestFactory;
   private final HttpTransport transport;
   private boolean directDownloadEnabled = false;
   private MediaHttpDownloaderProgressListener progressListener;
   private int chunkSize = 33554432;
   private long mediaContentLength;
   private MediaHttpDownloader$DownloadState downloadState;
   private long bytesDownloaded;
   private long lastBytePos;

   public MediaHttpDownloader(HttpTransport transport, HttpRequestInitializer httpRequestInitializer) {
      this.downloadState = MediaHttpDownloader$DownloadState.NOT_STARTED;
      this.lastBytePos = -1L;
      this.transport = (HttpTransport)Preconditions.checkNotNull(transport);
      this.requestFactory = httpRequestInitializer == null ? transport.createRequestFactory() : transport.createRequestFactory(httpRequestInitializer);
   }

   public void download(GenericUrl requestUrl, OutputStream outputStream) throws IOException {
      this.download(requestUrl, (HttpHeaders)null, outputStream);
   }

   public void download(GenericUrl requestUrl, HttpHeaders requestHeaders, OutputStream outputStream) throws IOException {
      Preconditions.checkArgument(this.downloadState == MediaHttpDownloader$DownloadState.NOT_STARTED);
      requestUrl.put("alt", "media");
      if (this.directDownloadEnabled) {
         this.updateStateAndNotifyListener(MediaHttpDownloader$DownloadState.MEDIA_IN_PROGRESS);
         HttpResponse response = this.executeCurrentRequest(this.lastBytePos, requestUrl, requestHeaders, outputStream);
         this.mediaContentLength = response.getHeaders().getContentLength();
         this.bytesDownloaded = this.mediaContentLength;
         this.updateStateAndNotifyListener(MediaHttpDownloader$DownloadState.MEDIA_COMPLETE);
      } else {
         while(true) {
            long currentRequestLastBytePos = this.bytesDownloaded + (long)this.chunkSize - 1L;
            if (this.lastBytePos != -1L) {
               currentRequestLastBytePos = Math.min(this.lastBytePos, currentRequestLastBytePos);
            }

            HttpResponse response = this.executeCurrentRequest(currentRequestLastBytePos, requestUrl, requestHeaders, outputStream);
            String contentRange = response.getHeaders().getContentRange();
            long nextByteIndex = this.getNextByteIndex(contentRange);
            this.setMediaContentLength(contentRange);
            if (this.mediaContentLength <= nextByteIndex) {
               this.bytesDownloaded = this.mediaContentLength;
               this.updateStateAndNotifyListener(MediaHttpDownloader$DownloadState.MEDIA_COMPLETE);
               return;
            }

            this.bytesDownloaded = nextByteIndex;
            this.updateStateAndNotifyListener(MediaHttpDownloader$DownloadState.MEDIA_IN_PROGRESS);
         }
      }
   }

   private HttpResponse executeCurrentRequest(long currentRequestLastBytePos, GenericUrl requestUrl, HttpHeaders requestHeaders, OutputStream outputStream) throws IOException {
      HttpRequest request = this.requestFactory.buildGetRequest(requestUrl);
      if (requestHeaders != null) {
         request.getHeaders().putAll(requestHeaders);
      }

      if (this.bytesDownloaded != 0L || currentRequestLastBytePos != -1L) {
         StringBuilder rangeHeader = new StringBuilder();
         rangeHeader.append("bytes=").append(this.bytesDownloaded).append("-");
         if (currentRequestLastBytePos != -1L) {
            rangeHeader.append(currentRequestLastBytePos);
         }

         request.getHeaders().setRange(rangeHeader.toString());
      }

      HttpResponse response = request.execute();

      try {
         IOUtils.copy(response.getContent(), outputStream);
      } finally {
         response.disconnect();
      }

      return response;
   }

   private long getNextByteIndex(String rangeHeader) {
      return rangeHeader == null ? 0L : Long.parseLong(rangeHeader.substring(rangeHeader.indexOf(45) + 1, rangeHeader.indexOf(47))) + 1L;
   }

   public MediaHttpDownloader setBytesDownloaded(long bytesDownloaded) {
      Preconditions.checkArgument(bytesDownloaded >= 0L);
      this.bytesDownloaded = bytesDownloaded;
      return this;
   }

   public MediaHttpDownloader setContentRange(long firstBytePos, int lastBytePos) {
      Preconditions.checkArgument((long)lastBytePos >= firstBytePos);
      this.setBytesDownloaded(firstBytePos);
      this.lastBytePos = (long)lastBytePos;
      return this;
   }

   private void setMediaContentLength(String rangeHeader) {
      if (rangeHeader != null) {
         if (this.mediaContentLength == 0L) {
            this.mediaContentLength = Long.parseLong(rangeHeader.substring(rangeHeader.indexOf(47) + 1));
         }

      }
   }

   public boolean isDirectDownloadEnabled() {
      return this.directDownloadEnabled;
   }

   public MediaHttpDownloader setDirectDownloadEnabled(boolean directDownloadEnabled) {
      this.directDownloadEnabled = directDownloadEnabled;
      return this;
   }

   public MediaHttpDownloader setProgressListener(MediaHttpDownloaderProgressListener progressListener) {
      this.progressListener = progressListener;
      return this;
   }

   public MediaHttpDownloaderProgressListener getProgressListener() {
      return this.progressListener;
   }

   public HttpTransport getTransport() {
      return this.transport;
   }

   public MediaHttpDownloader setChunkSize(int chunkSize) {
      Preconditions.checkArgument(chunkSize > 0 && chunkSize <= 33554432);
      this.chunkSize = chunkSize;
      return this;
   }

   public int getChunkSize() {
      return this.chunkSize;
   }

   public long getNumBytesDownloaded() {
      return this.bytesDownloaded;
   }

   public long getLastBytePosition() {
      return this.lastBytePos;
   }

   private void updateStateAndNotifyListener(MediaHttpDownloader$DownloadState downloadState) throws IOException {
      this.downloadState = downloadState;
      if (this.progressListener != null) {
         this.progressListener.progressChanged(this);
      }

   }

   public MediaHttpDownloader$DownloadState getDownloadState() {
      return this.downloadState;
   }

   public double getProgress() {
      return this.mediaContentLength == 0L ? 0.0D : (double)this.bytesDownloaded / (double)this.mediaContentLength;
   }
}
