package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

final class JacksonGenerator extends JsonGenerator {
   private final com.fasterxml.jackson.core.JsonGenerator generator;
   private final JacksonFactory factory;

   public JacksonFactory getFactory() {
      return this.factory;
   }

   JacksonGenerator(JacksonFactory factory, com.fasterxml.jackson.core.JsonGenerator generator) {
      this.factory = factory;
      this.generator = generator;
   }

   public void flush() throws IOException {
      this.generator.flush();
   }

   public void close() throws IOException {
      this.generator.close();
   }

   public void writeBoolean(boolean state) throws IOException {
      this.generator.writeBoolean(state);
   }

   public void writeEndArray() throws IOException {
      this.generator.writeEndArray();
   }

   public void writeEndObject() throws IOException {
      this.generator.writeEndObject();
   }

   public void writeFieldName(String name) throws IOException {
      this.generator.writeFieldName(name);
   }

   public void writeNull() throws IOException {
      this.generator.writeNull();
   }

   public void writeNumber(int v) throws IOException {
      this.generator.writeNumber(v);
   }

   public void writeNumber(long v) throws IOException {
      this.generator.writeNumber(v);
   }

   public void writeNumber(BigInteger v) throws IOException {
      this.generator.writeNumber(v);
   }

   public void writeNumber(double v) throws IOException {
      this.generator.writeNumber(v);
   }

   public void writeNumber(float v) throws IOException {
      this.generator.writeNumber(v);
   }

   public void writeNumber(BigDecimal v) throws IOException {
      this.generator.writeNumber(v);
   }

   public void writeNumber(String encodedValue) throws IOException {
      this.generator.writeNumber(encodedValue);
   }

   public void writeStartArray() throws IOException {
      this.generator.writeStartArray();
   }

   public void writeStartObject() throws IOException {
      this.generator.writeStartObject();
   }

   public void writeString(String value) throws IOException {
      this.generator.writeString(value);
   }

   public void enablePrettyPrint() throws IOException {
      this.generator.useDefaultPrettyPrinter();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonFactory getFactory() {
      return this.getFactory();
   }
}
