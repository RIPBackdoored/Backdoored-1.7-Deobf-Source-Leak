package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateChartSpecRequest extends GenericJson {
   @Key
   private Integer chartId;
   @Key
   private ChartSpec spec;

   public Integer getChartId() {
      return this.chartId;
   }

   public UpdateChartSpecRequest setChartId(Integer var1) {
      this.chartId = var1;
      return this;
   }

   public ChartSpec getSpec() {
      return this.spec;
   }

   public UpdateChartSpecRequest setSpec(ChartSpec var1) {
      this.spec = var1;
      return this;
   }

   public UpdateChartSpecRequest set(String var1, Object var2) {
      return (UpdateChartSpecRequest)super.set(var1, var2);
   }

   public UpdateChartSpecRequest clone() {
      return (UpdateChartSpecRequest)super.clone();
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
