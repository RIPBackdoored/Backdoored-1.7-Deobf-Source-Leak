package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateValuesResponse extends GenericJson {
   @Key
   private String spreadsheetId;
   @Key
   private Integer updatedCells;
   @Key
   private Integer updatedColumns;
   @Key
   private ValueRange updatedData;
   @Key
   private String updatedRange;
   @Key
   private Integer updatedRows;

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public UpdateValuesResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Integer getUpdatedCells() {
      return this.updatedCells;
   }

   public UpdateValuesResponse setUpdatedCells(Integer var1) {
      this.updatedCells = var1;
      return this;
   }

   public Integer getUpdatedColumns() {
      return this.updatedColumns;
   }

   public UpdateValuesResponse setUpdatedColumns(Integer var1) {
      this.updatedColumns = var1;
      return this;
   }

   public ValueRange getUpdatedData() {
      return this.updatedData;
   }

   public UpdateValuesResponse setUpdatedData(ValueRange var1) {
      this.updatedData = var1;
      return this;
   }

   public String getUpdatedRange() {
      return this.updatedRange;
   }

   public UpdateValuesResponse setUpdatedRange(String var1) {
      this.updatedRange = var1;
      return this;
   }

   public Integer getUpdatedRows() {
      return this.updatedRows;
   }

   public UpdateValuesResponse setUpdatedRows(Integer var1) {
      this.updatedRows = var1;
      return this;
   }

   public UpdateValuesResponse set(String var1, Object var2) {
      return (UpdateValuesResponse)super.set(var1, var2);
   }

   public UpdateValuesResponse clone() {
      return (UpdateValuesResponse)super.clone();
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
