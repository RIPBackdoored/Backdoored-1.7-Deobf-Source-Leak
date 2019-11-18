package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject.CustomerEncryption;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

public class BlobInfo$CustomerEncryption implements Serializable {
   private static final long serialVersionUID = -2133042982786959351L;
   private final String encryptionAlgorithm;
   private final String keySha256;

   BlobInfo$CustomerEncryption(String encryptionAlgorithm, String keySha256) {
      this.encryptionAlgorithm = encryptionAlgorithm;
      this.keySha256 = keySha256;
   }

   public String getEncryptionAlgorithm() {
      return this.encryptionAlgorithm;
   }

   public String getKeySha256() {
      return this.keySha256;
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("encryptionAlgorithm", this.getEncryptionAlgorithm()).add("keySha256", this.getKeySha256()).toString();
   }

   public final int hashCode() {
      return Objects.hash(new Object[]{this.encryptionAlgorithm, this.keySha256});
   }

   public final boolean equals(Object obj) {
      return obj == this || obj != null && obj.getClass().equals(BlobInfo$CustomerEncryption.class) && Objects.equals(this.toPb(), ((BlobInfo$CustomerEncryption)obj).toPb());
   }

   CustomerEncryption toPb() {
      return (new CustomerEncryption()).setEncryptionAlgorithm(this.encryptionAlgorithm).setKeySha256(this.keySha256);
   }

   static BlobInfo$CustomerEncryption fromPb(CustomerEncryption customerEncryptionPb) {
      return new BlobInfo$CustomerEncryption(customerEncryptionPb.getEncryptionAlgorithm(), customerEncryptionPb.getKeySha256());
   }
}
