package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class TextFormat extends GenericJson {
   @Key
   private Boolean bold;
   @Key
   private String fontFamily;
   @Key
   private Integer fontSize;
   @Key
   private Color foregroundColor;
   @Key
   private Boolean italic;
   @Key
   private Boolean strikethrough;
   @Key
   private Boolean underline;

   public Boolean getBold() {
      return this.bold;
   }

   public TextFormat setBold(Boolean var1) {
      this.bold = var1;
      return this;
   }

   public String getFontFamily() {
      return this.fontFamily;
   }

   public TextFormat setFontFamily(String var1) {
      this.fontFamily = var1;
      return this;
   }

   public Integer getFontSize() {
      return this.fontSize;
   }

   public TextFormat setFontSize(Integer var1) {
      this.fontSize = var1;
      return this;
   }

   public Color getForegroundColor() {
      return this.foregroundColor;
   }

   public TextFormat setForegroundColor(Color var1) {
      this.foregroundColor = var1;
      return this;
   }

   public Boolean getItalic() {
      return this.italic;
   }

   public TextFormat setItalic(Boolean var1) {
      this.italic = var1;
      return this;
   }

   public Boolean getStrikethrough() {
      return this.strikethrough;
   }

   public TextFormat setStrikethrough(Boolean var1) {
      this.strikethrough = var1;
      return this;
   }

   public Boolean getUnderline() {
      return this.underline;
   }

   public TextFormat setUnderline(Boolean var1) {
      this.underline = var1;
      return this;
   }

   public TextFormat set(String var1, Object var2) {
      return (TextFormat)super.set(var1, var2);
   }

   public TextFormat clone() {
      return (TextFormat)super.clone();
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
