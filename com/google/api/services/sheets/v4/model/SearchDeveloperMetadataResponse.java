package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class SearchDeveloperMetadataResponse extends GenericJson {
   @Key
   private List matchedDeveloperMetadata;

   public List getMatchedDeveloperMetadata() {
      return this.matchedDeveloperMetadata;
   }

   public SearchDeveloperMetadataResponse setMatchedDeveloperMetadata(List var1) {
      this.matchedDeveloperMetadata = var1;
      return this;
   }

   public SearchDeveloperMetadataResponse set(String var1, Object var2) {
      return (SearchDeveloperMetadataResponse)super.set(var1, var2);
   }

   public SearchDeveloperMetadataResponse clone() {
      return (SearchDeveloperMetadataResponse)super.clone();
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
      Data.nullOf(MatchedDeveloperMetadata.class);
   }
}
