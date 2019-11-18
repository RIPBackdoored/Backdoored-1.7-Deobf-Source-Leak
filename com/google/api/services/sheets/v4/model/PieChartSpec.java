package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class PieChartSpec extends GenericJson {
   @Key
   private ChartData domain;
   @Key
   private String legendPosition;
   @Key
   private Double pieHole;
   @Key
   private ChartData series;
   @Key
   private Boolean threeDimensional;

   public ChartData getDomain() {
      return this.domain;
   }

   public PieChartSpec setDomain(ChartData var1) {
      this.domain = var1;
      return this;
   }

   public String getLegendPosition() {
      return this.legendPosition;
   }

   public PieChartSpec setLegendPosition(String var1) {
      this.legendPosition = var1;
      return this;
   }

   public Double getPieHole() {
      return this.pieHole;
   }

   public PieChartSpec setPieHole(Double var1) {
      this.pieHole = var1;
      return this;
   }

   public ChartData getSeries() {
      return this.series;
   }

   public PieChartSpec setSeries(ChartData var1) {
      this.series = var1;
      return this;
   }

   public Boolean getThreeDimensional() {
      return this.threeDimensional;
   }

   public PieChartSpec setThreeDimensional(Boolean var1) {
      this.threeDimensional = var1;
      return this;
   }

   public PieChartSpec set(String var1, Object var2) {
      return (PieChartSpec)super.set(var1, var2);
   }

   public PieChartSpec clone() {
      return (PieChartSpec)super.clone();
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
