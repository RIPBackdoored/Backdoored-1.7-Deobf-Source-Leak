package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AddNamedRangeRequest extends GenericJson {
   @Key
   private NamedRange namedRange;

   public NamedRange getNamedRange() {
      return this.namedRange;
   }

   public AddNamedRangeRequest setNamedRange(NamedRange var1) {
      this.namedRange = var1;
      return this;
   }

   public AddNamedRangeRequest set(String var1, Object var2) {
      return (AddNamedRangeRequest)super.set(var1, var2);
   }

   public AddNamedRangeRequest clone() {
      return (AddNamedRangeRequest)super.clone();
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
