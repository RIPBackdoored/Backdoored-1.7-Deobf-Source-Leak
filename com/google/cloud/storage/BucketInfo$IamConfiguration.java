package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Bucket.IamConfiguration;
import com.google.api.services.storage.model.Bucket.IamConfiguration.BucketPolicyOnly;
import java.io.Serializable;
import java.util.Objects;

public class BucketInfo$IamConfiguration implements Serializable {
   private static final long serialVersionUID = -8671736104909424616L;
   private Boolean isBucketPolicyOnlyEnabled;
   private Long bucketPolicyOnlyLockedTime;

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         BucketInfo$IamConfiguration other = (BucketInfo$IamConfiguration)o;
         return Objects.equals(this.toPb(), other.toPb());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.isBucketPolicyOnlyEnabled, this.bucketPolicyOnlyLockedTime});
   }

   private BucketInfo$IamConfiguration(BucketInfo$IamConfiguration$Builder builder) {
      this.isBucketPolicyOnlyEnabled = BucketInfo$IamConfiguration$Builder.access$000(builder);
      this.bucketPolicyOnlyLockedTime = BucketInfo$IamConfiguration$Builder.access$100(builder);
   }

   public static BucketInfo$IamConfiguration$Builder newBuilder() {
      return new BucketInfo$IamConfiguration$Builder();
   }

   public BucketInfo$IamConfiguration$Builder toBuilder() {
      BucketInfo$IamConfiguration$Builder builder = new BucketInfo$IamConfiguration$Builder();
      BucketInfo$IamConfiguration$Builder.access$002(builder, this.isBucketPolicyOnlyEnabled);
      BucketInfo$IamConfiguration$Builder.access$102(builder, this.bucketPolicyOnlyLockedTime);
      return builder;
   }

   public Boolean isBucketPolicyOnlyEnabled() {
      return this.isBucketPolicyOnlyEnabled;
   }

   public Long getBucketPolicyOnlyLockedTime() {
      return this.bucketPolicyOnlyLockedTime;
   }

   IamConfiguration toPb() {
      IamConfiguration iamConfiguration = new IamConfiguration();
      BucketPolicyOnly bucketPolicyOnly = new BucketPolicyOnly();
      bucketPolicyOnly.setEnabled(this.isBucketPolicyOnlyEnabled);
      bucketPolicyOnly.setLockedTime(this.bucketPolicyOnlyLockedTime == null ? null : new DateTime(this.bucketPolicyOnlyLockedTime));
      iamConfiguration.setBucketPolicyOnly(bucketPolicyOnly);
      return iamConfiguration;
   }

   static BucketInfo$IamConfiguration fromPb(IamConfiguration iamConfiguration) {
      BucketPolicyOnly bucketPolicyOnly = iamConfiguration.getBucketPolicyOnly();
      DateTime lockedTime = bucketPolicyOnly.getLockedTime();
      return newBuilder().setIsBucketPolicyOnlyEnabled(bucketPolicyOnly.getEnabled()).setBucketPolicyOnlyLockedTime(lockedTime == null ? null : lockedTime.getValue()).build();
   }

   // $FF: synthetic method
   BucketInfo$IamConfiguration(BucketInfo$IamConfiguration$Builder x0, BucketInfo$1 x1) {
      this(x0);
   }
}
