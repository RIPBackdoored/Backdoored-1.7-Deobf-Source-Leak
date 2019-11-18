package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class MoveDimensionRequest extends GenericJson {
   @Key
   private Integer destinationIndex;
   @Key
   private DimensionRange source;

   public Integer getDestinationIndex() {
      return this.destinationIndex;
   }

   public MoveDimensionRequest setDestinationIndex(Integer var1) {
      this.destinationIndex = var1;
      return this;
   }

   public DimensionRange getSource() {
      return this.source;
   }

   public MoveDimensionRequest setSource(DimensionRange var1) {
      this.source = var1;
      return this;
   }

   public MoveDimensionRequest set(String var1, Object var2) {
      return (MoveDimensionRequest)super.set(var1, var2);
   }

   public MoveDimensionRequest clone() {
      return (MoveDimensionRequest)super.clone();
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
