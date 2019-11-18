package com.google.cloud.storage.testing;

public class RemoteStorageHelper$StorageHelperException extends RuntimeException {
   private static final long serialVersionUID = -7756074894502258736L;

   public RemoteStorageHelper$StorageHelperException(String message) {
      super(message);
   }

   public RemoteStorageHelper$StorageHelperException(String message, Throwable cause) {
      super(message, cause);
   }

   public static RemoteStorageHelper$StorageHelperException translate(Exception ex) {
      return new RemoteStorageHelper$StorageHelperException(ex.getMessage(), ex);
   }
}
