package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class SpreadsheetProperties extends GenericJson {
   @Key
   private String autoRecalc;
   @Key
   private CellFormat defaultFormat;
   @Key
   private IterativeCalculationSettings iterativeCalculationSettings;
   @Key
   private String locale;
   @Key
   private String timeZone;
   @Key
   private String title;

   public String getAutoRecalc() {
      return this.autoRecalc;
   }

   public SpreadsheetProperties setAutoRecalc(String var1) {
      this.autoRecalc = var1;
      return this;
   }

   public CellFormat getDefaultFormat() {
      return this.defaultFormat;
   }

   public SpreadsheetProperties setDefaultFormat(CellFormat var1) {
      this.defaultFormat = var1;
      return this;
   }

   public IterativeCalculationSettings getIterativeCalculationSettings() {
      return this.iterativeCalculationSettings;
   }

   public SpreadsheetProperties setIterativeCalculationSettings(IterativeCalculationSettings var1) {
      this.iterativeCalculationSettings = var1;
      return this;
   }

   public String getLocale() {
      return this.locale;
   }

   public SpreadsheetProperties setLocale(String var1) {
      this.locale = var1;
      return this;
   }

   public String getTimeZone() {
      return this.timeZone;
   }

   public SpreadsheetProperties setTimeZone(String var1) {
      this.timeZone = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public SpreadsheetProperties setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public SpreadsheetProperties set(String var1, Object var2) {
      return (SpreadsheetProperties)super.set(var1, var2);
   }

   public SpreadsheetProperties clone() {
      return (SpreadsheetProperties)super.clone();
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
