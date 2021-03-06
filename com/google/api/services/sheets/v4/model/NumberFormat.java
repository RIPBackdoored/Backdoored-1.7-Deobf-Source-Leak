package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class NumberFormat extends GenericJson {
   @Key
   private String pattern;
   @Key
   private String type;

   public String getPattern() {
      return this.pattern;
   }

   public NumberFormat setPattern(String var1) {
      this.pattern = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public NumberFormat setType(String var1) {
      this.type = var1;
      return this;
   }

   public NumberFormat set(String var1, Object var2) {
      return (NumberFormat)super.set(var1, var2);
   }

   public NumberFormat clone() {
      return (NumberFormat)super.clone();
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
