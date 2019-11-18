package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class ConditionalFormatRule extends GenericJson {
   @Key
   private BooleanRule booleanRule;
   @Key
   private GradientRule gradientRule;
   @Key
   private List ranges;

   public BooleanRule getBooleanRule() {
      return this.booleanRule;
   }

   public ConditionalFormatRule setBooleanRule(BooleanRule var1) {
      this.booleanRule = var1;
      return this;
   }

   public GradientRule getGradientRule() {
      return this.gradientRule;
   }

   public ConditionalFormatRule setGradientRule(GradientRule var1) {
      this.gradientRule = var1;
      return this;
   }

   public List getRanges() {
      return this.ranges;
   }

   public ConditionalFormatRule setRanges(List var1) {
      this.ranges = var1;
      return this;
   }

   public ConditionalFormatRule set(String var1, Object var2) {
      return (ConditionalFormatRule)super.set(var1, var2);
   }

   public ConditionalFormatRule clone() {
      return (ConditionalFormatRule)super.clone();
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
