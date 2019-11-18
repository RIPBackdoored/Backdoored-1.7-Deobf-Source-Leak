package com.google.api.client.util.store;

import java.io.IOException;
import java.util.Iterator;

public final class DataStoreUtils {
   public static String toString(DataStore dataStore) {
      try {
         StringBuilder sb = new StringBuilder();
         sb.append('{');
         boolean first = true;

         String key;
         for(Iterator var3 = dataStore.keySet().iterator(); var3.hasNext(); sb.append(key).append('=').append(dataStore.get(key))) {
            key = (String)var3.next();
            if (first) {
               first = false;
            } else {
               sb.append(", ");
            }
         }

         String var10000 = sb.append('}').toString();
         return var10000;
      } catch (IOException var5) {
         throw new RuntimeException(var5);
      }
   }

   private DataStoreUtils() {
   }
}
