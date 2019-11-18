package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UnmergeCellsRequest extends GenericJson {
   @Key
   private GridRange range;

   public GridRange getRange() {
      return this.range;
   }

   public UnmergeCellsRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public UnmergeCellsRequest set(String var1, Object var2) {
      return (UnmergeCellsRequest)super.set(var1, var2);
   }

   public UnmergeCellsRequest clone() {
      return (UnmergeCellsRequest)super.clone();
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
