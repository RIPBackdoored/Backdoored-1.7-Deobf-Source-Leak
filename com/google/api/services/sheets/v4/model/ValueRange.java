package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class ValueRange extends GenericJson {
   @Key
   private String majorDimension;
   @Key
   private String range;
   @Key
   private List values;

   public String getMajorDimension() {
      return this.majorDimension;
   }

   public ValueRange setMajorDimension(String var1) {
      this.majorDimension = var1;
      return this;
   }

   public String getRange() {
      return this.range;
   }

   public ValueRange setRange(String var1) {
      this.range = var1;
      return this;
   }

   public List getValues() {
      return this.values;
   }

   public ValueRange setValues(List var1) {
      this.values = var1;
      return this;
   }

   public ValueRange set(String var1, Object var2) {
      return (ValueRange)super.set(var1, var2);
   }

   public ValueRange clone() {
      return (ValueRange)super.clone();
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
