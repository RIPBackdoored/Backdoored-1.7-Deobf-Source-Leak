package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteDimensionGroupRequest extends GenericJson {
   @Key
   private DimensionRange range;

   public DimensionRange getRange() {
      return this.range;
   }

   public DeleteDimensionGroupRequest setRange(DimensionRange var1) {
      this.range = var1;
      return this;
   }

   public DeleteDimensionGroupRequest set(String var1, Object var2) {
      return (DeleteDimensionGroupRequest)super.set(var1, var2);
   }

   public DeleteDimensionGroupRequest clone() {
      return (DeleteDimensionGroupRequest)super.clone();
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
