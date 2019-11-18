package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Condition;

/** @deprecated */
@Deprecated
public class BucketInfo$CreatedBeforeDeleteRule extends BucketInfo$DeleteRule {
   private static final long serialVersionUID = 881692650279195867L;
   private final long timeMillis;

   public BucketInfo$CreatedBeforeDeleteRule(long timeMillis) {
      super(BucketInfo$DeleteRule$Type.CREATE_BEFORE);
      this.timeMillis = timeMillis;
   }

   public long getTimeMillis() {
      return this.timeMillis;
   }

   void populateCondition(Condition condition) {
      condition.setCreatedBefore(new DateTime(true, this.timeMillis, 0));
   }
}
