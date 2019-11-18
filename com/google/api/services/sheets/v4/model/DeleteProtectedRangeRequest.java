package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteProtectedRangeRequest extends GenericJson {
   @Key
   private Integer protectedRangeId;

   public Integer getProtectedRangeId() {
      return this.protectedRangeId;
   }

   public DeleteProtectedRangeRequest setProtectedRangeId(Integer var1) {
      this.protectedRangeId = var1;
      return this;
   }

   public DeleteProtectedRangeRequest set(String var1, Object var2) {
      return (DeleteProtectedRangeRequest)super.set(var1, var2);
   }

   public DeleteProtectedRangeRequest clone() {
      return (DeleteProtectedRangeRequest)super.clone();
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
