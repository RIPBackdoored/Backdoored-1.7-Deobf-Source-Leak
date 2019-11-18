package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateDimensionPropertiesRequest extends GenericJson {
   @Key
   private String fields;
   @Key
   private DimensionProperties properties;
   @Key
   private DimensionRange range;

   public String getFields() {
      return this.fields;
   }

   public UpdateDimensionPropertiesRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public DimensionProperties getProperties() {
      return this.properties;
   }

   public UpdateDimensionPropertiesRequest setProperties(DimensionProperties var1) {
      this.properties = var1;
      return this;
   }

   public DimensionRange getRange() {
      return this.range;
   }

   public UpdateDimensionPropertiesRequest setRange(DimensionRange var1) {
      this.range = var1;
      return this;
   }

   public UpdateDimensionPropertiesRequest set(String var1, Object var2) {
      return (UpdateDimensionPropertiesRequest)super.set(var1, var2);
   }

   public UpdateDimensionPropertiesRequest clone() {
      return (UpdateDimensionPropertiesRequest)super.clone();
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
