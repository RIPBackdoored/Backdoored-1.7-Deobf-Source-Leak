package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class GridCoordinate extends GenericJson {
   @Key
   private Integer columnIndex;
   @Key
   private Integer rowIndex;
   @Key
   private Integer sheetId;

   public Integer getColumnIndex() {
      return this.columnIndex;
   }

   public GridCoordinate setColumnIndex(Integer var1) {
      this.columnIndex = var1;
      return this;
   }

   public Integer getRowIndex() {
      return this.rowIndex;
   }

   public GridCoordinate setRowIndex(Integer var1) {
      this.rowIndex = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public GridCoordinate setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public GridCoordinate set(String var1, Object var2) {
      return (GridCoordinate)super.set(var1, var2);
   }

   public GridCoordinate clone() {
      return (GridCoordinate)super.clone();
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
