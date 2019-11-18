package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class TextPosition extends GenericJson {
   @Key
   private String horizontalAlignment;

   public String getHorizontalAlignment() {
      return this.horizontalAlignment;
   }

   public TextPosition setHorizontalAlignment(String var1) {
      this.horizontalAlignment = var1;
      return this;
   }

   public TextPosition set(String var1, Object var2) {
      return (TextPosition)super.set(var1, var2);
   }

   public TextPosition clone() {
      return (TextPosition)super.clone();
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
