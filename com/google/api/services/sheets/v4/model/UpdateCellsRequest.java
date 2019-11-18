package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class UpdateCellsRequest extends GenericJson {
   @Key
   private String fields;
   @Key
   private GridRange range;
   @Key
   private List rows;
   @Key
   private GridCoordinate start;

   public String getFields() {
      return this.fields;
   }

   public UpdateCellsRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public UpdateCellsRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public List getRows() {
      return this.rows;
   }

   public UpdateCellsRequest setRows(List var1) {
      this.rows = var1;
      return this;
   }

   public GridCoordinate getStart() {
      return this.start;
   }

   public UpdateCellsRequest setStart(GridCoordinate var1) {
      this.start = var1;
      return this;
   }

   public UpdateCellsRequest set(String var1, Object var2) {
      return (UpdateCellsRequest)super.set(var1, var2);
   }

   public UpdateCellsRequest clone() {
      return (UpdateCellsRequest)super.clone();
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
