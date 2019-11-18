package com.google.api.services.sheets.v4;

import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.GetSpreadsheetByDataFilterRequest;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import java.io.IOException;

public class Sheets$Spreadsheets {
   // $FF: synthetic field
   final Sheets this$0;

   public Sheets$Spreadsheets(Sheets var1) {
      this.this$0 = var1;
   }

   public Sheets$Spreadsheets$BatchUpdate batchUpdate(String var1, BatchUpdateSpreadsheetRequest var2) throws IOException {
      Sheets$Spreadsheets$BatchUpdate var3 = new Sheets$Spreadsheets$BatchUpdate(this, var1, var2);
      this.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$Create create(Spreadsheet var1) throws IOException {
      Sheets$Spreadsheets$Create var2 = new Sheets$Spreadsheets$Create(this, var1);
      this.this$0.initialize(var2);
      return var2;
   }

   public Sheets$Spreadsheets$Get get(String var1) throws IOException {
      Sheets$Spreadsheets$Get var2 = new Sheets$Spreadsheets$Get(this, var1);
      this.this$0.initialize(var2);
      return var2;
   }

   public Sheets$Spreadsheets$GetByDataFilter getByDataFilter(String var1, GetSpreadsheetByDataFilterRequest var2) throws IOException {
      Sheets$Spreadsheets$GetByDataFilter var3 = new Sheets$Spreadsheets$GetByDataFilter(this, var1, var2);
      this.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$DeveloperMetadata developerMetadata() {
      return new Sheets$Spreadsheets$DeveloperMetadata(this);
   }

   public Sheets$Spreadsheets$SheetsOperations sheets() {
      return new Sheets$Spreadsheets$SheetsOperations(this);
   }

   public Sheets$Spreadsheets$Values values() {
      return new Sheets$Spreadsheets$Values(this);
   }
}
