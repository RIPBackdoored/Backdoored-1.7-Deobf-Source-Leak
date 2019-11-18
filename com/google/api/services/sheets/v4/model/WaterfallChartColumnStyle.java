package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class WaterfallChartColumnStyle extends GenericJson {
   @Key
   private Color color;
   @Key
   private String label;

   public Color getColor() {
      return this.color;
   }

   public WaterfallChartColumnStyle setColor(Color var1) {
      this.color = var1;
      return this;
   }

   public String getLabel() {
      return this.label;
   }

   public WaterfallChartColumnStyle setLabel(String var1) {
      this.label = var1;
      return this;
   }

   public WaterfallChartColumnStyle set(String var1, Object var2) {
      return (WaterfallChartColumnStyle)super.set(var1, var2);
   }

   public WaterfallChartColumnStyle clone() {
      return (WaterfallChartColumnStyle)super.clone();
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
