package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import java.io.IOException;
import java.util.List;

public class Sheets$Spreadsheets$Get extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}";
   @Key
   private String spreadsheetId;
   @Key
   private List ranges;
   @Key
   private Boolean includeGridData;
   // $FF: synthetic field
   final Sheets$Spreadsheets this$1;

   protected Sheets$Spreadsheets$Get(Sheets$Spreadsheets var1, String var2) {
      super(var1.this$0, "GET", "v4/spreadsheets/{spreadsheetId}", (Object)null, Spreadsheet.class);
      this.this$1 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
   }

   public HttpResponse executeUsingHead() throws IOException {
      return super.executeUsingHead();
   }

   public HttpRequest buildHttpRequestUsingHead() throws IOException {
      return super.buildHttpRequestUsingHead();
   }

   public Sheets$Spreadsheets$Get set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Get)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Get setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Get)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Get setAlt(String var1) {
      return (Sheets$Spreadsheets$Get)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Get setCallback(String var1) {
      return (Sheets$Spreadsheets$Get)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Get setFields(String var1) {
      return (Sheets$Spreadsheets$Get)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Get setKey(String var1) {
      return (Sheets$Spreadsheets$Get)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Get setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Get)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Get setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Get)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Get setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Get)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Get setUploadType(String var1) {
      return (Sheets$Spreadsheets$Get)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Get setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Get)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$Get setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public List getRanges() {
      return this.ranges;
   }

   public Sheets$Spreadsheets$Get setRanges(List var1) {
      this.ranges = var1;
      return this;
   }

   public Boolean getIncludeGridData() {
      return this.includeGridData;
   }

   public Sheets$Spreadsheets$Get setIncludeGridData(Boolean var1) {
      this.includeGridData = var1;
      return this;
   }

   public Sheets$Spreadsheets$Get set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Get)super.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setUploadProtocol(String var1) {
      return this.setUploadProtocol(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setUploadType(String var1) {
      return this.setUploadType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setQuotaUser(String var1) {
      return this.setQuotaUser(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setPrettyPrint(Boolean var1) {
      return this.setPrettyPrint(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setOauthToken(String var1) {
      return this.setOauthToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setKey(String var1) {
      return this.setKey(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setFields(String var1) {
      return this.setFields(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setCallback(String var1) {
      return this.setCallback(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setAlt(String var1) {
      return this.setAlt(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setAccessToken(String var1) {
      return this.setAccessToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest set$Xgafv(String var1) {
      return this.set$Xgafv(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }
}
