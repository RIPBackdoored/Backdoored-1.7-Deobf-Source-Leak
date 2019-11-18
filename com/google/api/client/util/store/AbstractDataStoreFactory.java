package com.google.api.client.util.store;

import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public abstract class AbstractDataStoreFactory implements DataStoreFactory {
   private final Lock lock = new ReentrantLock();
   private final Map dataStoreMap = Maps.newHashMap();
   private static final Pattern ID_PATTERN = Pattern.compile("\\w{1,30}");

   public final DataStore getDataStore(String id) throws IOException {
      Preconditions.checkArgument(ID_PATTERN.matcher(id).matches(), "%s does not match pattern %s", id, ID_PATTERN);
      this.lock.lock();

      DataStore var3;
      try {
         DataStore dataStore = (DataStore)this.dataStoreMap.get(id);
         if (dataStore == null) {
            dataStore = this.createDataStore(id);
            this.dataStoreMap.put(id, dataStore);
         }

         var3 = dataStore;
      } finally {
         this.lock.unlock();
      }

      return var3;
   }

   protected abstract DataStore createDataStore(String var1) throws IOException;
}
