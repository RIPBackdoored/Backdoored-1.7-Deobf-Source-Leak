package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DimensionGroup extends GenericJson {
   @Key
   private Boolean collapsed;
   @Key
   private Integer depth;
   @Key
   private DimensionRange range;

   public Boolean getCollapsed() {
      return this.collapsed;
   }

   public DimensionGroup setCollapsed(Boolean var1) {
      this.collapsed = var1;
      return this;
   }

   public Integer getDepth() {
      return this.depth;
   }

   public DimensionGroup setDepth(Integer var1) {
      this.depth = var1;
      return this;
   }

   public DimensionRange getRange() {
      return this.range;
   }

   public DimensionGroup setRange(DimensionRange var1) {
      this.range = var1;
      return this;
   }

   public DimensionGroup set(String var1, Object var2) {
      return (DimensionGroup)super.set(var1, var2);
   }

   public DimensionGroup clone() {
      return (DimensionGroup)super.clone();
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
