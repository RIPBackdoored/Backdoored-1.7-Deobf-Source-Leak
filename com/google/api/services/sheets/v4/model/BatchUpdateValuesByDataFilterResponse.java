package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateValuesByDataFilterResponse extends GenericJson {
   @Key
   private List responses;
   @Key
   private String spreadsheetId;
   @Key
   private Integer totalUpdatedCells;
   @Key
   private Integer totalUpdatedColumns;
   @Key
   private Integer totalUpdatedRows;
   @Key
   private Integer totalUpdatedSheets;

   public List getResponses() {
      return this.responses;
   }

   public BatchUpdateValuesByDataFilterResponse setResponses(List var1) {
      this.responses = var1;
      return this;
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public BatchUpdateValuesByDataFilterResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Integer getTotalUpdatedCells() {
      return this.totalUpdatedCells;
   }

   public BatchUpdateValuesByDataFilterResponse setTotalUpdatedCells(Integer var1) {
      this.totalUpdatedCells = var1;
      return this;
   }

   public Integer getTotalUpdatedColumns() {
      return this.totalUpdatedColumns;
   }

   public BatchUpdateValuesByDataFilterResponse setTotalUpdatedColumns(Integer var1) {
      this.totalUpdatedColumns = var1;
      return this;
   }

   public Integer getTotalUpdatedRows() {
      return this.totalUpdatedRows;
   }

   public BatchUpdateValuesByDataFilterResponse setTotalUpdatedRows(Integer var1) {
      this.totalUpdatedRows = var1;
      return this;
   }

   public Integer getTotalUpdatedSheets() {
      return this.totalUpdatedSheets;
   }

   public BatchUpdateValuesByDataFilterResponse setTotalUpdatedSheets(Integer var1) {
      this.totalUpdatedSheets = var1;
      return this;
   }

   public BatchUpdateValuesByDataFilterResponse set(String var1, Object var2) {
      return (BatchUpdateValuesByDataFilterResponse)super.set(var1, var2);
   }

   public BatchUpdateValuesByDataFilterResponse clone() {
      return (BatchUpdateValuesByDataFilterResponse)super.clone();
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
