package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DimensionRange extends GenericJson {
   @Key
   private String dimension;
   @Key
   private Integer endIndex;
   @Key
   private Integer sheetId;
   @Key
   private Integer startIndex;

   public String getDimension() {
      return this.dimension;
   }

   public DimensionRange setDimension(String var1) {
      this.dimension = var1;
      return this;
   }

   public Integer getEndIndex() {
      return this.endIndex;
   }

   public DimensionRange setEndIndex(Integer var1) {
      this.endIndex = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public DimensionRange setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public Integer getStartIndex() {
      return this.startIndex;
   }

   public DimensionRange setStartIndex(Integer var1) {
      this.startIndex = var1;
      return this;
   }

   public DimensionRange set(String var1, Object var2) {
      return (DimensionRange)super.set(var1, var2);
   }

   public DimensionRange clone() {
      return (DimensionRange)super.clone();
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
