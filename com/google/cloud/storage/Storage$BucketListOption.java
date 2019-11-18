package com.google.cloud.storage;

import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$BucketListOption extends Option {
   private static final long serialVersionUID = 8754017079673290353L;

   private Storage$BucketListOption(StorageRpc$Option option, Object value) {
      super(option, value);
   }

   public static Storage$BucketListOption pageSize(long pageSize) {
      return new Storage$BucketListOption(StorageRpc$Option.MAX_RESULTS, pageSize);
   }

   public static Storage$BucketListOption pageToken(String pageToken) {
      return new Storage$BucketListOption(StorageRpc$Option.PAGE_TOKEN, pageToken);
   }

   public static Storage$BucketListOption prefix(String prefix) {
      return new Storage$BucketListOption(StorageRpc$Option.PREFIX, prefix);
   }

   public static Storage$BucketListOption userProject(String userProject) {
      return new Storage$BucketListOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$BucketListOption fields(Storage$BucketField... fields) {
      return new Storage$BucketListOption(StorageRpc$Option.FIELDS, Helper.listSelector("items", Storage$BucketField.REQUIRED_FIELDS, fields));
   }
}
