package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Bucket$BucketSourceOption extends Option {
   private static final long serialVersionUID = 6928872234155522371L;

   private Bucket$BucketSourceOption(StorageRpc$Option rpcOption) {
      super(rpcOption, (Object)null);
   }

   private Bucket$BucketSourceOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   private Storage$BucketSourceOption toSourceOption(BucketInfo bucketInfo) {
      // $FF: Couldn't be decompiled
   }

   private Storage$BucketGetOption toGetOption(BucketInfo bucketInfo) {
      // $FF: Couldn't be decompiled
   }

   public static Bucket$BucketSourceOption metagenerationMatch() {
      return new Bucket$BucketSourceOption(StorageRpc$Option.IF_METAGENERATION_MATCH);
   }

   public static Bucket$BucketSourceOption metagenerationNotMatch() {
      return new Bucket$BucketSourceOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH);
   }

   public static Bucket$BucketSourceOption userProject(String userProject) {
      return new Bucket$BucketSourceOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   static Storage$BucketSourceOption[] toSourceOptions(BucketInfo bucketInfo, Bucket$BucketSourceOption... options) {
      Storage$BucketSourceOption[] convertedOptions = new Storage$BucketSourceOption[options.length];
      int index = 0;
      Bucket$BucketSourceOption[] var4 = options;
      int var5 = options.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Bucket$BucketSourceOption option = var4[var6];
         convertedOptions[index++] = option.toSourceOption(bucketInfo);
      }

      return convertedOptions;
   }

   static Storage$BucketGetOption[] toGetOptions(BucketInfo bucketInfo, Bucket$BucketSourceOption... options) {
      Storage$BucketGetOption[] convertedOptions = new Storage$BucketGetOption[options.length];
      int index = 0;
      Bucket$BucketSourceOption[] var4 = options;
      int var5 = options.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Bucket$BucketSourceOption option = var4[var6];
         convertedOptions[index++] = option.toGetOption(bucketInfo);
      }

      return convertedOptions;
   }
}
