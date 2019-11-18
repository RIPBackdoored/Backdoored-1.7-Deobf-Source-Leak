package com.google.cloud.storage;

import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.core.BetaApi;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.StorageObject.Owner;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.BaseEncoding;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class BlobInfo implements Serializable {
   static final Function INFO_TO_PB_FUNCTION = new BlobInfo$1();
   private static final long serialVersionUID = -5625857076205028976L;
   private final BlobId blobId;
   private final String generatedId;
   private final String selfLink;
   private final String cacheControl;
   private final List acl;
   private final Acl$Entity owner;
   private final Long size;
   private final String etag;
   private final String md5;
   private final String crc32c;
   private final String mediaLink;
   private final Map metadata;
   private final Long metageneration;
   private final Long deleteTime;
   private final Long updateTime;
   private final Long createTime;
   private final String contentType;
   private final String contentEncoding;
   private final String contentDisposition;
   private final String contentLanguage;
   private final StorageClass storageClass;
   private final Integer componentCount;
   private final boolean isDirectory;
   private final BlobInfo$CustomerEncryption customerEncryption;
   private final String kmsKeyName;
   private final Boolean eventBasedHold;
   private final Boolean temporaryHold;
   private final Long retentionExpirationTime;

   BlobInfo(BlobInfo$BuilderImpl builder) {
      this.blobId = BlobInfo$BuilderImpl.access$2800(builder);
      this.generatedId = BlobInfo$BuilderImpl.access$2900(builder);
      this.cacheControl = BlobInfo$BuilderImpl.access$3000(builder);
      this.contentEncoding = BlobInfo$BuilderImpl.access$3100(builder);
      this.contentType = BlobInfo$BuilderImpl.access$3200(builder);
      this.contentDisposition = BlobInfo$BuilderImpl.access$3300(builder);
      this.contentLanguage = BlobInfo$BuilderImpl.access$3400(builder);
      this.componentCount = BlobInfo$BuilderImpl.access$3500(builder);
      this.customerEncryption = BlobInfo$BuilderImpl.access$3600(builder);
      this.acl = BlobInfo$BuilderImpl.access$3700(builder);
      this.owner = BlobInfo$BuilderImpl.access$3800(builder);
      this.size = BlobInfo$BuilderImpl.access$3900(builder);
      this.etag = BlobInfo$BuilderImpl.access$4000(builder);
      this.selfLink = BlobInfo$BuilderImpl.access$4100(builder);
      this.md5 = BlobInfo$BuilderImpl.access$4200(builder);
      this.crc32c = BlobInfo$BuilderImpl.access$4300(builder);
      this.mediaLink = BlobInfo$BuilderImpl.access$4400(builder);
      this.metadata = BlobInfo$BuilderImpl.access$4500(builder);
      this.metageneration = BlobInfo$BuilderImpl.access$4600(builder);
      this.deleteTime = BlobInfo$BuilderImpl.access$4700(builder);
      this.updateTime = BlobInfo$BuilderImpl.access$4800(builder);
      this.createTime = BlobInfo$BuilderImpl.access$4900(builder);
      this.isDirectory = (Boolean)MoreObjects.firstNonNull(BlobInfo$BuilderImpl.access$5000(builder), Boolean.FALSE);
      this.storageClass = BlobInfo$BuilderImpl.access$5100(builder);
      this.kmsKeyName = BlobInfo$BuilderImpl.access$5200(builder);
      this.eventBasedHold = BlobInfo$BuilderImpl.access$5300(builder);
      this.temporaryHold = BlobInfo$BuilderImpl.access$5400(builder);
      this.retentionExpirationTime = BlobInfo$BuilderImpl.access$5500(builder);
   }

   public BlobId getBlobId() {
      return this.blobId;
   }

   public String getBucket() {
      return this.getBlobId().getBucket();
   }

   public String getGeneratedId() {
      return this.generatedId;
   }

   public String getName() {
      return this.getBlobId().getName();
   }

   public String getCacheControl() {
      return Data.isNull(this.cacheControl) ? null : this.cacheControl;
   }

   public List getAcl() {
      return this.acl;
   }

   public Acl$Entity getOwner() {
      return this.owner;
   }

   public Long getSize() {
      return this.size;
   }

   public String getContentType() {
      return Data.isNull(this.contentType) ? null : this.contentType;
   }

   public String getContentEncoding() {
      return Data.isNull(this.contentEncoding) ? null : this.contentEncoding;
   }

   public String getContentDisposition() {
      return Data.isNull(this.contentDisposition) ? null : this.contentDisposition;
   }

   public String getContentLanguage() {
      return Data.isNull(this.contentLanguage) ? null : this.contentLanguage;
   }

   public Integer getComponentCount() {
      return this.componentCount;
   }

   public String getEtag() {
      return this.etag;
   }

   public String getSelfLink() {
      return this.selfLink;
   }

   public String getMd5() {
      return Data.isNull(this.md5) ? null : this.md5;
   }

   public String getMd5ToHexString() {
      if (this.md5 == null) {
         return null;
      } else {
         byte[] decodedMd5 = BaseEncoding.base64().decode(this.md5);
         StringBuilder stringBuilder = new StringBuilder();
         byte[] var3 = decodedMd5;
         int var4 = decodedMd5.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            stringBuilder.append(String.format("%02x", b & 255));
         }

         return stringBuilder.toString();
      }
   }

   public String getCrc32c() {
      return Data.isNull(this.crc32c) ? null : this.crc32c;
   }

   public String getCrc32cToHexString() {
      if (this.crc32c == null) {
         return null;
      } else {
         byte[] decodeCrc32c = BaseEncoding.base64().decode(this.crc32c);
         StringBuilder stringBuilder = new StringBuilder();
         byte[] var3 = decodeCrc32c;
         int var4 = decodeCrc32c.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            stringBuilder.append(String.format("%02x", b & 255));
         }

         return stringBuilder.toString();
      }
   }

   public String getMediaLink() {
      return this.mediaLink;
   }

   public Map getMetadata() {
      return this.metadata != null && !Data.isNull(this.metadata) ? Collections.unmodifiableMap(this.metadata) : null;
   }

   public Long getGeneration() {
      return this.getBlobId().getGeneration();
   }

   public Long getMetageneration() {
      return this.metageneration;
   }

   public Long getDeleteTime() {
      return this.deleteTime;
   }

   public Long getUpdateTime() {
      return this.updateTime;
   }

   public Long getCreateTime() {
      return this.createTime;
   }

   public boolean isDirectory() {
      return this.isDirectory;
   }

   public BlobInfo$CustomerEncryption getCustomerEncryption() {
      return this.customerEncryption;
   }

   public StorageClass getStorageClass() {
      return this.storageClass;
   }

   public String getKmsKeyName() {
      return this.kmsKeyName;
   }

   @BetaApi
   public Boolean getEventBasedHold() {
      return Data.isNull(this.eventBasedHold) ? null : this.eventBasedHold;
   }

   @BetaApi
   public Boolean getTemporaryHold() {
      return Data.isNull(this.temporaryHold) ? null : this.temporaryHold;
   }

   @BetaApi
   public Long getRetentionExpirationTime() {
      return Data.isNull(this.retentionExpirationTime) ? null : this.retentionExpirationTime;
   }

   public BlobInfo$Builder toBuilder() {
      return new BlobInfo$BuilderImpl(this);
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("bucket", this.getBucket()).add("name", this.getName()).add("generation", this.getGeneration()).add("size", this.getSize()).add("content-type", this.getContentType()).add("metadata", this.getMetadata()).toString();
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.blobId});
   }

   public boolean equals(Object obj) {
      return obj == this || obj != null && obj.getClass().equals(BlobInfo.class) && Objects.equals(this.toPb(), ((BlobInfo)obj).toPb());
   }

   StorageObject toPb() {
      StorageObject storageObject = this.blobId.toPb();
      if (this.acl != null) {
         storageObject.setAcl(Lists.transform(this.acl, new BlobInfo$2(this)));
      }

      if (this.deleteTime != null) {
         storageObject.setTimeDeleted(new DateTime(this.deleteTime));
      }

      if (this.updateTime != null) {
         storageObject.setUpdated(new DateTime(this.updateTime));
      }

      if (this.createTime != null) {
         storageObject.setTimeCreated(new DateTime(this.createTime));
      }

      if (this.size != null) {
         storageObject.setSize(BigInteger.valueOf(this.size));
      }

      if (this.owner != null) {
         storageObject.setOwner((new Owner()).setEntity(this.owner.toPb()));
      }

      if (this.storageClass != null) {
         storageObject.setStorageClass(this.storageClass.toString());
      }

      Map pbMetadata = this.metadata;
      if (this.metadata != null && !Data.isNull(this.metadata)) {
         pbMetadata = Maps.newHashMapWithExpectedSize(this.metadata.size());
         Iterator var3 = this.metadata.entrySet().iterator();

         while(var3.hasNext()) {
            Entry entry = (Entry)var3.next();
            ((Map)pbMetadata).put(entry.getKey(), MoreObjects.firstNonNull(entry.getValue(), Data.nullOf(String.class)));
         }
      }

      if (this.customerEncryption != null) {
         storageObject.setCustomerEncryption(this.customerEncryption.toPb());
      }

      if (this.retentionExpirationTime != null) {
         storageObject.setRetentionExpirationTime(new DateTime(this.retentionExpirationTime));
      }

      storageObject.setKmsKeyName(this.kmsKeyName);
      storageObject.setEventBasedHold(this.eventBasedHold);
      storageObject.setTemporaryHold(this.temporaryHold);
      storageObject.setMetadata((Map)pbMetadata);
      storageObject.setCacheControl(this.cacheControl);
      storageObject.setContentEncoding(this.contentEncoding);
      storageObject.setCrc32c(this.crc32c);
      storageObject.setContentType(this.contentType);
      storageObject.setMd5Hash(this.md5);
      storageObject.setMediaLink(this.mediaLink);
      storageObject.setMetageneration(this.metageneration);
      storageObject.setContentDisposition(this.contentDisposition);
      storageObject.setComponentCount(this.componentCount);
      storageObject.setContentLanguage(this.contentLanguage);
      storageObject.setEtag(this.etag);
      storageObject.setId(this.generatedId);
      storageObject.setSelfLink(this.selfLink);
      return storageObject;
   }

   public static BlobInfo$Builder newBuilder(BucketInfo bucketInfo, String name) {
      return newBuilder(bucketInfo.getName(), name);
   }

   public static BlobInfo$Builder newBuilder(String bucket, String name) {
      return newBuilder(BlobId.of(bucket, name));
   }

   public static BlobInfo$Builder newBuilder(BucketInfo bucketInfo, String name, Long generation) {
      return newBuilder(bucketInfo.getName(), name, generation);
   }

   public static BlobInfo$Builder newBuilder(String bucket, String name, Long generation) {
      return newBuilder(BlobId.of(bucket, name, generation));
   }

   public static BlobInfo$Builder newBuilder(BlobId blobId) {
      return new BlobInfo$BuilderImpl(blobId);
   }

   static BlobInfo fromPb(StorageObject storageObject) {
      BlobInfo$Builder builder = newBuilder(BlobId.fromPb(storageObject));
      if (storageObject.getCacheControl() != null) {
         builder.setCacheControl(storageObject.getCacheControl());
      }

      if (storageObject.getContentEncoding() != null) {
         builder.setContentEncoding(storageObject.getContentEncoding());
      }

      if (storageObject.getCrc32c() != null) {
         builder.setCrc32c(storageObject.getCrc32c());
      }

      if (storageObject.getContentType() != null) {
         builder.setContentType(storageObject.getContentType());
      }

      if (storageObject.getMd5Hash() != null) {
         builder.setMd5(storageObject.getMd5Hash());
      }

      if (storageObject.getMediaLink() != null) {
         builder.setMediaLink(storageObject.getMediaLink());
      }

      if (storageObject.getMetageneration() != null) {
         builder.setMetageneration(storageObject.getMetageneration());
      }

      if (storageObject.getContentDisposition() != null) {
         builder.setContentDisposition(storageObject.getContentDisposition());
      }

      if (storageObject.getComponentCount() != null) {
         builder.setComponentCount(storageObject.getComponentCount());
      }

      if (storageObject.getContentLanguage() != null) {
         builder.setContentLanguage(storageObject.getContentLanguage());
      }

      if (storageObject.getEtag() != null) {
         builder.setEtag(storageObject.getEtag());
      }

      if (storageObject.getId() != null) {
         builder.setGeneratedId(storageObject.getId());
      }

      if (storageObject.getSelfLink() != null) {
         builder.setSelfLink(storageObject.getSelfLink());
      }

      if (storageObject.getMetadata() != null) {
         builder.setMetadata(storageObject.getMetadata());
      }

      if (storageObject.getTimeDeleted() != null) {
         builder.setDeleteTime(storageObject.getTimeDeleted().getValue());
      }

      if (storageObject.getUpdated() != null) {
         builder.setUpdateTime(storageObject.getUpdated().getValue());
      }

      if (storageObject.getTimeCreated() != null) {
         builder.setCreateTime(storageObject.getTimeCreated().getValue());
      }

      if (storageObject.getSize() != null) {
         builder.setSize(storageObject.getSize().longValue());
      }

      if (storageObject.getOwner() != null) {
         builder.setOwner(Acl$Entity.fromPb(storageObject.getOwner().getEntity()));
      }

      if (storageObject.getAcl() != null) {
         builder.setAcl(Lists.transform(storageObject.getAcl(), new BlobInfo$3()));
      }

      if (storageObject.containsKey("isDirectory")) {
         builder.setIsDirectory(Boolean.TRUE);
      }

      if (storageObject.getCustomerEncryption() != null) {
         builder.setCustomerEncryption(BlobInfo$CustomerEncryption.fromPb(storageObject.getCustomerEncryption()));
      }

      if (storageObject.getStorageClass() != null) {
         builder.setStorageClass(StorageClass.valueOf(storageObject.getStorageClass()));
      }

      if (storageObject.getKmsKeyName() != null) {
         builder.setKmsKeyName(storageObject.getKmsKeyName());
      }

      if (storageObject.getEventBasedHold() != null) {
         builder.setEventBasedHold(storageObject.getEventBasedHold());
      }

      if (storageObject.getTemporaryHold() != null) {
         builder.setTemporaryHold(storageObject.getTemporaryHold());
      }

      if (storageObject.getRetentionExpirationTime() != null) {
         builder.setRetentionExpirationTime(storageObject.getRetentionExpirationTime().getValue());
      }

      return builder.build();
   }

   // $FF: synthetic method
   static BlobId access$000(BlobInfo x0) {
      return x0.blobId;
   }

   // $FF: synthetic method
   static String access$100(BlobInfo x0) {
      return x0.generatedId;
   }

   // $FF: synthetic method
   static String access$200(BlobInfo x0) {
      return x0.cacheControl;
   }

   // $FF: synthetic method
   static String access$300(BlobInfo x0) {
      return x0.contentEncoding;
   }

   // $FF: synthetic method
   static String access$400(BlobInfo x0) {
      return x0.contentType;
   }

   // $FF: synthetic method
   static String access$500(BlobInfo x0) {
      return x0.contentDisposition;
   }

   // $FF: synthetic method
   static String access$600(BlobInfo x0) {
      return x0.contentLanguage;
   }

   // $FF: synthetic method
   static Integer access$700(BlobInfo x0) {
      return x0.componentCount;
   }

   // $FF: synthetic method
   static BlobInfo$CustomerEncryption access$800(BlobInfo x0) {
      return x0.customerEncryption;
   }

   // $FF: synthetic method
   static List access$900(BlobInfo x0) {
      return x0.acl;
   }

   // $FF: synthetic method
   static Acl$Entity access$1000(BlobInfo x0) {
      return x0.owner;
   }

   // $FF: synthetic method
   static Long access$1100(BlobInfo x0) {
      return x0.size;
   }

   // $FF: synthetic method
   static String access$1200(BlobInfo x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   static String access$1300(BlobInfo x0) {
      return x0.selfLink;
   }

   // $FF: synthetic method
   static String access$1400(BlobInfo x0) {
      return x0.md5;
   }

   // $FF: synthetic method
   static String access$1500(BlobInfo x0) {
      return x0.crc32c;
   }

   // $FF: synthetic method
   static String access$1600(BlobInfo x0) {
      return x0.mediaLink;
   }

   // $FF: synthetic method
   static Map access$1700(BlobInfo x0) {
      return x0.metadata;
   }

   // $FF: synthetic method
   static Long access$1800(BlobInfo x0) {
      return x0.metageneration;
   }

   // $FF: synthetic method
   static Long access$1900(BlobInfo x0) {
      return x0.deleteTime;
   }

   // $FF: synthetic method
   static Long access$2000(BlobInfo x0) {
      return x0.updateTime;
   }

   // $FF: synthetic method
   static Long access$2100(BlobInfo x0) {
      return x0.createTime;
   }

   // $FF: synthetic method
   static boolean access$2200(BlobInfo x0) {
      return x0.isDirectory;
   }

   // $FF: synthetic method
   static StorageClass access$2300(BlobInfo x0) {
      return x0.storageClass;
   }

   // $FF: synthetic method
   static String access$2400(BlobInfo x0) {
      return x0.kmsKeyName;
   }

   // $FF: synthetic method
   static Boolean access$2500(BlobInfo x0) {
      return x0.eventBasedHold;
   }

   // $FF: synthetic method
   static Boolean access$2600(BlobInfo x0) {
      return x0.temporaryHold;
   }

   // $FF: synthetic method
   static Long access$2700(BlobInfo x0) {
      return x0.retentionExpirationTime;
   }
}
