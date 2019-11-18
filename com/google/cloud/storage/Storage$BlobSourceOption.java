package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.common.io.BaseEncoding;
import java.security.Key;

public class Storage$BlobSourceOption extends Option {
   private static final long serialVersionUID = -3712768261070182991L;

   private Storage$BlobSourceOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   public static Storage$BlobSourceOption generationMatch() {
      return new Storage$BlobSourceOption(StorageRpc$Option.IF_GENERATION_MATCH, (Object)null);
   }

   public static Storage$BlobSourceOption generationMatch(long generation) {
      return new Storage$BlobSourceOption(StorageRpc$Option.IF_GENERATION_MATCH, generation);
   }

   public static Storage$BlobSourceOption generationNotMatch() {
      return new Storage$BlobSourceOption(StorageRpc$Option.IF_GENERATION_NOT_MATCH, (Object)null);
   }

   public static Storage$BlobSourceOption generationNotMatch(long generation) {
      return new Storage$BlobSourceOption(StorageRpc$Option.IF_GENERATION_NOT_MATCH, generation);
   }

   public static Storage$BlobSourceOption metagenerationMatch(long metageneration) {
      return new Storage$BlobSourceOption(StorageRpc$Option.IF_METAGENERATION_MATCH, metageneration);
   }

   public static Storage$BlobSourceOption metagenerationNotMatch(long metageneration) {
      return new Storage$BlobSourceOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH, metageneration);
   }

   public static Storage$BlobSourceOption decryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new Storage$BlobSourceOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, base64Key);
   }

   public static Storage$BlobSourceOption decryptionKey(String key) {
      return new Storage$BlobSourceOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, key);
   }

   public static Storage$BlobSourceOption userProject(String userProject) {
      return new Storage$BlobSourceOption(StorageRpc$Option.USER_PROJECT, userProject);
   }
}
