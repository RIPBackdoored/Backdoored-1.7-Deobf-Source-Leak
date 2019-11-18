package com.google.api.client.googleapis.notifications.json;

import com.google.api.client.googleapis.notifications.TypedNotificationCallback;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import java.io.IOException;

@Beta
public abstract class JsonNotificationCallback extends TypedNotificationCallback {
   private static final long serialVersionUID = 1L;

   protected final JsonObjectParser getObjectParser() throws IOException {
      return new JsonObjectParser(this.getJsonFactory());
   }

   protected abstract JsonFactory getJsonFactory() throws IOException;

   // $FF: synthetic method
   // $FF: bridge method
   protected ObjectParser getObjectParser() throws IOException {
      return this.getObjectParser();
   }
}
