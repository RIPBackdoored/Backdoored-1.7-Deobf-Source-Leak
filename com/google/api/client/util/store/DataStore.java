package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface DataStore {
   DataStoreFactory getDataStoreFactory();

   String getId();

   int size() throws IOException;

   boolean isEmpty() throws IOException;

   boolean containsKey(String var1) throws IOException;

   boolean containsValue(Serializable var1) throws IOException;

   Set keySet() throws IOException;

   Collection values() throws IOException;

   Serializable get(String var1) throws IOException;

   DataStore set(String var1, Serializable var2) throws IOException;

   DataStore clear() throws IOException;

   DataStore delete(String var1) throws IOException;
}
