package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class TreemapChartSpec extends GenericJson {
   @Key
   private ChartData colorData;
   @Key
   private TreemapChartColorScale colorScale;
   @Key
   private Color headerColor;
   @Key
   private Boolean hideTooltips;
   @Key
   private Integer hintedLevels;
   @Key
   private ChartData labels;
   @Key
   private Integer levels;
   @Key
   private Double maxValue;
   @Key
   private Double minValue;
   @Key
   private ChartData parentLabels;
   @Key
   private ChartData sizeData;
   @Key
   private TextFormat textFormat;

   public ChartData getColorData() {
      return this.colorData;
   }

   public TreemapChartSpec setColorData(ChartData var1) {
      this.colorData = var1;
      return this;
   }

   public TreemapChartColorScale getColorScale() {
      return this.colorScale;
   }

   public TreemapChartSpec setColorScale(TreemapChartColorScale var1) {
      this.colorScale = var1;
      return this;
   }

   public Color getHeaderColor() {
      return this.headerColor;
   }

   public TreemapChartSpec setHeaderColor(Color var1) {
      this.headerColor = var1;
      return this;
   }

   public Boolean getHideTooltips() {
      return this.hideTooltips;
   }

   public TreemapChartSpec setHideTooltips(Boolean var1) {
      this.hideTooltips = var1;
      return this;
   }

   public Integer getHintedLevels() {
      return this.hintedLevels;
   }

   public TreemapChartSpec setHintedLevels(Integer var1) {
      this.hintedLevels = var1;
      return this;
   }

   public ChartData getLabels() {
      return this.labels;
   }

   public TreemapChartSpec setLabels(ChartData var1) {
      this.labels = var1;
      return this;
   }

   public Integer getLevels() {
      return this.levels;
   }

   public TreemapChartSpec setLevels(Integer var1) {
      this.levels = var1;
      return this;
   }

   public Double getMaxValue() {
      return this.maxValue;
   }

   public TreemapChartSpec setMaxValue(Double var1) {
      this.maxValue = var1;
      return this;
   }

   public Double getMinValue() {
      return this.minValue;
   }

   public TreemapChartSpec setMinValue(Double var1) {
      this.minValue = var1;
      return this;
   }

   public ChartData getParentLabels() {
      return this.parentLabels;
   }

   public TreemapChartSpec setParentLabels(ChartData var1) {
      this.parentLabels = var1;
      return this;
   }

   public ChartData getSizeData() {
      return this.sizeData;
   }

   public TreemapChartSpec setSizeData(ChartData var1) {
      this.sizeData = var1;
      return this;
   }

   public TextFormat getTextFormat() {
      return this.textFormat;
   }

   public TreemapChartSpec setTextFormat(TextFormat var1) {
      this.textFormat = var1;
      return this;
   }

   public TreemapChartSpec set(String var1, Object var2) {
      return (TreemapChartSpec)super.set(var1, var2);
   }

   public TreemapChartSpec clone() {
      return (TreemapChartSpec)super.clone();
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
