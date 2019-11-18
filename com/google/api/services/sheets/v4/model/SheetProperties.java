package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class SheetProperties extends GenericJson {
   @Key
   private GridProperties gridProperties;
   @Key
   private Boolean hidden;
   @Key
   private Integer index;
   @Key
   private Boolean rightToLeft;
   @Key
   private Integer sheetId;
   @Key
   private String sheetType;
   @Key
   private Color tabColor;
   @Key
   private String title;

   public GridProperties getGridProperties() {
      return this.gridProperties;
   }

   public SheetProperties setGridProperties(GridProperties var1) {
      this.gridProperties = var1;
      return this;
   }

   public Boolean getHidden() {
      return this.hidden;
   }

   public SheetProperties setHidden(Boolean var1) {
      this.hidden = var1;
      return this;
   }

   public Integer getIndex() {
      return this.index;
   }

   public SheetProperties setIndex(Integer var1) {
      this.index = var1;
      return this;
   }

   public Boolean getRightToLeft() {
      return this.rightToLeft;
   }

   public SheetProperties setRightToLeft(Boolean var1) {
      this.rightToLeft = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public SheetProperties setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public String getSheetType() {
      return this.sheetType;
   }

   public SheetProperties setSheetType(String var1) {
      this.sheetType = var1;
      return this;
   }

   public Color getTabColor() {
      return this.tabColor;
   }

   public SheetProperties setTabColor(Color var1) {
      this.tabColor = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public SheetProperties setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public SheetProperties set(String var1, Object var2) {
      return (SheetProperties)super.set(var1, var2);
   }

   public SheetProperties clone() {
      return (SheetProperties)super.clone();
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
