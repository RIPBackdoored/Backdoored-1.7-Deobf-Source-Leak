package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateSpreadsheetResponse extends GenericJson {
   @Key
   private List replies;
   @Key
   private String spreadsheetId;
   @Key
   private Spreadsheet updatedSpreadsheet;

   public List getReplies() {
      return this.replies;
   }

   public BatchUpdateSpreadsheetResponse setReplies(List var1) {
      this.replies = var1;
      return this;
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public BatchUpdateSpreadsheetResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Spreadsheet getUpdatedSpreadsheet() {
      return this.updatedSpreadsheet;
   }

   public BatchUpdateSpreadsheetResponse setUpdatedSpreadsheet(Spreadsheet var1) {
      this.updatedSpreadsheet = var1;
      return this;
   }

   public BatchUpdateSpreadsheetResponse set(String var1, Object var2) {
      return (BatchUpdateSpreadsheetResponse)super.set(var1, var2);
   }

   public BatchUpdateSpreadsheetResponse clone() {
      return (BatchUpdateSpreadsheetResponse)super.clone();
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

   static {
      Data.nullOf(Response.class);
   }
}
