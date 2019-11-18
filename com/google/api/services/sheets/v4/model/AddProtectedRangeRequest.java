package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AddProtectedRangeRequest extends GenericJson {
   @Key
   private ProtectedRange protectedRange;

   public ProtectedRange getProtectedRange() {
      return this.protectedRange;
   }

   public AddProtectedRangeRequest setProtectedRange(ProtectedRange var1) {
      this.protectedRange = var1;
      return this;
   }

   public AddProtectedRangeRequest set(String var1, Object var2) {
      return (AddProtectedRangeRequest)super.set(var1, var2);
   }

   public AddProtectedRangeRequest clone() {
      return (AddProtectedRangeRequest)super.clone();
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
