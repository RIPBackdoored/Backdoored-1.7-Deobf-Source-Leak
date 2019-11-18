package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DataFilter extends GenericJson {
   @Key
   private String a1Range;
   @Key
   private DeveloperMetadataLookup developerMetadataLookup;
   @Key
   private GridRange gridRange;

   public String getA1Range() {
      return this.a1Range;
   }

   public DataFilter setA1Range(String var1) {
      this.a1Range = var1;
      return this;
   }

   public DeveloperMetadataLookup getDeveloperMetadataLookup() {
      return this.developerMetadataLookup;
   }

   public DataFilter setDeveloperMetadataLookup(DeveloperMetadataLookup var1) {
      this.developerMetadataLookup = var1;
      return this;
   }

   public GridRange getGridRange() {
      return this.gridRange;
   }

   public DataFilter setGridRange(GridRange var1) {
      this.gridRange = var1;
      return this;
   }

   public DataFilter set(String var1, Object var2) {
      return (DataFilter)super.set(var1, var2);
   }

   public DataFilter clone() {
      return (DataFilter)super.clone();
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
