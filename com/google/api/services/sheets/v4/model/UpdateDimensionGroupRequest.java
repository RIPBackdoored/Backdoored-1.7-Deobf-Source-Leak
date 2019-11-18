package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateDimensionGroupRequest extends GenericJson {
   @Key
   private DimensionGroup dimensionGroup;
   @Key
   private String fields;

   public DimensionGroup getDimensionGroup() {
      return this.dimensionGroup;
   }

   public UpdateDimensionGroupRequest setDimensionGroup(DimensionGroup var1) {
      this.dimensionGroup = var1;
      return this;
   }

   public String getFields() {
      return this.fields;
   }

   public UpdateDimensionGroupRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public UpdateDimensionGroupRequest set(String var1, Object var2) {
      return (UpdateDimensionGroupRequest)super.set(var1, var2);
   }

   public UpdateDimensionGroupRequest clone() {
      return (UpdateDimensionGroupRequest)super.clone();
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
