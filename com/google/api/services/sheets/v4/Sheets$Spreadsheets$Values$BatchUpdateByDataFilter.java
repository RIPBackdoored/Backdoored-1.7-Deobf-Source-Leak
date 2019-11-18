package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesByDataFilterRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesByDataFilterResponse;

public class Sheets$Spreadsheets$Values$BatchUpdateByDataFilter extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/values:batchUpdateByDataFilter";
   @Key
   private String spreadsheetId;
   // $FF: synthetic field
   final Sheets$Spreadsheets$Values this$2;

   protected Sheets$Spreadsheets$Values$BatchUpdateByDataFilter(Sheets$Spreadsheets$Values var1, String var2, BatchUpdateValuesByDataFilterRequest var3) {
      super(var1.this$1.this$0, "POST", "v4/spreadsheets/{spreadsheetId}/values:batchUpdateByDataFilter", var3, BatchUpdateValuesByDataFilterResponse.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setAlt(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setCallback(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setFields(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setKey(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setUploadType(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Values$BatchUpdateByDataFilter)super.set(var1, var2);
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
