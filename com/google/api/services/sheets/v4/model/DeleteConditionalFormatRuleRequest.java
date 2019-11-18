package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteConditionalFormatRuleRequest extends GenericJson {
   @Key
   private Integer index;
   @Key
   private Integer sheetId;

   public Integer getIndex() {
      return this.index;
   }

   public DeleteConditionalFormatRuleRequest setIndex(Integer var1) {
      this.index = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public DeleteConditionalFormatRuleRequest setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public DeleteConditionalFormatRuleRequest set(String var1, Object var2) {
      return (DeleteConditionalFormatRuleRequest)super.set(var1, var2);
   }

   public DeleteConditionalFormatRuleRequest clone() {
      return (DeleteConditionalFormatRuleRequest)super.clone();
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
