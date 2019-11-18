package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchGetValuesByDataFilterRequest extends GenericJson {
   @Key
   private List dataFilters;
   @Key
   private String dateTimeRenderOption;
   @Key
   private String majorDimension;
   @Key
   private String valueRenderOption;

   public List getDataFilters() {
      return this.dataFilters;
   }

   public BatchGetValuesByDataFilterRequest setDataFilters(List var1) {
      this.dataFilters = var1;
      return this;
   }

   public String getDateTimeRenderOption() {
      return this.dateTimeRenderOption;
   }

   public BatchGetValuesByDataFilterRequest setDateTimeRenderOption(String var1) {
      this.dateTimeRenderOption = var1;
      return this;
   }

   public String getMajorDimension() {
      return this.majorDimension;
   }

   public BatchGetValuesByDataFilterRequest setMajorDimension(String var1) {
      this.majorDimension = var1;
      return this;
   }

   public String getValueRenderOption() {
      return this.valueRenderOption;
   }

   public BatchGetValuesByDataFilterRequest setValueRenderOption(String var1) {
      this.valueRenderOption = var1;
      return this;
   }

   public BatchGetValuesByDataFilterRequest set(String var1, Object var2) {
      return (BatchGetValuesByDataFilterRequest)super.set(var1, var2);
   }

   public BatchGetValuesByDataFilterRequest clone() {
      return (BatchGetValuesByDataFilterRequest)super.clone();
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
