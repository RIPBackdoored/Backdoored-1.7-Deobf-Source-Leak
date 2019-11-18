package com.google.cloud.storage;

import java.io.Serializable;
import java.util.Objects;

public class HmacKey implements Serializable {
   private static final long serialVersionUID = -1809610424373783062L;
   private final String secretKey;
   private final HmacKey$HmacKeyMetadata metadata;

   private HmacKey(HmacKey$Builder builder) {
      this.secretKey = HmacKey$Builder.access$000(builder);
      this.metadata = HmacKey$Builder.access$100(builder);
   }

   public static HmacKey$Builder newBuilder(String secretKey) {
      return new HmacKey$Builder(secretKey, (HmacKey$1)null);
   }

   public String getSecretKey() {
      return this.secretKey;
   }

   public HmacKey$HmacKeyMetadata getMetadata() {
      return this.metadata;
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.secretKey, this.metadata});
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         HmacKey$HmacKeyMetadata other = (HmacKey$HmacKeyMetadata)obj;
         return Objects.equals(this.secretKey, this.secretKey) && Objects.equals(this.metadata, this.metadata);
      } else {
         return false;
      }
   }

   com.google.api.services.storage.model.HmacKey toPb() {
      com.google.api.services.storage.model.HmacKey hmacKey = new com.google.api.services.storage.model.HmacKey();
      hmacKey.setSecret(this.secretKey);
      if (this.metadata != null) {
         hmacKey.setMetadata(this.metadata.toPb());
      }

      return hmacKey;
   }

   static HmacKey fromPb(com.google.api.services.storage.model.HmacKey hmacKey) {
      return newBuilder(hmacKey.getSecret()).setMetadata(HmacKey$HmacKeyMetadata.fromPb(hmacKey.getMetadata())).build();
   }

   // $FF: synthetic method
   HmacKey(HmacKey$Builder x0, HmacKey$1 x1) {
      this(x0);
   }
}
