package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateSpreadsheetPropertiesRequest extends GenericJson {
   @Key
   private String fields;
   @Key
   private SpreadsheetProperties properties;

   public String getFields() {
      return this.fields;
   }

   public UpdateSpreadsheetPropertiesRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public SpreadsheetProperties getProperties() {
      return this.properties;
   }

   public UpdateSpreadsheetPropertiesRequest setProperties(SpreadsheetProperties var1) {
      this.properties = var1;
      return this;
   }

   public UpdateSpreadsheetPropertiesRequest set(String var1, Object var2) {
      return (UpdateSpreadsheetPropertiesRequest)super.set(var1, var2);
   }

   public UpdateSpreadsheetPropertiesRequest clone() {
      return (UpdateSpreadsheetPropertiesRequest)super.clone();
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
