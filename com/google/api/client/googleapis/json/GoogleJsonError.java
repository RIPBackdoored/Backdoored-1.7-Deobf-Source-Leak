package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonObjectParser$Builder;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GoogleJsonError extends GenericJson {
   @Key
   private List errors;
   @Key
   private int code;
   @Key
   private String message;

   public static GoogleJsonError parse(JsonFactory jsonFactory, HttpResponse response) throws IOException {
      JsonObjectParser jsonObjectParser = (new JsonObjectParser$Builder(jsonFactory)).setWrapperKeys(Collections.singleton("error")).build();
      return (GoogleJsonError)jsonObjectParser.parseAndClose(response.getContent(), response.getContentCharset(), GoogleJsonError.class);
   }

   public final List getErrors() {
      return this.errors;
   }

   public final void setErrors(List errors) {
      this.errors = errors;
   }

   public final int getCode() {
      return this.code;
   }

   public final void setCode(int code) {
      this.code = code;
   }

   public final String getMessage() {
      return this.message;
   }

   public final void setMessage(String message) {
      this.message = message;
   }

   public GoogleJsonError set(String fieldName, Object value) {
      return (GoogleJsonError)super.set(fieldName, value);
   }

   public GoogleJsonError clone() {
      return (GoogleJsonError)super.clone();
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

   static {
      Data.nullOf(GoogleJsonError$ErrorInfo.class);
   }
}
