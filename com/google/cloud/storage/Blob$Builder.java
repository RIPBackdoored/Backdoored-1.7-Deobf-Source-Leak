package com.google.cloud.storage;

import java.util.List;
import java.util.Map;

public class Blob$Builder extends BlobInfo$Builder {
   private final Storage storage;
   private final BlobInfo$BuilderImpl infoBuilder;

   Blob$Builder(Blob blob) {
      this.storage = blob.getStorage();
      this.infoBuilder = new BlobInfo$BuilderImpl(blob);
   }

   public Blob$Builder setBlobId(BlobId blobId) {
      this.infoBuilder.setBlobId(blobId);
      return this;
   }

   Blob$Builder setGeneratedId(String generatedId) {
      this.infoBuilder.setGeneratedId(generatedId);
      return this;
   }

   public Blob$Builder setContentType(String contentType) {
      this.infoBuilder.setContentType(contentType);
      return this;
   }

   public Blob$Builder setContentDisposition(String contentDisposition) {
      this.infoBuilder.setContentDisposition(contentDisposition);
      return this;
   }

   public Blob$Builder setContentLanguage(String contentLanguage) {
      this.infoBuilder.setContentLanguage(contentLanguage);
      return this;
   }

   public Blob$Builder setContentEncoding(String contentEncoding) {
      this.infoBuilder.setContentEncoding(contentEncoding);
      return this;
   }

   Blob$Builder setComponentCount(Integer componentCount) {
      this.infoBuilder.setComponentCount(componentCount);
      return this;
   }

   public Blob$Builder setCacheControl(String cacheControl) {
      this.infoBuilder.setCacheControl(cacheControl);
      return this;
   }

   public Blob$Builder setAcl(List acl) {
      this.infoBuilder.setAcl(acl);
      return this;
   }

   Blob$Builder setOwner(Acl$Entity owner) {
      this.infoBuilder.setOwner(owner);
      return this;
   }

   Blob$Builder setSize(Long size) {
      this.infoBuilder.setSize(size);
      return this;
   }

   Blob$Builder setEtag(String etag) {
      this.infoBuilder.setEtag(etag);
      return this;
   }

   Blob$Builder setSelfLink(String selfLink) {
      this.infoBuilder.setSelfLink(selfLink);
      return this;
   }

   public Blob$Builder setMd5(String md5) {
      this.infoBuilder.setMd5(md5);
      return this;
   }

   public Blob$Builder setMd5FromHexString(String md5HexString) {
      this.infoBuilder.setMd5FromHexString(md5HexString);
      return this;
   }

   public Blob$Builder setCrc32c(String crc32c) {
      this.infoBuilder.setCrc32c(crc32c);
      return this;
   }

   public Blob$Builder setCrc32cFromHexString(String crc32cHexString) {
      this.infoBuilder.setCrc32cFromHexString(crc32cHexString);
      return this;
   }

   Blob$Builder setMediaLink(String mediaLink) {
      this.infoBuilder.setMediaLink(mediaLink);
      return this;
   }

   public Blob$Builder setMetadata(Map metadata) {
      this.infoBuilder.setMetadata(metadata);
      return this;
   }

   public Blob$Builder setStorageClass(StorageClass storageClass) {
      this.infoBuilder.setStorageClass(storageClass);
      return this;
   }

   Blob$Builder setMetageneration(Long metageneration) {
      this.infoBuilder.setMetageneration(metageneration);
      return this;
   }

   Blob$Builder setDeleteTime(Long deleteTime) {
      this.infoBuilder.setDeleteTime(deleteTime);
      return this;
   }

   Blob$Builder setUpdateTime(Long updateTime) {
      this.infoBuilder.setUpdateTime(updateTime);
      return this;
   }

   Blob$Builder setCreateTime(Long createTime) {
      this.infoBuilder.setCreateTime(createTime);
      return this;
   }

   Blob$Builder setIsDirectory(boolean isDirectory) {
      this.infoBuilder.setIsDirectory(isDirectory);
      return this;
   }

   Blob$Builder setCustomerEncryption(BlobInfo$CustomerEncryption customerEncryption) {
      this.infoBuilder.setCustomerEncryption(customerEncryption);
      return this;
   }

   Blob$Builder setKmsKeyName(String kmsKeyName) {
      this.infoBuilder.setKmsKeyName(kmsKeyName);
      return this;
   }

   public Blob$Builder setEventBasedHold(Boolean eventBasedHold) {
      this.infoBuilder.setEventBasedHold(eventBasedHold);
      return this;
   }

   public Blob$Builder setTemporaryHold(Boolean temporaryHold) {
      this.infoBuilder.setTemporaryHold(temporaryHold);
      return this;
   }

   Blob$Builder setRetentionExpirationTime(Long retentionExpirationTime) {
      this.infoBuilder.setRetentionExpirationTime(retentionExpirationTime);
      return this;
   }

   public Blob build() {
      return new Blob(this.storage, this.infoBuilder);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo build() {
      return this.build();
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setRetentionExpirationTime(Long var1) {
      return this.setRetentionExpirationTime(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setTemporaryHold(Boolean var1) {
      return this.setTemporaryHold(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setEventBasedHold(Boolean var1) {
      return this.setEventBasedHold(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setKmsKeyName(String var1) {
      return this.setKmsKeyName(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setCustomerEncryption(BlobInfo$CustomerEncryption var1) {
      return this.setCustomerEncryption(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setIsDirectory(boolean var1) {
      return this.setIsDirectory(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setCreateTime(Long var1) {
      return this.setCreateTime(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setUpdateTime(Long var1) {
      return this.setUpdateTime(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setDeleteTime(Long var1) {
      return this.setDeleteTime(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setMetageneration(Long var1) {
      return this.setMetageneration(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setMetadata(Map var1) {
      return this.setMetadata(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setStorageClass(StorageClass var1) {
      return this.setStorageClass(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setMediaLink(String var1) {
      return this.setMediaLink(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setCrc32cFromHexString(String var1) {
      return this.setCrc32cFromHexString(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setCrc32c(String var1) {
      return this.setCrc32c(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setMd5FromHexString(String var1) {
      return this.setMd5FromHexString(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setMd5(String var1) {
      return this.setMd5(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setSelfLink(String var1) {
      return this.setSelfLink(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setEtag(String var1) {
      return this.setEtag(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setSize(Long var1) {
      return this.setSize(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setOwner(Acl$Entity var1) {
      return this.setOwner(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setAcl(List var1) {
      return this.setAcl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setCacheControl(String var1) {
      return this.setCacheControl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setComponentCount(Integer var1) {
      return this.setComponentCount(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setContentEncoding(String var1) {
      return this.setContentEncoding(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setContentLanguage(String var1) {
      return this.setContentLanguage(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setContentDisposition(String var1) {
      return this.setContentDisposition(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setContentType(String var1) {
      return this.setContentType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BlobInfo$Builder setGeneratedId(String var1) {
      return this.setGeneratedId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder setBlobId(BlobId var1) {
      return this.setBlobId(var1);
   }
}
