package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StreamingContent;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HttpRequest {
   public static final String VERSION = "1.25.0";
   public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.25.0 (gzip)";
   public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
   private HttpExecuteInterceptor executeInterceptor;
   private HttpHeaders headers = new HttpHeaders();
   private HttpHeaders responseHeaders = new HttpHeaders();
   private int numRetries = 10;
   private int contentLoggingLimit = 16384;
   private boolean loggingEnabled = true;
   private boolean curlLoggingEnabled = true;
   private HttpContent content;
   private final HttpTransport transport;
   private String requestMethod;
   private GenericUrl url;
   private int connectTimeout = 20000;
   private int readTimeout = 20000;
   private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
   @Beta
   private HttpIOExceptionHandler ioExceptionHandler;
   private HttpResponseInterceptor responseInterceptor;
   private ObjectParser objectParser;
   private HttpEncoding encoding;
   /** @deprecated */
   @Deprecated
   @Beta
   private BackOffPolicy backOffPolicy;
   private boolean followRedirects = true;
   private boolean throwExceptionOnExecuteError = true;
   /** @deprecated */
   @Deprecated
   @Beta
   private boolean retryOnExecuteIOException = false;
   private boolean suppressUserAgentSuffix;
   private Sleeper sleeper;

   HttpRequest(HttpTransport transport, String requestMethod) {
      this.sleeper = Sleeper.DEFAULT;
      this.transport = transport;
      this.setRequestMethod(requestMethod);
   }

   public HttpTransport getTransport() {
      return this.transport;
   }

   public String getRequestMethod() {
      return this.requestMethod;
   }

   public HttpRequest setRequestMethod(String requestMethod) {
      Preconditions.checkArgument(requestMethod == null || HttpMediaType.matchesToken(requestMethod));
      this.requestMethod = requestMethod;
      return this;
   }

   public GenericUrl getUrl() {
      return this.url;
   }

   public HttpRequest setUrl(GenericUrl url) {
      this.url = (GenericUrl)Preconditions.checkNotNull(url);
      return this;
   }

   public HttpContent getContent() {
      return this.content;
   }

   public HttpRequest setContent(HttpContent content) {
      this.content = content;
      return this;
   }

   public HttpEncoding getEncoding() {
      return this.encoding;
   }

   public HttpRequest setEncoding(HttpEncoding encoding) {
      this.encoding = encoding;
      return this;
   }

   /** @deprecated */
   @Deprecated
   @Beta
   public BackOffPolicy getBackOffPolicy() {
      return this.backOffPolicy;
   }

   /** @deprecated */
   @Deprecated
   @Beta
   public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
      this.backOffPolicy = backOffPolicy;
      return this;
   }

   public int getContentLoggingLimit() {
      return this.contentLoggingLimit;
   }

   public HttpRequest setContentLoggingLimit(int contentLoggingLimit) {
      Preconditions.checkArgument(contentLoggingLimit >= 0, "The content logging limit must be non-negative.");
      this.contentLoggingLimit = contentLoggingLimit;
      return this;
   }

   public boolean isLoggingEnabled() {
      return this.loggingEnabled;
   }

   public HttpRequest setLoggingEnabled(boolean loggingEnabled) {
      this.loggingEnabled = loggingEnabled;
      return this;
   }

   public boolean isCurlLoggingEnabled() {
      return this.curlLoggingEnabled;
   }

   public HttpRequest setCurlLoggingEnabled(boolean curlLoggingEnabled) {
      this.curlLoggingEnabled = curlLoggingEnabled;
      return this;
   }

   public int getConnectTimeout() {
      return this.connectTimeout;
   }

   public HttpRequest setConnectTimeout(int connectTimeout) {
      Preconditions.checkArgument(connectTimeout >= 0);
      this.connectTimeout = connectTimeout;
      return this;
   }

   public int getReadTimeout() {
      return this.readTimeout;
   }

   public HttpRequest setReadTimeout(int readTimeout) {
      Preconditions.checkArgument(readTimeout >= 0);
      this.readTimeout = readTimeout;
      return this;
   }

   public HttpHeaders getHeaders() {
      return this.headers;
   }

   public HttpRequest setHeaders(HttpHeaders headers) {
      this.headers = (HttpHeaders)Preconditions.checkNotNull(headers);
      return this;
   }

   public HttpHeaders getResponseHeaders() {
      return this.responseHeaders;
   }

   public HttpRequest setResponseHeaders(HttpHeaders responseHeaders) {
      this.responseHeaders = (HttpHeaders)Preconditions.checkNotNull(responseHeaders);
      return this;
   }

   public HttpExecuteInterceptor getInterceptor() {
      return this.executeInterceptor;
   }

   public HttpRequest setInterceptor(HttpExecuteInterceptor interceptor) {
      this.executeInterceptor = interceptor;
      return this;
   }

   public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
      return this.unsuccessfulResponseHandler;
   }

   public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler) {
      this.unsuccessfulResponseHandler = unsuccessfulResponseHandler;
      return this;
   }

   @Beta
   public HttpIOExceptionHandler getIOExceptionHandler() {
      return this.ioExceptionHandler;
   }

   @Beta
   public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler ioExceptionHandler) {
      this.ioExceptionHandler = ioExceptionHandler;
      return this;
   }

   public HttpResponseInterceptor getResponseInterceptor() {
      return this.responseInterceptor;
   }

   public HttpRequest setResponseInterceptor(HttpResponseInterceptor responseInterceptor) {
      this.responseInterceptor = responseInterceptor;
      return this;
   }

   public int getNumberOfRetries() {
      return this.numRetries;
   }

   public HttpRequest setNumberOfRetries(int numRetries) {
      Preconditions.checkArgument(numRetries >= 0);
      this.numRetries = numRetries;
      return this;
   }

   public HttpRequest setParser(ObjectParser parser) {
      this.objectParser = parser;
      return this;
   }

   public final ObjectParser getParser() {
      return this.objectParser;
   }

   public boolean getFollowRedirects() {
      return this.followRedirects;
   }

   public HttpRequest setFollowRedirects(boolean followRedirects) {
      this.followRedirects = followRedirects;
      return this;
   }

   public boolean getThrowExceptionOnExecuteError() {
      return this.throwExceptionOnExecuteError;
   }

   public HttpRequest setThrowExceptionOnExecuteError(boolean throwExceptionOnExecuteError) {
      this.throwExceptionOnExecuteError = throwExceptionOnExecuteError;
      return this;
   }

   /** @deprecated */
   @Deprecated
   @Beta
   public boolean getRetryOnExecuteIOException() {
      return this.retryOnExecuteIOException;
   }

   /** @deprecated */
   @Deprecated
   @Beta
   public HttpRequest setRetryOnExecuteIOException(boolean retryOnExecuteIOException) {
      this.retryOnExecuteIOException = retryOnExecuteIOException;
      return this;
   }

   public boolean getSuppressUserAgentSuffix() {
      return this.suppressUserAgentSuffix;
   }

   public HttpRequest setSuppressUserAgentSuffix(boolean suppressUserAgentSuffix) {
      this.suppressUserAgentSuffix = suppressUserAgentSuffix;
      return this;
   }

   public HttpResponse execute() throws IOException {
      boolean retryRequest = false;
      Preconditions.checkArgument(this.numRetries >= 0);
      int retriesRemaining = this.numRetries;
      if (this.backOffPolicy != null) {
         this.backOffPolicy.reset();
      }

      HttpResponse response = null;
      Preconditions.checkNotNull(this.requestMethod);
      Preconditions.checkNotNull(this.url);

      IOException executeException;
      do {
         if (response != null) {
            response.ignore();
         }

         response = null;
         executeException = null;
         if (this.executeInterceptor != null) {
            this.executeInterceptor.intercept(this);
         }

         String urlString = this.url.build();
         LowLevelHttpRequest lowLevelHttpRequest = this.transport.buildRequest(this.requestMethod, urlString);
         Logger logger = HttpTransport.LOGGER;
         boolean loggable = this.loggingEnabled && logger.isLoggable(Level.CONFIG);
         StringBuilder logbuf = null;
         StringBuilder curlbuf = null;
         if (loggable) {
            logbuf = new StringBuilder();
            logbuf.append("-------------- REQUEST  --------------").append(StringUtils.LINE_SEPARATOR);
            logbuf.append(this.requestMethod).append(' ').append(urlString).append(StringUtils.LINE_SEPARATOR);
            if (this.curlLoggingEnabled) {
               curlbuf = new StringBuilder("curl -v --compressed");
               if (!this.requestMethod.equals("GET")) {
                  curlbuf.append(" -X ").append(this.requestMethod);
               }
            }
         }

         String originalUserAgent = this.headers.getUserAgent();
         if (!this.suppressUserAgentSuffix) {
            if (originalUserAgent == null) {
               this.headers.setUserAgent("Google-HTTP-Java-Client/1.25.0 (gzip)");
            } else {
               this.headers.setUserAgent(originalUserAgent + " " + "Google-HTTP-Java-Client/1.25.0 (gzip)");
            }
         }

         HttpHeaders.serializeHeaders(this.headers, logbuf, curlbuf, logger, lowLevelHttpRequest);
         if (!this.suppressUserAgentSuffix) {
            this.headers.setUserAgent(originalUserAgent);
         }

         StreamingContent streamingContent = this.content;
         boolean contentRetrySupported = streamingContent == null || this.content.retrySupported();
         if (streamingContent != null) {
            String contentType = this.content.getType();
            if (loggable) {
               streamingContent = new LoggingStreamingContent((StreamingContent)streamingContent, HttpTransport.LOGGER, Level.CONFIG, this.contentLoggingLimit);
            }

            String contentEncoding;
            long contentLength;
            if (this.encoding == null) {
               contentEncoding = null;
               contentLength = this.content.getLength();
            } else {
               contentEncoding = this.encoding.getName();
               streamingContent = new HttpEncodingStreamingContent((StreamingContent)streamingContent, this.encoding);
               contentLength = contentRetrySupported ? IOUtils.computeLength((StreamingContent)streamingContent) : -1L;
            }

            if (loggable) {
               String header;
               if (contentType != null) {
                  header = "Content-Type: " + contentType;
                  logbuf.append(header).append(StringUtils.LINE_SEPARATOR);
                  if (curlbuf != null) {
                     curlbuf.append(" -H '" + header + "'");
                  }
               }

               if (contentEncoding != null) {
                  header = "Content-Encoding: " + contentEncoding;
                  logbuf.append(header).append(StringUtils.LINE_SEPARATOR);
                  if (curlbuf != null) {
                     curlbuf.append(" -H '" + header + "'");
                  }
               }

               if (contentLength >= 0L) {
                  header = "Content-Length: " + contentLength;
                  logbuf.append(header).append(StringUtils.LINE_SEPARATOR);
               }
            }

            if (curlbuf != null) {
               curlbuf.append(" -d '@-'");
            }

            lowLevelHttpRequest.setContentType(contentType);
            lowLevelHttpRequest.setContentEncoding(contentEncoding);
            lowLevelHttpRequest.setContentLength(contentLength);
            lowLevelHttpRequest.setStreamingContent((StreamingContent)streamingContent);
         }

         if (loggable) {
            logger.config(logbuf.toString());
            if (curlbuf != null) {
               curlbuf.append(" -- '");
               curlbuf.append(urlString.replaceAll("'", "'\"'\"'"));
               curlbuf.append("'");
               if (streamingContent != null) {
                  curlbuf.append(" << $$$");
               }

               logger.config(curlbuf.toString());
            }
         }

         retryRequest = contentRetrySupported && retriesRemaining > 0;
         lowLevelHttpRequest.setTimeout(this.connectTimeout, this.readTimeout);

         boolean errorHandled;
         try {
            LowLevelHttpResponse lowLevelHttpResponse = lowLevelHttpRequest.execute();
            errorHandled = false;
            boolean var42 = false;

            try {
               var42 = true;
               response = new HttpResponse(this, lowLevelHttpResponse);
               errorHandled = true;
               var42 = false;
            } finally {
               if (var42) {
                  if (!errorHandled) {
                     InputStream lowLevelContent = lowLevelHttpResponse.getContent();
                     if (lowLevelContent != null) {
                        lowLevelContent.close();
                     }
                  }

               }
            }

            if (!errorHandled) {
               InputStream lowLevelContent = lowLevelHttpResponse.getContent();
               if (lowLevelContent != null) {
                  lowLevelContent.close();
               }
            }
         } catch (IOException var46) {
            if (!this.retryOnExecuteIOException && (this.ioExceptionHandler == null || !this.ioExceptionHandler.handleIOException(this, retryRequest))) {
               throw var46;
            }

            executeException = var46;
            if (loggable) {
               logger.log(Level.WARNING, "exception thrown while executing request", var46);
            }
         }

         boolean responseProcessed = false;

         try {
            if (response != null && !response.isSuccessStatusCode()) {
               errorHandled = false;
               if (this.unsuccessfulResponseHandler != null) {
                  errorHandled = this.unsuccessfulResponseHandler.handleResponse(this, response, retryRequest);
               }

               if (!errorHandled) {
                  if (this.handleRedirect(response.getStatusCode(), response.getHeaders())) {
                     errorHandled = true;
                  } else if (retryRequest && this.backOffPolicy != null && this.backOffPolicy.isBackOffRequired(response.getStatusCode())) {
                     long backOffTime = this.backOffPolicy.getNextBackOffMillis();
                     if (backOffTime != -1L) {
                        try {
                           this.sleeper.sleep(backOffTime);
                        } catch (InterruptedException var44) {
                        }

                        errorHandled = true;
                     }
                  }
               }

               retryRequest &= errorHandled;
               if (retryRequest) {
                  response.ignore();
               }
            } else {
               retryRequest &= response == null;
            }

            --retriesRemaining;
            responseProcessed = true;
         } finally {
            if (response != null && !responseProcessed) {
               response.disconnect();
            }

         }
      } while(retryRequest);

      if (response == null) {
         throw executeException;
      } else {
         if (this.responseInterceptor != null) {
            this.responseInterceptor.interceptResponse(response);
         }

         if (this.throwExceptionOnExecuteError && !response.isSuccessStatusCode()) {
            try {
               throw new HttpResponseException(response);
            } finally {
               response.disconnect();
            }
         } else {
            return response;
         }
      }
   }

   @Beta
   public Future executeAsync(Executor executor) {
      FutureTask future = new FutureTask(new HttpRequest$1(this));
      executor.execute(future);
      return future;
   }

   @Beta
   public Future executeAsync() {
      return this.executeAsync(Executors.newSingleThreadExecutor());
   }

   public boolean handleRedirect(int statusCode, HttpHeaders responseHeaders) {
      String redirectLocation = responseHeaders.getLocation();
      if (this.getFollowRedirects() && HttpStatusCodes.isRedirect(statusCode) && redirectLocation != null) {
         this.setUrl(new GenericUrl(this.url.toURL(redirectLocation)));
         if (statusCode == 303) {
            this.setRequestMethod("GET");
            this.setContent((HttpContent)null);
         }

         this.headers.setAuthorization((String)null);
         this.headers.setIfMatch((String)null);
         this.headers.setIfNoneMatch((String)null);
         this.headers.setIfModifiedSince((String)null);
         this.headers.setIfUnmodifiedSince((String)null);
         this.headers.setIfRange((String)null);
         return true;
      } else {
         return false;
      }
   }

   public Sleeper getSleeper() {
      return this.sleeper;
   }

   public HttpRequest setSleeper(Sleeper sleeper) {
      this.sleeper = (Sleeper)Preconditions.checkNotNull(sleeper);
      return this;
   }
}
