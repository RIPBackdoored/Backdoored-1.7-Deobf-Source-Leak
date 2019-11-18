package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AppendValuesResponse extends GenericJson {
   @Key
   private String spreadsheetId;
   @Key
   private String tableRange;
   @Key
   private UpdateValuesResponse updates;

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public AppendValuesResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public String getTableRange() {
      return this.tableRange;
   }

   public AppendValuesResponse setTableRange(String var1) {
      this.tableRange = var1;
      return this;
   }

   public UpdateValuesResponse getUpdates() {
      return this.updates;
   }

   public AppendValuesResponse setUpdates(UpdateValuesResponse var1) {
      this.updates = var1;
      return this;
   }

   public AppendValuesResponse set(String var1, Object var2) {
      return (AppendValuesResponse)super.set(var1, var2);
   }

   public AppendValuesResponse clone() {
      return (AppendValuesResponse)super.clone();
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
