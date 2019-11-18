package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;

public class Sheets$Spreadsheets$Values$Get extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/values/{range}";
   @Key
   private String spreadsheetId;
   @Key
   private String range;
   @Key
   private String valueRenderOption;
   @Key
   private String dateTimeRenderOption;
   @Key
   private String majorDimension;
   // $FF: synthetic field
   final Sheets$Spreadsheets$Values this$2;

   protected Sheets$Spreadsheets$Values$Get(Sheets$Spreadsheets$Values var1, String var2, String var3) {
      super(var1.this$1.this$0, "GET", "v4/spreadsheets/{spreadsheetId}/values/{range}", (Object)null, ValueRange.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
      this.range = (String)Preconditions.checkNotNull(var3, "Required parameter range must be specified.");
   }

   public HttpResponse executeUsingHead() throws IOException {
      return super.executeUsingHead();
   }

   public HttpRequest buildHttpRequestUsingHead() throws IOException {
      return super.buildHttpRequestUsingHead();
   }

   public Sheets$Spreadsheets$Values$Get set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Values$Get setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Values$Get setAlt(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Values$Get setCallback(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Values$Get setFields(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Values$Get setKey(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Values$Get setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Values$Get setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Values$Get setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Values$Get setUploadType(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Values$Get setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Values$Get)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$Values$Get setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public String getRange() {
      return this.range;
   }

   public Sheets$Spreadsheets$Values$Get setRange(String var1) {
      this.range = var1;
      return this;
   }

   public String getValueRenderOption() {
      return this.valueRenderOption;
   }

   public Sheets$Spreadsheets$Values$Get setValueRenderOption(String var1) {
      this.valueRenderOption = var1;
      return this;
   }

   public String getDateTimeRenderOption() {
      return this.dateTimeRenderOption;
   }

   public Sheets$Spreadsheets$Values$Get setDateTimeRenderOption(String var1) {
      this.dateTimeRenderOption = var1;
      return this;
   }

   public String getMajorDimension() {
      return this.majorDimension;
   }

   public Sheets$Spreadsheets$Values$Get setMajorDimension(String var1) {
      this.majorDimension = var1;
      return this;
   }

   public Sheets$Spreadsheets$Values$Get set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Values$Get)super.set(var1, var2);
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
