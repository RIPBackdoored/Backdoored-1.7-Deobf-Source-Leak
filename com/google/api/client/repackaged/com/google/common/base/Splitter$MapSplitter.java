package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Beta
public final class Splitter$MapSplitter {
   private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
   private final Splitter outerSplitter;
   private final Splitter entrySplitter;

   private Splitter$MapSplitter(Splitter outerSplitter, Splitter entrySplitter) {
      this.outerSplitter = outerSplitter;
      this.entrySplitter = (Splitter)Preconditions.checkNotNull(entrySplitter);
   }

   public Map split(CharSequence sequence) {
      Map map = new LinkedHashMap();
      Iterator i$ = this.outerSplitter.split(sequence).iterator();

      while(i$.hasNext()) {
         String entry = (String)i$.next();
         Iterator entryFields = Splitter.access$000(this.entrySplitter, entry);
         Preconditions.checkArgument(entryFields.hasNext(), "Chunk [%s] is not a valid entry", (Object)entry);
         String key = (String)entryFields.next();
         Preconditions.checkArgument(!map.containsKey(key), "Duplicate key [%s] found.", (Object)key);
         Preconditions.checkArgument(entryFields.hasNext(), "Chunk [%s] is not a valid entry", (Object)entry);
         String value = (String)entryFields.next();
         map.put(key, value);
         Preconditions.checkArgument(!entryFields.hasNext(), "Chunk [%s] is not a valid entry", (Object)entry);
      }

      return Collections.unmodifiableMap(map);
   }

   // $FF: synthetic method
   Splitter$MapSplitter(Splitter x0, Splitter x1, Splitter$1 x2) {
      this(x0, x1);
   }
}
