package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AddChartRequest extends GenericJson {
   @Key
   private EmbeddedChart chart;

   public EmbeddedChart getChart() {
      return this.chart;
   }

   public AddChartRequest setChart(EmbeddedChart var1) {
      this.chart = var1;
      return this;
   }

   public AddChartRequest set(String var1, Object var2) {
      return (AddChartRequest)super.set(var1, var2);
   }

   public AddChartRequest clone() {
      return (AddChartRequest)super.clone();
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
