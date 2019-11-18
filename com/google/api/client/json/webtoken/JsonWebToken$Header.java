package com.google.api.client.json.webtoken;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public class JsonWebToken$Header extends GenericJson {
   @Key("typ")
   private String type;
   @Key("cty")
   private String contentType;

   public final String getType() {
      return this.type;
   }

   public JsonWebToken$Header setType(String type) {
      this.type = type;
      return this;
   }

   public final String getContentType() {
      return this.contentType;
   }

   public JsonWebToken$Header setContentType(String contentType) {
      this.contentType = contentType;
      return this;
   }

   public JsonWebToken$Header set(String fieldName, Object value) {
      return (JsonWebToken$Header)super.set(fieldName, value);
   }

   public JsonWebToken$Header clone() {
      return (JsonWebToken$Header)super.clone();
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
