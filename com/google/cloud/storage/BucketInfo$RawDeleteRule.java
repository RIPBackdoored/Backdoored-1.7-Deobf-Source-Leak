package com.google.cloud.storage;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.api.services.storage.model.Bucket.Lifecycle.Rule.Condition;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class BucketInfo$RawDeleteRule extends BucketInfo$DeleteRule {
   private static final long serialVersionUID = -7166938278642301933L;
   private transient Rule rule;

   BucketInfo$RawDeleteRule(Rule rule) {
      super(BucketInfo$DeleteRule$Type.UNKNOWN);
      this.rule = rule;
   }

   void populateCondition(Condition condition) {
      throw new UnsupportedOperationException();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeUTF(this.rule.toString());
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.rule = (Rule)(new JacksonFactory()).fromString(in.readUTF(), Rule.class);
   }

   Rule toPb() {
      return this.rule;
   }
}
