package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class Border extends GenericJson {
   @Key
   private Color color;
   @Key
   private String style;
   @Key
   private Integer width;

   public Color getColor() {
      return this.color;
   }

   public Border setColor(Color var1) {
      this.color = var1;
      return this;
   }

   public String getStyle() {
      return this.style;
   }

   public Border setStyle(String var1) {
      this.style = var1;
      return this;
   }

   public Integer getWidth() {
      return this.width;
   }

   public Border setWidth(Integer var1) {
      this.width = var1;
      return this;
   }

   public Border set(String var1, Object var2) {
      return (Border)super.set(var1, var2);
   }

   public Border clone() {
      return (Border)super.clone();
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
