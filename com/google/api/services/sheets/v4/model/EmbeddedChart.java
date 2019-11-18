package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class EmbeddedChart extends GenericJson {
   @Key
   private Integer chartId;
   @Key
   private EmbeddedObjectPosition position;
   @Key
   private ChartSpec spec;

   public Integer getChartId() {
      return this.chartId;
   }

   public EmbeddedChart setChartId(Integer var1) {
      this.chartId = var1;
      return this;
   }

   public EmbeddedObjectPosition getPosition() {
      return this.position;
   }

   public EmbeddedChart setPosition(EmbeddedObjectPosition var1) {
      this.position = var1;
      return this;
   }

   public ChartSpec getSpec() {
      return this.spec;
   }

   public EmbeddedChart setSpec(ChartSpec var1) {
      this.spec = var1;
      return this;
   }

   public EmbeddedChart set(String var1, Object var2) {
      return (EmbeddedChart)super.set(var1, var2);
   }

   public EmbeddedChart clone() {
      return (EmbeddedChart)super.clone();
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
