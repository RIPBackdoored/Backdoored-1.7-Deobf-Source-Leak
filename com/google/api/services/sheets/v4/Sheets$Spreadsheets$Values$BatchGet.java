package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import java.io.IOException;
import java.util.List;

public class Sheets$Spreadsheets$Values$BatchGet extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/values:batchGet";
   @Key
   private String spreadsheetId;
   @Key
   private String valueRenderOption;
   @Key
   private String dateTimeRenderOption;
   @Key
   private List ranges;
   @Key
   private String majorDimension;
   // $FF: synthetic field
   final Sheets$Spreadsheets$Values this$2;

   protected Sheets$Spreadsheets$Values$BatchGet(Sheets$Spreadsheets$Values var1, String var2) {
      super(var1.this$1.this$0, "GET", "v4/spreadsheets/{spreadsheetId}/values:batchGet", (Object)null, BatchGetValuesResponse.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
   }

   public HttpResponse executeUsingHead() throws IOException {
      return super.executeUsingHead();
   }

   public HttpRequest buildHttpRequestUsingHead() throws IOException {
      return super.buildHttpRequestUsingHead();
   }

   public Sheets$Spreadsheets$Values$BatchGet set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setAlt(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setCallback(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setFields(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setKey(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setUploadType(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Values$BatchGet setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$Values$BatchGet setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public String getValueRenderOption() {
      return this.valueRenderOption;
   }

   public Sheets$Spreadsheets$Values$BatchGet setValueRenderOption(String var1) {
      this.valueRenderOption = var1;
      return this;
   }

   public String getDateTimeRenderOption() {
      return this.dateTimeRenderOption;
   }

   public Sheets$Spreadsheets$Values$BatchGet setDateTimeRenderOption(String var1) {
      this.dateTimeRenderOption = var1;
      return this;
   }

   public List getRanges() {
      return this.ranges;
   }

   public Sheets$Spreadsheets$Values$BatchGet setRanges(List var1) {
      this.ranges = var1;
      return this;
   }

   public String getMajorDimension() {
      return this.majorDimension;
   }

   public Sheets$Spreadsheets$Values$BatchGet setMajorDimension(String var1) {
      this.majorDimension = var1;
      return this;
   }

   public Sheets$Spreadsheets$Values$BatchGet set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Values$BatchGet)super.set(var1, var2);
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
