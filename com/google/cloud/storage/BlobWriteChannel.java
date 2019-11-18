package com.google.cloud.storage;

import com.google.cloud.BaseWriteChannel;
import com.google.cloud.RetryHelper;
import com.google.cloud.ServiceOptions;
import com.google.cloud.BaseWriteChannel.BaseState;
import com.google.cloud.BaseWriteChannel.BaseState.Builder;
import com.google.cloud.RetryHelper.RetryHelperException;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Executors;

class BlobWriteChannel extends BaseWriteChannel {
   BlobWriteChannel(StorageOptions options, BlobInfo blob, Map optionsMap) {
      this(options, blob, open(options, blob, optionsMap));
   }

   BlobWriteChannel(StorageOptions options, URL signedURL) {
      this(options, open(signedURL, options));
   }

   BlobWriteChannel(StorageOptions options, BlobInfo blobInfo, String uploadId) {
      super(options, blobInfo, uploadId);
   }

   BlobWriteChannel(StorageOptions options, String uploadId) {
      super(options, (Serializable)null, uploadId);
   }

   protected void flushBuffer(int length, boolean last) {
      try {
         RetryHelper.runWithRetries(Executors.callable(new BlobWriteChannel$1(this, length, last)), ((StorageOptions)this.getOptions()).getRetrySettings(), StorageImpl.EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

   }

   protected BlobWriteChannel$StateImpl$Builder stateBuilder() {
      return BlobWriteChannel$StateImpl.builder((StorageOptions)this.getOptions(), (BlobInfo)this.getEntity(), this.getUploadId());
   }

   private static String open(StorageOptions options, BlobInfo blob, Map optionsMap) {
      String var10000;
      try {
         var10000 = (String)RetryHelper.runWithRetries(new BlobWriteChannel$2(options, blob, optionsMap), options.getRetrySettings(), StorageImpl.EXCEPTION_HANDLER, options.getClock());
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   private static String open(URL signedURL, StorageOptions options) {
      String var10000;
      try {
         var10000 = (String)RetryHelper.runWithRetries(new BlobWriteChannel$3(signedURL, options), options.getRetrySettings(), StorageImpl.EXCEPTION_HANDLER, options.getClock());
      } catch (RetryHelperException var3) {
         throw StorageException.translateAndThrow(var3);
      }

      return var10000;
   }

   private static boolean isValidSignedURL(String signedURLQuery) {
      boolean isValid = true;
      if (signedURLQuery.startsWith("X-Goog-Algorithm=")) {
         if (!signedURLQuery.contains("&X-Goog-Credential=") || !signedURLQuery.contains("&X-Goog-Date=") || !signedURLQuery.contains("&X-Goog-Expires=") || !signedURLQuery.contains("&X-Goog-SignedHeaders=") || !signedURLQuery.contains("&X-Goog-Signature=")) {
            isValid = false;
         }
      } else if (signedURLQuery.startsWith("GoogleAccessId=")) {
         if (!signedURLQuery.contains("&Expires=") || !signedURLQuery.contains("&Signature=")) {
            isValid = false;
         }
      } else {
         isValid = false;
      }

      return isValid;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Builder stateBuilder() {
      return this.stateBuilder();
   }

   // $FF: synthetic method
   static String access$000(BlobWriteChannel x0) {
      return x0.getUploadId();
   }

   // $FF: synthetic method
   static byte[] access$100(BlobWriteChannel x0) {
      return x0.getBuffer();
   }

   // $FF: synthetic method
   static long access$200(BlobWriteChannel x0) {
      return x0.getPosition();
   }

   // $FF: synthetic method
   static ServiceOptions access$300(BlobWriteChannel x0) {
      return x0.getOptions();
   }

   // $FF: synthetic method
   static boolean access$400(String x0) {
      return isValidSignedURL(x0);
   }

   // $FF: synthetic method
   static void access$600(BlobWriteChannel x0, BaseState x1) {
      x0.restore(x1);
   }
}
