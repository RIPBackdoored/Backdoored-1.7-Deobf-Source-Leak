package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateBordersRequest extends GenericJson {
   @Key
   private Border bottom;
   @Key
   private Border innerHorizontal;
   @Key
   private Border innerVertical;
   @Key
   private Border left;
   @Key
   private GridRange range;
   @Key
   private Border right;
   @Key
   private Border top;

   public Border getBottom() {
      return this.bottom;
   }

   public UpdateBordersRequest setBottom(Border var1) {
      this.bottom = var1;
      return this;
   }

   public Border getInnerHorizontal() {
      return this.innerHorizontal;
   }

   public UpdateBordersRequest setInnerHorizontal(Border var1) {
      this.innerHorizontal = var1;
      return this;
   }

   public Border getInnerVertical() {
      return this.innerVertical;
   }

   public UpdateBordersRequest setInnerVertical(Border var1) {
      this.innerVertical = var1;
      return this;
   }

   public Border getLeft() {
      return this.left;
   }

   public UpdateBordersRequest setLeft(Border var1) {
      this.left = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public UpdateBordersRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public Border getRight() {
      return this.right;
   }

   public UpdateBordersRequest setRight(Border var1) {
      this.right = var1;
      return this;
   }

   public Border getTop() {
      return this.top;
   }

   public UpdateBordersRequest setTop(Border var1) {
      this.top = var1;
      return this;
   }

   public UpdateBordersRequest set(String var1, Object var2) {
      return (UpdateBordersRequest)super.set(var1, var2);
   }

   public UpdateBordersRequest clone() {
      return (UpdateBordersRequest)super.clone();
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
