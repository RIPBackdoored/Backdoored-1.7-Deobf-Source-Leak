package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.services.sheets.v4.model.Spreadsheet;

public class Sheets$Spreadsheets$Create extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets";
   // $FF: synthetic field
   final Sheets$Spreadsheets this$1;

   protected Sheets$Spreadsheets$Create(Sheets$Spreadsheets var1, Spreadsheet var2) {
      super(var1.this$0, "POST", "v4/spreadsheets", var2, Spreadsheet.class);
      this.this$1 = var1;
   }

   public Sheets$Spreadsheets$Create set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Create)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Create setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Create)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Create setAlt(String var1) {
      return (Sheets$Spreadsheets$Create)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Create setCallback(String var1) {
      return (Sheets$Spreadsheets$Create)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Create setFields(String var1) {
      return (Sheets$Spreadsheets$Create)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Create setKey(String var1) {
      return (Sheets$Spreadsheets$Create)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Create setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Create)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Create setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Create)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Create setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Create)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Create setUploadType(String var1) {
      return (Sheets$Spreadsheets$Create)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Create setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Create)super.setUploadProtocol(var1);
   }

   public Sheets$Spreadsheets$Create set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Create)super.set(var1, var2);
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
