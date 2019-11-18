package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class PivotGroupSortValueBucket extends GenericJson {
   @Key
   private List buckets;
   @Key
   private Integer valuesIndex;

   public List getBuckets() {
      return this.buckets;
   }

   public PivotGroupSortValueBucket setBuckets(List var1) {
      this.buckets = var1;
      return this;
   }

   public Integer getValuesIndex() {
      return this.valuesIndex;
   }

   public PivotGroupSortValueBucket setValuesIndex(Integer var1) {
      this.valuesIndex = var1;
      return this;
   }

   public PivotGroupSortValueBucket set(String var1, Object var2) {
      return (PivotGroupSortValueBucket)super.set(var1, var2);
   }

   public PivotGroupSortValueBucket clone() {
      return (PivotGroupSortValueBucket)super.clone();
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
