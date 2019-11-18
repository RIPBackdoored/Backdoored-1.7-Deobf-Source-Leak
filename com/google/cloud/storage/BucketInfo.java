package com.google.cloud.storage;

import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.core.BetaApi;
import com.google.api.services.storage.model.Bucket.Billing;
import com.google.api.services.storage.model.Bucket.Encryption;
import com.google.api.services.storage.model.Bucket.Lifecycle;
import com.google.api.services.storage.model.Bucket.Owner;
import com.google.api.services.storage.model.Bucket.RetentionPolicy;
import com.google.api.services.storage.model.Bucket.Versioning;
import com.google.api.services.storage.model.Bucket.Website;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BucketInfo implements Serializable {
   static final Function FROM_PB_FUNCTION = new BucketInfo$1();
   static final Function TO_PB_FUNCTION = new BucketInfo$2();
   private static final long serialVersionUID = -4712013629621638459L;
   private final String generatedId;
   private final String name;
   private final Acl$Entity owner;
   private final String selfLink;
   private final Boolean requesterPays;
   private final Boolean versioningEnabled;
   private final String indexPage;
   private final String notFoundPage;
   private final List deleteRules;
   private final List lifecycleRules;
   private final String etag;
   private final Long createTime;
   private final Long metageneration;
   private final List cors;
   private final List acl;
   private final List defaultAcl;
   private final String location;
   private final StorageClass storageClass;
   private final Map labels;
   private final String defaultKmsKeyName;
   private final Boolean defaultEventBasedHold;
   private final Long retentionEffectiveTime;
   private final Boolean retentionPolicyIsLocked;
   private final Long retentionPeriod;
   private final BucketInfo$IamConfiguration iamConfiguration;
   private final String locationType;

   BucketInfo(BucketInfo$BuilderImpl builder) {
      this.generatedId = BucketInfo$BuilderImpl.access$3800(builder);
      this.name = BucketInfo$BuilderImpl.access$3900(builder);
      this.etag = BucketInfo$BuilderImpl.access$4000(builder);
      this.createTime = BucketInfo$BuilderImpl.access$4100(builder);
      this.metageneration = BucketInfo$BuilderImpl.access$4200(builder);
      this.location = BucketInfo$BuilderImpl.access$4300(builder);
      this.storageClass = BucketInfo$BuilderImpl.access$4400(builder);
      this.cors = BucketInfo$BuilderImpl.access$4500(builder);
      this.acl = BucketInfo$BuilderImpl.access$4600(builder);
      this.defaultAcl = BucketInfo$BuilderImpl.access$4700(builder);
      this.owner = BucketInfo$BuilderImpl.access$4800(builder);
      this.selfLink = BucketInfo$BuilderImpl.access$4900(builder);
      this.versioningEnabled = BucketInfo$BuilderImpl.access$5000(builder);
      this.indexPage = BucketInfo$BuilderImpl.access$5100(builder);
      this.notFoundPage = BucketInfo$BuilderImpl.access$5200(builder);
      this.deleteRules = BucketInfo$BuilderImpl.access$5300(builder);
      this.lifecycleRules = BucketInfo$BuilderImpl.access$5400(builder);
      this.labels = BucketInfo$BuilderImpl.access$5500(builder);
      this.requesterPays = BucketInfo$BuilderImpl.access$5600(builder);
      this.defaultKmsKeyName = BucketInfo$BuilderImpl.access$5700(builder);
      this.defaultEventBasedHold = BucketInfo$BuilderImpl.access$5800(builder);
      this.retentionEffectiveTime = BucketInfo$BuilderImpl.access$5900(builder);
      this.retentionPolicyIsLocked = BucketInfo$BuilderImpl.access$6000(builder);
      this.retentionPeriod = BucketInfo$BuilderImpl.access$6100(builder);
      this.iamConfiguration = BucketInfo$BuilderImpl.access$6200(builder);
      this.locationType = BucketInfo$BuilderImpl.access$6300(builder);
   }

   public String getGeneratedId() {
      return this.generatedId;
   }

   public String getName() {
      return this.name;
   }

   public Acl$Entity getOwner() {
      return this.owner;
   }

   public String getSelfLink() {
      return this.selfLink;
   }

   public Boolean versioningEnabled() {
      return Data.isNull(this.versioningEnabled) ? null : this.versioningEnabled;
   }

   public Boolean requesterPays() {
      return Data.isNull(this.requesterPays) ? null : this.requesterPays;
   }

   public String getIndexPage() {
      return this.indexPage;
   }

   public String getNotFoundPage() {
      return this.notFoundPage;
   }

   /** @deprecated */
   @Deprecated
   public List getDeleteRules() {
      return this.deleteRules;
   }

   public List getLifecycleRules() {
      return this.lifecycleRules;
   }

   public String getEtag() {
      return this.etag;
   }

   public Long getCreateTime() {
      return this.createTime;
   }

   public Long getMetageneration() {
      return this.metageneration;
   }

   public String getLocation() {
      return this.location;
   }

   public String getLocationType() {
      return this.locationType;
   }

   public StorageClass getStorageClass() {
      return this.storageClass;
   }

   public List getCors() {
      return this.cors;
   }

   public List getAcl() {
      return this.acl;
   }

   public List getDefaultAcl() {
      return this.defaultAcl;
   }

   public Map getLabels() {
      return this.labels;
   }

   public String getDefaultKmsKeyName() {
      return this.defaultKmsKeyName;
   }

   @BetaApi
   public Boolean getDefaultEventBasedHold() {
      return Data.isNull(this.defaultEventBasedHold) ? null : this.defaultEventBasedHold;
   }

   @BetaApi
   public Long getRetentionEffectiveTime() {
      return this.retentionEffectiveTime;
   }

   @BetaApi
   public Boolean retentionPolicyIsLocked() {
      return Data.isNull(this.retentionPolicyIsLocked) ? null : this.retentionPolicyIsLocked;
   }

   @BetaApi
   public Long getRetentionPeriod() {
      return this.retentionPeriod;
   }

   @BetaApi
   public BucketInfo$IamConfiguration getIamConfiguration() {
      return this.iamConfiguration;
   }

   public BucketInfo$Builder toBuilder() {
      return new BucketInfo$BuilderImpl(this);
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.name});
   }

   public boolean equals(Object obj) {
      return obj == this || obj != null && obj.getClass().equals(BucketInfo.class) && Objects.equals(this.toPb(), ((BucketInfo)obj).toPb());
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("name", this.name).toString();
   }

   com.google.api.services.storage.model.Bucket toPb() {
      com.google.api.services.storage.model.Bucket bucketPb = new com.google.api.services.storage.model.Bucket();
      bucketPb.setId(this.generatedId);
      bucketPb.setName(this.name);
      bucketPb.setEtag(this.etag);
      if (this.createTime != null) {
         bucketPb.setTimeCreated(new DateTime(this.createTime));
      }

      if (this.metageneration != null) {
         bucketPb.setMetageneration(this.metageneration);
      }

      if (this.location != null) {
         bucketPb.setLocation(this.location);
      }

      if (this.locationType != null) {
         bucketPb.setLocationType(this.locationType);
      }

      if (this.storageClass != null) {
         bucketPb.setStorageClass(this.storageClass.toString());
      }

      if (this.cors != null) {
         bucketPb.setCors(Lists.transform(this.cors, Cors.TO_PB_FUNCTION));
      }

      if (this.acl != null) {
         bucketPb.setAcl(Lists.transform(this.acl, new BucketInfo$3(this)));
      }

      if (this.defaultAcl != null) {
         bucketPb.setDefaultObjectAcl(Lists.transform(this.defaultAcl, new BucketInfo$4(this)));
      }

      if (this.owner != null) {
         bucketPb.setOwner((new Owner()).setEntity(this.owner.toPb()));
      }

      bucketPb.setSelfLink(this.selfLink);
      if (this.versioningEnabled != null) {
         bucketPb.setVersioning((new Versioning()).setEnabled(this.versioningEnabled));
      }

      if (this.requesterPays != null) {
         Billing billing = new Billing();
         billing.setRequesterPays(this.requesterPays);
         bucketPb.setBilling(billing);
      }

      if (this.indexPage != null || this.notFoundPage != null) {
         Website website = new Website();
         website.setMainPageSuffix(this.indexPage);
         website.setNotFoundPage(this.notFoundPage);
         bucketPb.setWebsite(website);
      }

      Set rules = new HashSet();
      if (this.deleteRules != null) {
         rules.addAll(Lists.transform(this.deleteRules, new BucketInfo$5(this)));
      }

      if (this.lifecycleRules != null) {
         rules.addAll(Lists.transform(this.lifecycleRules, new BucketInfo$6(this)));
      }

      if (!rules.isEmpty()) {
         Lifecycle lifecycle = new Lifecycle();
         lifecycle.setRule(ImmutableList.copyOf(rules));
         bucketPb.setLifecycle(lifecycle);
      }

      if (this.labels != null) {
         bucketPb.setLabels(this.labels);
      }

      if (this.defaultKmsKeyName != null) {
         bucketPb.setEncryption((new Encryption()).setDefaultKmsKeyName(this.defaultKmsKeyName));
      }

      if (this.defaultEventBasedHold != null) {
         bucketPb.setDefaultEventBasedHold(this.defaultEventBasedHold);
      }

      if (this.retentionPeriod != null) {
         if (Data.isNull(this.retentionPeriod)) {
            bucketPb.setRetentionPolicy((RetentionPolicy)Data.nullOf(RetentionPolicy.class));
         } else {
            RetentionPolicy retentionPolicy = new RetentionPolicy();
            retentionPolicy.setRetentionPeriod(this.retentionPeriod);
            if (this.retentionEffectiveTime != null) {
               retentionPolicy.setEffectiveTime(new DateTime(this.retentionEffectiveTime));
            }

            if (this.retentionPolicyIsLocked != null) {
               retentionPolicy.setIsLocked(this.retentionPolicyIsLocked);
            }

            bucketPb.setRetentionPolicy(retentionPolicy);
         }
      }

      if (this.iamConfiguration != null) {
         bucketPb.setIamConfiguration(this.iamConfiguration.toPb());
      }

      return bucketPb;
   }

   public static BucketInfo of(String name) {
      return newBuilder(name).build();
   }

   public static BucketInfo$Builder newBuilder(String name) {
      return new BucketInfo$BuilderImpl(name);
   }

   static BucketInfo fromPb(com.google.api.services.storage.model.Bucket bucketPb) {
      BucketInfo$Builder builder = new BucketInfo$BuilderImpl(bucketPb.getName());
      if (bucketPb.getId() != null) {
         builder.setGeneratedId(bucketPb.getId());
      }

      if (bucketPb.getEtag() != null) {
         builder.setEtag(bucketPb.getEtag());
      }

      if (bucketPb.getMetageneration() != null) {
         builder.setMetageneration(bucketPb.getMetageneration());
      }

      if (bucketPb.getSelfLink() != null) {
         builder.setSelfLink(bucketPb.getSelfLink());
      }

      if (bucketPb.getTimeCreated() != null) {
         builder.setCreateTime(bucketPb.getTimeCreated().getValue());
      }

      if (bucketPb.getLocation() != null) {
         builder.setLocation(bucketPb.getLocation());
      }

      if (bucketPb.getStorageClass() != null) {
         builder.setStorageClass(StorageClass.valueOf(bucketPb.getStorageClass()));
      }

      if (bucketPb.getCors() != null) {
         builder.setCors(Lists.transform(bucketPb.getCors(), Cors.FROM_PB_FUNCTION));
      }

      if (bucketPb.getAcl() != null) {
         builder.setAcl(Lists.transform(bucketPb.getAcl(), new BucketInfo$7()));
      }

      if (bucketPb.getDefaultObjectAcl() != null) {
         builder.setDefaultAcl(Lists.transform(bucketPb.getDefaultObjectAcl(), new BucketInfo$8()));
      }

      if (bucketPb.getOwner() != null) {
         builder.setOwner(Acl$Entity.fromPb(bucketPb.getOwner().getEntity()));
      }

      if (bucketPb.getVersioning() != null) {
         builder.setVersioningEnabled(bucketPb.getVersioning().getEnabled());
      }

      Website website = bucketPb.getWebsite();
      if (website != null) {
         builder.setIndexPage(website.getMainPageSuffix());
         builder.setNotFoundPage(website.getNotFoundPage());
      }

      if (bucketPb.getLifecycle() != null && bucketPb.getLifecycle().getRule() != null) {
         builder.setLifecycleRules(Lists.transform(bucketPb.getLifecycle().getRule(), new BucketInfo$9()));
         builder.setDeleteRules(Lists.transform(bucketPb.getLifecycle().getRule(), new BucketInfo$10()));
      }

      if (bucketPb.getLabels() != null) {
         builder.setLabels(bucketPb.getLabels());
      }

      Billing billing = bucketPb.getBilling();
      if (billing != null) {
         builder.setRequesterPays(billing.getRequesterPays());
      }

      Encryption encryption = bucketPb.getEncryption();
      if (encryption != null && encryption.getDefaultKmsKeyName() != null && !encryption.getDefaultKmsKeyName().isEmpty()) {
         builder.setDefaultKmsKeyName(encryption.getDefaultKmsKeyName());
      }

      if (bucketPb.getDefaultEventBasedHold() != null) {
         builder.setDefaultEventBasedHold(bucketPb.getDefaultEventBasedHold());
      }

      RetentionPolicy retentionPolicy = bucketPb.getRetentionPolicy();
      if (retentionPolicy != null) {
         if (retentionPolicy.getEffectiveTime() != null) {
            builder.setRetentionEffectiveTime(retentionPolicy.getEffectiveTime().getValue());
         }

         if (retentionPolicy.getIsLocked() != null) {
            builder.setRetentionPolicyIsLocked(retentionPolicy.getIsLocked());
         }

         if (retentionPolicy.getRetentionPeriod() != null) {
            builder.setRetentionPeriod(retentionPolicy.getRetentionPeriod());
         }
      }

      com.google.api.services.storage.model.Bucket.IamConfiguration iamConfiguration = bucketPb.getIamConfiguration();
      if (bucketPb.getLocationType() != null) {
         builder.setLocationType(bucketPb.getLocationType());
      }

      if (iamConfiguration != null) {
         builder.setIamConfiguration(BucketInfo$IamConfiguration.fromPb(iamConfiguration));
      }

      return builder.build();
   }

   // $FF: synthetic method
   static String access$1200(BucketInfo x0) {
      return x0.generatedId;
   }

   // $FF: synthetic method
   static String access$1300(BucketInfo x0) {
      return x0.name;
   }

   // $FF: synthetic method
   static String access$1400(BucketInfo x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   static Long access$1500(BucketInfo x0) {
      return x0.createTime;
   }

   // $FF: synthetic method
   static Long access$1600(BucketInfo x0) {
      return x0.metageneration;
   }

   // $FF: synthetic method
   static String access$1700(BucketInfo x0) {
      return x0.location;
   }

   // $FF: synthetic method
   static StorageClass access$1800(BucketInfo x0) {
      return x0.storageClass;
   }

   // $FF: synthetic method
   static List access$1900(BucketInfo x0) {
      return x0.cors;
   }

   // $FF: synthetic method
   static List access$2000(BucketInfo x0) {
      return x0.acl;
   }

   // $FF: synthetic method
   static List access$2100(BucketInfo x0) {
      return x0.defaultAcl;
   }

   // $FF: synthetic method
   static Acl$Entity access$2200(BucketInfo x0) {
      return x0.owner;
   }

   // $FF: synthetic method
   static String access$2300(BucketInfo x0) {
      return x0.selfLink;
   }

   // $FF: synthetic method
   static Boolean access$2400(BucketInfo x0) {
      return x0.versioningEnabled;
   }

   // $FF: synthetic method
   static String access$2500(BucketInfo x0) {
      return x0.indexPage;
   }

   // $FF: synthetic method
   static String access$2600(BucketInfo x0) {
      return x0.notFoundPage;
   }

   // $FF: synthetic method
   static List access$2700(BucketInfo x0) {
      return x0.deleteRules;
   }

   // $FF: synthetic method
   static List access$2800(BucketInfo x0) {
      return x0.lifecycleRules;
   }

   // $FF: synthetic method
   static Map access$2900(BucketInfo x0) {
      return x0.labels;
   }

   // $FF: synthetic method
   static Boolean access$3000(BucketInfo x0) {
      return x0.requesterPays;
   }

   // $FF: synthetic method
   static String access$3100(BucketInfo x0) {
      return x0.defaultKmsKeyName;
   }

   // $FF: synthetic method
   static Boolean access$3200(BucketInfo x0) {
      return x0.defaultEventBasedHold;
   }

   // $FF: synthetic method
   static Long access$3300(BucketInfo x0) {
      return x0.retentionEffectiveTime;
   }

   // $FF: synthetic method
   static Boolean access$3400(BucketInfo x0) {
      return x0.retentionPolicyIsLocked;
   }

   // $FF: synthetic method
   static Long access$3500(BucketInfo x0) {
      return x0.retentionPeriod;
   }

   // $FF: synthetic method
   static BucketInfo$IamConfiguration access$3600(BucketInfo x0) {
      return x0.iamConfiguration;
   }

   // $FF: synthetic method
   static String access$3700(BucketInfo x0) {
      return x0.locationType;
   }
}
