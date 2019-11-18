package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class BasicChartAxis extends GenericJson {
   @Key
   private TextFormat format;
   @Key
   private String position;
   @Key
   private String title;
   @Key
   private TextPosition titleTextPosition;

   public TextFormat getFormat() {
      return this.format;
   }

   public BasicChartAxis setFormat(TextFormat var1) {
      this.format = var1;
      return this;
   }

   public String getPosition() {
      return this.position;
   }

   public BasicChartAxis setPosition(String var1) {
      this.position = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public BasicChartAxis setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public TextPosition getTitleTextPosition() {
      return this.titleTextPosition;
   }

   public BasicChartAxis setTitleTextPosition(TextPosition var1) {
      this.titleTextPosition = var1;
      return this;
   }

   public BasicChartAxis set(String var1, Object var2) {
      return (BasicChartAxis)super.set(var1, var2);
   }

   public BasicChartAxis clone() {
      return (BasicChartAxis)super.clone();
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
