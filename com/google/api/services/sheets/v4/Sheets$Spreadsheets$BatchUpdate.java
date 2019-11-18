package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetResponse;

public class Sheets$Spreadsheets$BatchUpdate extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}:batchUpdate";
   @Key
   private String spreadsheetId;
   // $FF: synthetic field
   final Sheets$Spreadsheets this$1;

   protected Sheets$Spreadsheets$BatchUpdate(Sheets$Spreadsheets var1, String var2, BatchUpdateSpreadsheetRequest var3) {
      super(var1.this$0, "POST", "v4/spreadsheets/{spreadsheetId}:batchUpdate", var3, BatchUpdateSpreadsheetResponse.class);
      this.this$1 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
   }

   public Sheets$Spreadsheets$BatchUpdate set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setAccessToken(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setAlt(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setCallback(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setFields(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setFields(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setKey(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setKey(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setOauthToken(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setUploadType(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$BatchUpdate setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$BatchUpdate)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$BatchUpdate setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Sheets$Spreadsheets$BatchUpdate set(String var1, Object var2) {
      return (Sheets$Spreadsheets$BatchUpdate)super.set(var1, var2);
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
