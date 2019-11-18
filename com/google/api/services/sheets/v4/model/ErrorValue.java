package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class ErrorValue extends GenericJson {
   @Key
   private String message;
   @Key
   private String type;

   public String getMessage() {
      return this.message;
   }

   public ErrorValue setMessage(String var1) {
      this.message = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public ErrorValue setType(String var1) {
      this.type = var1;
      return this;
   }

   public ErrorValue set(String var1, Object var2) {
      return (ErrorValue)super.set(var1, var2);
   }

   public ErrorValue clone() {
      return (ErrorValue)super.clone();
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
