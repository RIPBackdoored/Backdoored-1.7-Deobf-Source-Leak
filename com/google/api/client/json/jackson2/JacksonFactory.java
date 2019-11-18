package com.google.api.client.json.jackson2;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator$Feature;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public final class JacksonFactory extends JsonFactory {
   private final com.fasterxml.jackson.core.JsonFactory factory = new com.fasterxml.jackson.core.JsonFactory();

   public JacksonFactory() {
      this.factory.configure(JsonGenerator$Feature.AUTO_CLOSE_JSON_CONTENT, false);
   }

   public static JacksonFactory getDefaultInstance() {
      return JacksonFactory$InstanceHolder.INSTANCE;
   }

   public JsonGenerator createJsonGenerator(OutputStream out, Charset enc) throws IOException {
      return new JacksonGenerator(this, this.factory.createJsonGenerator(out, JsonEncoding.UTF8));
   }

   public JsonGenerator createJsonGenerator(Writer writer) throws IOException {
      return new JacksonGenerator(this, this.factory.createJsonGenerator(writer));
   }

   public JsonParser createJsonParser(Reader reader) throws IOException {
      Preconditions.checkNotNull(reader);
      return new JacksonParser(this, this.factory.createJsonParser(reader));
   }

   public JsonParser createJsonParser(InputStream in) throws IOException {
      Preconditions.checkNotNull(in);
      return new JacksonParser(this, this.factory.createJsonParser(in));
   }

   public JsonParser createJsonParser(InputStream in, Charset charset) throws IOException {
      Preconditions.checkNotNull(in);
      return new JacksonParser(this, this.factory.createJsonParser(in));
   }

   public JsonParser createJsonParser(String value) throws IOException {
      Preconditions.checkNotNull(value);
      return new JacksonParser(this, this.factory.createJsonParser(value));
   }

   static JsonToken convert(com.fasterxml.jackson.core.JsonToken token) {
      // $FF: Couldn't be decompiled
   }
}
