package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class BasicChartSeries extends GenericJson {
   @Key
   private Color color;
   @Key
   private LineStyle lineStyle;
   @Key
   private ChartData series;
   @Key
   private String targetAxis;
   @Key
   private String type;

   public Color getColor() {
      return this.color;
   }

   public BasicChartSeries setColor(Color var1) {
      this.color = var1;
      return this;
   }

   public LineStyle getLineStyle() {
      return this.lineStyle;
   }

   public BasicChartSeries setLineStyle(LineStyle var1) {
      this.lineStyle = var1;
      return this;
   }

   public ChartData getSeries() {
      return this.series;
   }

   public BasicChartSeries setSeries(ChartData var1) {
      this.series = var1;
      return this;
   }

   public String getTargetAxis() {
      return this.targetAxis;
   }

   public BasicChartSeries setTargetAxis(String var1) {
      this.targetAxis = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public BasicChartSeries setType(String var1) {
      this.type = var1;
      return this;
   }

   public BasicChartSeries set(String var1, Object var2) {
      return (BasicChartSeries)super.set(var1, var2);
   }

   public BasicChartSeries clone() {
      return (BasicChartSeries)super.clone();
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
