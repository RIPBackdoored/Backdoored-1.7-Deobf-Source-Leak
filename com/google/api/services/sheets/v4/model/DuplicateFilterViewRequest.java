package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DuplicateFilterViewRequest extends GenericJson {
   @Key
   private Integer filterId;

   public Integer getFilterId() {
      return this.filterId;
   }

   public DuplicateFilterViewRequest setFilterId(Integer var1) {
      this.filterId = var1;
      return this;
   }

   public DuplicateFilterViewRequest set(String var1, Object var2) {
      return (DuplicateFilterViewRequest)super.set(var1, var2);
   }

   public DuplicateFilterViewRequest clone() {
      return (DuplicateFilterViewRequest)super.clone();
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
