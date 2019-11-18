package com.google.cloud.storage;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Condition;

/** @deprecated */
@Deprecated
public class BucketInfo$NumNewerVersionsDeleteRule extends BucketInfo$DeleteRule {
   private static final long serialVersionUID = -1955554976528303894L;
   private final int numNewerVersions;

   public BucketInfo$NumNewerVersionsDeleteRule(int numNewerVersions) {
      super(BucketInfo$DeleteRule$Type.NUM_NEWER_VERSIONS);
      this.numNewerVersions = numNewerVersions;
   }

   public int getNumNewerVersions() {
      return this.numNewerVersions;
   }

   void populateCondition(Condition condition) {
      condition.setNumNewerVersions(this.numNewerVersions);
   }
}
