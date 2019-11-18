package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateConditionalFormatRuleRequest extends GenericJson {
   @Key
   private Integer index;
   @Key
   private Integer newIndex;
   @Key
   private ConditionalFormatRule rule;
   @Key
   private Integer sheetId;

   public Integer getIndex() {
      return this.index;
   }

   public UpdateConditionalFormatRuleRequest setIndex(Integer var1) {
      this.index = var1;
      return this;
   }

   public Integer getNewIndex() {
      return this.newIndex;
   }

   public UpdateConditionalFormatRuleRequest setNewIndex(Integer var1) {
      this.newIndex = var1;
      return this;
   }

   public ConditionalFormatRule getRule() {
      return this.rule;
   }

   public UpdateConditionalFormatRuleRequest setRule(ConditionalFormatRule var1) {
      this.rule = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public UpdateConditionalFormatRuleRequest setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public UpdateConditionalFormatRuleRequest set(String var1, Object var2) {
      return (UpdateConditionalFormatRuleRequest)super.set(var1, var2);
   }

   public UpdateConditionalFormatRuleRequest clone() {
      return (UpdateConditionalFormatRuleRequest)super.clone();
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
