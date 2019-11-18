package com.google.cloud.storage;

import com.google.cloud.Tuple;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.io.BaseEncoding;
import java.io.Serializable;
import java.security.Key;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class Bucket$BlobWriteOption implements Serializable {
   private static final Function TO_ENUM = new Bucket$BlobWriteOption$1();
   private static final long serialVersionUID = 4722190734541993114L;
   private final Storage$BlobWriteOption$Option option;
   private final Object value;

   private Tuple toWriteOption(BlobInfo blobInfo) {
      // $FF: Couldn't be decompiled
   }

   private Bucket$BlobWriteOption(Storage$BlobWriteOption$Option option, Object value) {
      this.option = option;
      this.value = value;
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.option, this.value});
   }

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      } else if (!(obj instanceof Bucket$BlobWriteOption)) {
         return false;
      } else {
         Bucket$BlobWriteOption other = (Bucket$BlobWriteOption)obj;
         return this.option == other.option && Objects.equals(this.value, other.value);
      }
   }

   public static Bucket$BlobWriteOption predefinedAcl(Storage$PredefinedAcl acl) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.PREDEFINED_ACL, acl);
   }

   public static Bucket$BlobWriteOption doesNotExist() {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.IF_GENERATION_MATCH, 0L);
   }

   public static Bucket$BlobWriteOption generationMatch(long generation) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.IF_GENERATION_MATCH, generation);
   }

   public static Bucket$BlobWriteOption generationNotMatch(long generation) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.IF_GENERATION_NOT_MATCH, generation);
   }

   public static Bucket$BlobWriteOption metagenerationMatch(long metageneration) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.IF_METAGENERATION_MATCH, metageneration);
   }

   public static Bucket$BlobWriteOption metagenerationNotMatch(long metageneration) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.IF_METAGENERATION_NOT_MATCH, metageneration);
   }

   public static Bucket$BlobWriteOption md5Match(String md5) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.IF_MD5_MATCH, md5);
   }

   public static Bucket$BlobWriteOption crc32cMatch(String crc32c) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.IF_CRC32C_MATCH, crc32c);
   }

   public static Bucket$BlobWriteOption encryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.CUSTOMER_SUPPLIED_KEY, base64Key);
   }

   public static Bucket$BlobWriteOption encryptionKey(String key) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.CUSTOMER_SUPPLIED_KEY, key);
   }

   public static Bucket$BlobWriteOption userProject(String userProject) {
      return new Bucket$BlobWriteOption(Storage$BlobWriteOption$Option.USER_PROJECT, userProject);
   }

   static Tuple toWriteOptions(BlobInfo info, Bucket$BlobWriteOption... options) {
      Set optionSet = Sets.immutableEnumSet(Lists.transform(Arrays.asList(options), TO_ENUM));
      Preconditions.checkArgument(!optionSet.contains(Storage$BlobWriteOption$Option.IF_METAGENERATION_NOT_MATCH) || !optionSet.contains(Storage$BlobWriteOption$Option.IF_METAGENERATION_MATCH), "metagenerationMatch and metagenerationNotMatch options can not be both provided");
      Preconditions.checkArgument(!optionSet.contains(Storage$BlobWriteOption$Option.IF_GENERATION_NOT_MATCH) || !optionSet.contains(Storage$BlobWriteOption$Option.IF_GENERATION_MATCH), "Only one option of generationMatch, doesNotExist or generationNotMatch can be provided");
      Storage$BlobWriteOption[] convertedOptions = new Storage$BlobWriteOption[options.length];
      BlobInfo writeInfo = info;
      int index = 0;
      Bucket$BlobWriteOption[] var6 = options;
      int var7 = options.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Bucket$BlobWriteOption option = var6[var8];
         Tuple write = option.toWriteOption(writeInfo);
         writeInfo = (BlobInfo)write.x();
         convertedOptions[index++] = (Storage$BlobWriteOption)write.y();
      }

      return Tuple.of(writeInfo, convertedOptions);
   }

   // $FF: synthetic method
   static Storage$BlobWriteOption$Option access$000(Bucket$BlobWriteOption x0) {
      return x0.option;
   }
}
