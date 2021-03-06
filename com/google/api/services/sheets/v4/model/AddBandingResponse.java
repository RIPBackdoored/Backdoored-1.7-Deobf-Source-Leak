package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class AddBandingResponse extends GenericJson {
   @Key
   private BandedRange bandedRange;

   public BandedRange getBandedRange() {
      return this.bandedRange;
   }

   public AddBandingResponse setBandedRange(BandedRange var1) {
      this.bandedRange = var1;
      return this;
   }

   public AddBandingResponse set(String var1, Object var2) {
      return (AddBandingResponse)super.set(var1, var2);
   }

   public AddBandingResponse clone() {
      return (AddBandingResponse)super.clone();
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
