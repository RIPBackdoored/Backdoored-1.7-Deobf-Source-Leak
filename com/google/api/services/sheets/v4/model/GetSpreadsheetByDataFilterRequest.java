package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class GetSpreadsheetByDataFilterRequest extends GenericJson {
   @Key
   private List dataFilters;
   @Key
   private Boolean includeGridData;

   public List getDataFilters() {
      return this.dataFilters;
   }

   public GetSpreadsheetByDataFilterRequest setDataFilters(List var1) {
      this.dataFilters = var1;
      return this;
   }

   public Boolean getIncludeGridData() {
      return this.includeGridData;
   }

   public GetSpreadsheetByDataFilterRequest setIncludeGridData(Boolean var1) {
      this.includeGridData = var1;
      return this;
   }

   public GetSpreadsheetByDataFilterRequest set(String var1, Object var2) {
      return (GetSpreadsheetByDataFilterRequest)super.set(var1, var2);
   }

   public GetSpreadsheetByDataFilterRequest clone() {
      return (GetSpreadsheetByDataFilterRequest)super.clone();
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
