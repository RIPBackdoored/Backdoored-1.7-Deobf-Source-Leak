package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class WaterfallChartSeries extends GenericJson {
   @Key
   private List customSubtotals;
   @Key
   private ChartData data;
   @Key
   private Boolean hideTrailingSubtotal;
   @Key
   private WaterfallChartColumnStyle negativeColumnsStyle;
   @Key
   private WaterfallChartColumnStyle positiveColumnsStyle;
   @Key
   private WaterfallChartColumnStyle subtotalColumnsStyle;

   public List getCustomSubtotals() {
      return this.customSubtotals;
   }

   public WaterfallChartSeries setCustomSubtotals(List var1) {
      this.customSubtotals = var1;
      return this;
   }

   public ChartData getData() {
      return this.data;
   }

   public WaterfallChartSeries setData(ChartData var1) {
      this.data = var1;
      return this;
   }

   public Boolean getHideTrailingSubtotal() {
      return this.hideTrailingSubtotal;
   }

   public WaterfallChartSeries setHideTrailingSubtotal(Boolean var1) {
      this.hideTrailingSubtotal = var1;
      return this;
   }

   public WaterfallChartColumnStyle getNegativeColumnsStyle() {
      return this.negativeColumnsStyle;
   }

   public WaterfallChartSeries setNegativeColumnsStyle(WaterfallChartColumnStyle var1) {
      this.negativeColumnsStyle = var1;
      return this;
   }

   public WaterfallChartColumnStyle getPositiveColumnsStyle() {
      return this.positiveColumnsStyle;
   }

   public WaterfallChartSeries setPositiveColumnsStyle(WaterfallChartColumnStyle var1) {
      this.positiveColumnsStyle = var1;
      return this;
   }

   public WaterfallChartColumnStyle getSubtotalColumnsStyle() {
      return this.subtotalColumnsStyle;
   }

   public WaterfallChartSeries setSubtotalColumnsStyle(WaterfallChartColumnStyle var1) {
      this.subtotalColumnsStyle = var1;
      return this;
   }

   public WaterfallChartSeries set(String var1, Object var2) {
      return (WaterfallChartSeries)super.set(var1, var2);
   }

   public WaterfallChartSeries clone() {
      return (WaterfallChartSeries)super.clone();
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
