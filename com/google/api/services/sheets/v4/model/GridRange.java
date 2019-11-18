package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class GridRange extends GenericJson {
   @Key
   private Integer endColumnIndex;
   @Key
   private Integer endRowIndex;
   @Key
   private Integer sheetId;
   @Key
   private Integer startColumnIndex;
   @Key
   private Integer startRowIndex;

   public Integer getEndColumnIndex() {
      return this.endColumnIndex;
   }

   public GridRange setEndColumnIndex(Integer var1) {
      this.endColumnIndex = var1;
      return this;
   }

   public Integer getEndRowIndex() {
      return this.endRowIndex;
   }

   public GridRange setEndRowIndex(Integer var1) {
      this.endRowIndex = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public GridRange setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public Integer getStartColumnIndex() {
      return this.startColumnIndex;
   }

   public GridRange setStartColumnIndex(Integer var1) {
      this.startColumnIndex = var1;
      return this;
   }

   public Integer getStartRowIndex() {
      return this.startRowIndex;
   }

   public GridRange setStartRowIndex(Integer var1) {
      this.startRowIndex = var1;
      return this;
   }

   public GridRange set(String var1, Object var2) {
      return (GridRange)super.set(var1, var2);
   }

   public GridRange clone() {
      return (GridRange)super.clone();
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
