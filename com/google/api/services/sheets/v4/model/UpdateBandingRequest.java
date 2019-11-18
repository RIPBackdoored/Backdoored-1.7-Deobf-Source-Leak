package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class UpdateBandingRequest extends GenericJson {
   @Key
   private BandedRange bandedRange;
   @Key
   private String fields;

   public BandedRange getBandedRange() {
      return this.bandedRange;
   }

   public UpdateBandingRequest setBandedRange(BandedRange var1) {
      this.bandedRange = var1;
      return this;
   }

   public String getFields() {
      return this.fields;
   }

   public UpdateBandingRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public UpdateBandingRequest set(String var1, Object var2) {
      return (UpdateBandingRequest)super.set(var1, var2);
   }

   public UpdateBandingRequest clone() {
      return (UpdateBandingRequest)super.clone();
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
