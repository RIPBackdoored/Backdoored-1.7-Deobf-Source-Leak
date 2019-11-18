package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class BandedRange extends GenericJson {
   @Key
   private Integer bandedRangeId;
   @Key
   private BandingProperties columnProperties;
   @Key
   private GridRange range;
   @Key
   private BandingProperties rowProperties;

   public Integer getBandedRangeId() {
      return this.bandedRangeId;
   }

   public BandedRange setBandedRangeId(Integer var1) {
      this.bandedRangeId = var1;
      return this;
   }

   public BandingProperties getColumnProperties() {
      return this.columnProperties;
   }

   public BandedRange setColumnProperties(BandingProperties var1) {
      this.columnProperties = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public BandedRange setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public BandingProperties getRowProperties() {
      return this.rowProperties;
   }

   public BandedRange setRowProperties(BandingProperties var1) {
      this.rowProperties = var1;
      return this;
   }

   public BandedRange set(String var1, Object var2) {
      return (BandedRange)super.set(var1, var2);
   }

   public BandedRange clone() {
      return (BandedRange)super.clone();
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
