package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class ExtendedValue extends GenericJson {
   @Key
   private Boolean boolValue;
   @Key
   private ErrorValue errorValue;
   @Key
   private String formulaValue;
   @Key
   private Double numberValue;
   @Key
   private String stringValue;

   public Boolean getBoolValue() {
      return this.boolValue;
   }

   public ExtendedValue setBoolValue(Boolean var1) {
      this.boolValue = var1;
      return this;
   }

   public ErrorValue getErrorValue() {
      return this.errorValue;
   }

   public ExtendedValue setErrorValue(ErrorValue var1) {
      this.errorValue = var1;
      return this;
   }

   public String getFormulaValue() {
      return this.formulaValue;
   }

   public ExtendedValue setFormulaValue(String var1) {
      this.formulaValue = var1;
      return this;
   }

   public Double getNumberValue() {
      return this.numberValue;
   }

   public ExtendedValue setNumberValue(Double var1) {
      this.numberValue = var1;
      return this;
   }

   public String getStringValue() {
      return this.stringValue;
   }

   public ExtendedValue setStringValue(String var1) {
      this.stringValue = var1;
      return this;
   }

   public ExtendedValue set(String var1, Object var2) {
      return (ExtendedValue)super.set(var1, var2);
   }

   public ExtendedValue clone() {
      return (ExtendedValue)super.clone();
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
