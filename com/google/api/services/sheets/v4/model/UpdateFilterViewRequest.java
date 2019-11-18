package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateFilterViewRequest extends GenericJson {
   @Key
   private String fields;
   @Key
   private FilterView filter;

   public String getFields() {
      return this.fields;
   }

   public UpdateFilterViewRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public FilterView getFilter() {
      return this.filter;
   }

   public UpdateFilterViewRequest setFilter(FilterView var1) {
      this.filter = var1;
      return this;
   }

   public UpdateFilterViewRequest set(String var1, Object var2) {
      return (UpdateFilterViewRequest)super.set(var1, var2);
   }

   public UpdateFilterViewRequest clone() {
      return (UpdateFilterViewRequest)super.clone();
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
