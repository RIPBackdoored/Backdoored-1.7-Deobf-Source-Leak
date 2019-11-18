package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class CellData extends GenericJson {
   @Key
   private DataValidationRule dataValidation;
   @Key
   private CellFormat effectiveFormat;
   @Key
   private ExtendedValue effectiveValue;
   @Key
   private String formattedValue;
   @Key
   private String hyperlink;
   @Key
   private String note;
   @Key
   private PivotTable pivotTable;
   @Key
   private List textFormatRuns;
   @Key
   private CellFormat userEnteredFormat;
   @Key
   private ExtendedValue userEnteredValue;

   public DataValidationRule getDataValidation() {
      return this.dataValidation;
   }

   public CellData setDataValidation(DataValidationRule var1) {
      this.dataValidation = var1;
      return this;
   }

   public CellFormat getEffectiveFormat() {
      return this.effectiveFormat;
   }

   public CellData setEffectiveFormat(CellFormat var1) {
      this.effectiveFormat = var1;
      return this;
   }

   public ExtendedValue getEffectiveValue() {
      return this.effectiveValue;
   }

   public CellData setEffectiveValue(ExtendedValue var1) {
      this.effectiveValue = var1;
      return this;
   }

   public String getFormattedValue() {
      return this.formattedValue;
   }

   public CellData setFormattedValue(String var1) {
      this.formattedValue = var1;
      return this;
   }

   public String getHyperlink() {
      return this.hyperlink;
   }

   public CellData setHyperlink(String var1) {
      this.hyperlink = var1;
      return this;
   }

   public String getNote() {
      return this.note;
   }

   public CellData setNote(String var1) {
      this.note = var1;
      return this;
   }

   public PivotTable getPivotTable() {
      return this.pivotTable;
   }

   public CellData setPivotTable(PivotTable var1) {
      this.pivotTable = var1;
      return this;
   }

   public List getTextFormatRuns() {
      return this.textFormatRuns;
   }

   public CellData setTextFormatRuns(List var1) {
      this.textFormatRuns = var1;
      return this;
   }

   public CellFormat getUserEnteredFormat() {
      return this.userEnteredFormat;
   }

   public CellData setUserEnteredFormat(CellFormat var1) {
      this.userEnteredFormat = var1;
      return this;
   }

   public ExtendedValue getUserEnteredValue() {
      return this.userEnteredValue;
   }

   public CellData setUserEnteredValue(ExtendedValue var1) {
      this.userEnteredValue = var1;
      return this;
   }

   public CellData set(String var1, Object var2) {
      return (CellData)super.set(var1, var2);
   }

   public CellData clone() {
      return (CellData)super.clone();
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

   static {
      Data.nullOf(TextFormatRun.class);
   }
}
