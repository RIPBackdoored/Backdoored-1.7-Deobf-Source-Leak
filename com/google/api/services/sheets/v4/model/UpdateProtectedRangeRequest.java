package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateProtectedRangeRequest extends GenericJson {
   @Key
   private String fields;
   @Key
   private ProtectedRange protectedRange;

   public String getFields() {
      return this.fields;
   }

   public UpdateProtectedRangeRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public ProtectedRange getProtectedRange() {
      return this.protectedRange;
   }

   public UpdateProtectedRangeRequest setProtectedRange(ProtectedRange var1) {
      this.protectedRange = var1;
      return this;
   }

   public UpdateProtectedRangeRequest set(String var1, Object var2) {
      return (UpdateProtectedRangeRequest)super.set(var1, var2);
   }

   public UpdateProtectedRangeRequest clone() {
      return (UpdateProtectedRangeRequest)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
