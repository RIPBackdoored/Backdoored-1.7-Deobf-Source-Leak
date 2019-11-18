package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class SourceAndDestination extends GenericJson {
   @Key
   private String dimension;
   @Key
   private Integer fillLength;
   @Key
   private GridRange source;

   public String getDimension() {
      return this.dimension;
   }

   public SourceAndDestination setDimension(String var1) {
      this.dimension = var1;
      return this;
   }

   public Integer getFillLength() {
      return this.fillLength;
   }

   public SourceAndDestination setFillLength(Integer var1) {
      this.fillLength = var1;
      return this;
   }

   public GridRange getSource() {
      return this.source;
   }

   public SourceAndDestination setSource(GridRange var1) {
      this.source = var1;
      return this;
   }

   public SourceAndDestination set(String var1, Object var2) {
      return (SourceAndDestination)super.set(var1, var2);
   }

   public SourceAndDestination clone() {
      return (SourceAndDestination)super.clone();
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
