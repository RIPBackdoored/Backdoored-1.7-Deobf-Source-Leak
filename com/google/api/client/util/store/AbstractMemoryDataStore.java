package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbstractMemoryDataStore extends AbstractDataStore {
   private final Lock lock = new ReentrantLock();
   protected HashMap keyValueMap = Maps.newHashMap();

   protected AbstractMemoryDataStore(DataStoreFactory dataStoreFactory, String id) {
      super(dataStoreFactory, id);
   }

   public final Set keySet() throws IOException {
      this.lock.lock();

      Set var1;
      try {
         var1 = Collections.unmodifiableSet(this.keyValueMap.keySet());
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public final Collection values() throws IOException {
      this.lock.lock();

      try {
         List result = Lists.newArrayList();
         Iterator var2 = this.keyValueMap.values().iterator();

         while(var2.hasNext()) {
            byte[] bytes = (byte[])var2.next();
            result.add(IOUtils.deserialize(bytes));
         }

         List var7 = Collections.unmodifiableList(result);
         return var7;
      } finally {
         this.lock.unlock();
      }
   }

   public final Serializable get(String key) throws IOException {
      if (key == null) {
         return null;
      } else {
         this.lock.lock();

         Serializable var2;
         try {
            var2 = IOUtils.deserialize((byte[])this.keyValueMap.get(key));
         } finally {
            this.lock.unlock();
         }

         return var2;
      }
   }

   public final DataStore set(String key, Serializable value) throws IOException {
      Preconditions.checkNotNull(key);
      Preconditions.checkNotNull(value);
      this.lock.lock();

      try {
         this.keyValueMap.put(key, IOUtils.serialize(value));
         this.save();
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public DataStore delete(String key) throws IOException {
      if (key == null) {
         return this;
      } else {
         this.lock.lock();

         try {
            this.keyValueMap.remove(key);
            this.save();
         } finally {
            this.lock.unlock();
         }

         return this;
      }
   }

   public final DataStore clear() throws IOException {
      this.lock.lock();

      try {
         this.keyValueMap.clear();
         this.save();
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public boolean containsKey(String key) throws IOException {
      if (key == null) {
         return false;
      } else {
         this.lock.lock();

         boolean var2;
         try {
            var2 = this.keyValueMap.containsKey(key);
         } finally {
            this.lock.unlock();
         }

         return var2;
      }
   }

   public boolean containsValue(Serializable value) throws IOException {
      if (value == null) {
         return false;
      } else {
         this.lock.lock();

         boolean var5;
         try {
            byte[] serialized = IOUtils.serialize(value);
            Iterator var3 = this.keyValueMap.values().iterator();

            byte[] bytes;
            do {
               if (!var3.hasNext()) {
                  boolean var9 = false;
                  return var9;
               }

               bytes = (byte[])var3.next();
            } while(!Arrays.equals(serialized, bytes));

            var5 = true;
         } finally {
            this.lock.unlock();
         }

         return var5;
      }
   }

   public boolean isEmpty() throws IOException {
      this.lock.lock();

      boolean var1;
      try {
         var1 = this.keyValueMap.isEmpty();
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public int size() throws IOException {
      this.lock.lock();

      int var1;
      try {
         var1 = this.keyValueMap.size();
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public void save() throws IOException {
   }

   public String toString() {
      return DataStoreUtils.toString(this);
   }
}
