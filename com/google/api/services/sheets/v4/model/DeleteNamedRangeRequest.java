package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteNamedRangeRequest extends GenericJson {
   @Key
   private String namedRangeId;

   public String getNamedRangeId() {
      return this.namedRangeId;
   }

   public DeleteNamedRangeRequest setNamedRangeId(String var1) {
      this.namedRangeId = var1;
      return this;
   }

   public DeleteNamedRangeRequest set(String var1, Object var2) {
      return (DeleteNamedRangeRequest)super.set(var1, var2);
   }

   public DeleteNamedRangeRequest clone() {
      return (DeleteNamedRangeRequest)super.clone();
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
