package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class RepeatCellRequest extends GenericJson {
   @Key
   private CellData cell;
   @Key
   private String fields;
   @Key
   private GridRange range;

   public CellData getCell() {
      return this.cell;
   }

   public RepeatCellRequest setCell(CellData var1) {
      this.cell = var1;
      return this;
   }

   public String getFields() {
      return this.fields;
   }

   public RepeatCellRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public RepeatCellRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public RepeatCellRequest set(String var1, Object var2) {
      return (RepeatCellRequest)super.set(var1, var2);
   }

   public RepeatCellRequest clone() {
      return (RepeatCellRequest)super.clone();
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
