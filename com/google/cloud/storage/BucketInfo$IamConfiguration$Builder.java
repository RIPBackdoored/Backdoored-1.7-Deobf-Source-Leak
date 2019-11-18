package com.google.cloud.storage;

public class BucketInfo$IamConfiguration$Builder {
   private Boolean isBucketPolicyOnlyEnabled;
   private Long bucketPolicyOnlyLockedTime;

   public BucketInfo$IamConfiguration$Builder setIsBucketPolicyOnlyEnabled(Boolean isBucketPolicyOnlyEnabled) {
      this.isBucketPolicyOnlyEnabled = isBucketPolicyOnlyEnabled;
      return this;
   }

   BucketInfo$IamConfiguration$Builder setBucketPolicyOnlyLockedTime(Long bucketPolicyOnlyLockedTime) {
      this.bucketPolicyOnlyLockedTime = bucketPolicyOnlyLockedTime;
      return this;
   }

   public BucketInfo$IamConfiguration build() {
      return new BucketInfo$IamConfiguration(this, (BucketInfo$1)null);
   }

   // $FF: synthetic method
   static Boolean access$000(BucketInfo$IamConfiguration$Builder x0) {
      return x0.isBucketPolicyOnlyEnabled;
   }

   // $FF: synthetic method
   static Long access$100(BucketInfo$IamConfiguration$Builder x0) {
      return x0.bucketPolicyOnlyLockedTime;
   }

   // $FF: synthetic method
   static Boolean access$002(BucketInfo$IamConfiguration$Builder x0, Boolean x1) {
      return x0.isBucketPolicyOnlyEnabled = x1;
   }

   // $FF: synthetic method
   static Long access$102(BucketInfo$IamConfiguration$Builder x0, Long x1) {
      return x0.bucketPolicyOnlyLockedTime = x1;
   }
}
