package com.google.cloud.storage;

import com.google.api.client.util.Data;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;

final class BucketInfo$BuilderImpl extends BucketInfo$Builder {
   private String generatedId;
   private String name;
   private Acl$Entity owner;
   private String selfLink;
   private Boolean requesterPays;
   private Boolean versioningEnabled;
   private String indexPage;
   private String notFoundPage;
   private List deleteRules;
   private List lifecycleRules;
   private StorageClass storageClass;
   private String location;
   private String etag;
   private Long createTime;
   private Long metageneration;
   private List cors;
   private List acl;
   private List defaultAcl;
   private Map labels;
   private String defaultKmsKeyName;
   private Boolean defaultEventBasedHold;
   private Long retentionEffectiveTime;
   private Boolean retentionPolicyIsLocked;
   private Long retentionPeriod;
   private BucketInfo$IamConfiguration iamConfiguration;
   private String locationType;

   BucketInfo$BuilderImpl(String name) {
      this.name = name;
   }

   BucketInfo$BuilderImpl(BucketInfo bucketInfo) {
      this.generatedId = BucketInfo.access$1200(bucketInfo);
      this.name = BucketInfo.access$1300(bucketInfo);
      this.etag = BucketInfo.access$1400(bucketInfo);
      this.createTime = BucketInfo.access$1500(bucketInfo);
      this.metageneration = BucketInfo.access$1600(bucketInfo);
      this.location = BucketInfo.access$1700(bucketInfo);
      this.storageClass = BucketInfo.access$1800(bucketInfo);
      this.cors = BucketInfo.access$1900(bucketInfo);
      this.acl = BucketInfo.access$2000(bucketInfo);
      this.defaultAcl = BucketInfo.access$2100(bucketInfo);
      this.owner = BucketInfo.access$2200(bucketInfo);
      this.selfLink = BucketInfo.access$2300(bucketInfo);
      this.versioningEnabled = BucketInfo.access$2400(bucketInfo);
      this.indexPage = BucketInfo.access$2500(bucketInfo);
      this.notFoundPage = BucketInfo.access$2600(bucketInfo);
      this.deleteRules = BucketInfo.access$2700(bucketInfo);
      this.lifecycleRules = BucketInfo.access$2800(bucketInfo);
      this.labels = BucketInfo.access$2900(bucketInfo);
      this.requesterPays = BucketInfo.access$3000(bucketInfo);
      this.defaultKmsKeyName = BucketInfo.access$3100(bucketInfo);
      this.defaultEventBasedHold = BucketInfo.access$3200(bucketInfo);
      this.retentionEffectiveTime = BucketInfo.access$3300(bucketInfo);
      this.retentionPolicyIsLocked = BucketInfo.access$3400(bucketInfo);
      this.retentionPeriod = BucketInfo.access$3500(bucketInfo);
      this.iamConfiguration = BucketInfo.access$3600(bucketInfo);
      this.locationType = BucketInfo.access$3700(bucketInfo);
   }

   public BucketInfo$Builder setName(String name) {
      this.name = (String)Preconditions.checkNotNull(name);
      return this;
   }

   BucketInfo$Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
   }

   BucketInfo$Builder setOwner(Acl$Entity owner) {
      this.owner = owner;
      return this;
   }

   BucketInfo$Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
   }

   public BucketInfo$Builder setVersioningEnabled(Boolean enable) {
      this.versioningEnabled = (Boolean)MoreObjects.firstNonNull(enable, Data.nullOf(Boolean.class));
      return this;
   }

   public BucketInfo$Builder setRequesterPays(Boolean enable) {
      this.requesterPays = (Boolean)MoreObjects.firstNonNull(enable, Data.nullOf(Boolean.class));
      return this;
   }

   public BucketInfo$Builder setIndexPage(String indexPage) {
      this.indexPage = indexPage;
      return this;
   }

   public BucketInfo$Builder setNotFoundPage(String notFoundPage) {
      this.notFoundPage = notFoundPage;
      return this;
   }

   /** @deprecated */
   @Deprecated
   public BucketInfo$Builder setDeleteRules(Iterable rules) {
      this.deleteRules = rules != null ? ImmutableList.copyOf(rules) : null;
      return this;
   }

   public BucketInfo$Builder setLifecycleRules(Iterable rules) {
      this.lifecycleRules = rules != null ? ImmutableList.copyOf(rules) : null;
      return this;
   }

   public BucketInfo$Builder setStorageClass(StorageClass storageClass) {
      this.storageClass = storageClass;
      return this;
   }

   public BucketInfo$Builder setLocation(String location) {
      this.location = location;
      return this;
   }

   BucketInfo$Builder setEtag(String etag) {
      this.etag = etag;
      return this;
   }

   BucketInfo$Builder setCreateTime(Long createTime) {
      this.createTime = createTime;
      return this;
   }

   BucketInfo$Builder setMetageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
   }

   public BucketInfo$Builder setCors(Iterable cors) {
      this.cors = cors != null ? ImmutableList.copyOf(cors) : null;
      return this;
   }

   public BucketInfo$Builder setAcl(Iterable acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
   }

   public BucketInfo$Builder setDefaultAcl(Iterable acl) {
      this.defaultAcl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
   }

   public BucketInfo$Builder setLabels(Map labels) {
      this.labels = labels != null ? ImmutableMap.copyOf(labels) : null;
      return this;
   }

   public BucketInfo$Builder setDefaultKmsKeyName(String defaultKmsKeyName) {
      this.defaultKmsKeyName = defaultKmsKeyName != null ? defaultKmsKeyName : (String)Data.nullOf(String.class);
      return this;
   }

   public BucketInfo$Builder setDefaultEventBasedHold(Boolean defaultEventBasedHold) {
      this.defaultEventBasedHold = (Boolean)MoreObjects.firstNonNull(defaultEventBasedHold, Data.nullOf(Boolean.class));
      return this;
   }

   BucketInfo$Builder setRetentionEffectiveTime(Long retentionEffectiveTime) {
      this.retentionEffectiveTime = (Long)MoreObjects.firstNonNull(retentionEffectiveTime, Data.nullOf(Long.class));
      return this;
   }

   BucketInfo$Builder setRetentionPolicyIsLocked(Boolean retentionPolicyIsLocked) {
      this.retentionPolicyIsLocked = (Boolean)MoreObjects.firstNonNull(retentionPolicyIsLocked, Data.nullOf(Boolean.class));
      return this;
   }

   public BucketInfo$Builder setRetentionPeriod(Long retentionPeriod) {
      this.retentionPeriod = (Long)MoreObjects.firstNonNull(retentionPeriod, Data.nullOf(Long.class));
      return this;
   }

   public BucketInfo$Builder setIamConfiguration(BucketInfo$IamConfiguration iamConfiguration) {
      this.iamConfiguration = iamConfiguration;
      return this;
   }

   BucketInfo$Builder setLocationType(String locationType) {
      this.locationType = locationType;
      return this;
   }

   public BucketInfo build() {
      Preconditions.checkNotNull(this.name);
      return new BucketInfo(this);
   }

   // $FF: synthetic method
   static String access$3800(BucketInfo$BuilderImpl x0) {
      return x0.generatedId;
   }

   // $FF: synthetic method
   static String access$3900(BucketInfo$BuilderImpl x0) {
      return x0.name;
   }

   // $FF: synthetic method
   static String access$4000(BucketInfo$BuilderImpl x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   static Long access$4100(BucketInfo$BuilderImpl x0) {
      return x0.createTime;
   }

   // $FF: synthetic method
   static Long access$4200(BucketInfo$BuilderImpl x0) {
      return x0.metageneration;
   }

   // $FF: synthetic method
   static String access$4300(BucketInfo$BuilderImpl x0) {
      return x0.location;
   }

   // $FF: synthetic method
   static StorageClass access$4400(BucketInfo$BuilderImpl x0) {
      return x0.storageClass;
   }

   // $FF: synthetic method
   static List access$4500(BucketInfo$BuilderImpl x0) {
      return x0.cors;
   }

   // $FF: synthetic method
   static List access$4600(BucketInfo$BuilderImpl x0) {
      return x0.acl;
   }

   // $FF: synthetic method
   static List access$4700(BucketInfo$BuilderImpl x0) {
      return x0.defaultAcl;
   }

   // $FF: synthetic method
   static Acl$Entity access$4800(BucketInfo$BuilderImpl x0) {
      return x0.owner;
   }

   // $FF: synthetic method
   static String access$4900(BucketInfo$BuilderImpl x0) {
      return x0.selfLink;
   }

   // $FF: synthetic method
   static Boolean access$5000(BucketInfo$BuilderImpl x0) {
      return x0.versioningEnabled;
   }

   // $FF: synthetic method
   static String access$5100(BucketInfo$BuilderImpl x0) {
      return x0.indexPage;
   }

   // $FF: synthetic method
   static String access$5200(BucketInfo$BuilderImpl x0) {
      return x0.notFoundPage;
   }

   // $FF: synthetic method
   static List access$5300(BucketInfo$BuilderImpl x0) {
      return x0.deleteRules;
   }

   // $FF: synthetic method
   static List access$5400(BucketInfo$BuilderImpl x0) {
      return x0.lifecycleRules;
   }

   // $FF: synthetic method
   static Map access$5500(BucketInfo$BuilderImpl x0) {
      return x0.labels;
   }

   // $FF: synthetic method
   static Boolean access$5600(BucketInfo$BuilderImpl x0) {
      return x0.requesterPays;
   }

   // $FF: synthetic method
   static String access$5700(BucketInfo$BuilderImpl x0) {
      return x0.defaultKmsKeyName;
   }

   // $FF: synthetic method
   static Boolean access$5800(BucketInfo$BuilderImpl x0) {
      return x0.defaultEventBasedHold;
   }

   // $FF: synthetic method
   static Long access$5900(BucketInfo$BuilderImpl x0) {
      return x0.retentionEffectiveTime;
   }

   // $FF: synthetic method
   static Boolean access$6000(BucketInfo$BuilderImpl x0) {
      return x0.retentionPolicyIsLocked;
   }

   // $FF: synthetic method
   static Long access$6100(BucketInfo$BuilderImpl x0) {
      return x0.retentionPeriod;
   }

   // $FF: synthetic method
   static BucketInfo$IamConfiguration access$6200(BucketInfo$BuilderImpl x0) {
      return x0.iamConfiguration;
   }

   // $FF: synthetic method
   static String access$6300(BucketInfo$BuilderImpl x0) {
      return x0.locationType;
   }
}
