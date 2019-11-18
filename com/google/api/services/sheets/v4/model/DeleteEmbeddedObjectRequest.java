package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteEmbeddedObjectRequest extends GenericJson {
   @Key
   private Integer objectId;

   public Integer getObjectId() {
      return this.objectId;
   }

   public DeleteEmbeddedObjectRequest setObjectId(Integer var1) {
      this.objectId = var1;
      return this;
   }

   public DeleteEmbeddedObjectRequest set(String var1, Object var2) {
      return (DeleteEmbeddedObjectRequest)super.set(var1, var2);
   }

   public DeleteEmbeddedObjectRequest clone() {
      return (DeleteEmbeddedObjectRequest)super.clone();
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
