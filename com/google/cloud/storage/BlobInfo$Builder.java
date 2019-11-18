package com.google.cloud.storage;

import com.google.api.core.BetaApi;
import java.util.List;
import java.util.Map;

public abstract class BlobInfo$Builder {
   public abstract BlobInfo$Builder setBlobId(BlobId var1);

   abstract BlobInfo$Builder setGeneratedId(String var1);

   public abstract BlobInfo$Builder setContentType(String var1);

   public abstract BlobInfo$Builder setContentDisposition(String var1);

   public abstract BlobInfo$Builder setContentLanguage(String var1);

   public abstract BlobInfo$Builder setContentEncoding(String var1);

   abstract BlobInfo$Builder setComponentCount(Integer var1);

   public abstract BlobInfo$Builder setCacheControl(String var1);

   public abstract BlobInfo$Builder setAcl(List var1);

   abstract BlobInfo$Builder setOwner(Acl$Entity var1);

   abstract BlobInfo$Builder setSize(Long var1);

   abstract BlobInfo$Builder setEtag(String var1);

   abstract BlobInfo$Builder setSelfLink(String var1);

   public abstract BlobInfo$Builder setMd5(String var1);

   public abstract BlobInfo$Builder setMd5FromHexString(String var1);

   public abstract BlobInfo$Builder setCrc32c(String var1);

   public abstract BlobInfo$Builder setCrc32cFromHexString(String var1);

   abstract BlobInfo$Builder setMediaLink(String var1);

   public abstract BlobInfo$Builder setStorageClass(StorageClass var1);

   public abstract BlobInfo$Builder setMetadata(Map var1);

   abstract BlobInfo$Builder setMetageneration(Long var1);

   abstract BlobInfo$Builder setDeleteTime(Long var1);

   abstract BlobInfo$Builder setUpdateTime(Long var1);

   abstract BlobInfo$Builder setCreateTime(Long var1);

   abstract BlobInfo$Builder setIsDirectory(boolean var1);

   abstract BlobInfo$Builder setCustomerEncryption(BlobInfo$CustomerEncryption var1);

   abstract BlobInfo$Builder setKmsKeyName(String var1);

   @BetaApi
   public abstract BlobInfo$Builder setEventBasedHold(Boolean var1);

   @BetaApi
   public abstract BlobInfo$Builder setTemporaryHold(Boolean var1);

   @BetaApi
   abstract BlobInfo$Builder setRetentionExpirationTime(Long var1);

   public abstract BlobInfo build();
}
