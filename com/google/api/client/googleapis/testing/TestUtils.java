package com.google.api.client.googleapis.testing;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class TestUtils {
   private static final String UTF_8 = "UTF-8";

   public static Map parseQuery(String query) throws IOException {
      Map map = new HashMap();
      Iterable entries = Splitter.on('&').split(query);
      Iterator i$ = entries.iterator();

      while(i$.hasNext()) {
         String entry = (String)i$.next();
         List sides = Lists.newArrayList(Splitter.on('=').split(entry));
         if (sides.size() != 2) {
            throw new IOException("Invalid Query String");
         }

         String key = URLDecoder.decode((String)sides.get(0), "UTF-8");
         String value = URLDecoder.decode((String)sides.get(1), "UTF-8");
         map.put(key, value);
      }

      return map;
   }

   private TestUtils() {
   }
}
