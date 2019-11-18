package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import java.util.List;

public class BucketInfo$LifecycleRule$LifecycleCondition$Builder {
   private Integer age;
   private DateTime createdBefore;
   private Integer numberOfNewerVersions;
   private Boolean isLive;
   private List matchesStorageClass;

   private BucketInfo$LifecycleRule$LifecycleCondition$Builder() {
   }

   public BucketInfo$LifecycleRule$LifecycleCondition$Builder setAge(Integer age) {
      this.age = age;
      return this;
   }

   public BucketInfo$LifecycleRule$LifecycleCondition$Builder setCreatedBefore(DateTime createdBefore) {
      this.createdBefore = createdBefore;
      return this;
   }

   public BucketInfo$LifecycleRule$LifecycleCondition$Builder setNumberOfNewerVersions(Integer numberOfNewerVersions) {
      this.numberOfNewerVersions = numberOfNewerVersions;
      return this;
   }

   public BucketInfo$LifecycleRule$LifecycleCondition$Builder setIsLive(Boolean live) {
      this.isLive = live;
      return this;
   }

   public BucketInfo$LifecycleRule$LifecycleCondition$Builder setMatchesStorageClass(List matchesStorageClass) {
      this.matchesStorageClass = matchesStorageClass;
      return this;
   }

   public BucketInfo$LifecycleRule$LifecycleCondition build() {
      return new BucketInfo$LifecycleRule$LifecycleCondition(this, (BucketInfo$1)null);
   }

   // $FF: synthetic method
   static Integer access$300(BucketInfo$LifecycleRule$LifecycleCondition$Builder x0) {
      return x0.age;
   }

   // $FF: synthetic method
   static DateTime access$400(BucketInfo$LifecycleRule$LifecycleCondition$Builder x0) {
      return x0.createdBefore;
   }

   // $FF: synthetic method
   static Integer access$500(BucketInfo$LifecycleRule$LifecycleCondition$Builder x0) {
      return x0.numberOfNewerVersions;
   }

   // $FF: synthetic method
   static Boolean access$600(BucketInfo$LifecycleRule$LifecycleCondition$Builder x0) {
      return x0.isLive;
   }

   // $FF: synthetic method
   static List access$700(BucketInfo$LifecycleRule$LifecycleCondition$Builder x0) {
      return x0.matchesStorageClass;
   }

   // $FF: synthetic method
   BucketInfo$LifecycleRule$LifecycleCondition$Builder(BucketInfo$1 x0) {
      this();
   }
}
