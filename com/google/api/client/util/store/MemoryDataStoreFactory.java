package com.google.api.client.util.store;

import java.io.IOException;

public class MemoryDataStoreFactory extends AbstractDataStoreFactory {
   protected DataStore createDataStore(String id) throws IOException {
      return new MemoryDataStoreFactory$MemoryDataStore(this, id);
   }

   public static MemoryDataStoreFactory getDefaultInstance() {
      return MemoryDataStoreFactory$InstanceHolder.INSTANCE;
   }
}
