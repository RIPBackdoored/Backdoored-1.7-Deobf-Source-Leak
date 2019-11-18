package com.google.api.services.sheets.v4;

import com.google.api.services.sheets.v4.model.BatchClearValuesByDataFilterRequest;
import com.google.api.services.sheets.v4.model.BatchClearValuesRequest;
import com.google.api.services.sheets.v4.model.BatchGetValuesByDataFilterRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesByDataFilterRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.ClearValuesRequest;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;

public class Sheets$Spreadsheets$Values {
   // $FF: synthetic field
   final Sheets$Spreadsheets this$1;

   public Sheets$Spreadsheets$Values(Sheets$Spreadsheets var1) {
      this.this$1 = var1;
   }

   public Sheets$Spreadsheets$Values$Append append(String var1, String var2, ValueRange var3) throws IOException {
      Sheets$Spreadsheets$Values$Append var4 = new Sheets$Spreadsheets$Values$Append(this, var1, var2, var3);
      this.this$1.this$0.initialize(var4);
      return var4;
   }

   public Sheets$Spreadsheets$Values$BatchClear batchClear(String var1, BatchClearValuesRequest var2) throws IOException {
      Sheets$Spreadsheets$Values$BatchClear var3 = new Sheets$Spreadsheets$Values$BatchClear(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$Values$BatchClearByDataFilter batchClearByDataFilter(String var1, BatchClearValuesByDataFilterRequest var2) throws IOException {
      Sheets$Spreadsheets$Values$BatchClearByDataFilter var3 = new Sheets$Spreadsheets$Values$BatchClearByDataFilter(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$Values$BatchGet batchGet(String var1) throws IOException {
      Sheets$Spreadsheets$Values$BatchGet var2 = new Sheets$Spreadsheets$Values$BatchGet(this, var1);
      this.this$1.this$0.initialize(var2);
      return var2;
   }

   public Sheets$Spreadsheets$Values$BatchGetByDataFilter batchGetByDataFilter(String var1, BatchGetValuesByDataFilterRequest var2) throws IOException {
      Sheets$Spreadsheets$Values$BatchGetByDataFilter var3 = new Sheets$Spreadsheets$Values$BatchGetByDataFilter(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$Values$BatchUpdate batchUpdate(String var1, BatchUpdateValuesRequest var2) throws IOException {
      Sheets$Spreadsheets$Values$BatchUpdate var3 = new Sheets$Spreadsheets$Values$BatchUpdate(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$Values$BatchUpdateByDataFilter batchUpdateByDataFilter(String var1, BatchUpdateValuesByDataFilterRequest var2) throws IOException {
      Sheets$Spreadsheets$Values$BatchUpdateByDataFilter var3 = new Sheets$Spreadsheets$Values$BatchUpdateByDataFilter(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$Values$Clear clear(String var1, String var2, ClearValuesRequest var3) throws IOException {
      Sheets$Spreadsheets$Values$Clear var4 = new Sheets$Spreadsheets$Values$Clear(this, var1, var2, var3);
      this.this$1.this$0.initialize(var4);
      return var4;
   }

   public Sheets$Spreadsheets$Values$Get get(String var1, String var2) throws IOException {
      Sheets$Spreadsheets$Values$Get var3 = new Sheets$Spreadsheets$Values$Get(this, var1, var2);
      this.this$1.this$0.initialize(var3);
      return var3;
   }

   public Sheets$Spreadsheets$Values$Update update(String var1, String var2, ValueRange var3) throws IOException {
      Sheets$Spreadsheets$Values$Update var4 = new Sheets$Spreadsheets$Values$Update(this, var1, var2, var3);
      this.this$1.this$0.initialize(var4);
      return var4;
   }
}
