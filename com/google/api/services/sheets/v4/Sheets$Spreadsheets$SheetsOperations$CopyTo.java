package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.CopySheetToAnotherSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.SheetProperties;

public class Sheets$Spreadsheets$SheetsOperations$CopyTo extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/sheets/{sheetId}:copyTo";
   @Key
   private String spreadsheetId;
   @Key
   private Integer sheetId;
   // $FF: synthetic field
   final Sheets$Spreadsheets$SheetsOperations this$2;

   protected Sheets$Spreadsheets$SheetsOperations$CopyTo(Sheets$Spreadsheets$SheetsOperations var1, String var2, Integer var3, CopySheetToAnotherSpreadsheetRequest var4) {
      super(var1.this$1.this$0, "POST", "v4/spreadsheets/{spreadsheetId}/sheets/{sheetId}:copyTo", var4, SheetProperties.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
      this.sheetId = (Integer)Preconditions.checkNotNull(var3, "Required parameter sheetId must be specified.");
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setAccessToken(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setAlt(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setCallback(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setFields(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setFields(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setKey(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setKey(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setOauthToken(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setUploadType(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo set(String var1, Object var2) {
      return (Sheets$Spreadsheets$SheetsOperations$CopyTo)super.set(var1, var2);
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
