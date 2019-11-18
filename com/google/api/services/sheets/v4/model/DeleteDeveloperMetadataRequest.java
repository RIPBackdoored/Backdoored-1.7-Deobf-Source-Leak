package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteDeveloperMetadataRequest extends GenericJson {
   @Key
   private DataFilter dataFilter;

   public DataFilter getDataFilter() {
      return this.dataFilter;
   }

   public DeleteDeveloperMetadataRequest setDataFilter(DataFilter var1) {
      this.dataFilter = var1;
      return this;
   }

   public DeleteDeveloperMetadataRequest set(String var1, Object var2) {
      return (DeleteDeveloperMetadataRequest)super.set(var1, var2);
   }

   public DeleteDeveloperMetadataRequest clone() {
      return (DeleteDeveloperMetadataRequest)super.clone();
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
