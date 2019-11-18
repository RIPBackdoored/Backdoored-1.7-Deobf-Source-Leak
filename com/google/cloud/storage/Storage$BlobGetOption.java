package com.google.cloud.storage;

import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.common.io.BaseEncoding;
import java.security.Key;

public class Storage$BlobGetOption extends Option {
   private static final long serialVersionUID = 803817709703661480L;

   private Storage$BlobGetOption(StorageRpc$Option rpcOption, Long value) {
      super(rpcOption, value);
   }

   private Storage$BlobGetOption(StorageRpc$Option rpcOption, String value) {
      super(rpcOption, value);
   }

   public static Storage$BlobGetOption generationMatch() {
      return new Storage$BlobGetOption(StorageRpc$Option.IF_GENERATION_MATCH, (Long)null);
   }

   public static Storage$BlobGetOption generationMatch(long generation) {
      return new Storage$BlobGetOption(StorageRpc$Option.IF_GENERATION_MATCH, generation);
   }

   public static Storage$BlobGetOption generationNotMatch() {
      return new Storage$BlobGetOption(StorageRpc$Option.IF_GENERATION_NOT_MATCH, (Long)null);
   }

   public static Storage$BlobGetOption generationNotMatch(long generation) {
      return new Storage$BlobGetOption(StorageRpc$Option.IF_GENERATION_NOT_MATCH, generation);
   }

   public static Storage$BlobGetOption metagenerationMatch(long metageneration) {
      return new Storage$BlobGetOption(StorageRpc$Option.IF_METAGENERATION_MATCH, metageneration);
   }

   public static Storage$BlobGetOption metagenerationNotMatch(long metageneration) {
      return new Storage$BlobGetOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH, metageneration);
   }

   public static Storage$BlobGetOption fields(Storage$BlobField... fields) {
      return new Storage$BlobGetOption(StorageRpc$Option.FIELDS, Helper.selector(Storage$BlobField.REQUIRED_FIELDS, fields));
   }

   public static Storage$BlobGetOption userProject(String userProject) {
      return new Storage$BlobGetOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$BlobGetOption decryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new Storage$BlobGetOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, base64Key);
   }

   public static Storage$BlobGetOption decryptionKey(String key) {
      return new Storage$BlobGetOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, key);
   }
}
