package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class PivotGroupValueMetadata extends GenericJson {
   @Key
   private Boolean collapsed;
   @Key
   private ExtendedValue value;

   public Boolean getCollapsed() {
      return this.collapsed;
   }

   public PivotGroupValueMetadata setCollapsed(Boolean var1) {
      this.collapsed = var1;
      return this;
   }

   public ExtendedValue getValue() {
      return this.value;
   }

   public PivotGroupValueMetadata setValue(ExtendedValue var1) {
      this.value = var1;
      return this;
   }

   public PivotGroupValueMetadata set(String var1, Object var2) {
      return (PivotGroupValueMetadata)super.set(var1, var2);
   }

   public PivotGroupValueMetadata clone() {
      return (PivotGroupValueMetadata)super.clone();
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
