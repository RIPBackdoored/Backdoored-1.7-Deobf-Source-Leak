package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class AddDimensionGroupResponse extends GenericJson {
   @Key
   private List dimensionGroups;

   public List getDimensionGroups() {
      return this.dimensionGroups;
   }

   public AddDimensionGroupResponse setDimensionGroups(List var1) {
      this.dimensionGroups = var1;
      return this;
   }

   public AddDimensionGroupResponse set(String var1, Object var2) {
      return (AddDimensionGroupResponse)super.set(var1, var2);
   }

   public AddDimensionGroupResponse clone() {
      return (AddDimensionGroupResponse)super.clone();
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

   static {
      Data.nullOf(DimensionGroup.class);
   }
}
