package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class InsertRangeRequest extends GenericJson {
   @Key
   private GridRange range;
   @Key
   private String shiftDimension;

   public GridRange getRange() {
      return this.range;
   }

   public InsertRangeRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public String getShiftDimension() {
      return this.shiftDimension;
   }

   public InsertRangeRequest setShiftDimension(String var1) {
      this.shiftDimension = var1;
      return this;
   }

   public InsertRangeRequest set(String var1, Object var2) {
      return (InsertRangeRequest)super.set(var1, var2);
   }

   public InsertRangeRequest clone() {
      return (InsertRangeRequest)super.clone();
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
