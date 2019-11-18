package com.google.api.client.googleapis.util;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;

@Beta
public final class Utils {
   public static JsonFactory getDefaultJsonFactory() {
      return Utils$JsonFactoryInstanceHolder.INSTANCE;
   }

   public static HttpTransport getDefaultTransport() {
      return Utils$TransportInstanceHolder.INSTANCE;
   }

   private Utils() {
   }
}
