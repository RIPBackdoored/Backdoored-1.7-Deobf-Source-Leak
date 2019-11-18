package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeveloperMetadata extends GenericJson {
   @Key
   private DeveloperMetadataLocation location;
   @Key
   private Integer metadataId;
   @Key
   private String metadataKey;
   @Key
   private String metadataValue;
   @Key
   private String visibility;

   public DeveloperMetadataLocation getLocation() {
      return this.location;
   }

   public DeveloperMetadata setLocation(DeveloperMetadataLocation var1) {
      this.location = var1;
      return this;
   }

   public Integer getMetadataId() {
      return this.metadataId;
   }

   public DeveloperMetadata setMetadataId(Integer var1) {
      this.metadataId = var1;
      return this;
   }

   public String getMetadataKey() {
      return this.metadataKey;
   }

   public DeveloperMetadata setMetadataKey(String var1) {
      this.metadataKey = var1;
      return this;
   }

   public String getMetadataValue() {
      return this.metadataValue;
   }

   public DeveloperMetadata setMetadataValue(String var1) {
      this.metadataValue = var1;
      return this;
   }

   public String getVisibility() {
      return this.visibility;
   }

   public DeveloperMetadata setVisibility(String var1) {
      this.visibility = var1;
      return this;
   }

   public DeveloperMetadata set(String var1, Object var2) {
      return (DeveloperMetadata)super.set(var1, var2);
   }

   public DeveloperMetadata clone() {
      return (DeveloperMetadata)super.clone();
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
