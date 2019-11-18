package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateEmbeddedObjectPositionRequest extends GenericJson {
   @Key
   private String fields;
   @Key
   private EmbeddedObjectPosition newPosition;
   @Key
   private Integer objectId;

   public String getFields() {
      return this.fields;
   }

   public UpdateEmbeddedObjectPositionRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public EmbeddedObjectPosition getNewPosition() {
      return this.newPosition;
   }

   public UpdateEmbeddedObjectPositionRequest setNewPosition(EmbeddedObjectPosition var1) {
      this.newPosition = var1;
      return this;
   }

   public Integer getObjectId() {
      return this.objectId;
   }

   public UpdateEmbeddedObjectPositionRequest setObjectId(Integer var1) {
      this.objectId = var1;
      return this;
   }

   public UpdateEmbeddedObjectPositionRequest set(String var1, Object var2) {
      return (UpdateEmbeddedObjectPositionRequest)super.set(var1, var2);
   }

   public UpdateEmbeddedObjectPositionRequest clone() {
      return (UpdateEmbeddedObjectPositionRequest)super.clone();
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
