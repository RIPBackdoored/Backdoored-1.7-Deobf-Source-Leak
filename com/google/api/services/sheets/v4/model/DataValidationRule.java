package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DataValidationRule extends GenericJson {
   @Key
   private BooleanCondition condition;
   @Key
   private String inputMessage;
   @Key
   private Boolean showCustomUi;
   @Key
   private Boolean strict;

   public BooleanCondition getCondition() {
      return this.condition;
   }

   public DataValidationRule setCondition(BooleanCondition var1) {
      this.condition = var1;
      return this;
   }

   public String getInputMessage() {
      return this.inputMessage;
   }

   public DataValidationRule setInputMessage(String var1) {
      this.inputMessage = var1;
      return this;
   }

   public Boolean getShowCustomUi() {
      return this.showCustomUi;
   }

   public DataValidationRule setShowCustomUi(Boolean var1) {
      this.showCustomUi = var1;
      return this;
   }

   public Boolean getStrict() {
      return this.strict;
   }

   public DataValidationRule setStrict(Boolean var1) {
      this.strict = var1;
      return this;
   }

   public DataValidationRule set(String var1, Object var2) {
      return (DataValidationRule)super.set(var1, var2);
   }

   public DataValidationRule clone() {
      return (DataValidationRule)super.clone();
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
