package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Reader;

public final class GoogleClientSecrets extends GenericJson {
   @Key
   private GoogleClientSecrets$Details installed;
   @Key
   private GoogleClientSecrets$Details web;

   public GoogleClientSecrets$Details getInstalled() {
      return this.installed;
   }

   public GoogleClientSecrets setInstalled(GoogleClientSecrets$Details installed) {
      this.installed = installed;
      return this;
   }

   public GoogleClientSecrets$Details getWeb() {
      return this.web;
   }

   public GoogleClientSecrets setWeb(GoogleClientSecrets$Details web) {
      this.web = web;
      return this;
   }

   public GoogleClientSecrets$Details getDetails() {
      Preconditions.checkArgument(this.web == null != (this.installed == null));
      return this.web == null ? this.installed : this.web;
   }

   public GoogleClientSecrets set(String fieldName, Object value) {
      return (GoogleClientSecrets)super.set(fieldName, value);
   }

   public GoogleClientSecrets clone() {
      return (GoogleClientSecrets)super.clone();
   }

   public static GoogleClientSecrets load(JsonFactory jsonFactory, Reader reader) throws IOException {
      return (GoogleClientSecrets)jsonFactory.fromReader(reader, GoogleClientSecrets.class);
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
