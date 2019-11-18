package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class DataFilterValueRange extends GenericJson {
   @Key
   private DataFilter dataFilter;
   @Key
   private String majorDimension;
   @Key
   private List values;

   public DataFilter getDataFilter() {
      return this.dataFilter;
   }

   public DataFilterValueRange setDataFilter(DataFilter var1) {
      this.dataFilter = var1;
      return this;
   }

   public String getMajorDimension() {
      return this.majorDimension;
   }

   public DataFilterValueRange setMajorDimension(String var1) {
      this.majorDimension = var1;
      return this;
   }

   public List getValues() {
      return this.values;
   }

   public DataFilterValueRange setValues(List var1) {
      this.values = var1;
      return this;
   }

   public DataFilterValueRange set(String var1, Object var2) {
      return (DataFilterValueRange)super.set(var1, var2);
   }

   public DataFilterValueRange clone() {
      return (DataFilterValueRange)super.clone();
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
