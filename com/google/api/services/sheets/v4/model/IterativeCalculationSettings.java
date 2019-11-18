package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class IterativeCalculationSettings extends GenericJson {
   @Key
   private Double convergenceThreshold;
   @Key
   private Integer maxIterations;

   public Double getConvergenceThreshold() {
      return this.convergenceThreshold;
   }

   public IterativeCalculationSettings setConvergenceThreshold(Double var1) {
      this.convergenceThreshold = var1;
      return this;
   }

   public Integer getMaxIterations() {
      return this.maxIterations;
   }

   public IterativeCalculationSettings setMaxIterations(Integer var1) {
      this.maxIterations = var1;
      return this;
   }

   public IterativeCalculationSettings set(String var1, Object var2) {
      return (IterativeCalculationSettings)super.set(var1, var2);
   }

   public IterativeCalculationSettings clone() {
      return (IterativeCalculationSettings)super.clone();
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
