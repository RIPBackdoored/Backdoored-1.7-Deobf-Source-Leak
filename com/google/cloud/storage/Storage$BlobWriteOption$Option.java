package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

final class Storage$BlobWriteOption$Option extends Enum {
   public static final Storage$BlobWriteOption$Option PREDEFINED_ACL = new Storage$BlobWriteOption$Option("PREDEFINED_ACL", 0);
   public static final Storage$BlobWriteOption$Option IF_GENERATION_MATCH = new Storage$BlobWriteOption$Option("IF_GENERATION_MATCH", 1);
   public static final Storage$BlobWriteOption$Option IF_GENERATION_NOT_MATCH = new Storage$BlobWriteOption$Option("IF_GENERATION_NOT_MATCH", 2);
   public static final Storage$BlobWriteOption$Option IF_METAGENERATION_MATCH = new Storage$BlobWriteOption$Option("IF_METAGENERATION_MATCH", 3);
   public static final Storage$BlobWriteOption$Option IF_METAGENERATION_NOT_MATCH = new Storage$BlobWriteOption$Option("IF_METAGENERATION_NOT_MATCH", 4);
   public static final Storage$BlobWriteOption$Option IF_MD5_MATCH = new Storage$BlobWriteOption$Option("IF_MD5_MATCH", 5);
   public static final Storage$BlobWriteOption$Option IF_CRC32C_MATCH = new Storage$BlobWriteOption$Option("IF_CRC32C_MATCH", 6);
   public static final Storage$BlobWriteOption$Option CUSTOMER_SUPPLIED_KEY = new Storage$BlobWriteOption$Option("CUSTOMER_SUPPLIED_KEY", 7);
   public static final Storage$BlobWriteOption$Option KMS_KEY_NAME = new Storage$BlobWriteOption$Option("KMS_KEY_NAME", 8);
   public static final Storage$BlobWriteOption$Option USER_PROJECT = new Storage$BlobWriteOption$Option("USER_PROJECT", 9);
   // $FF: synthetic field
   private static final Storage$BlobWriteOption$Option[] $VALUES = new Storage$BlobWriteOption$Option[]{PREDEFINED_ACL, IF_GENERATION_MATCH, IF_GENERATION_NOT_MATCH, IF_METAGENERATION_MATCH, IF_METAGENERATION_NOT_MATCH, IF_MD5_MATCH, IF_CRC32C_MATCH, CUSTOMER_SUPPLIED_KEY, KMS_KEY_NAME, USER_PROJECT};

   public static Storage$BlobWriteOption$Option[] values() {
      return (Storage$BlobWriteOption$Option[])$VALUES.clone();
   }

   public static Storage$BlobWriteOption$Option valueOf(String name) {
      return (Storage$BlobWriteOption$Option)Enum.valueOf(Storage$BlobWriteOption$Option.class, name);
   }

   private Storage$BlobWriteOption$Option(String var1, int var2) {
      super(var1, var2);
   }

   StorageRpc$Option toRpcOption() {
      return StorageRpc$Option.valueOf(this.name());
   }
}
