package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class CandlestickData extends GenericJson {
   @Key
   private CandlestickSeries closeSeries;
   @Key
   private CandlestickSeries highSeries;
   @Key
   private CandlestickSeries lowSeries;
   @Key
   private CandlestickSeries openSeries;

   public CandlestickSeries getCloseSeries() {
      return this.closeSeries;
   }

   public CandlestickData setCloseSeries(CandlestickSeries var1) {
      this.closeSeries = var1;
      return this;
   }

   public CandlestickSeries getHighSeries() {
      return this.highSeries;
   }

   public CandlestickData setHighSeries(CandlestickSeries var1) {
      this.highSeries = var1;
      return this;
   }

   public CandlestickSeries getLowSeries() {
      return this.lowSeries;
   }

   public CandlestickData setLowSeries(CandlestickSeries var1) {
      this.lowSeries = var1;
      return this;
   }

   public CandlestickSeries getOpenSeries() {
      return this.openSeries;
   }

   public CandlestickData setOpenSeries(CandlestickSeries var1) {
      this.openSeries = var1;
      return this;
   }

   public CandlestickData set(String var1, Object var2) {
      return (CandlestickData)super.set(var1, var2);
   }

   public CandlestickData clone() {
      return (CandlestickData)super.clone();
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
