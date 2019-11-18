package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class Spreadsheet extends GenericJson {
   @Key
   private List developerMetadata;
   @Key
   private List namedRanges;
   @Key
   private SpreadsheetProperties properties;
   @Key
   private List sheets;
   @Key
   private String spreadsheetId;
   @Key
   private String spreadsheetUrl;

   public List getDeveloperMetadata() {
      return this.developerMetadata;
   }

   public Spreadsheet setDeveloperMetadata(List var1) {
      this.developerMetadata = var1;
      return this;
   }

   public List getNamedRanges() {
      return this.namedRanges;
   }

   public Spreadsheet setNamedRanges(List var1) {
      this.namedRanges = var1;
      return this;
   }

   public SpreadsheetProperties getProperties() {
      return this.properties;
   }

   public Spreadsheet setProperties(SpreadsheetProperties var1) {
      this.properties = var1;
      return this;
   }

   public List getSheets() {
      return this.sheets;
   }

   public Spreadsheet setSheets(List var1) {
      this.sheets = var1;
      return this;
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Spreadsheet setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public String getSpreadsheetUrl() {
      return this.spreadsheetUrl;
   }

   public Spreadsheet setSpreadsheetUrl(String var1) {
      this.spreadsheetUrl = var1;
      return this;
   }

   public Spreadsheet set(String var1, Object var2) {
      return (Spreadsheet)super.set(var1, var2);
   }

   public Spreadsheet clone() {
      return (Spreadsheet)super.clone();
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
      Data.nullOf(DeveloperMetadata.class);
      Data.nullOf(Sheet.class);
   }
}
