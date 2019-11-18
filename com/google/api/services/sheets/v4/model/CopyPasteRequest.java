package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class CopyPasteRequest extends GenericJson {
   @Key
   private GridRange destination;
   @Key
   private String pasteOrientation;
   @Key
   private String pasteType;
   @Key
   private GridRange source;

   public GridRange getDestination() {
      return this.destination;
   }

   public CopyPasteRequest setDestination(GridRange var1) {
      this.destination = var1;
      return this;
   }

   public String getPasteOrientation() {
      return this.pasteOrientation;
   }

   public CopyPasteRequest setPasteOrientation(String var1) {
      this.pasteOrientation = var1;
      return this;
   }

   public String getPasteType() {
      return this.pasteType;
   }

   public CopyPasteRequest setPasteType(String var1) {
      this.pasteType = var1;
      return this;
   }

   public GridRange getSource() {
      return this.source;
   }

   public CopyPasteRequest setSource(GridRange var1) {
      this.source = var1;
      return this;
   }

   public CopyPasteRequest set(String var1, Object var2) {
      return (CopyPasteRequest)super.set(var1, var2);
   }

   public CopyPasteRequest clone() {
      return (CopyPasteRequest)super.clone();
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
