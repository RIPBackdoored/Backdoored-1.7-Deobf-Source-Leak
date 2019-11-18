package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AddConditionalFormatRuleRequest extends GenericJson {
   @Key
   private Integer index;
   @Key
   private ConditionalFormatRule rule;

   public Integer getIndex() {
      return this.index;
   }

   public AddConditionalFormatRuleRequest setIndex(Integer var1) {
      this.index = var1;
      return this;
   }

   public ConditionalFormatRule getRule() {
      return this.rule;
   }

   public AddConditionalFormatRuleRequest setRule(ConditionalFormatRule var1) {
      this.rule = var1;
      return this;
   }

   public AddConditionalFormatRuleRequest set(String var1, Object var2) {
      return (AddConditionalFormatRuleRequest)super.set(var1, var2);
   }

   public AddConditionalFormatRuleRequest clone() {
      return (AddConditionalFormatRuleRequest)super.clone();
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
