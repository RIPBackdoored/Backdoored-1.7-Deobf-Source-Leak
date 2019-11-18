package com.google.api.client.util.store;

import java.io.IOException;

public interface DataStoreFactory {
   DataStore getDataStore(String var1) throws IOException;
}
