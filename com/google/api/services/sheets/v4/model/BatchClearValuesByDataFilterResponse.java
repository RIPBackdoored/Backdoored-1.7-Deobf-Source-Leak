package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchClearValuesByDataFilterResponse extends GenericJson {
   @Key
   private List clearedRanges;
   @Key
   private String spreadsheetId;

   public List getClearedRanges() {
      return this.clearedRanges;
   }

   public BatchClearValuesByDataFilterResponse setClearedRanges(List var1) {
      this.clearedRanges = var1;
      return this;
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public BatchClearValuesByDataFilterResponse setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public BatchClearValuesByDataFilterResponse set(String var1, Object var2) {
      return (BatchClearValuesByDataFilterResponse)super.set(var1, var2);
   }

   public BatchClearValuesByDataFilterResponse clone() {
      return (BatchClearValuesByDataFilterResponse)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
