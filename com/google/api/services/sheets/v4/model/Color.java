package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class Color extends GenericJson {
   @Key
   private Float alpha;
   @Key
   private Float blue;
   @Key
   private Float green;
   @Key
   private Float red;

   public Float getAlpha() {
      return this.alpha;
   }

   public Color setAlpha(Float var1) {
      this.alpha = var1;
      return this;
   }

   public Float getBlue() {
      return this.blue;
   }

   public Color setBlue(Float var1) {
      this.blue = var1;
      return this;
   }

   public Float getGreen() {
      return this.green;
   }

   public Color setGreen(Float var1) {
      this.green = var1;
      return this;
   }

   public Float getRed() {
      return this.red;
   }

   public Color setRed(Float var1) {
      this.red = var1;
      return this;
   }

   public Color set(String var1, Object var2) {
      return (Color)super.set(var1, var2);
   }

   public Color clone() {
      return (Color)super.clone();
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
