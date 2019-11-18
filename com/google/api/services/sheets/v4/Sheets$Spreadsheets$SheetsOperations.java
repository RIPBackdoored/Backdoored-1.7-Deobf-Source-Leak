package com.google.api.services.sheets.v4;

import com.google.api.services.sheets.v4.model.CopySheetToAnotherSpreadsheetRequest;
import java.io.IOException;

public class Sheets$Spreadsheets$SheetsOperations {
   // $FF: synthetic field
   final Sheets$Spreadsheets this$1;

   public Sheets$Spreadsheets$SheetsOperations(Sheets$Spreadsheets var1) {
      this.this$1 = var1;
   }

   public Sheets$Spreadsheets$SheetsOperations$CopyTo copyTo(String var1, Integer var2, CopySheetToAnotherSpreadsheetRequest var3) throws IOException {
      Sheets$Spreadsheets$SheetsOperations$CopyTo var4 = new Sheets$Spreadsheets$SheetsOperations$CopyTo(this, var1, var2, var3);
      this.this$1.this$0.initialize(var4);
      return var4;
   }
}
