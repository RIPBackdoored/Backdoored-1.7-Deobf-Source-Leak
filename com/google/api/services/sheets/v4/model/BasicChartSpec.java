package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BasicChartSpec extends GenericJson {
   @Key
   private List axis;
   @Key
   private String chartType;
   @Key
   private String compareMode;
   @Key
   private List domains;
   @Key
   private Integer headerCount;
   @Key
   private Boolean interpolateNulls;
   @Key
   private String legendPosition;
   @Key
   private Boolean lineSmoothing;
   @Key
   private List series;
   @Key
   private String stackedType;
   @Key
   private Boolean threeDimensional;

   public List getAxis() {
      return this.axis;
   }

   public BasicChartSpec setAxis(List var1) {
      this.axis = var1;
      return this;
   }

   public String getChartType() {
      return this.chartType;
   }

   public BasicChartSpec setChartType(String var1) {
      this.chartType = var1;
      return this;
   }

   public String getCompareMode() {
      return this.compareMode;
   }

   public BasicChartSpec setCompareMode(String var1) {
      this.compareMode = var1;
      return this;
   }

   public List getDomains() {
      return this.domains;
   }

   public BasicChartSpec setDomains(List var1) {
      this.domains = var1;
      return this;
   }

   public Integer getHeaderCount() {
      return this.headerCount;
   }

   public BasicChartSpec setHeaderCount(Integer var1) {
      this.headerCount = var1;
      return this;
   }

   public Boolean getInterpolateNulls() {
      return this.interpolateNulls;
   }

   public BasicChartSpec setInterpolateNulls(Boolean var1) {
      this.interpolateNulls = var1;
      return this;
   }

   public String getLegendPosition() {
      return this.legendPosition;
   }

   public BasicChartSpec setLegendPosition(String var1) {
      this.legendPosition = var1;
      return this;
   }

   public Boolean getLineSmoothing() {
      return this.lineSmoothing;
   }

   public BasicChartSpec setLineSmoothing(Boolean var1) {
      this.lineSmoothing = var1;
      return this;
   }

   public List getSeries() {
      return this.series;
   }

   public BasicChartSpec setSeries(List var1) {
      this.series = var1;
      return this;
   }

   public String getStackedType() {
      return this.stackedType;
   }

   public BasicChartSpec setStackedType(String var1) {
      this.stackedType = var1;
      return this;
   }

   public Boolean getThreeDimensional() {
      return this.threeDimensional;
   }

   public BasicChartSpec setThreeDimensional(Boolean var1) {
      this.threeDimensional = var1;
      return this;
   }

   public BasicChartSpec set(String var1, Object var2) {
      return (BasicChartSpec)super.set(var1, var2);
   }

   public BasicChartSpec clone() {
      return (BasicChartSpec)super.clone();
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

   static {
      Data.nullOf(BasicChartDomain.class);
   }
}
