package com.google.cloud.storage;

import java.util.Map;

public class Bucket$Builder extends BucketInfo$Builder {
   private final Storage storage;
   private final BucketInfo$BuilderImpl infoBuilder;

   Bucket$Builder(Bucket bucket) {
      this.storage = Bucket.access$100(bucket);
      this.infoBuilder = new BucketInfo$BuilderImpl(bucket);
   }

   public Bucket$Builder setName(String name) {
      this.infoBuilder.setName(name);
      return this;
   }

   Bucket$Builder setGeneratedId(String generatedId) {
      this.infoBuilder.setGeneratedId(generatedId);
      return this;
   }

   Bucket$Builder setOwner(Acl$Entity owner) {
      this.infoBuilder.setOwner(owner);
      return this;
   }

   Bucket$Builder setSelfLink(String selfLink) {
      this.infoBuilder.setSelfLink(selfLink);
      return this;
   }

   public Bucket$Builder setVersioningEnabled(Boolean enable) {
      this.infoBuilder.setVersioningEnabled(enable);
      return this;
   }

   public Bucket$Builder setRequesterPays(Boolean requesterPays) {
      this.infoBuilder.setRequesterPays(requesterPays);
      return this;
   }

   public Bucket$Builder setIndexPage(String indexPage) {
      this.infoBuilder.setIndexPage(indexPage);
      return this;
   }

   public Bucket$Builder setNotFoundPage(String notFoundPage) {
      this.infoBuilder.setNotFoundPage(notFoundPage);
      return this;
   }

   /** @deprecated */
   @Deprecated
   public Bucket$Builder setDeleteRules(Iterable rules) {
      this.infoBuilder.setDeleteRules(rules);
      return this;
   }

   public Bucket$Builder setLifecycleRules(Iterable rules) {
      this.infoBuilder.setLifecycleRules(rules);
      return this;
   }

   public Bucket$Builder setStorageClass(StorageClass storageClass) {
      this.infoBuilder.setStorageClass(storageClass);
      return this;
   }

   public Bucket$Builder setLocation(String location) {
      this.infoBuilder.setLocation(location);
      return this;
   }

   Bucket$Builder setEtag(String etag) {
      this.infoBuilder.setEtag(etag);
      return this;
   }

   Bucket$Builder setCreateTime(Long createTime) {
      this.infoBuilder.setCreateTime(createTime);
      return this;
   }

   Bucket$Builder setMetageneration(Long metageneration) {
      this.infoBuilder.setMetageneration(metageneration);
      return this;
   }

   public Bucket$Builder setCors(Iterable cors) {
      this.infoBuilder.setCors(cors);
      return this;
   }

   public Bucket$Builder setAcl(Iterable acl) {
      this.infoBuilder.setAcl(acl);
      return this;
   }

   public Bucket$Builder setDefaultAcl(Iterable acl) {
      this.infoBuilder.setDefaultAcl(acl);
      return this;
   }

   public Bucket$Builder setLabels(Map labels) {
      this.infoBuilder.setLabels(labels);
      return this;
   }

   public Bucket$Builder setDefaultKmsKeyName(String defaultKmsKeyName) {
      this.infoBuilder.setDefaultKmsKeyName(defaultKmsKeyName);
      return this;
   }

   public Bucket$Builder setDefaultEventBasedHold(Boolean defaultEventBasedHold) {
      this.infoBuilder.setDefaultEventBasedHold(defaultEventBasedHold);
      return this;
   }

   Bucket$Builder setRetentionEffectiveTime(Long retentionEffectiveTime) {
      this.infoBuilder.setRetentionEffectiveTime(retentionEffectiveTime);
      return this;
   }

   Bucket$Builder setRetentionPolicyIsLocked(Boolean retentionIsLocked) {
      this.infoBuilder.setRetentionPolicyIsLocked(retentionIsLocked);
      return this;
   }

   public Bucket$Builder setRetentionPeriod(Long retentionPeriod) {
      this.infoBuilder.setRetentionPeriod(retentionPeriod);
      return this;
   }

   public Bucket$Builder setIamConfiguration(BucketInfo$IamConfiguration iamConfiguration) {
      this.infoBuilder.setIamConfiguration(iamConfiguration);
      return this;
   }

   Bucket$Builder setLocationType(String locationType) {
      this.infoBuilder.setLocationType(locationType);
      return this;
   }

   public Bucket build() {
      return new Bucket(this.storage, this.infoBuilder);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo build() {
      return this.build();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setIamConfiguration(BucketInfo$IamConfiguration var1) {
      return this.setIamConfiguration(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setRetentionPeriod(Long var1) {
      return this.setRetentionPeriod(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setRetentionPolicyIsLocked(Boolean var1) {
      return this.setRetentionPolicyIsLocked(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setRetentionEffectiveTime(Long var1) {
      return this.setRetentionEffectiveTime(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setDefaultEventBasedHold(Boolean var1) {
      return this.setDefaultEventBasedHold(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setDefaultKmsKeyName(String var1) {
      return this.setDefaultKmsKeyName(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setLabels(Map var1) {
      return this.setLabels(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setDefaultAcl(Iterable var1) {
      return this.setDefaultAcl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setAcl(Iterable var1) {
      return this.setAcl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setCors(Iterable var1) {
      return this.setCors(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setLocationType(String var1) {
      return this.setLocationType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setMetageneration(Long var1) {
      return this.setMetageneration(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setCreateTime(Long var1) {
      return this.setCreateTime(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setEtag(String var1) {
      return this.setEtag(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setLocation(String var1) {
      return this.setLocation(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setStorageClass(StorageClass var1) {
      return this.setStorageClass(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setLifecycleRules(Iterable var1) {
      return this.setLifecycleRules(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   @Deprecated
   public BucketInfo$Builder setDeleteRules(Iterable var1) {
      return this.setDeleteRules(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setNotFoundPage(String var1) {
      return this.setNotFoundPage(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setIndexPage(String var1) {
      return this.setIndexPage(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setVersioningEnabled(Boolean var1) {
      return this.setVersioningEnabled(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setRequesterPays(Boolean var1) {
      return this.setRequesterPays(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setSelfLink(String var1) {
      return this.setSelfLink(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setOwner(Acl$Entity var1) {
      return this.setOwner(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   BucketInfo$Builder setGeneratedId(String var1) {
      return this.setGeneratedId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder setName(String var1) {
      return this.setName(var1);
   }
}
