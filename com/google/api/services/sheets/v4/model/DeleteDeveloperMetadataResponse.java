package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class DeleteDeveloperMetadataResponse extends GenericJson {
   @Key
   private List deletedDeveloperMetadata;

   public List getDeletedDeveloperMetadata() {
      return this.deletedDeveloperMetadata;
   }

   public DeleteDeveloperMetadataResponse setDeletedDeveloperMetadata(List var1) {
      this.deletedDeveloperMetadata = var1;
      return this;
   }

   public DeleteDeveloperMetadataResponse set(String var1, Object var2) {
      return (DeleteDeveloperMetadataResponse)super.set(var1, var2);
   }

   public DeleteDeveloperMetadataResponse clone() {
      return (DeleteDeveloperMetadataResponse)super.clone();
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
