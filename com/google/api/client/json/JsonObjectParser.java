package com.google.api.client.json;

import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JsonObjectParser implements ObjectParser {
   private final JsonFactory jsonFactory;
   private final Set wrapperKeys;

   public JsonObjectParser(JsonFactory jsonFactory) {
      this(new JsonObjectParser$Builder(jsonFactory));
   }

   protected JsonObjectParser(JsonObjectParser$Builder builder) {
      this.jsonFactory = builder.jsonFactory;
      this.wrapperKeys = new HashSet(builder.wrapperKeys);
   }

   public Object parseAndClose(InputStream in, Charset charset, Class dataClass) throws IOException {
      return this.parseAndClose(in, charset, (Type)dataClass);
   }

   public Object parseAndClose(InputStream in, Charset charset, Type dataType) throws IOException {
      JsonParser parser = this.jsonFactory.createJsonParser(in, charset);
      this.initializeParser(parser);
      return parser.parse(dataType, true);
   }

   public Object parseAndClose(Reader reader, Class dataClass) throws IOException {
      return this.parseAndClose(reader, (Type)dataClass);
   }

   public Object parseAndClose(Reader reader, Type dataType) throws IOException {
      JsonParser parser = this.jsonFactory.createJsonParser(reader);
      this.initializeParser(parser);
      return parser.parse(dataType, true);
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public Set getWrapperKeys() {
      return Collections.unmodifiableSet(this.wrapperKeys);
   }

   private void initializeParser(JsonParser parser) throws IOException {
      if (!this.wrapperKeys.isEmpty()) {
         boolean failed = true;

         try {
            String match = parser.skipToKey(this.wrapperKeys);
            Preconditions.checkArgument(match != null && parser.getCurrentToken() != JsonToken.END_OBJECT, "wrapper key(s) not found: %s", this.wrapperKeys);
            failed = false;
         } finally {
            if (failed) {
               parser.close();
            }

         }

      }
   }
}
