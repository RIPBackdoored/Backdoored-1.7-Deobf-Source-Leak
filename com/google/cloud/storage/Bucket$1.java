package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

// $FF: synthetic class
class Bucket$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option;
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option = new int[Storage$BlobWriteOption$Option.values().length];

   static {
      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.PREDEFINED_ACL.ordinal()] = 1;
      } catch (NoSuchFieldError var18) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.IF_GENERATION_MATCH.ordinal()] = 2;
      } catch (NoSuchFieldError var17) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.IF_GENERATION_NOT_MATCH.ordinal()] = 3;
      } catch (NoSuchFieldError var16) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.IF_METAGENERATION_MATCH.ordinal()] = 4;
      } catch (NoSuchFieldError var15) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.IF_METAGENERATION_NOT_MATCH.ordinal()] = 5;
      } catch (NoSuchFieldError var14) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.IF_MD5_MATCH.ordinal()] = 6;
      } catch (NoSuchFieldError var13) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.IF_CRC32C_MATCH.ordinal()] = 7;
      } catch (NoSuchFieldError var12) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.CUSTOMER_SUPPLIED_KEY.ordinal()] = 8;
      } catch (NoSuchFieldError var11) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.KMS_KEY_NAME.ordinal()] = 9;
      } catch (NoSuchFieldError var10) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$Storage$BlobWriteOption$Option[Storage$BlobWriteOption$Option.USER_PROJECT.ordinal()] = 10;
      } catch (NoSuchFieldError var9) {
      }

      $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option = new int[StorageRpc$Option.values().length];

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_METAGENERATION_MATCH.ordinal()] = 1;
      } catch (NoSuchFieldError var8) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.ordinal()] = 2;
      } catch (NoSuchFieldError var7) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.PREDEFINED_ACL.ordinal()] = 3;
      } catch (NoSuchFieldError var6) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_GENERATION_MATCH.ordinal()] = 4;
      } catch (NoSuchFieldError var5) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_GENERATION_NOT_MATCH.ordinal()] = 5;
      } catch (NoSuchFieldError var4) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.CUSTOMER_SUPPLIED_KEY.ordinal()] = 6;
      } catch (NoSuchFieldError var3) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.KMS_KEY_NAME.ordinal()] = 7;
      } catch (NoSuchFieldError var2) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.USER_PROJECT.ordinal()] = 8;
      } catch (NoSuchFieldError var1) {
      }

   }
}
