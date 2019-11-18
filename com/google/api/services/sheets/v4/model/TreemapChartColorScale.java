package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class TreemapChartColorScale extends GenericJson {
   @Key
   private Color maxValueColor;
   @Key
   private Color midValueColor;
   @Key
   private Color minValueColor;
   @Key
   private Color noDataColor;

   public Color getMaxValueColor() {
      return this.maxValueColor;
   }

   public TreemapChartColorScale setMaxValueColor(Color var1) {
      this.maxValueColor = var1;
      return this;
   }

   public Color getMidValueColor() {
      return this.midValueColor;
   }

   public TreemapChartColorScale setMidValueColor(Color var1) {
      this.midValueColor = var1;
      return this;
   }

   public Color getMinValueColor() {
      return this.minValueColor;
   }

   public TreemapChartColorScale setMinValueColor(Color var1) {
      this.minValueColor = var1;
      return this;
   }

   public Color getNoDataColor() {
      return this.noDataColor;
   }

   public TreemapChartColorScale setNoDataColor(Color var1) {
      this.noDataColor = var1;
      return this;
   }

   public TreemapChartColorScale set(String var1, Object var2) {
      return (TreemapChartColorScale)super.set(var1, var2);
   }

   public TreemapChartColorScale clone() {
      return (TreemapChartColorScale)super.clone();
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
