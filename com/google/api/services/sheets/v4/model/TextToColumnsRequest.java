package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class TextToColumnsRequest extends GenericJson {
   @Key
   private String delimiter;
   @Key
   private String delimiterType;
   @Key
   private GridRange source;

   public String getDelimiter() {
      return this.delimiter;
   }

   public TextToColumnsRequest setDelimiter(String var1) {
      this.delimiter = var1;
      return this;
   }

   public String getDelimiterType() {
      return this.delimiterType;
   }

   public TextToColumnsRequest setDelimiterType(String var1) {
      this.delimiterType = var1;
      return this;
   }

   public GridRange getSource() {
      return this.source;
   }

   public TextToColumnsRequest setSource(GridRange var1) {
      this.source = var1;
      return this;
   }

   public TextToColumnsRequest set(String var1, Object var2) {
      return (TextToColumnsRequest)super.set(var1, var2);
   }

   public TextToColumnsRequest clone() {
      return (TextToColumnsRequest)super.clone();
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
