package com.google.api.client.extensions.java6.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/** @deprecated */
@Deprecated
@Beta
public class FilePersistedCredentials extends GenericJson {
   @Key
   private Map credentials = Maps.newHashMap();

   void store(String userId, Credential credential) {
      Preconditions.checkNotNull(userId);
      FilePersistedCredential fileCredential = (FilePersistedCredential)this.credentials.get(userId);
      if (fileCredential == null) {
         fileCredential = new FilePersistedCredential();
         this.credentials.put(userId, fileCredential);
      }

      fileCredential.store(credential);
   }

   boolean load(String userId, Credential credential) {
      Preconditions.checkNotNull(userId);
      FilePersistedCredential fileCredential = (FilePersistedCredential)this.credentials.get(userId);
      if (fileCredential == null) {
         return false;
      } else {
         fileCredential.load(credential);
         return true;
      }
   }

   void delete(String userId) {
      Preconditions.checkNotNull(userId);
      this.credentials.remove(userId);
   }

   public FilePersistedCredentials set(String fieldName, Object value) {
      return (FilePersistedCredentials)super.set(fieldName, value);
   }

   public FilePersistedCredentials clone() {
      return (FilePersistedCredentials)super.clone();
   }

   void migrateTo(DataStore typedDataStore) throws IOException {
      Iterator i$ = this.credentials.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         typedDataStore.set((String)entry.getKey(), ((FilePersistedCredential)entry.getValue()).toStoredCredential());
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
