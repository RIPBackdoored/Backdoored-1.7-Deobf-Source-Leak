package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class SetBasicFilterRequest extends GenericJson {
   @Key
   private BasicFilter filter;

   public BasicFilter getFilter() {
      return this.filter;
   }

   public SetBasicFilterRequest setFilter(BasicFilter var1) {
      this.filter = var1;
      return this;
   }

   public SetBasicFilterRequest set(String var1, Object var2) {
      return (SetBasicFilterRequest)super.set(var1, var2);
   }

   public SetBasicFilterRequest clone() {
      return (SetBasicFilterRequest)super.clone();
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
