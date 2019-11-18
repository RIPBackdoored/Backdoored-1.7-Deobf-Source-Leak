package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

@Beta
final class AuthKeyValueParser implements ObjectParser {
   public static final AuthKeyValueParser INSTANCE = new AuthKeyValueParser();

   public String getContentType() {
      return "text/plain";
   }

   public Object parse(HttpResponse response, Class dataClass) throws IOException {
      response.setContentLoggingLimit(0);
      InputStream content = response.getContent();

      Object var4;
      try {
         var4 = this.parse(content, dataClass);
      } finally {
         content.close();
      }

      return var4;
   }

   public Object parse(InputStream content, Class dataClass) throws IOException {
      ClassInfo classInfo = ClassInfo.of(dataClass);
      Object newInstance = Types.newInstance(dataClass);
      BufferedReader reader = new BufferedReader(new InputStreamReader(content));

      while(true) {
         while(true) {
            String line = reader.readLine();
            if (line == null) {
               return newInstance;
            }

            int equals = line.indexOf(61);
            String key = line.substring(0, equals);
            String value = line.substring(equals + 1);
            Field field = classInfo.getField(key);
            if (field != null) {
               Class fieldClass = field.getType();
               Object fieldValue;
               if (fieldClass != Boolean.TYPE && fieldClass != Boolean.class) {
                  fieldValue = value;
               } else {
                  fieldValue = Boolean.valueOf(value);
               }

               FieldInfo.setFieldValue(field, newInstance, fieldValue);
            } else if (GenericData.class.isAssignableFrom(dataClass)) {
               GenericData data = (GenericData)newInstance;
               data.set(key, value);
            } else if (Map.class.isAssignableFrom(dataClass)) {
               Map map = (Map)newInstance;
               map.put(key, value);
            }
         }
      }
   }

   private AuthKeyValueParser() {
   }

   public Object parseAndClose(InputStream in, Charset charset, Class dataClass) throws IOException {
      Reader reader = new InputStreamReader(in, charset);
      return this.parseAndClose(reader, (Class)dataClass);
   }

   public Object parseAndClose(InputStream in, Charset charset, Type dataType) {
      throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
   }

   public Object parseAndClose(Reader reader, Class dataClass) throws IOException {
      try {
         ClassInfo classInfo = ClassInfo.of(dataClass);
         Object newInstance = Types.newInstance(dataClass);
         BufferedReader breader = new BufferedReader(reader);

         while(true) {
            String line = breader.readLine();
            if (line == null) {
               Object var18 = newInstance;
               return var18;
            }

            int equals = line.indexOf(61);
            String key = line.substring(0, equals);
            String value = line.substring(equals + 1);
            Field field = classInfo.getField(key);
            if (field == null) {
               if (GenericData.class.isAssignableFrom(dataClass)) {
                  GenericData data = (GenericData)newInstance;
                  data.set(key, value);
               } else if (Map.class.isAssignableFrom(dataClass)) {
                  Map map = (Map)newInstance;
                  map.put(key, value);
               }
            } else {
               Class fieldClass = field.getType();
               Object fieldValue;
               if (fieldClass != Boolean.TYPE && fieldClass != Boolean.class) {
                  fieldValue = value;
               } else {
                  fieldValue = Boolean.valueOf(value);
               }

               FieldInfo.setFieldValue(field, newInstance, fieldValue);
            }
         }
      } finally {
         reader.close();
      }
   }

   public Object parseAndClose(Reader reader, Type dataType) {
      throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
   }
}
