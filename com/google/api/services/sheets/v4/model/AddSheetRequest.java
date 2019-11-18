package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AddSheetRequest extends GenericJson {
   @Key
   private SheetProperties properties;

   public SheetProperties getProperties() {
      return this.properties;
   }

   public AddSheetRequest setProperties(SheetProperties var1) {
      this.properties = var1;
      return this;
   }

   public AddSheetRequest set(String var1, Object var2) {
      return (AddSheetRequest)super.set(var1, var2);
   }

   public AddSheetRequest clone() {
      return (AddSheetRequest)super.clone();
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
