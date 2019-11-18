package com.google.cloud.storage;

public class HmacKey$Builder {
   private String secretKey;
   private HmacKey$HmacKeyMetadata metadata;

   private HmacKey$Builder(String secretKey) {
      this.secretKey = secretKey;
   }

   public HmacKey$Builder setSecretKey(String secretKey) {
      this.secretKey = secretKey;
      return this;
   }

   public HmacKey$Builder setMetadata(HmacKey$HmacKeyMetadata metadata) {
      this.metadata = metadata;
      return this;
   }

   public HmacKey build() {
      return new HmacKey(this, (HmacKey$1)null);
   }

   // $FF: synthetic method
   static String access$000(HmacKey$Builder x0) {
      return x0.secretKey;
   }

   // $FF: synthetic method
   static HmacKey$HmacKeyMetadata access$100(HmacKey$Builder x0) {
      return x0.metadata;
   }

   // $FF: synthetic method
   HmacKey$Builder(String x0, HmacKey$1 x1) {
      this(x0);
   }
}
