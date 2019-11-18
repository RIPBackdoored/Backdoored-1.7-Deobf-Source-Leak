package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class CellFormat extends GenericJson {
   @Key
   private Color backgroundColor;
   @Key
   private Borders borders;
   @Key
   private String horizontalAlignment;
   @Key
   private String hyperlinkDisplayType;
   @Key
   private NumberFormat numberFormat;
   @Key
   private Padding padding;
   @Key
   private String textDirection;
   @Key
   private TextFormat textFormat;
   @Key
   private TextRotation textRotation;
   @Key
   private String verticalAlignment;
   @Key
   private String wrapStrategy;

   public Color getBackgroundColor() {
      return this.backgroundColor;
   }

   public CellFormat setBackgroundColor(Color var1) {
      this.backgroundColor = var1;
      return this;
   }

   public Borders getBorders() {
      return this.borders;
   }

   public CellFormat setBorders(Borders var1) {
      this.borders = var1;
      return this;
   }

   public String getHorizontalAlignment() {
      return this.horizontalAlignment;
   }

   public CellFormat setHorizontalAlignment(String var1) {
      this.horizontalAlignment = var1;
      return this;
   }

   public String getHyperlinkDisplayType() {
      return this.hyperlinkDisplayType;
   }

   public CellFormat setHyperlinkDisplayType(String var1) {
      this.hyperlinkDisplayType = var1;
      return this;
   }

   public NumberFormat getNumberFormat() {
      return this.numberFormat;
   }

   public CellFormat setNumberFormat(NumberFormat var1) {
      this.numberFormat = var1;
      return this;
   }

   public Padding getPadding() {
      return this.padding;
   }

   public CellFormat setPadding(Padding var1) {
      this.padding = var1;
      return this;
   }

   public String getTextDirection() {
      return this.textDirection;
   }

   public CellFormat setTextDirection(String var1) {
      this.textDirection = var1;
      return this;
   }

   public TextFormat getTextFormat() {
      return this.textFormat;
   }

   public CellFormat setTextFormat(TextFormat var1) {
      this.textFormat = var1;
      return this;
   }

   public TextRotation getTextRotation() {
      return this.textRotation;
   }

   public CellFormat setTextRotation(TextRotation var1) {
      this.textRotation = var1;
      return this;
   }

   public String getVerticalAlignment() {
      return this.verticalAlignment;
   }

   public CellFormat setVerticalAlignment(String var1) {
      this.verticalAlignment = var1;
      return this;
   }

   public String getWrapStrategy() {
      return this.wrapStrategy;
   }

   public CellFormat setWrapStrategy(String var1) {
      this.wrapStrategy = var1;
      return this;
   }

   public CellFormat set(String var1, Object var2) {
      return (CellFormat)super.set(var1, var2);
   }

   public CellFormat clone() {
      return (CellFormat)super.clone();
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
