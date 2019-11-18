package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeveloperMetadataLocation extends GenericJson {
   @Key
   private DimensionRange dimensionRange;
   @Key
   private String locationType;
   @Key
   private Integer sheetId;
   @Key
   private Boolean spreadsheet;

   public DimensionRange getDimensionRange() {
      return this.dimensionRange;
   }

   public DeveloperMetadataLocation setDimensionRange(DimensionRange var1) {
      this.dimensionRange = var1;
      return this;
   }

   public String getLocationType() {
      return this.locationType;
   }

   public DeveloperMetadataLocation setLocationType(String var1) {
      this.locationType = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public DeveloperMetadataLocation setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public Boolean getSpreadsheet() {
      return this.spreadsheet;
   }

   public DeveloperMetadataLocation setSpreadsheet(Boolean var1) {
      this.spreadsheet = var1;
      return this;
   }

   public DeveloperMetadataLocation set(String var1, Object var2) {
      return (DeveloperMetadataLocation)super.set(var1, var2);
   }

   public DeveloperMetadataLocation clone() {
      return (DeveloperMetadataLocation)super.clone();
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
