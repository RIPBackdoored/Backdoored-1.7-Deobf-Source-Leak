package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateEmbeddedObjectPositionResponse extends GenericJson {
   @Key
   private EmbeddedObjectPosition position;

   public EmbeddedObjectPosition getPosition() {
      return this.position;
   }

   public UpdateEmbeddedObjectPositionResponse setPosition(EmbeddedObjectPosition var1) {
      this.position = var1;
      return this;
   }

   public UpdateEmbeddedObjectPositionResponse set(String var1, Object var2) {
      return (UpdateEmbeddedObjectPositionResponse)super.set(var1, var2);
   }

   public UpdateEmbeddedObjectPositionResponse clone() {
      return (UpdateEmbeddedObjectPositionResponse)super.clone();
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
