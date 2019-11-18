package com.google.cloud.storage;

import com.google.api.core.BetaApi;
import java.util.Map;

public abstract class BucketInfo$Builder {
   BucketInfo$Builder() {
   }

   public abstract BucketInfo$Builder setName(String var1);

   abstract BucketInfo$Builder setGeneratedId(String var1);

   abstract BucketInfo$Builder setOwner(Acl$Entity var1);

   abstract BucketInfo$Builder setSelfLink(String var1);

   public abstract BucketInfo$Builder setRequesterPays(Boolean var1);

   public abstract BucketInfo$Builder setVersioningEnabled(Boolean var1);

   public abstract BucketInfo$Builder setIndexPage(String var1);

   public abstract BucketInfo$Builder setNotFoundPage(String var1);

   /** @deprecated */
   @Deprecated
   public abstract BucketInfo$Builder setDeleteRules(Iterable var1);

   public abstract BucketInfo$Builder setLifecycleRules(Iterable var1);

   public abstract BucketInfo$Builder setStorageClass(StorageClass var1);

   public abstract BucketInfo$Builder setLocation(String var1);

   abstract BucketInfo$Builder setEtag(String var1);

   abstract BucketInfo$Builder setCreateTime(Long var1);

   abstract BucketInfo$Builder setMetageneration(Long var1);

   abstract BucketInfo$Builder setLocationType(String var1);

   public abstract BucketInfo$Builder setCors(Iterable var1);

   public abstract BucketInfo$Builder setAcl(Iterable var1);

   public abstract BucketInfo$Builder setDefaultAcl(Iterable var1);

   public abstract BucketInfo$Builder setLabels(Map var1);

   public abstract BucketInfo$Builder setDefaultKmsKeyName(String var1);

   @BetaApi
   public abstract BucketInfo$Builder setDefaultEventBasedHold(Boolean var1);

   @BetaApi
   abstract BucketInfo$Builder setRetentionEffectiveTime(Long var1);

   @BetaApi
   abstract BucketInfo$Builder setRetentionPolicyIsLocked(Boolean var1);

   @BetaApi
   public abstract BucketInfo$Builder setRetentionPeriod(Long var1);

   @BetaApi
   public abstract BucketInfo$Builder setIamConfiguration(BucketInfo$IamConfiguration var1);

   public abstract BucketInfo build();
}
