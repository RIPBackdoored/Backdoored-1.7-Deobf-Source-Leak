package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class HistogramRule extends GenericJson {
   @Key
   private Double end;
   @Key
   private Double interval;
   @Key
   private Double start;

   public Double getEnd() {
      return this.end;
   }

   public HistogramRule setEnd(Double var1) {
      this.end = var1;
      return this;
   }

   public Double getInterval() {
      return this.interval;
   }

   public HistogramRule setInterval(Double var1) {
      this.interval = var1;
      return this;
   }

   public Double getStart() {
      return this.start;
   }

   public HistogramRule setStart(Double var1) {
      this.start = var1;
      return this;
   }

   public HistogramRule set(String var1, Object var2) {
      return (HistogramRule)super.set(var1, var2);
   }

   public HistogramRule clone() {
      return (HistogramRule)super.clone();
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
