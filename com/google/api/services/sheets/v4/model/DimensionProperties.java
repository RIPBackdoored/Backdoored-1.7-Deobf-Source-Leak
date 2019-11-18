package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class DimensionProperties extends GenericJson {
   @Key
   private List developerMetadata;
   @Key
   private Boolean hiddenByFilter;
   @Key
   private Boolean hiddenByUser;
   @Key
   private Integer pixelSize;

   public List getDeveloperMetadata() {
      return this.developerMetadata;
   }

   public DimensionProperties setDeveloperMetadata(List var1) {
      this.developerMetadata = var1;
      return this;
   }

   public Boolean getHiddenByFilter() {
      return this.hiddenByFilter;
   }

   public DimensionProperties setHiddenByFilter(Boolean var1) {
      this.hiddenByFilter = var1;
      return this;
   }

   public Boolean getHiddenByUser() {
      return this.hiddenByUser;
   }

   public DimensionProperties setHiddenByUser(Boolean var1) {
      this.hiddenByUser = var1;
      return this;
   }

   public Integer getPixelSize() {
      return this.pixelSize;
   }

   public DimensionProperties setPixelSize(Integer var1) {
      this.pixelSize = var1;
      return this;
   }

   public DimensionProperties set(String var1, Object var2) {
      return (DimensionProperties)super.set(var1, var2);
   }

   public DimensionProperties clone() {
      return (DimensionProperties)super.clone();
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
      Data.nullOf(DeveloperMetadata.class);
   }
}
