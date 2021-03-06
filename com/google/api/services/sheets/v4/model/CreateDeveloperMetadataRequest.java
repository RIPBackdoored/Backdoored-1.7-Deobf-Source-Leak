package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class CreateDeveloperMetadataRequest extends GenericJson {
   @Key
   private DeveloperMetadata developerMetadata;

   public DeveloperMetadata getDeveloperMetadata() {
      return this.developerMetadata;
   }

   public CreateDeveloperMetadataRequest setDeveloperMetadata(DeveloperMetadata var1) {
      this.developerMetadata = var1;
      return this;
   }

   public CreateDeveloperMetadataRequest set(String var1, Object var2) {
      return (CreateDeveloperMetadataRequest)super.set(var1, var2);
   }

   public CreateDeveloperMetadataRequest clone() {
      return (CreateDeveloperMetadataRequest)super.clone();
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
