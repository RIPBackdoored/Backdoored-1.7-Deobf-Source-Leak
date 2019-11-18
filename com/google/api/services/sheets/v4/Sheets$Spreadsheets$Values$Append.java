package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class Sheets$Spreadsheets$Values$Append extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/values/{range}:append";
   @Key
   private String spreadsheetId;
   @Key
   private String range;
   @Key
   private String responseValueRenderOption;
   @Key
   private String insertDataOption;
   @Key
   private String valueInputOption;
   @Key
   private String responseDateTimeRenderOption;
   @Key
   private Boolean includeValuesInResponse;
   // $FF: synthetic field
   final Sheets$Spreadsheets$Values this$2;

   protected Sheets$Spreadsheets$Values$Append(Sheets$Spreadsheets$Values var1, String var2, String var3, ValueRange var4) {
      super(var1.this$1.this$0, "POST", "v4/spreadsheets/{spreadsheetId}/values/{range}:append", var4, AppendValuesResponse.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
      this.range = (String)Preconditions.checkNotNull(var3, "Required parameter range must be specified.");
   }

   public Sheets$Spreadsheets$Values$Append set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Values$Append setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Values$Append setAlt(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Values$Append setCallback(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Values$Append setFields(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Values$Append setKey(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Values$Append setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Values$Append setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Values$Append setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Values$Append setUploadType(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Values$Append setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Values$Append)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$Values$Append setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public String getRange() {
      return this.range;
   }

   public Sheets$Spreadsheets$Values$Append setRange(String var1) {
      this.range = var1;
      return this;
   }

   public String getResponseValueRenderOption() {
      return this.responseValueRenderOption;
   }

   public Sheets$Spreadsheets$Values$Append setResponseValueRenderOption(String var1) {
      this.responseValueRenderOption = var1;
      return this;
   }

   public String getInsertDataOption() {
      return this.insertDataOption;
   }

   public Sheets$Spreadsheets$Values$Append setInsertDataOption(String var1) {
      this.insertDataOption = var1;
      return this;
   }

   public String getValueInputOption() {
      return this.valueInputOption;
   }

   public Sheets$Spreadsheets$Values$Append setValueInputOption(String var1) {
      this.valueInputOption = var1;
      return this;
   }

   public String getResponseDateTimeRenderOption() {
      return this.responseDateTimeRenderOption;
   }

   public Sheets$Spreadsheets$Values$Append setResponseDateTimeRenderOption(String var1) {
      this.responseDateTimeRenderOption = var1;
      return this;
   }

   public Boolean getIncludeValuesInResponse() {
      return this.includeValuesInResponse;
   }

   public Sheets$Spreadsheets$Values$Append setIncludeValuesInResponse(Boolean var1) {
      this.includeValuesInResponse = var1;
      return this;
   }

   public Sheets$Spreadsheets$Values$Append set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Values$Append)super.set(var1, var2);
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
