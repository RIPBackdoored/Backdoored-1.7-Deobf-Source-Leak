package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class BubbleChartSpec extends GenericJson {
   @Key
   private Color bubbleBorderColor;
   @Key
   private ChartData bubbleLabels;
   @Key
   private Integer bubbleMaxRadiusSize;
   @Key
   private Integer bubbleMinRadiusSize;
   @Key
   private Float bubbleOpacity;
   @Key
   private ChartData bubbleSizes;
   @Key
   private TextFormat bubbleTextStyle;
   @Key
   private ChartData domain;
   @Key
   private ChartData groupIds;
   @Key
   private String legendPosition;
   @Key
   private ChartData series;

   public Color getBubbleBorderColor() {
      return this.bubbleBorderColor;
   }

   public BubbleChartSpec setBubbleBorderColor(Color var1) {
      this.bubbleBorderColor = var1;
      return this;
   }

   public ChartData getBubbleLabels() {
      return this.bubbleLabels;
   }

   public BubbleChartSpec setBubbleLabels(ChartData var1) {
      this.bubbleLabels = var1;
      return this;
   }

   public Integer getBubbleMaxRadiusSize() {
      return this.bubbleMaxRadiusSize;
   }

   public BubbleChartSpec setBubbleMaxRadiusSize(Integer var1) {
      this.bubbleMaxRadiusSize = var1;
      return this;
   }

   public Integer getBubbleMinRadiusSize() {
      return this.bubbleMinRadiusSize;
   }

   public BubbleChartSpec setBubbleMinRadiusSize(Integer var1) {
      this.bubbleMinRadiusSize = var1;
      return this;
   }

   public Float getBubbleOpacity() {
      return this.bubbleOpacity;
   }

   public BubbleChartSpec setBubbleOpacity(Float var1) {
      this.bubbleOpacity = var1;
      return this;
   }

   public ChartData getBubbleSizes() {
      return this.bubbleSizes;
   }

   public BubbleChartSpec setBubbleSizes(ChartData var1) {
      this.bubbleSizes = var1;
      return this;
   }

   public TextFormat getBubbleTextStyle() {
      return this.bubbleTextStyle;
   }

   public BubbleChartSpec setBubbleTextStyle(TextFormat var1) {
      this.bubbleTextStyle = var1;
      return this;
   }

   public ChartData getDomain() {
      return this.domain;
   }

   public BubbleChartSpec setDomain(ChartData var1) {
      this.domain = var1;
      return this;
   }

   public ChartData getGroupIds() {
      return this.groupIds;
   }

   public BubbleChartSpec setGroupIds(ChartData var1) {
      this.groupIds = var1;
      return this;
   }

   public String getLegendPosition() {
      return this.legendPosition;
   }

   public BubbleChartSpec setLegendPosition(String var1) {
      this.legendPosition = var1;
      return this;
   }

   public ChartData getSeries() {
      return this.series;
   }

   public BubbleChartSpec setSeries(ChartData var1) {
      this.series = var1;
      return this;
   }

   public BubbleChartSpec set(String var1, Object var2) {
      return (BubbleChartSpec)super.set(var1, var2);
   }

   public BubbleChartSpec clone() {
      return (BubbleChartSpec)super.clone();
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
