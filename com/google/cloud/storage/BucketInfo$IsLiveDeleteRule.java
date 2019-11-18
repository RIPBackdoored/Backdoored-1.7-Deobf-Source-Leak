package com.google.cloud.storage;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Condition;

/** @deprecated */
@Deprecated
public class BucketInfo$IsLiveDeleteRule extends BucketInfo$DeleteRule {
   private static final long serialVersionUID = -3502994563121313364L;
   private final boolean isLive;

   public BucketInfo$IsLiveDeleteRule(boolean isLive) {
      super(BucketInfo$DeleteRule$Type.IS_LIVE);
      this.isLive = isLive;
   }

   public boolean isLive() {
      return this.isLive;
   }

   void populateCondition(Condition condition) {
      condition.setIsLive(this.isLive);
   }
}
