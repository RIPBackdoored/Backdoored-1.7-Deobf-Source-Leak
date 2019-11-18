package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class DeleteBandingRequest extends GenericJson {
   @Key
   private Integer bandedRangeId;

   public Integer getBandedRangeId() {
      return this.bandedRangeId;
   }

   public DeleteBandingRequest setBandedRangeId(Integer var1) {
      this.bandedRangeId = var1;
      return this;
   }

   public DeleteBandingRequest set(String var1, Object var2) {
      return (DeleteBandingRequest)super.set(var1, var2);
   }

   public DeleteBandingRequest clone() {
      return (DeleteBandingRequest)super.clone();
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
