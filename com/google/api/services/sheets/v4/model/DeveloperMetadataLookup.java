package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeveloperMetadataLookup extends GenericJson {
   @Key
   private String locationMatchingStrategy;
   @Key
   private String locationType;
   @Key
   private Integer metadataId;
   @Key
   private String metadataKey;
   @Key
   private DeveloperMetadataLocation metadataLocation;
   @Key
   private String metadataValue;
   @Key
   private String visibility;

   public String getLocationMatchingStrategy() {
      return this.locationMatchingStrategy;
   }

   public DeveloperMetadataLookup setLocationMatchingStrategy(String var1) {
      this.locationMatchingStrategy = var1;
      return this;
   }

   public String getLocationType() {
      return this.locationType;
   }

   public DeveloperMetadataLookup setLocationType(String var1) {
      this.locationType = var1;
      return this;
   }

   public Integer getMetadataId() {
      return this.metadataId;
   }

   public DeveloperMetadataLookup setMetadataId(Integer var1) {
      this.metadataId = var1;
      return this;
   }

   public String getMetadataKey() {
      return this.metadataKey;
   }

   public DeveloperMetadataLookup setMetadataKey(String var1) {
      this.metadataKey = var1;
      return this;
   }

   public DeveloperMetadataLocation getMetadataLocation() {
      return this.metadataLocation;
   }

   public DeveloperMetadataLookup setMetadataLocation(DeveloperMetadataLocation var1) {
      this.metadataLocation = var1;
      return this;
   }

   public String getMetadataValue() {
      return this.metadataValue;
   }

   public DeveloperMetadataLookup setMetadataValue(String var1) {
      this.metadataValue = var1;
      return this;
   }

   public String getVisibility() {
      return this.visibility;
   }

   public DeveloperMetadataLookup setVisibility(String var1) {
      this.visibility = var1;
      return this;
   }

   public DeveloperMetadataLookup set(String var1, Object var2) {
      return (DeveloperMetadataLookup)super.set(var1, var2);
   }

   public DeveloperMetadataLookup clone() {
      return (DeveloperMetadataLookup)super.clone();
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
