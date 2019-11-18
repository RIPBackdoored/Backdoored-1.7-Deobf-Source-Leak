package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class Padding extends GenericJson {
   @Key
   private Integer bottom;
   @Key
   private Integer left;
   @Key
   private Integer right;
   @Key
   private Integer top;

   public Integer getBottom() {
      return this.bottom;
   }

   public Padding setBottom(Integer var1) {
      this.bottom = var1;
      return this;
   }

   public Integer getLeft() {
      return this.left;
   }

   public Padding setLeft(Integer var1) {
      this.left = var1;
      return this;
   }

   public Integer getRight() {
      return this.right;
   }

   public Padding setRight(Integer var1) {
      this.right = var1;
      return this;
   }

   public Integer getTop() {
      return this.top;
   }

   public Padding setTop(Integer var1) {
      this.top = var1;
      return this;
   }

   public Padding set(String var1, Object var2) {
      return (Padding)super.set(var1, var2);
   }

   public Padding clone() {
      return (Padding)super.clone();
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
