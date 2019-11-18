package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$BucketSourceOption extends Option {
   private static final long serialVersionUID = 5185657617120212117L;

   private Storage$BucketSourceOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   public static Storage$BucketSourceOption metagenerationMatch(long metageneration) {
      return new Storage$BucketSourceOption(StorageRpc$Option.IF_METAGENERATION_MATCH, metageneration);
   }

   public static Storage$BucketSourceOption metagenerationNotMatch(long metageneration) {
      return new Storage$BucketSourceOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH, metageneration);
   }

   public static Storage$BucketSourceOption userProject(String userProject) {
      return new Storage$BucketSourceOption(StorageRpc$Option.USER_PROJECT, userProject);
   }
}
