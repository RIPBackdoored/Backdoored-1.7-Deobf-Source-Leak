package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class GradientRule extends GenericJson {
   @Key
   private InterpolationPoint maxpoint;
   @Key
   private InterpolationPoint midpoint;
   @Key
   private InterpolationPoint minpoint;

   public InterpolationPoint getMaxpoint() {
      return this.maxpoint;
   }

   public GradientRule setMaxpoint(InterpolationPoint var1) {
      this.maxpoint = var1;
      return this;
   }

   public InterpolationPoint getMidpoint() {
      return this.midpoint;
   }

   public GradientRule setMidpoint(InterpolationPoint var1) {
      this.midpoint = var1;
      return this;
   }

   public InterpolationPoint getMinpoint() {
      return this.minpoint;
   }

   public GradientRule setMinpoint(InterpolationPoint var1) {
      this.minpoint = var1;
      return this;
   }

   public GradientRule set(String var1, Object var2) {
      return (GradientRule)super.set(var1, var2);
   }

   public GradientRule clone() {
      return (GradientRule)super.clone();
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
