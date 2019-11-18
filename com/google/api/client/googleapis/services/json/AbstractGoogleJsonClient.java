package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.ObjectParser;

public abstract class AbstractGoogleJsonClient extends AbstractGoogleClient {
   protected AbstractGoogleJsonClient(AbstractGoogleJsonClient$Builder builder) {
      super(builder);
   }

   public JsonObjectParser getObjectParser() {
      return (JsonObjectParser)super.getObjectParser();
   }

   public final JsonFactory getJsonFactory() {
      return this.getObjectParser().getJsonFactory();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public ObjectParser getObjectParser() {
      return this.getObjectParser();
   }
}
