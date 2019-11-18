package com.google.api.client.util.store;

class MemoryDataStoreFactory$MemoryDataStore extends AbstractMemoryDataStore {
   MemoryDataStoreFactory$MemoryDataStore(MemoryDataStoreFactory dataStore, String id) {
      super(dataStore, id);
   }

   public MemoryDataStoreFactory getDataStoreFactory() {
      return (MemoryDataStoreFactory)super.getDataStoreFactory();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public DataStoreFactory getDataStoreFactory() {
      return this.getDataStoreFactory();
   }
}
