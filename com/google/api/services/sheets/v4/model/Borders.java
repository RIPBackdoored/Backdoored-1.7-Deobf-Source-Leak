package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class Borders extends GenericJson {
   @Key
   private Border bottom;
   @Key
   private Border left;
   @Key
   private Border right;
   @Key
   private Border top;

   public Border getBottom() {
      return this.bottom;
   }

   public Borders setBottom(Border var1) {
      this.bottom = var1;
      return this;
   }

   public Border getLeft() {
      return this.left;
   }

   public Borders setLeft(Border var1) {
      this.left = var1;
      return this;
   }

   public Border getRight() {
      return this.right;
   }

   public Borders setRight(Border var1) {
      this.right = var1;
      return this;
   }

   public Border getTop() {
      return this.top;
   }

   public Borders setTop(Border var1) {
      this.top = var1;
      return this;
   }

   public Borders set(String var1, Object var2) {
      return (Borders)super.set(var1, var2);
   }

   public Borders clone() {
      return (Borders)super.clone();
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
