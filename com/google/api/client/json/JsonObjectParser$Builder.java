package com.google.api.client.json;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import java.util.Collection;

public class JsonObjectParser$Builder {
   final JsonFactory jsonFactory;
   Collection wrapperKeys = Sets.newHashSet();

   public JsonObjectParser$Builder(JsonFactory jsonFactory) {
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
   }

   public JsonObjectParser build() {
      return new JsonObjectParser(this);
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final Collection getWrapperKeys() {
      return this.wrapperKeys;
   }

   public JsonObjectParser$Builder setWrapperKeys(Collection wrapperKeys) {
      this.wrapperKeys = wrapperKeys;
      return this;
   }
}
