package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class GridProperties extends GenericJson {
   @Key
   private Integer columnCount;
   @Key
   private Boolean columnGroupControlAfter;
   @Key
   private Integer frozenColumnCount;
   @Key
   private Integer frozenRowCount;
   @Key
   private Boolean hideGridlines;
   @Key
   private Integer rowCount;
   @Key
   private Boolean rowGroupControlAfter;

   public Integer getColumnCount() {
      return this.columnCount;
   }

   public GridProperties setColumnCount(Integer var1) {
      this.columnCount = var1;
      return this;
   }

   public Boolean getColumnGroupControlAfter() {
      return this.columnGroupControlAfter;
   }

   public GridProperties setColumnGroupControlAfter(Boolean var1) {
      this.columnGroupControlAfter = var1;
      return this;
   }

   public Integer getFrozenColumnCount() {
      return this.frozenColumnCount;
   }

   public GridProperties setFrozenColumnCount(Integer var1) {
      this.frozenColumnCount = var1;
      return this;
   }

   public Integer getFrozenRowCount() {
      return this.frozenRowCount;
   }

   public GridProperties setFrozenRowCount(Integer var1) {
      this.frozenRowCount = var1;
      return this;
   }

   public Boolean getHideGridlines() {
      return this.hideGridlines;
   }

   public GridProperties setHideGridlines(Boolean var1) {
      this.hideGridlines = var1;
      return this;
   }

   public Integer getRowCount() {
      return this.rowCount;
   }

   public GridProperties setRowCount(Integer var1) {
      this.rowCount = var1;
      return this;
   }

   public Boolean getRowGroupControlAfter() {
      return this.rowGroupControlAfter;
   }

   public GridProperties setRowGroupControlAfter(Boolean var1) {
      this.rowGroupControlAfter = var1;
      return this;
   }

   public GridProperties set(String var1, Object var2) {
      return (GridProperties)super.set(var1, var2);
   }

   public GridProperties clone() {
      return (GridProperties)super.clone();
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
