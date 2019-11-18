package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateValuesRequest extends GenericJson {
   @Key
   private List data;
   @Key
   private Boolean includeValuesInResponse;
   @Key
   private String responseDateTimeRenderOption;
   @Key
   private String responseValueRenderOption;
   @Key
   private String valueInputOption;

   public List getData() {
      return this.data;
   }

   public BatchUpdateValuesRequest setData(List var1) {
      this.data = var1;
      return this;
   }

   public Boolean getIncludeValuesInResponse() {
      return this.includeValuesInResponse;
   }

   public BatchUpdateValuesRequest setIncludeValuesInResponse(Boolean var1) {
      this.includeValuesInResponse = var1;
      return this;
   }

   public String getResponseDateTimeRenderOption() {
      return this.responseDateTimeRenderOption;
   }

   public BatchUpdateValuesRequest setResponseDateTimeRenderOption(String var1) {
      this.responseDateTimeRenderOption = var1;
      return this;
   }

   public String getResponseValueRenderOption() {
      return this.responseValueRenderOption;
   }

   public BatchUpdateValuesRequest setResponseValueRenderOption(String var1) {
      this.responseValueRenderOption = var1;
      return this;
   }

   public String getValueInputOption() {
      return this.valueInputOption;
   }

   public BatchUpdateValuesRequest setValueInputOption(String var1) {
      this.valueInputOption = var1;
      return this;
   }

   public BatchUpdateValuesRequest set(String var1, Object var2) {
      return (BatchUpdateValuesRequest)super.set(var1, var2);
   }

   public BatchUpdateValuesRequest clone() {
      return (BatchUpdateValuesRequest)super.clone();
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
