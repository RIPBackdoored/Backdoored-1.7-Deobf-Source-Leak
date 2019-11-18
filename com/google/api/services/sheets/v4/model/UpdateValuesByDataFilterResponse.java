package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateValuesByDataFilterResponse extends GenericJson {
   @Key
   private DataFilter dataFilter;
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

   public DataFilter getDataFilter() {
      return this.dataFilter;
   }

   public UpdateValuesByDataFilterResponse setDataFilter(DataFilter var1) {
      this.dataFilter = var1;
      return this;
   }

   public Integer getUpdatedCells() {
      return this.updatedCells;
   }

   public UpdateValuesByDataFilterResponse setUpdatedCells(Integer var1) {
      this.updatedCells = var1;
      return this;
   }

   public Integer getUpdatedColumns() {
      return this.updatedColumns;
   }

   public UpdateValuesByDataFilterResponse setUpdatedColumns(Integer var1) {
      this.updatedColumns = var1;
      return this;
   }

   public ValueRange getUpdatedData() {
      return this.updatedData;
   }

   public UpdateValuesByDataFilterResponse setUpdatedData(ValueRange var1) {
      this.updatedData = var1;
      return this;
   }

   public String getUpdatedRange() {
      return this.updatedRange;
   }

   public UpdateValuesByDataFilterResponse setUpdatedRange(String var1) {
      this.updatedRange = var1;
      return this;
   }

   public Integer getUpdatedRows() {
      return this.updatedRows;
   }

   public UpdateValuesByDataFilterResponse setUpdatedRows(Integer var1) {
      this.updatedRows = var1;
      return this;
   }

   public UpdateValuesByDataFilterResponse set(String var1, Object var2) {
      return (UpdateValuesByDataFilterResponse)super.set(var1, var2);
   }

   public UpdateValuesByDataFilterResponse clone() {
      return (UpdateValuesByDataFilterResponse)super.clone();
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
