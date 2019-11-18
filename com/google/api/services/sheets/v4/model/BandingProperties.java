package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class BandingProperties extends GenericJson {
   @Key
   private Color firstBandColor;
   @Key
   private Color footerColor;
   @Key
   private Color headerColor;
   @Key
   private Color secondBandColor;

   public Color getFirstBandColor() {
      return this.firstBandColor;
   }

   public BandingProperties setFirstBandColor(Color var1) {
      this.firstBandColor = var1;
      return this;
   }

   public Color getFooterColor() {
      return this.footerColor;
   }

   public BandingProperties setFooterColor(Color var1) {
      this.footerColor = var1;
      return this;
   }

   public Color getHeaderColor() {
      return this.headerColor;
   }

   public BandingProperties setHeaderColor(Color var1) {
      this.headerColor = var1;
      return this;
   }

   public Color getSecondBandColor() {
      return this.secondBandColor;
   }

   public BandingProperties setSecondBandColor(Color var1) {
      this.secondBandColor = var1;
      return this;
   }

   public BandingProperties set(String var1, Object var2) {
      return (BandingProperties)super.set(var1, var2);
   }

   public BandingProperties clone() {
      return (BandingProperties)super.clone();
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
