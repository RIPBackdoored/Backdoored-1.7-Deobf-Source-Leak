package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import java.io.Serializable;
import java.util.List;

public class BucketInfo$LifecycleRule$LifecycleCondition implements Serializable {
   private static final long serialVersionUID = -6482314338394768785L;
   private final Integer age;
   private final DateTime createdBefore;
   private final Integer numberOfNewerVersions;
   private final Boolean isLive;
   private final List matchesStorageClass;

   private BucketInfo$LifecycleRule$LifecycleCondition(BucketInfo$LifecycleRule$LifecycleCondition$Builder builder) {
      this.age = BucketInfo$LifecycleRule$LifecycleCondition$Builder.access$300(builder);
      this.createdBefore = BucketInfo$LifecycleRule$LifecycleCondition$Builder.access$400(builder);
      this.numberOfNewerVersions = BucketInfo$LifecycleRule$LifecycleCondition$Builder.access$500(builder);
      this.isLive = BucketInfo$LifecycleRule$LifecycleCondition$Builder.access$600(builder);
      this.matchesStorageClass = BucketInfo$LifecycleRule$LifecycleCondition$Builder.access$700(builder);
   }

   public BucketInfo$LifecycleRule$LifecycleCondition$Builder toBuilder() {
      return newBuilder().setAge(this.age).setCreatedBefore(this.createdBefore).setNumberOfNewerVersions(this.numberOfNewerVersions).setIsLive(this.isLive).setMatchesStorageClass(this.matchesStorageClass);
   }

   public static BucketInfo$LifecycleRule$LifecycleCondition$Builder newBuilder() {
      return new BucketInfo$LifecycleRule$LifecycleCondition$Builder((BucketInfo$1)null);
   }

   public Integer getAge() {
      return this.age;
   }

   public DateTime getCreatedBefore() {
      return this.createdBefore;
   }

   public Integer getNumberOfNewerVersions() {
      return this.numberOfNewerVersions;
   }

   public Boolean getIsLive() {
      return this.isLive;
   }

   public List getMatchesStorageClass() {
      return this.matchesStorageClass;
   }

   // $FF: synthetic method
   BucketInfo$LifecycleRule$LifecycleCondition(BucketInfo$LifecycleRule$LifecycleCondition$Builder x0, BucketInfo$1 x1) {
      this(x0);
   }
}
