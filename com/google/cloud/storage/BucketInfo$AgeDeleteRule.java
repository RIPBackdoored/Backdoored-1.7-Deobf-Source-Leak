package com.google.cloud.storage;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Condition;

/** @deprecated */
@Deprecated
public class BucketInfo$AgeDeleteRule extends BucketInfo$DeleteRule {
   private static final long serialVersionUID = 5697166940712116380L;
   private final int daysToLive;

   public BucketInfo$AgeDeleteRule(int daysToLive) {
      super(BucketInfo$DeleteRule$Type.AGE);
      this.daysToLive = daysToLive;
   }

   public int getDaysToLive() {
      return this.daysToLive;
   }

   void populateCondition(Condition condition) {
      condition.setAge(this.daysToLive);
   }
}
