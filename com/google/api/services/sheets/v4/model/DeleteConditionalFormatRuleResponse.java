package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteConditionalFormatRuleResponse extends GenericJson {
   @Key
   private ConditionalFormatRule rule;

   public ConditionalFormatRule getRule() {
      return this.rule;
   }

   public DeleteConditionalFormatRuleResponse setRule(ConditionalFormatRule var1) {
      this.rule = var1;
      return this;
   }

   public DeleteConditionalFormatRuleResponse set(String var1, Object var2) {
      return (DeleteConditionalFormatRuleResponse)super.set(var1, var2);
   }

   public DeleteConditionalFormatRuleResponse clone() {
      return (DeleteConditionalFormatRuleResponse)super.clone();
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
