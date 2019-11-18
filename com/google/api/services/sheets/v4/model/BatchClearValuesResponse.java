package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchClearValuesResponse extends GenericJson {
   @Key
   private List clearedRanges;
   @Key
   private String spreadsheetId;

   public List getClearedRanges() {
      return this.clearedRanges;
   }

   public BatchClearValuesResponse setClearedRanges(List var1) {
      this.clearedRanges = var1;
      return this;
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public BatchClearValuesResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public BatchClearValuesResponse set(String var1, Object var2) {
      return (BatchClearValuesResponse)super.set(var1, var2);
   }

   public BatchClearValuesResponse clone() {
      return (BatchClearValuesResponse)super.clone();
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
