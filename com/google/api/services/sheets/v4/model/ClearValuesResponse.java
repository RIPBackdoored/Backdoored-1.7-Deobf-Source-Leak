package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class ClearValuesResponse extends GenericJson {
   @Key
   private String clearedRange;
   @Key
   private String spreadsheetId;

   public String getClearedRange() {
      return this.clearedRange;
   }

   public ClearValuesResponse setClearedRange(String var1) {
      this.clearedRange = var1;
      return this;
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public ClearValuesResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public ClearValuesResponse set(String var1, Object var2) {
      return (ClearValuesResponse)super.set(var1, var2);
   }

   public ClearValuesResponse clone() {
      return (ClearValuesResponse)super.clone();
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
