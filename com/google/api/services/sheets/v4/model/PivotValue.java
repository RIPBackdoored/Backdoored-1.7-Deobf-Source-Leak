package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class PivotValue extends GenericJson {
   @Key
   private String calculatedDisplayType;
   @Key
   private String formula;
   @Key
   private String name;
   @Key
   private Integer sourceColumnOffset;
   @Key
   private String summarizeFunction;

   public String getCalculatedDisplayType() {
      return this.calculatedDisplayType;
   }

   public PivotValue setCalculatedDisplayType(String var1) {
      this.calculatedDisplayType = var1;
      return this;
   }

   public String getFormula() {
      return this.formula;
   }

   public PivotValue setFormula(String var1) {
      this.formula = var1;
      return this;
   }

   public String getName() {
      return this.name;
   }

   public PivotValue setName(String var1) {
      this.name = var1;
      return this;
   }

   public Integer getSourceColumnOffset() {
      return this.sourceColumnOffset;
   }

   public PivotValue setSourceColumnOffset(Integer var1) {
      this.sourceColumnOffset = var1;
      return this;
   }

   public String getSummarizeFunction() {
      return this.summarizeFunction;
   }

   public PivotValue setSummarizeFunction(String var1) {
      this.summarizeFunction = var1;
      return this;
   }

   public PivotValue set(String var1, Object var2) {
      return (PivotValue)super.set(var1, var2);
   }

   public PivotValue clone() {
      return (PivotValue)super.clone();
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
