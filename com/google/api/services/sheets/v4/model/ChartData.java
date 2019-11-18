package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class ChartData extends GenericJson {
   @Key
   private ChartSourceRange sourceRange;

   public ChartSourceRange getSourceRange() {
      return this.sourceRange;
   }

   public ChartData setSourceRange(ChartSourceRange var1) {
      this.sourceRange = var1;
      return this;
   }

   public ChartData set(String var1, Object var2) {
      return (ChartData)super.set(var1, var2);
   }

   public ChartData clone() {
      return (ChartData)super.clone();
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
