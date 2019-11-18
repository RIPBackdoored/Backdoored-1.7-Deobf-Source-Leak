package com.google.cloud.storage;

import com.google.api.client.util.Data;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class BlobInfo$BuilderImpl extends BlobInfo$Builder {
   private BlobId blobId;
   private String generatedId;
   private String contentType;
   private String contentEncoding;
   private String contentDisposition;
   private String contentLanguage;
   private Integer componentCount;
   private String cacheControl;
   private List acl;
   private Acl$Entity owner;
   private Long size;
   private String etag;
   private String selfLink;
   private String md5;
   private String crc32c;
   private String mediaLink;
   private Map metadata;
   private Long metageneration;
   private Long deleteTime;
   private Long updateTime;
   private Long createTime;
   private Boolean isDirectory;
   private BlobInfo$CustomerEncryption customerEncryption;
   private StorageClass storageClass;
   private String kmsKeyName;
   private Boolean eventBasedHold;
   private Boolean temporaryHold;
   private Long retentionExpirationTime;

   BlobInfo$BuilderImpl(BlobId blobId) {
      this.blobId = blobId;
   }

   BlobInfo$BuilderImpl(BlobInfo blobInfo) {
      this.blobId = BlobInfo.access$000(blobInfo);
      this.generatedId = BlobInfo.access$100(blobInfo);
      this.cacheControl = BlobInfo.access$200(blobInfo);
      this.contentEncoding = BlobInfo.access$300(blobInfo);
      this.contentType = BlobInfo.access$400(blobInfo);
      this.contentDisposition = BlobInfo.access$500(blobInfo);
      this.contentLanguage = BlobInfo.access$600(blobInfo);
      this.componentCount = BlobInfo.access$700(blobInfo);
      this.customerEncryption = BlobInfo.access$800(blobInfo);
      this.acl = BlobInfo.access$900(blobInfo);
      this.owner = BlobInfo.access$1000(blobInfo);
      this.size = BlobInfo.access$1100(blobInfo);
      this.etag = BlobInfo.access$1200(blobInfo);
      this.selfLink = BlobInfo.access$1300(blobInfo);
      this.md5 = BlobInfo.access$1400(blobInfo);
      this.crc32c = BlobInfo.access$1500(blobInfo);
      this.mediaLink = BlobInfo.access$1600(blobInfo);
      this.metadata = BlobInfo.access$1700(blobInfo);
      this.metageneration = BlobInfo.access$1800(blobInfo);
      this.deleteTime = BlobInfo.access$1900(blobInfo);
      this.updateTime = BlobInfo.access$2000(blobInfo);
      this.createTime = BlobInfo.access$2100(blobInfo);
      this.isDirectory = BlobInfo.access$2200(blobInfo);
      this.storageClass = BlobInfo.access$2300(blobInfo);
      this.kmsKeyName = BlobInfo.access$2400(blobInfo);
      this.eventBasedHold = BlobInfo.access$2500(blobInfo);
      this.temporaryHold = BlobInfo.access$2600(blobInfo);
      this.retentionExpirationTime = BlobInfo.access$2700(blobInfo);
   }

   public BlobInfo$Builder setBlobId(BlobId blobId) {
      this.blobId = (BlobId)Preconditions.checkNotNull(blobId);
      return this;
   }

   BlobInfo$Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
   }

   public BlobInfo$Builder setContentType(String contentType) {
      this.contentType = (String)MoreObjects.firstNonNull(contentType, Data.nullOf(String.class));
      return this;
   }

   public BlobInfo$Builder setContentDisposition(String contentDisposition) {
      this.contentDisposition = (String)MoreObjects.firstNonNull(contentDisposition, Data.nullOf(String.class));
      return this;
   }

   public BlobInfo$Builder setContentLanguage(String contentLanguage) {
      this.contentLanguage = (String)MoreObjects.firstNonNull(contentLanguage, Data.nullOf(String.class));
      return this;
   }

   public BlobInfo$Builder setContentEncoding(String contentEncoding) {
      this.contentEncoding = (String)MoreObjects.firstNonNull(contentEncoding, Data.nullOf(String.class));
      return this;
   }

   BlobInfo$Builder setComponentCount(Integer componentCount) {
      this.componentCount = componentCount;
      return this;
   }

   public BlobInfo$Builder setCacheControl(String cacheControl) {
      this.cacheControl = (String)MoreObjects.firstNonNull(cacheControl, Data.nullOf(String.class));
      return this;
   }

   public BlobInfo$Builder setAcl(List acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
   }

   BlobInfo$Builder setOwner(Acl$Entity owner) {
      this.owner = owner;
      return this;
   }

   BlobInfo$Builder setSize(Long size) {
      this.size = size;
      return this;
   }

   BlobInfo$Builder setEtag(String etag) {
      this.etag = etag;
      return this;
   }

   BlobInfo$Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
   }

   public BlobInfo$Builder setMd5(String md5) {
      this.md5 = (String)MoreObjects.firstNonNull(md5, Data.nullOf(String.class));
      return this;
   }

   public BlobInfo$Builder setMd5FromHexString(String md5HexString) {
      if (md5HexString == null) {
         return this;
      } else {
         byte[] bytes = (new BigInteger(md5HexString, 16)).toByteArray();
         int leadingEmptyBytes = bytes.length - md5HexString.length() / 2;
         if (leadingEmptyBytes > 0) {
            bytes = Arrays.copyOfRange(bytes, leadingEmptyBytes, bytes.length);
         }

         this.md5 = BaseEncoding.base64().encode(bytes);
         return this;
      }
   }

   public BlobInfo$Builder setCrc32c(String crc32c) {
      this.crc32c = (String)MoreObjects.firstNonNull(crc32c, Data.nullOf(String.class));
      return this;
   }

   public BlobInfo$Builder setCrc32cFromHexString(String crc32cHexString) {
      if (crc32cHexString == null) {
         return this;
      } else {
         byte[] bytes = (new BigInteger(crc32cHexString, 16)).toByteArray();
         int leadingEmptyBytes = bytes.length - crc32cHexString.length() / 2;
         if (leadingEmptyBytes > 0) {
            bytes = Arrays.copyOfRange(bytes, leadingEmptyBytes, bytes.length);
         }

         this.crc32c = BaseEncoding.base64().encode(bytes);
         return this;
      }
   }

   BlobInfo$Builder setMediaLink(String mediaLink) {
      this.mediaLink = mediaLink;
      return this;
   }

   public BlobInfo$Builder setMetadata(Map metadata) {
      if (metadata != null) {
         this.metadata = new HashMap(metadata);
      } else {
         this.metadata = (Map)Data.nullOf(BlobInfo$ImmutableEmptyMap.class);
      }

      return this;
   }

   public BlobInfo$Builder setStorageClass(StorageClass storageClass) {
      this.storageClass = storageClass;
      return this;
   }

   BlobInfo$Builder setMetageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
   }

   BlobInfo$Builder setDeleteTime(Long deleteTime) {
      this.deleteTime = deleteTime;
      return this;
   }

   BlobInfo$Builder setUpdateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   BlobInfo$Builder setCreateTime(Long createTime) {
      this.createTime = createTime;
      return this;
   }

   BlobInfo$Builder setIsDirectory(boolean isDirectory) {
      this.isDirectory = isDirectory;
      return this;
   }

   BlobInfo$Builder setCustomerEncryption(BlobInfo$CustomerEncryption customerEncryption) {
      this.customerEncryption = customerEncryption;
      return this;
   }

   BlobInfo$Builder setKmsKeyName(String kmsKeyName) {
      this.kmsKeyName = kmsKeyName;
      return this;
   }

   public BlobInfo$Builder setEventBasedHold(Boolean eventBasedHold) {
      this.eventBasedHold = eventBasedHold;
      return this;
   }

   public BlobInfo$Builder setTemporaryHold(Boolean temporaryHold) {
      this.temporaryHold = temporaryHold;
      return this;
   }

   BlobInfo$Builder setRetentionExpirationTime(Long retentionExpirationTime) {
      this.retentionExpirationTime = retentionExpirationTime;
      return this;
   }

   public BlobInfo build() {
      Preconditions.checkNotNull(this.blobId);
      return new BlobInfo(this);
   }

   // $FF: synthetic method
   static BlobId access$2800(BlobInfo$BuilderImpl x0) {
      return x0.blobId;
   }

   // $FF: synthetic method
   static String access$2900(BlobInfo$BuilderImpl x0) {
      return x0.generatedId;
   }

   // $FF: synthetic method
   static String access$3000(BlobInfo$BuilderImpl x0) {
      return x0.cacheControl;
   }

   // $FF: synthetic method
   static String access$3100(BlobInfo$BuilderImpl x0) {
      return x0.contentEncoding;
   }

   // $FF: synthetic method
   static String access$3200(BlobInfo$BuilderImpl x0) {
      return x0.contentType;
   }

   // $FF: synthetic method
   static String access$3300(BlobInfo$BuilderImpl x0) {
      return x0.contentDisposition;
   }

   // $FF: synthetic method
   static String access$3400(BlobInfo$BuilderImpl x0) {
      return x0.contentLanguage;
   }

   // $FF: synthetic method
   static Integer access$3500(BlobInfo$BuilderImpl x0) {
      return x0.componentCount;
   }

   // $FF: synthetic method
   static BlobInfo$CustomerEncryption access$3600(BlobInfo$BuilderImpl x0) {
      return x0.customerEncryption;
   }

   // $FF: synthetic method
   static List access$3700(BlobInfo$BuilderImpl x0) {
      return x0.acl;
   }

   // $FF: synthetic method
   static Acl$Entity access$3800(BlobInfo$BuilderImpl x0) {
      return x0.owner;
   }

   // $FF: synthetic method
   static Long access$3900(BlobInfo$BuilderImpl x0) {
      return x0.size;
   }

   // $FF: synthetic method
   static String access$4000(BlobInfo$BuilderImpl x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   static String access$4100(BlobInfo$BuilderImpl x0) {
      return x0.selfLink;
   }

   // $FF: synthetic method
   static String access$4200(BlobInfo$BuilderImpl x0) {
      return x0.md5;
   }

   // $FF: synthetic method
   static String access$4300(BlobInfo$BuilderImpl x0) {
      return x0.crc32c;
   }

   // $FF: synthetic method
   static String access$4400(BlobInfo$BuilderImpl x0) {
      return x0.mediaLink;
   }

   // $FF: synthetic method
   static Map access$4500(BlobInfo$BuilderImpl x0) {
      return x0.metadata;
   }

   // $FF: synthetic method
   static Long access$4600(BlobInfo$BuilderImpl x0) {
      return x0.metageneration;
   }

   // $FF: synthetic method
   static Long access$4700(BlobInfo$BuilderImpl x0) {
      return x0.deleteTime;
   }

   // $FF: synthetic method
   static Long access$4800(BlobInfo$BuilderImpl x0) {
      return x0.updateTime;
   }

   // $FF: synthetic method
   static Long access$4900(BlobInfo$BuilderImpl x0) {
      return x0.createTime;
   }

   // $FF: synthetic method
   static Boolean access$5000(BlobInfo$BuilderImpl x0) {
      return x0.isDirectory;
   }

   // $FF: synthetic method
   static StorageClass access$5100(BlobInfo$BuilderImpl x0) {
      return x0.storageClass;
   }

   // $FF: synthetic method
   static String access$5200(BlobInfo$BuilderImpl x0) {
      return x0.kmsKeyName;
   }

   // $FF: synthetic method
   static Boolean access$5300(BlobInfo$BuilderImpl x0) {
      return x0.eventBasedHold;
   }

   // $FF: synthetic method
   static Boolean access$5400(BlobInfo$BuilderImpl x0) {
      return x0.temporaryHold;
   }

   // $FF: synthetic method
   static Long access$5500(BlobInfo$BuilderImpl x0) {
      return x0.retentionExpirationTime;
   }
}
