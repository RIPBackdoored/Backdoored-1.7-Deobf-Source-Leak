package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class SetDataValidationRequest extends GenericJson {
   @Key
   private GridRange range;
   @Key
   private DataValidationRule rule;

   public GridRange getRange() {
      return this.range;
   }

   public SetDataValidationRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public DataValidationRule getRule() {
      return this.rule;
   }

   public SetDataValidationRequest setRule(DataValidationRule var1) {
      this.rule = var1;
      return this;
   }

   public SetDataValidationRequest set(String var1, Object var2) {
      return (SetDataValidationRequest)super.set(var1, var2);
   }

   public SetDataValidationRequest clone() {
      return (SetDataValidationRequest)super.clone();
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
