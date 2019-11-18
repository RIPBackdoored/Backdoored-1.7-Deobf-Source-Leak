package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class Sheets$Spreadsheets$Values$Update extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/values/{range}";
   @Key
   private String spreadsheetId;
   @Key
   private String range;
   @Key
   private String responseValueRenderOption;
   @Key
   private String valueInputOption;
   @Key
   private String responseDateTimeRenderOption;
   @Key
   private Boolean includeValuesInResponse;
   // $FF: synthetic field
   final Sheets$Spreadsheets$Values this$2;

   protected Sheets$Spreadsheets$Values$Update(Sheets$Spreadsheets$Values var1, String var2, String var3, ValueRange var4) {
      super(var1.this$1.this$0, "PUT", "v4/spreadsheets/{spreadsheetId}/values/{range}", var4, UpdateValuesResponse.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
      this.range = (String)Preconditions.checkNotNull(var3, "Required parameter range must be specified.");
   }

   public Sheets$Spreadsheets$Values$Update set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Values$Update setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Values$Update setAlt(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Values$Update setCallback(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Values$Update setFields(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Values$Update setKey(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Values$Update setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Values$Update setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Values$Update setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Values$Update setUploadType(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Values$Update setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Values$Update)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$Values$Update setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public String getRange() {
      return this.range;
   }

   public Sheets$Spreadsheets$Values$Update setRange(String var1) {
      this.range = var1;
      return this;
   }

   public String getResponseValueRenderOption() {
      return this.responseValueRenderOption;
   }

   public Sheets$Spreadsheets$Values$Update setResponseValueRenderOption(String var1) {
      this.responseValueRenderOption = var1;
      return this;
   }

   public String getValueInputOption() {
      return this.valueInputOption;
   }

   public Sheets$Spreadsheets$Values$Update setValueInputOption(String var1) {
      this.valueInputOption = var1;
      return this;
   }

   public String getResponseDateTimeRenderOption() {
      return this.responseDateTimeRenderOption;
   }

   public Sheets$Spreadsheets$Values$Update setResponseDateTimeRenderOption(String var1) {
      this.responseDateTimeRenderOption = var1;
      return this;
   }

   public Boolean getIncludeValuesInResponse() {
      return this.includeValuesInResponse;
   }

   public Sheets$Spreadsheets$Values$Update setIncludeValuesInResponse(Boolean var1) {
      this.includeValuesInResponse = var1;
      return this;
   }

   public Sheets$Spreadsheets$Values$Update set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Values$Update)super.set(var1, var2);
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
