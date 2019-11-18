package com.google.cloud.storage;

import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$BucketGetOption extends Option {
   private static final long serialVersionUID = 1901844869484087395L;

   private Storage$BucketGetOption(StorageRpc$Option rpcOption, long metageneration) {
      super(rpcOption, metageneration);
   }

   private Storage$BucketGetOption(StorageRpc$Option rpcOption, String value) {
      super(rpcOption, value);
   }

   public static Storage$BucketGetOption metagenerationMatch(long metageneration) {
      return new Storage$BucketGetOption(StorageRpc$Option.IF_METAGENERATION_MATCH, metageneration);
   }

   public static Storage$BucketGetOption metagenerationNotMatch(long metageneration) {
      return new Storage$BucketGetOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH, metageneration);
   }

   public static Storage$BucketGetOption userProject(String userProject) {
      return new Storage$BucketGetOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$BucketGetOption fields(Storage$BucketField... fields) {
      return new Storage$BucketGetOption(StorageRpc$Option.FIELDS, Helper.selector(Storage$BucketField.REQUIRED_FIELDS, fields));
   }
}
