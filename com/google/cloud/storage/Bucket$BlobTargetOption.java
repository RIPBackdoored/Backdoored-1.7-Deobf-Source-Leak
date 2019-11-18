package com.google.cloud.storage;

import com.google.cloud.Tuple;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.io.BaseEncoding;
import java.security.Key;
import java.util.Arrays;
import java.util.Set;

public class Bucket$BlobTargetOption extends Option {
   private static final Function TO_ENUM = new Bucket$BlobTargetOption$1();
   private static final long serialVersionUID = 8345296337342509425L;

   private Bucket$BlobTargetOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   private Tuple toTargetOption(BlobInfo blobInfo) {
      // $FF: Couldn't be decompiled
   }

   public static Bucket$BlobTargetOption predefinedAcl(Storage$PredefinedAcl acl) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.PREDEFINED_ACL, acl);
   }

   public static Bucket$BlobTargetOption doesNotExist() {
      return new Bucket$BlobTargetOption(StorageRpc$Option.IF_GENERATION_MATCH, 0L);
   }

   public static Bucket$BlobTargetOption generationMatch(long generation) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.IF_GENERATION_MATCH, generation);
   }

   public static Bucket$BlobTargetOption generationNotMatch(long generation) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.IF_GENERATION_NOT_MATCH, generation);
   }

   public static Bucket$BlobTargetOption metagenerationMatch(long metageneration) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.IF_METAGENERATION_MATCH, metageneration);
   }

   public static Bucket$BlobTargetOption metagenerationNotMatch(long metageneration) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH, metageneration);
   }

   public static Bucket$BlobTargetOption encryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new Bucket$BlobTargetOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, base64Key);
   }

   public static Bucket$BlobTargetOption encryptionKey(String key) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.CUSTOMER_SUPPLIED_KEY, key);
   }

   public static Bucket$BlobTargetOption kmsKeyName(String kmsKeyName) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.KMS_KEY_NAME, kmsKeyName);
   }

   public static Bucket$BlobTargetOption userProject(String userProject) {
      return new Bucket$BlobTargetOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   static Tuple toTargetOptions(BlobInfo info, Bucket$BlobTargetOption... options) {
      Set optionSet = Sets.immutableEnumSet(Lists.transform(Arrays.asList(options), TO_ENUM));
      Preconditions.checkArgument(!optionSet.contains(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH) || !optionSet.contains(StorageRpc$Option.IF_METAGENERATION_MATCH), "metagenerationMatch and metagenerationNotMatch options can not be both provided");
      Preconditions.checkArgument(!optionSet.contains(StorageRpc$Option.IF_GENERATION_NOT_MATCH) || !optionSet.contains(StorageRpc$Option.IF_GENERATION_MATCH), "Only one option of generationMatch, doesNotExist or generationNotMatch can be provided");
      Storage$BlobTargetOption[] convertedOptions = new Storage$BlobTargetOption[options.length];
      BlobInfo targetInfo = info;
      int index = 0;
      Bucket$BlobTargetOption[] var6 = options;
      int var7 = options.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Bucket$BlobTargetOption option = var6[var8];
         Tuple target = option.toTargetOption(targetInfo);
         targetInfo = (BlobInfo)target.x();
         convertedOptions[index++] = (Storage$BlobTargetOption)target.y();
      }

      return Tuple.of(targetInfo, convertedOptions);
   }
}
