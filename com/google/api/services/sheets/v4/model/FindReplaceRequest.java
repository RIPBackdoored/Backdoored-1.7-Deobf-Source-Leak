package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class FindReplaceRequest extends GenericJson {
   @Key
   private Boolean allSheets;
   @Key
   private String find;
   @Key
   private Boolean includeFormulas;
   @Key
   private Boolean matchCase;
   @Key
   private Boolean matchEntireCell;
   @Key
   private GridRange range;
   @Key
   private String replacement;
   @Key
   private Boolean searchByRegex;
   @Key
   private Integer sheetId;

   public Boolean getAllSheets() {
      return this.allSheets;
   }

   public FindReplaceRequest setAllSheets(Boolean var1) {
      this.allSheets = var1;
      return this;
   }

   public String getFind() {
      return this.find;
   }

   public FindReplaceRequest setFind(String var1) {
      this.find = var1;
      return this;
   }

   public Boolean getIncludeFormulas() {
      return this.includeFormulas;
   }

   public FindReplaceRequest setIncludeFormulas(Boolean var1) {
      this.includeFormulas = var1;
      return this;
   }

   public Boolean getMatchCase() {
      return this.matchCase;
   }

   public FindReplaceRequest setMatchCase(Boolean var1) {
      this.matchCase = var1;
      return this;
   }

   public Boolean getMatchEntireCell() {
      return this.matchEntireCell;
   }

   public FindReplaceRequest setMatchEntireCell(Boolean var1) {
      this.matchEntireCell = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public FindReplaceRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public String getReplacement() {
      return this.replacement;
   }

   public FindReplaceRequest setReplacement(String var1) {
      this.replacement = var1;
      return this;
   }

   public Boolean getSearchByRegex() {
      return this.searchByRegex;
   }

   public FindReplaceRequest setSearchByRegex(Boolean var1) {
      this.searchByRegex = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public FindReplaceRequest setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public FindReplaceRequest set(String var1, Object var2) {
      return (FindReplaceRequest)super.set(var1, var2);
   }

   public FindReplaceRequest clone() {
      return (FindReplaceRequest)super.clone();
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
