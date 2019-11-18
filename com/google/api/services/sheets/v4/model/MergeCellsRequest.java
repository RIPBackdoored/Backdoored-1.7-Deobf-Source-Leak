package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class MergeCellsRequest extends GenericJson {
   @Key
   private String mergeType;
   @Key
   private GridRange range;

   public String getMergeType() {
      return this.mergeType;
   }

   public MergeCellsRequest setMergeType(String var1) {
      this.mergeType = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public MergeCellsRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public MergeCellsRequest set(String var1, Object var2) {
      return (MergeCellsRequest)super.set(var1, var2);
   }

   public MergeCellsRequest clone() {
      return (MergeCellsRequest)super.clone();
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
