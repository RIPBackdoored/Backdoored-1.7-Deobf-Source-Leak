package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class PasteDataRequest extends GenericJson {
   @Key
   private GridCoordinate coordinate;
   @Key
   private String data;
   @Key
   private String delimiter;
   @Key
   private Boolean html;
   @Key
   private String type;

   public GridCoordinate getCoordinate() {
      return this.coordinate;
   }

   public PasteDataRequest setCoordinate(GridCoordinate var1) {
      this.coordinate = var1;
      return this;
   }

   public String getData() {
      return this.data;
   }

   public PasteDataRequest setData(String var1) {
      this.data = var1;
      return this;
   }

   public String getDelimiter() {
      return this.delimiter;
   }

   public PasteDataRequest setDelimiter(String var1) {
      this.delimiter = var1;
      return this;
   }

   public Boolean getHtml() {
      return this.html;
   }

   public PasteDataRequest setHtml(Boolean var1) {
      this.html = var1;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public PasteDataRequest setType(String var1) {
      this.type = var1;
      return this;
   }

   public PasteDataRequest set(String var1, Object var2) {
      return (PasteDataRequest)super.set(var1, var2);
   }

   public PasteDataRequest clone() {
      return (PasteDataRequest)super.clone();
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
