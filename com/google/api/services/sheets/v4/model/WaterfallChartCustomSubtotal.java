package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class WaterfallChartCustomSubtotal extends GenericJson {
   @Key
   private Boolean dataIsSubtotal;
   @Key
   private String label;
   @Key
   private Integer subtotalIndex;

   public Boolean getDataIsSubtotal() {
      return this.dataIsSubtotal;
   }

   public WaterfallChartCustomSubtotal setDataIsSubtotal(Boolean var1) {
      this.dataIsSubtotal = var1;
      return this;
   }

   public String getLabel() {
      return this.label;
   }

   public WaterfallChartCustomSubtotal setLabel(String var1) {
      this.label = var1;
      return this;
   }

   public Integer getSubtotalIndex() {
      return this.subtotalIndex;
   }

   public WaterfallChartCustomSubtotal setSubtotalIndex(Integer var1) {
      this.subtotalIndex = var1;
      return this;
   }

   public WaterfallChartCustomSubtotal set(String var1, Object var2) {
      return (WaterfallChartCustomSubtotal)super.set(var1, var2);
   }

   public WaterfallChartCustomSubtotal clone() {
      return (WaterfallChartCustomSubtotal)super.clone();
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
