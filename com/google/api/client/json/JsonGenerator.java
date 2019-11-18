package com.google.api.client.json;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class JsonGenerator {
   public abstract JsonFactory getFactory();

   public abstract void flush() throws IOException;

   public abstract void close() throws IOException;

   public abstract void writeStartArray() throws IOException;

   public abstract void writeEndArray() throws IOException;

   public abstract void writeStartObject() throws IOException;

   public abstract void writeEndObject() throws IOException;

   public abstract void writeFieldName(String var1) throws IOException;

   public abstract void writeNull() throws IOException;

   public abstract void writeString(String var1) throws IOException;

   public abstract void writeBoolean(boolean var1) throws IOException;

   public abstract void writeNumber(int var1) throws IOException;

   public abstract void writeNumber(long var1) throws IOException;

   public abstract void writeNumber(BigInteger var1) throws IOException;

   public abstract void writeNumber(float var1) throws IOException;

   public abstract void writeNumber(double var1) throws IOException;

   public abstract void writeNumber(BigDecimal var1) throws IOException;

   public abstract void writeNumber(String var1) throws IOException;

   public final void serialize(Object value) throws IOException {
      this.serialize(false, value);
   }

   private void serialize(boolean isJsonString, Object value) throws IOException {
      if (value != null) {
         Class valueClass = value.getClass();
         if (Data.isNull(value)) {
            this.writeNull();
         } else if (value instanceof String) {
            this.writeString((String)value);
         } else if (value instanceof Number) {
            if (isJsonString) {
               this.writeString(value.toString());
            } else if (value instanceof BigDecimal) {
               this.writeNumber((BigDecimal)value);
            } else if (value instanceof BigInteger) {
               this.writeNumber((BigInteger)value);
            } else if (value instanceof Long) {
               this.writeNumber((Long)value);
            } else if (value instanceof Float) {
               float floatValue = ((Number)value).floatValue();
               Preconditions.checkArgument(!Float.isInfinite(floatValue) && !Float.isNaN(floatValue));
               this.writeNumber(floatValue);
            } else if (!(value instanceof Integer) && !(value instanceof Short) && !(value instanceof Byte)) {
               double doubleValue = ((Number)value).doubleValue();
               Preconditions.checkArgument(!Double.isInfinite(doubleValue) && !Double.isNaN(doubleValue));
               this.writeNumber(doubleValue);
            } else {
               this.writeNumber(((Number)value).intValue());
            }
         } else if (value instanceof Boolean) {
            this.writeBoolean((Boolean)value);
         } else if (value instanceof DateTime) {
            this.writeString(((DateTime)value).toStringRfc3339());
         } else if (!(value instanceof Iterable) && !valueClass.isArray()) {
            if (valueClass.isEnum()) {
               String name = FieldInfo.of((Enum)value).getName();
               if (name == null) {
                  this.writeNull();
               } else {
                  this.writeString(name);
               }
            } else {
               this.writeStartObject();
               boolean isMapNotGenericData = value instanceof Map && !(value instanceof GenericData);
               ClassInfo classInfo = isMapNotGenericData ? null : ClassInfo.of(valueClass);
               Iterator var8 = Data.mapOf(value).entrySet().iterator();

               while(true) {
                  Entry entry;
                  Object fieldValue;
                  do {
                     if (!var8.hasNext()) {
                        this.writeEndObject();
                        return;
                     }

                     entry = (Entry)var8.next();
                     fieldValue = entry.getValue();
                  } while(fieldValue == null);

                  String fieldName = (String)entry.getKey();
                  boolean isJsonStringForField;
                  if (isMapNotGenericData) {
                     isJsonStringForField = isJsonString;
                  } else {
                     Field field = classInfo.getField(fieldName);
                     isJsonStringForField = field != null && field.getAnnotation(JsonString.class) != null;
                  }

                  this.writeFieldName(fieldName);
                  this.serialize(isJsonStringForField, fieldValue);
               }
            }
         } else {
            this.writeStartArray();
            Iterator var14 = Types.iterableOf(value).iterator();

            while(var14.hasNext()) {
               Object o = var14.next();
               this.serialize(isJsonString, o);
            }

            this.writeEndArray();
         }

      }
   }

   public void enablePrettyPrint() throws IOException {
   }
}
