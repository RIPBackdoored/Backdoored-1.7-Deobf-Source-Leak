package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateConditionalFormatRuleResponse extends GenericJson {
   @Key
   private Integer newIndex;
   @Key
   private ConditionalFormatRule newRule;
   @Key
   private Integer oldIndex;
   @Key
   private ConditionalFormatRule oldRule;

   public Integer getNewIndex() {
      return this.newIndex;
   }

   public UpdateConditionalFormatRuleResponse setNewIndex(Integer var1) {
      this.newIndex = var1;
      return this;
   }

   public ConditionalFormatRule getNewRule() {
      return this.newRule;
   }

   public UpdateConditionalFormatRuleResponse setNewRule(ConditionalFormatRule var1) {
      this.newRule = var1;
      return this;
   }

   public Integer getOldIndex() {
      return this.oldIndex;
   }

   public UpdateConditionalFormatRuleResponse setOldIndex(Integer var1) {
      this.oldIndex = var1;
      return this;
   }

   public ConditionalFormatRule getOldRule() {
      return this.oldRule;
   }

   public UpdateConditionalFormatRuleResponse setOldRule(ConditionalFormatRule var1) {
      this.oldRule = var1;
      return this;
   }

   public UpdateConditionalFormatRuleResponse set(String var1, Object var2) {
      return (UpdateConditionalFormatRuleResponse)super.set(var1, var2);
   }

   public UpdateConditionalFormatRuleResponse clone() {
      return (UpdateConditionalFormatRuleResponse)super.clone();
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
