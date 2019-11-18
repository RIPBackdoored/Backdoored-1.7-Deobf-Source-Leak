package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateSpreadsheetRequest extends GenericJson {
   @Key
   private Boolean includeSpreadsheetInResponse;
   @Key
   private List requests;
   @Key
   private Boolean responseIncludeGridData;
   @Key
   private List responseRanges;

   public Boolean getIncludeSpreadsheetInResponse() {
      return this.includeSpreadsheetInResponse;
   }

   public BatchUpdateSpreadsheetRequest setIncludeSpreadsheetInResponse(Boolean var1) {
      this.includeSpreadsheetInResponse = var1;
      return this;
   }

   public List getRequests() {
      return this.requests;
   }

   public BatchUpdateSpreadsheetRequest setRequests(List var1) {
      this.requests = var1;
      return this;
   }

   public Boolean getResponseIncludeGridData() {
      return this.responseIncludeGridData;
   }

   public BatchUpdateSpreadsheetRequest setResponseIncludeGridData(Boolean var1) {
      this.responseIncludeGridData = var1;
      return this;
   }

   public List getResponseRanges() {
      return this.responseRanges;
   }

   public BatchUpdateSpreadsheetRequest setResponseRanges(List var1) {
      this.responseRanges = var1;
      return this;
   }

   public BatchUpdateSpreadsheetRequest set(String var1, Object var2) {
      return (BatchUpdateSpreadsheetRequest)super.set(var1, var2);
   }

   public BatchUpdateSpreadsheetRequest clone() {
      return (BatchUpdateSpreadsheetRequest)super.clone();
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
      Data.nullOf(Request.class);
   }
}
