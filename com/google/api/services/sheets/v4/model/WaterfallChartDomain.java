package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class WaterfallChartDomain extends GenericJson {
   @Key
   private ChartData data;
   @Key
   private Boolean reversed;

   public ChartData getData() {
      return this.data;
   }

   public WaterfallChartDomain setData(ChartData var1) {
      this.data = var1;
      return this;
   }

   public Boolean getReversed() {
      return this.reversed;
   }

   public WaterfallChartDomain setReversed(Boolean var1) {
      this.reversed = var1;
      return this;
   }

   public WaterfallChartDomain set(String var1, Object var2) {
      return (WaterfallChartDomain)super.set(var1, var2);
   }

   public WaterfallChartDomain clone() {
      return (WaterfallChartDomain)super.clone();
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
