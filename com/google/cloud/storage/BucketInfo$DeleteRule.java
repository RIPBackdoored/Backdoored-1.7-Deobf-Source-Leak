package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Action;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Condition;
import java.io.Serializable;
import java.util.Objects;

/** @deprecated */
@Deprecated
public abstract class BucketInfo$DeleteRule implements Serializable {
   private static final long serialVersionUID = 3137971668395933033L;
   private static final String SUPPORTED_ACTION = "Delete";
   private final BucketInfo$DeleteRule$Type type;

   BucketInfo$DeleteRule(BucketInfo$DeleteRule$Type type) {
      this.type = type;
   }

   public BucketInfo$DeleteRule$Type getType() {
      return this.type;
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.type});
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         BucketInfo$DeleteRule other = (BucketInfo$DeleteRule)obj;
         return Objects.equals(this.toPb(), other.toPb());
      } else {
         return false;
      }
   }

   Rule toPb() {
      Rule rule = new Rule();
      rule.setAction((new Action()).setType("Delete"));
      Condition condition = new Condition();
      this.populateCondition(condition);
      rule.setCondition(condition);
      return rule;
   }

   abstract void populateCondition(Condition var1);

   static BucketInfo$DeleteRule fromPb(Rule rule) {
      if (rule.getAction() != null && "Delete".endsWith(rule.getAction().getType())) {
         Condition condition = rule.getCondition();
         Integer age = condition.getAge();
         if (age != null) {
            return new BucketInfo$AgeDeleteRule(age);
         }

         DateTime dateTime = condition.getCreatedBefore();
         if (dateTime != null) {
            return new BucketInfo$CreatedBeforeDeleteRule(dateTime.getValue());
         }

         Integer numNewerVersions = condition.getNumNewerVersions();
         if (numNewerVersions != null) {
            return new BucketInfo$NumNewerVersionsDeleteRule(numNewerVersions);
         }

         Boolean isLive = condition.getIsLive();
         if (isLive != null) {
            return new BucketInfo$IsLiveDeleteRule(isLive);
         }
      }

      return new BucketInfo$RawDeleteRule(rule);
   }
}
