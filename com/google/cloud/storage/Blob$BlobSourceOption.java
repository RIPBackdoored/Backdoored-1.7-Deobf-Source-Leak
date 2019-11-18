package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.common.io.BaseEncoding;
import java.security.Key;

public class Blob$BlobSourceOption extends Option {
   private static final long serialVersionUID = 214616862061934846L;

   private Blob$BlobSourceOption(StorageRpc$Option rpcOption) {
      super(rpcOption, (Object)null);
   }

   private Blob$BlobSourceOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   private Storage$BlobSourceOption toSourceOptions(BlobInfo blobInfo) {
      // $FF: Couldn't be decompiled
   }

   private Storage$BlobGetOption toGetOption(BlobInfo blobInfo) {
      // $FF: Couldn't be decompiled
   }

   public static Blob$BlobSourceOption generationMatch() {
      return new Blob$BlobSourceOption(StorageRpc$Option.IF_GENERATION_MATCH);
   }

   public static Blob$BlobSourceOption generationNotMatch() {
      return new Blob$BlobSourceOption(StorageRpc$Option.IF_GENERATION_NOT_MATCH);
   }

   public static Blob$BlobSourceOption metagenerationMatch() {
      return new Blob$BlobSourceOption(StorageRpc$Option.IF_METAGENERATION_MATCH);
   }

   public static Blob$BlobSourceOption metagenerationNotMatch() {
      return new Blob$BlobSourceOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH);
   }

   public static Blob$BlobSourceOption decryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new Blob$BlobSourceOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, base64Key);
   }

   public static Blob$BlobSourceOption decryptionKey(String key) {
      return new Blob$BlobSourceOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, key);
   }

   public static Blob$BlobSourceOption userProject(String userProject) {
      return new Blob$BlobSourceOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   static Storage$BlobSourceOption[] toSourceOptions(BlobInfo blobInfo, Blob$BlobSourceOption... options) {
      Storage$BlobSourceOption[] convertedOptions = new Storage$BlobSourceOption[options.length];
      int index = 0;
      Blob$BlobSourceOption[] var4 = options;
      int var5 = options.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Blob$BlobSourceOption option = var4[var6];
         convertedOptions[index++] = option.toSourceOptions(blobInfo);
      }

      return convertedOptions;
   }

   static Storage$BlobGetOption[] toGetOptions(BlobInfo blobInfo, Blob$BlobSourceOption... options) {
      Storage$BlobGetOption[] convertedOptions = new Storage$BlobGetOption[options.length];
      int index = 0;
      Blob$BlobSourceOption[] var4 = options;
      int var5 = options.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Blob$BlobSourceOption option = var4[var6];
         convertedOptions[index++] = option.toGetOption(blobInfo);
      }

      return convertedOptions;
   }
}
