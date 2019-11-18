package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class HistogramSeries extends GenericJson {
   @Key
   private Color barColor;
   @Key
   private ChartData data;

   public Color getBarColor() {
      return this.barColor;
   }

   public HistogramSeries setBarColor(Color var1) {
      this.barColor = var1;
      return this;
   }

   public ChartData getData() {
      return this.data;
   }

   public HistogramSeries setData(ChartData var1) {
      this.data = var1;
      return this;
   }

   public HistogramSeries set(String var1, Object var2) {
      return (HistogramSeries)super.set(var1, var2);
   }

   public HistogramSeries clone() {
      return (HistogramSeries)super.clone();
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
