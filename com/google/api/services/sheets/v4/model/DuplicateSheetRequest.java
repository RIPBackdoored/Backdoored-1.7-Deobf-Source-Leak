package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DuplicateSheetRequest extends GenericJson {
   @Key
   private Integer insertSheetIndex;
   @Key
   private Integer newSheetId;
   @Key
   private String newSheetName;
   @Key
   private Integer sourceSheetId;

   public Integer getInsertSheetIndex() {
      return this.insertSheetIndex;
   }

   public DuplicateSheetRequest setInsertSheetIndex(Integer var1) {
      this.insertSheetIndex = var1;
      return this;
   }

   public Integer getNewSheetId() {
      return this.newSheetId;
   }

   public DuplicateSheetRequest setNewSheetId(Integer var1) {
      this.newSheetId = var1;
      return this;
   }

   public String getNewSheetName() {
      return this.newSheetName;
   }

   public DuplicateSheetRequest setNewSheetName(String var1) {
      this.newSheetName = var1;
      return this;
   }

   public Integer getSourceSheetId() {
      return this.sourceSheetId;
   }

   public DuplicateSheetRequest setSourceSheetId(Integer var1) {
      this.sourceSheetId = var1;
      return this;
   }

   public DuplicateSheetRequest set(String var1, Object var2) {
      return (DuplicateSheetRequest)super.set(var1, var2);
   }

   public DuplicateSheetRequest clone() {
      return (DuplicateSheetRequest)super.clone();
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
