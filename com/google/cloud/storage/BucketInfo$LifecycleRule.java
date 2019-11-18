package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Action;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Condition;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Objects;

public class BucketInfo$LifecycleRule implements Serializable {
   private static final long serialVersionUID = -5739807320148748613L;
   private final BucketInfo$LifecycleRule$LifecycleAction lifecycleAction;
   private final BucketInfo$LifecycleRule$LifecycleCondition lifecycleCondition;

   public BucketInfo$LifecycleRule(BucketInfo$LifecycleRule$LifecycleAction action, BucketInfo$LifecycleRule$LifecycleCondition condition) {
      if (condition.getIsLive() == null && condition.getAge() == null && condition.getCreatedBefore() == null && condition.getMatchesStorageClass() == null && condition.getNumberOfNewerVersions() == null) {
         throw new IllegalArgumentException("You must specify at least one condition to use object lifecycle management. Please see https://cloud.google.com/storage/docs/lifecycle for details.");
      } else {
         this.lifecycleAction = action;
         this.lifecycleCondition = condition;
      }
   }

   public BucketInfo$LifecycleRule$LifecycleAction getAction() {
      return this.lifecycleAction;
   }

   public BucketInfo$LifecycleRule$LifecycleCondition getCondition() {
      return this.lifecycleCondition;
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.lifecycleAction, this.lifecycleCondition});
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         BucketInfo$LifecycleRule other = (BucketInfo$LifecycleRule)obj;
         return Objects.equals(this.toPb(), other.toPb());
      } else {
         return false;
      }
   }

   Rule toPb() {
      Rule rule = new Rule();
      Action action = (new Action()).setType(this.lifecycleAction.getActionType());
      if (this.lifecycleAction.getActionType().equals("SetStorageClass")) {
         action.setStorageClass(((BucketInfo$LifecycleRule$SetStorageClassLifecycleAction)this.lifecycleAction).getStorageClass().toString());
      }

      rule.setAction(action);
      Condition condition = (new Condition()).setAge(this.lifecycleCondition.getAge()).setCreatedBefore(this.lifecycleCondition.getCreatedBefore() == null ? null : new DateTime(true, this.lifecycleCondition.getCreatedBefore().getValue(), 0)).setIsLive(this.lifecycleCondition.getIsLive()).setNumNewerVersions(this.lifecycleCondition.getNumberOfNewerVersions()).setMatchesStorageClass(this.lifecycleCondition.getMatchesStorageClass() == null ? null : Lists.transform(this.lifecycleCondition.getMatchesStorageClass(), Functions.toStringFunction()));
      rule.setCondition(condition);
      return rule;
   }

   static BucketInfo$LifecycleRule fromPb(Rule rule) {
      Action action = rule.getAction();
      String var3 = action.getType();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case -1883369185:
         if (var3.equals("SetStorageClass")) {
            var4 = 1;
         }
         break;
      case 2043376075:
         if (var3.equals("Delete")) {
            var4 = 0;
         }
      }

      Object lifecycleAction;
      switch(var4) {
      case 0:
         lifecycleAction = BucketInfo$LifecycleRule$LifecycleAction.newDeleteAction();
         break;
      case 1:
         lifecycleAction = BucketInfo$LifecycleRule$LifecycleAction.newSetStorageClassAction(StorageClass.valueOf(action.getStorageClass()));
         break;
      default:
         throw new UnsupportedOperationException("The specified lifecycle action " + action.getType() + " is not currently supported");
      }

      Condition condition = rule.getCondition();
      BucketInfo$LifecycleRule$LifecycleCondition$Builder conditionBuilder = BucketInfo$LifecycleRule$LifecycleCondition.newBuilder().setAge(condition.getAge()).setCreatedBefore(condition.getCreatedBefore()).setIsLive(condition.getIsLive()).setNumberOfNewerVersions(condition.getNumNewerVersions()).setMatchesStorageClass(condition.getMatchesStorageClass() == null ? null : Lists.transform(condition.getMatchesStorageClass(), new BucketInfo$LifecycleRule$1()));
      return new BucketInfo$LifecycleRule((BucketInfo$LifecycleRule$LifecycleAction)lifecycleAction, conditionBuilder.build());
   }
}
