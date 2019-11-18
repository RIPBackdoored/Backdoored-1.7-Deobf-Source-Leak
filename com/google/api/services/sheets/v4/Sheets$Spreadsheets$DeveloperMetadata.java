package com.google.api.services.sheets.v4;

import com.google.api.services.sheets.v4.model.SearchDeveloperMetadataRequest;
import java.io.IOException;

public class Sheets$Spreadsheets$DeveloperMetadata {
   // $FF: synthetic field
   final Sheets$Spreadsheets this$1;

   public Sheets$Spreadsheets$DeveloperMetadata(Sheets$Spreadsheets var1) {
      this.this$1 = var1;
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get get(String var1, Integer var2) throws IOException {
      Sheets$Spreadsheets$DeveloperMetadata$Get var3 = new Sheets$Spreadsheets$DeveloperMetadata$Get(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search search(String var1, SearchDeveloperMetadataRequest var2) throws IOException {
      Sheets$Spreadsheets$DeveloperMetadata$Search var3 = new Sheets$Spreadsheets$DeveloperMetadata$Search(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }
}
