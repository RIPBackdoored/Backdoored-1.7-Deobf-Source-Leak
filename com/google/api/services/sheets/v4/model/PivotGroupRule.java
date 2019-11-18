package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class PivotGroupRule extends GenericJson {
   @Key
   private DateTimeRule dateTimeRule;
   @Key
   private HistogramRule histogramRule;
   @Key
   private ManualRule manualRule;

   public DateTimeRule getDateTimeRule() {
      return this.dateTimeRule;
   }

   public PivotGroupRule setDateTimeRule(DateTimeRule var1) {
      this.dateTimeRule = var1;
      return this;
   }

   public HistogramRule getHistogramRule() {
      return this.histogramRule;
   }

   public PivotGroupRule setHistogramRule(HistogramRule var1) {
      this.histogramRule = var1;
      return this;
   }

   public ManualRule getManualRule() {
      return this.manualRule;
   }

   public PivotGroupRule setManualRule(ManualRule var1) {
      this.manualRule = var1;
      return this;
   }

   public PivotGroupRule set(String var1, Object var2) {
      return (PivotGroupRule)super.set(var1, var2);
   }

   public PivotGroupRule clone() {
      return (PivotGroupRule)super.clone();
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
