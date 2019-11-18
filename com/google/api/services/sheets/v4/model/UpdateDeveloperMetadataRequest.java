package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class UpdateDeveloperMetadataRequest extends GenericJson {
   @Key
   private List dataFilters;
   @Key
   private DeveloperMetadata developerMetadata;
   @Key
   private String fields;

   public List getDataFilters() {
      return this.dataFilters;
   }

   public UpdateDeveloperMetadataRequest setDataFilters(List var1) {
      this.dataFilters = var1;
      return this;
   }

   public DeveloperMetadata getDeveloperMetadata() {
      return this.developerMetadata;
   }

   public UpdateDeveloperMetadataRequest setDeveloperMetadata(DeveloperMetadata var1) {
      this.developerMetadata = var1;
      return this;
   }

   public String getFields() {
      return this.fields;
   }

   public UpdateDeveloperMetadataRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public UpdateDeveloperMetadataRequest set(String var1, Object var2) {
      return (UpdateDeveloperMetadataRequest)super.set(var1, var2);
   }

   public UpdateDeveloperMetadataRequest clone() {
      return (UpdateDeveloperMetadataRequest)super.clone();
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
