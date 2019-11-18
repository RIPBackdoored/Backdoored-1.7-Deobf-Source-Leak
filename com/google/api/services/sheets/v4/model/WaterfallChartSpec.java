package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class WaterfallChartSpec extends GenericJson {
   @Key
   private LineStyle connectorLineStyle;
   @Key
   private WaterfallChartDomain domain;
   @Key
   private Boolean firstValueIsTotal;
   @Key
   private Boolean hideConnectorLines;
   @Key
   private List series;
   @Key
   private String stackedType;

   public LineStyle getConnectorLineStyle() {
      return this.connectorLineStyle;
   }

   public WaterfallChartSpec setConnectorLineStyle(LineStyle var1) {
      this.connectorLineStyle = var1;
      return this;
   }

   public WaterfallChartDomain getDomain() {
      return this.domain;
   }

   public WaterfallChartSpec setDomain(WaterfallChartDomain var1) {
      this.domain = var1;
      return this;
   }

   public Boolean getFirstValueIsTotal() {
      return this.firstValueIsTotal;
   }

   public WaterfallChartSpec setFirstValueIsTotal(Boolean var1) {
      this.firstValueIsTotal = var1;
      return this;
   }

   public Boolean getHideConnectorLines() {
      return this.hideConnectorLines;
   }

   public WaterfallChartSpec setHideConnectorLines(Boolean var1) {
      this.hideConnectorLines = var1;
      return this;
   }

   public List getSeries() {
      return this.series;
   }

   public WaterfallChartSpec setSeries(List var1) {
      this.series = var1;
      return this;
   }

   public String getStackedType() {
      return this.stackedType;
   }

   public WaterfallChartSpec setStackedType(String var1) {
      this.stackedType = var1;
      return this;
   }

   public WaterfallChartSpec set(String var1, Object var2) {
      return (WaterfallChartSpec)super.set(var1, var2);
   }

   public WaterfallChartSpec clone() {
      return (WaterfallChartSpec)super.clone();
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
