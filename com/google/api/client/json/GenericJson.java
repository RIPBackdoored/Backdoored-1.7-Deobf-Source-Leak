package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Throwables;
import java.io.IOException;

public class GenericJson extends GenericData implements Cloneable {
   private JsonFactory jsonFactory;

   public final JsonFactory getFactory() {
      return this.jsonFactory;
   }

   public final void setFactory(JsonFactory factory) {
      this.jsonFactory = factory;
   }

   public String toString() {
      if (this.jsonFactory != null) {
         String var10000;
         try {
            var10000 = this.jsonFactory.toString(this);
         } catch (IOException var2) {
            throw Throwables.propagate(var2);
         }

         return var10000;
      } else {
         return super.toString();
      }
   }

   public String toPrettyString() throws IOException {
      return this.jsonFactory != null ? this.jsonFactory.toPrettyString(this) : super.toString();
   }

   public GenericJson clone() {
      return (GenericJson)super.clone();
   }

   public GenericJson set(String fieldName, Object value) {
      return (GenericJson)super.set(fieldName, value);
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
