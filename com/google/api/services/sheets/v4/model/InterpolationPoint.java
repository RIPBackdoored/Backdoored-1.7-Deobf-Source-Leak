package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class InterpolationPoint extends GenericJson {
   @Key
   private Color color;
   @Key
   private String type;
   @Key
   private String value;

   public Color getColor() {
      return this.color;
   }

   public InterpolationPoint setColor(Color var1) {
      this.color = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public InterpolationPoint setType(String var1) {
      this.type = var1;
      return this;
   }

   public String getValue() {
      return this.value;
   }

   public InterpolationPoint setValue(String var1) {
      this.value = var1;
      return this;
   }

   public InterpolationPoint set(String var1, Object var2) {
      return (InterpolationPoint)super.set(var1, var2);
   }

   public InterpolationPoint clone() {
      return (InterpolationPoint)super.clone();
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
