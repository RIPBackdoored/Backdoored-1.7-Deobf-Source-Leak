package com.google.cloud.storage;

import com.google.cloud.Tuple;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import java.security.Key;
import java.util.List;

public class Storage$BlobTargetOption extends Option {
   private static final long serialVersionUID = 214616862061934846L;

   private Storage$BlobTargetOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   private Storage$BlobTargetOption(StorageRpc$Option rpcOption) {
      this(rpcOption, (Object)null);
   }

   public static Storage$BlobTargetOption predefinedAcl(Storage$PredefinedAcl acl) {
      return new Storage$BlobTargetOption(StorageRpc$Option.PREDEFINED_ACL, acl.getEntry());
   }

   public static Storage$BlobTargetOption doesNotExist() {
      return new Storage$BlobTargetOption(StorageRpc$Option.IF_GENERATION_MATCH, 0L);
   }

   public static Storage$BlobTargetOption generationMatch() {
      return new Storage$BlobTargetOption(StorageRpc$Option.IF_GENERATION_MATCH);
   }

   public static Storage$BlobTargetOption generationNotMatch() {
      return new Storage$BlobTargetOption(StorageRpc$Option.IF_GENERATION_NOT_MATCH);
   }

   public static Storage$BlobTargetOption metagenerationMatch() {
      return new Storage$BlobTargetOption(StorageRpc$Option.IF_METAGENERATION_MATCH);
   }

   public static Storage$BlobTargetOption metagenerationNotMatch() {
      return new Storage$BlobTargetOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH);
   }

   public static Storage$BlobTargetOption disableGzipContent() {
      return new Storage$BlobTargetOption(StorageRpc$Option.IF_DISABLE_GZIP_CONTENT, true);
   }

   public static Storage$BlobTargetOption encryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new Storage$BlobTargetOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, base64Key);
   }

   public static Storage$BlobTargetOption userProject(String userProject) {
      return new Storage$BlobTargetOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$BlobTargetOption encryptionKey(String key) {
      return new Storage$BlobTargetOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, key);
   }

   public static Storage$BlobTargetOption kmsKeyName(String kmsKeyName) {
      return new Storage$BlobTargetOption(StorageRpc$Option.KMS_KEY_NAME, kmsKeyName);
   }

   static Tuple convert(BlobInfo info, Storage$BlobWriteOption... options) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   Storage$BlobTargetOption(StorageRpc$Option x0, Object x1, Storage$1 x2) {
      this(x0, x1);
   }
}
