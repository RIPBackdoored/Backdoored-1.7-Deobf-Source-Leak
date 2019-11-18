package com.google.cloud.storage;

import com.google.common.io.BaseEncoding;
import java.io.Serializable;
import java.security.Key;
import java.util.Objects;

public class Storage$BlobWriteOption implements Serializable {
   private static final long serialVersionUID = -3880421670966224580L;
   private final Storage$BlobWriteOption$Option option;
   private final Object value;

   Storage$BlobTargetOption toTargetOption() {
      return new Storage$BlobTargetOption(this.option.toRpcOption(), this.value, (Storage$1)null);
   }

   private Storage$BlobWriteOption(Storage$BlobWriteOption$Option option, Object value) {
      this.option = option;
      this.value = value;
   }

   private Storage$BlobWriteOption(Storage$BlobWriteOption$Option option) {
      this(option, (Object)null);
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.option, this.value});
   }

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      } else if (!(obj instanceof Storage$BlobWriteOption)) {
         return false;
      } else {
         Storage$BlobWriteOption other = (Storage$BlobWriteOption)obj;
         return this.option == other.option && Objects.equals(this.value, other.value);
      }
   }

   public static Storage$BlobWriteOption predefinedAcl(Storage$PredefinedAcl acl) {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.PREDEFINED_ACL, acl.getEntry());
   }

   public static Storage$BlobWriteOption doesNotExist() {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.IF_GENERATION_MATCH, 0L);
   }

   public static Storage$BlobWriteOption generationMatch() {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.IF_GENERATION_MATCH);
   }

   public static Storage$BlobWriteOption generationNotMatch() {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.IF_GENERATION_NOT_MATCH);
   }

   public static Storage$BlobWriteOption metagenerationMatch() {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.IF_METAGENERATION_MATCH);
   }

   public static Storage$BlobWriteOption metagenerationNotMatch() {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.IF_METAGENERATION_NOT_MATCH);
   }

   public static Storage$BlobWriteOption md5Match() {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.IF_MD5_MATCH, true);
   }

   public static Storage$BlobWriteOption crc32cMatch() {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.IF_CRC32C_MATCH, true);
   }

   public static Storage$BlobWriteOption encryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.CUSTOMER_SUPPLIED_KEY, base64Key);
   }

   public static Storage$BlobWriteOption encryptionKey(String key) {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.CUSTOMER_SUPPLIED_KEY, key);
   }

   public static Storage$BlobWriteOption kmsKeyName(String kmsKeyName) {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.KMS_KEY_NAME, kmsKeyName);
   }

   public static Storage$BlobWriteOption userProject(String userProject) {
      return new Storage$BlobWriteOption(Storage$BlobWriteOption$Option.USER_PROJECT, userProject);
   }

   // $FF: synthetic method
   static Storage$BlobWriteOption$Option access$000(Storage$BlobWriteOption x0) {
      return x0.option;
   }
}
