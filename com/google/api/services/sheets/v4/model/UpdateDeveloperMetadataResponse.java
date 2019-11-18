package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class UpdateDeveloperMetadataResponse extends GenericJson {
   @Key
   private List developerMetadata;

   public List getDeveloperMetadata() {
      return this.developerMetadata;
   }

   public UpdateDeveloperMetadataResponse setDeveloperMetadata(List var1) {
      this.developerMetadata = var1;
      return this;
   }

   public UpdateDeveloperMetadataResponse set(String var1, Object var2) {
      return (UpdateDeveloperMetadataResponse)super.set(var1, var2);
   }

   public UpdateDeveloperMetadataResponse clone() {
      return (UpdateDeveloperMetadataResponse)super.clone();
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
