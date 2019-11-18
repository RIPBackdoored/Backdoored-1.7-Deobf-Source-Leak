package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class GridData extends GenericJson {
   @Key
   private List columnMetadata;
   @Key
   private List rowData;
   @Key
   private List rowMetadata;
   @Key
   private Integer startColumn;
   @Key
   private Integer startRow;

   public List getColumnMetadata() {
      return this.columnMetadata;
   }

   public GridData setColumnMetadata(List var1) {
      this.columnMetadata = var1;
      return this;
   }

   public List getRowData() {
      return this.rowData;
   }

   public GridData setRowData(List var1) {
      this.rowData = var1;
      return this;
   }

   public List getRowMetadata() {
      return this.rowMetadata;
   }

   public GridData setRowMetadata(List var1) {
      this.rowMetadata = var1;
      return this;
   }

   public Integer getStartColumn() {
      return this.startColumn;
   }

   public GridData setStartColumn(Integer var1) {
      this.startColumn = var1;
      return this;
   }

   public Integer getStartRow() {
      return this.startRow;
   }

   public GridData setStartRow(Integer var1) {
      this.startRow = var1;
      return this;
   }

   public GridData set(String var1, Object var2) {
      return (GridData)super.set(var1, var2);
   }

   public GridData clone() {
      return (GridData)super.clone();
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
      Data.nullOf(RowData.class);
   }
}
