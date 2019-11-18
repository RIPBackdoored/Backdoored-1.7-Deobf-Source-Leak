package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchGetValuesResponse extends GenericJson {
   @Key
   private String spreadsheetId;
   @Key
   private List valueRanges;

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public BatchGetValuesResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public List getValueRanges() {
      return this.valueRanges;
   }

   public BatchGetValuesResponse setValueRanges(List var1) {
      this.valueRanges = var1;
      return this;
   }

   public BatchGetValuesResponse set(String var1, Object var2) {
      return (BatchGetValuesResponse)super.set(var1, var2);
   }

   public BatchGetValuesResponse clone() {
      return (BatchGetValuesResponse)super.clone();
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
