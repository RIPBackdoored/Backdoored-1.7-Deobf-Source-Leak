package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class TextFormatRun extends GenericJson {
   @Key
   private TextFormat format;
   @Key
   private Integer startIndex;

   public TextFormat getFormat() {
      return this.format;
   }

   public TextFormatRun setFormat(TextFormat var1) {
      this.format = var1;
      return this;
   }

   public Integer getStartIndex() {
      return this.startIndex;
   }

   public TextFormatRun setStartIndex(Integer var1) {
      this.startIndex = var1;
      return this;
   }

   public TextFormatRun set(String var1, Object var2) {
      return (TextFormatRun)super.set(var1, var2);
   }

   public TextFormatRun clone() {
      return (TextFormatRun)super.clone();
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
