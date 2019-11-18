package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteRangeRequest extends GenericJson {
   @Key
   private GridRange range;
   @Key
   private String shiftDimension;

   public GridRange getRange() {
      return this.range;
   }

   public DeleteRangeRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public String getShiftDimension() {
      return this.shiftDimension;
   }

   public DeleteRangeRequest setShiftDimension(String var1) {
      this.shiftDimension = var1;
      return this;
   }

   public DeleteRangeRequest set(String var1, Object var2) {
      return (DeleteRangeRequest)super.set(var1, var2);
   }

   public DeleteRangeRequest clone() {
      return (DeleteRangeRequest)super.clone();
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
