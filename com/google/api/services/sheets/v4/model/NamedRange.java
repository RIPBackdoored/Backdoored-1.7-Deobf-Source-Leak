package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class NamedRange extends GenericJson {
   @Key
   private String name;
   @Key
   private String namedRangeId;
   @Key
   private GridRange range;

   public String getName() {
      return this.name;
   }

   public NamedRange setName(String var1) {
      this.name = var1;
      return this;
   }

   public String getNamedRangeId() {
      return this.namedRangeId;
   }

   public NamedRange setNamedRangeId(String var1) {
      this.namedRangeId = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public NamedRange setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public NamedRange set(String var1, Object var2) {
      return (NamedRange)super.set(var1, var2);
   }

   public NamedRange clone() {
      return (NamedRange)super.clone();
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
