package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class CutPasteRequest extends GenericJson {
   @Key
   private GridCoordinate destination;
   @Key
   private String pasteType;
   @Key
   private GridRange source;

   public GridCoordinate getDestination() {
      return this.destination;
   }

   public CutPasteRequest setDestination(GridCoordinate var1) {
      this.destination = var1;
      return this;
   }

   public String getPasteType() {
      return this.pasteType;
   }

   public CutPasteRequest setPasteType(String var1) {
      this.pasteType = var1;
      return this;
   }

   public GridRange getSource() {
      return this.source;
   }

   public CutPasteRequest setSource(GridRange var1) {
      this.source = var1;
      return this;
   }

   public CutPasteRequest set(String var1, Object var2) {
      return (CutPasteRequest)super.set(var1, var2);
   }

   public CutPasteRequest clone() {
      return (CutPasteRequest)super.clone();
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
