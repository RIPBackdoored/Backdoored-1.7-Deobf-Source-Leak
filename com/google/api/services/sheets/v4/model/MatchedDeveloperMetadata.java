package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class MatchedDeveloperMetadata extends GenericJson {
   @Key
   private List dataFilters;
   @Key
   private DeveloperMetadata developerMetadata;

   public List getDataFilters() {
      return this.dataFilters;
   }

   public MatchedDeveloperMetadata setDataFilters(List var1) {
      this.dataFilters = var1;
      return this;
   }

   public DeveloperMetadata getDeveloperMetadata() {
      return this.developerMetadata;
   }

   public MatchedDeveloperMetadata setDeveloperMetadata(DeveloperMetadata var1) {
      this.developerMetadata = var1;
      return this;
   }

   public MatchedDeveloperMetadata set(String var1, Object var2) {
      return (MatchedDeveloperMetadata)super.set(var1, var2);
   }

   public MatchedDeveloperMetadata clone() {
      return (MatchedDeveloperMetadata)super.clone();
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
