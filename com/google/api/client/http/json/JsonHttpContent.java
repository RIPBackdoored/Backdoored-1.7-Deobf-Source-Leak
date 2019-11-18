package com.google.api.client.http.json;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpMediaType;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

public class JsonHttpContent extends AbstractHttpContent {
   private final Object data;
   private final JsonFactory jsonFactory;
   private String wrapperKey;

   public JsonHttpContent(JsonFactory jsonFactory, Object data) {
      super("application/json; charset=UTF-8");
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
      this.data = Preconditions.checkNotNull(data);
   }

   public void writeTo(OutputStream out) throws IOException {
      JsonGenerator generator = this.jsonFactory.createJsonGenerator(out, this.getCharset());
      if (this.wrapperKey != null) {
         generator.writeStartObject();
         generator.writeFieldName(this.wrapperKey);
      }

      generator.serialize(this.data);
      if (this.wrapperKey != null) {
         generator.writeEndObject();
      }

      generator.flush();
   }

   public JsonHttpContent setMediaType(HttpMediaType mediaType) {
      super.setMediaType(mediaType);
      return this;
   }

   public final Object getData() {
      return this.data;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final String getWrapperKey() {
      return this.wrapperKey;
   }

   public JsonHttpContent setWrapperKey(String wrapperKey) {
      this.wrapperKey = wrapperKey;
      return this;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractHttpContent setMediaType(HttpMediaType var1) {
      return this.setMediaType(var1);
   }
}
