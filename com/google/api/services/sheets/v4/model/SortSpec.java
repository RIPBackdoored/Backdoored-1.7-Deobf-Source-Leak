package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class SortSpec extends GenericJson {
   @Key
   private Integer dimensionIndex;
   @Key
   private String sortOrder;

   public Integer getDimensionIndex() {
      return this.dimensionIndex;
   }

   public SortSpec setDimensionIndex(Integer var1) {
      this.dimensionIndex = var1;
      return this;
   }

   public String getSortOrder() {
      return this.sortOrder;
   }

   public SortSpec setSortOrder(String var1) {
      this.sortOrder = var1;
      return this;
   }

   public SortSpec set(String var1, Object var2) {
      return (SortSpec)super.set(var1, var2);
   }

   public SortSpec clone() {
      return (SortSpec)super.clone();
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
