package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AutoResizeDimensionsRequest extends GenericJson {
   @Key
   private DimensionRange dimensions;

   public DimensionRange getDimensions() {
      return this.dimensions;
   }

   public AutoResizeDimensionsRequest setDimensions(DimensionRange var1) {
      this.dimensions = var1;
      return this;
   }

   public AutoResizeDimensionsRequest set(String var1, Object var2) {
      return (AutoResizeDimensionsRequest)super.set(var1, var2);
   }

   public AutoResizeDimensionsRequest clone() {
      return (AutoResizeDimensionsRequest)super.clone();
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
