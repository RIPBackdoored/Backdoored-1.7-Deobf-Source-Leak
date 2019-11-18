package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

// $FF: synthetic class
class Blob$3 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option = new int[StorageRpc$Option.values().length];

   static {
      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_GENERATION_MATCH.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_GENERATION_NOT_MATCH.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_METAGENERATION_MATCH.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.CUSTOMER_SUPPLIED_KEY.ordinal()] = 5;
      } catch (NoSuchFieldError var2) {
      }

      try {
         $SwitchMap$com$google$cloud$storage$spi$v1$StorageRpc$Option[StorageRpc$Option.USER_PROJECT.ordinal()] = 6;
      } catch (NoSuchFieldError var1) {
      }

   }
}
