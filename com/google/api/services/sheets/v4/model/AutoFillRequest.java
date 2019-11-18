package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AutoFillRequest extends GenericJson {
   @Key
   private GridRange range;
   @Key
   private SourceAndDestination sourceAndDestination;
   @Key
   private Boolean useAlternateSeries;

   public GridRange getRange() {
      return this.range;
   }

   public AutoFillRequest setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public SourceAndDestination getSourceAndDestination() {
      return this.sourceAndDestination;
   }

   public AutoFillRequest setSourceAndDestination(SourceAndDestination var1) {
      this.sourceAndDestination = var1;
      return this;
   }

   public Boolean getUseAlternateSeries() {
      return this.useAlternateSeries;
   }

   public AutoFillRequest setUseAlternateSeries(Boolean var1) {
      this.useAlternateSeries = var1;
      return this;
   }

   public AutoFillRequest set(String var1, Object var2) {
      return (AutoFillRequest)super.set(var1, var2);
   }

   public AutoFillRequest clone() {
      return (AutoFillRequest)super.clone();
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
