package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AppendDimensionRequest extends GenericJson {
   @Key
   private String dimension;
   @Key
   private Integer length;
   @Key
   private Integer sheetId;

   public String getDimension() {
      return this.dimension;
   }

   public AppendDimensionRequest setDimension(String var1) {
      this.dimension = var1;
      return this;
   }

   public Integer getLength() {
      return this.length;
   }

   public AppendDimensionRequest setLength(Integer var1) {
      this.length = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public AppendDimensionRequest setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public AppendDimensionRequest set(String var1, Object var2) {
      return (AppendDimensionRequest)super.set(var1, var2);
   }

   public AppendDimensionRequest clone() {
      return (AppendDimensionRequest)super.clone();
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
