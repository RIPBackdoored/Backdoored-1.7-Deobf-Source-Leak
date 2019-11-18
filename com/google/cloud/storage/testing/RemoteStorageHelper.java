package com.google.cloud.storage.testing;

import com.google.api.gax.retrying.RetrySettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.StorageOptions$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

public class RemoteStorageHelper {
   private static final Logger log = Logger.getLogger(RemoteStorageHelper.class.getName());
   private static final String BUCKET_NAME_PREFIX = "gcloud-test-bucket-temp-";
   private final StorageOptions options;

   private RemoteStorageHelper(StorageOptions options) {
      this.options = options;
   }

   public StorageOptions getOptions() {
      return this.options;
   }

   public static void cleanBuckets(Storage storage, long olderThan, long timeoutMs) {
      Runnable task = new RemoteStorageHelper$1(storage, olderThan);
      Thread thread = new Thread(task);
      thread.start();

      try {
         thread.join(timeoutMs);
      } catch (InterruptedException var8) {
         log.info("cleanBuckets interrupted");
      }

   }

   public static Boolean forceDelete(Storage storage, String bucket, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException {
      return forceDelete(storage, bucket, timeout, unit, "");
   }

   public static Boolean forceDelete(Storage storage, String bucket, long timeout, TimeUnit unit, String userProject) throws InterruptedException, ExecutionException {
      ExecutorService executor = Executors.newSingleThreadExecutor();
      Future future = executor.submit(new RemoteStorageHelper$DeleteBucketTask(storage, bucket, userProject));

      Boolean var9;
      try {
         Boolean var8 = (Boolean)future.get(timeout, unit);
         return var8;
      } catch (TimeoutException var13) {
         var9 = false;
      } finally {
         executor.shutdown();
      }

      return var9;
   }

   public static void forceDelete(Storage storage, String bucket) {
      (new RemoteStorageHelper$DeleteBucketTask(storage, bucket)).call();
   }

   public static String generateBucketName() {
      return "gcloud-test-bucket-temp-" + UUID.randomUUID().toString();
   }

   public static RemoteStorageHelper create(String projectId, InputStream keyStream) throws RemoteStorageHelper$StorageHelperException {
      RemoteStorageHelper var10000;
      try {
         HttpTransportOptions transportOptions = StorageOptions.getDefaultHttpTransportOptions();
         transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000).build();
         StorageOptions storageOptions = ((StorageOptions$Builder)((StorageOptions$Builder)((StorageOptions$Builder)StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(keyStream))).setProjectId(projectId)).setRetrySettings(retrySettings())).setTransportOptions(transportOptions).build();
         var10000 = new RemoteStorageHelper(storageOptions);
      } catch (IOException var4) {
         if (log.isLoggable(Level.WARNING)) {
            log.log(Level.WARNING, var4.getMessage());
         }

         throw RemoteStorageHelper$StorageHelperException.translate(var4);
      }

      return var10000;
   }

   public static RemoteStorageHelper create() throws RemoteStorageHelper$StorageHelperException {
      HttpTransportOptions transportOptions = StorageOptions.getDefaultHttpTransportOptions();
      transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000).build();
      StorageOptions storageOptions = ((StorageOptions$Builder)StorageOptions.newBuilder().setRetrySettings(retrySettings())).setTransportOptions(transportOptions).build();
      return new RemoteStorageHelper(storageOptions);
   }

   private static RetrySettings retrySettings() {
      return RetrySettings.newBuilder().setMaxAttempts(10).setMaxRetryDelay(Duration.ofMillis(30000L)).setTotalTimeout(Duration.ofMillis(120000L)).setInitialRetryDelay(Duration.ofMillis(250L)).setRetryDelayMultiplier(1.0D).setInitialRpcTimeout(Duration.ofMillis(120000L)).setRpcTimeoutMultiplier(1.0D).setMaxRpcTimeout(Duration.ofMillis(120000L)).build();
   }
}
