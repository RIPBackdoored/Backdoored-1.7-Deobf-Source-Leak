package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class HistogramChartSpec extends GenericJson {
   @Key
   private Double bucketSize;
   @Key
   private String legendPosition;
   @Key
   private Double outlierPercentile;
   @Key
   private List series;
   @Key
   private Boolean showItemDividers;

   public Double getBucketSize() {
      return this.bucketSize;
   }

   public HistogramChartSpec setBucketSize(Double var1) {
      this.bucketSize = var1;
      return this;
   }

   public String getLegendPosition() {
      return this.legendPosition;
   }

   public HistogramChartSpec setLegendPosition(String var1) {
      this.legendPosition = var1;
      return this;
   }

   public Double getOutlierPercentile() {
      return this.outlierPercentile;
   }

   public HistogramChartSpec setOutlierPercentile(Double var1) {
      this.outlierPercentile = var1;
      return this;
   }

   public List getSeries() {
      return this.series;
   }

   public HistogramChartSpec setSeries(List var1) {
      this.series = var1;
      return this;
   }

   public Boolean getShowItemDividers() {
      return this.showItemDividers;
   }

   public HistogramChartSpec setShowItemDividers(Boolean var1) {
      this.showItemDividers = var1;
      return this;
   }

   public HistogramChartSpec set(String var1, Object var2) {
      return (HistogramChartSpec)super.set(var1, var2);
   }

   public HistogramChartSpec clone() {
      return (HistogramChartSpec)super.clone();
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
