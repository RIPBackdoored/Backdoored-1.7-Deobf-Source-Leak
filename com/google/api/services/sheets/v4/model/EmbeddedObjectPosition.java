package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class EmbeddedObjectPosition extends GenericJson {
   @Key
   private Boolean newSheet;
   @Key
   private OverlayPosition overlayPosition;
   @Key
   private Integer sheetId;

   public Boolean getNewSheet() {
      return this.newSheet;
   }

   public EmbeddedObjectPosition setNewSheet(Boolean var1) {
      this.newSheet = var1;
      return this;
   }

   public OverlayPosition getOverlayPosition() {
      return this.overlayPosition;
   }

   public EmbeddedObjectPosition setOverlayPosition(OverlayPosition var1) {
      this.overlayPosition = var1;
      return this;
   }

   public Integer getSheetId() {
      return this.sheetId;
   }

   public EmbeddedObjectPosition setSheetId(Integer var1) {
      this.sheetId = var1;
      return this;
   }

   public EmbeddedObjectPosition set(String var1, Object var2) {
      return (EmbeddedObjectPosition)super.set(var1, var2);
   }

   public EmbeddedObjectPosition clone() {
      return (EmbeddedObjectPosition)super.clone();
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
