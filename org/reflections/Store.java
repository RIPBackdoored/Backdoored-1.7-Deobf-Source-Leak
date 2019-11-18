package org.reflections;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Store {
   private transient boolean concurrent;
   private final Map storeMap = new HashMap();

   protected Store() {
      this.concurrent = false;
   }

   public Store(Configuration configuration) {
      this.concurrent = configuration.getExecutorService() != null;
   }

   public Set keySet() {
      return this.storeMap.keySet();
   }

   public Multimap getOrCreate(String index) {
      Multimap mmap = (Multimap)this.storeMap.get(index);
      if (mmap == null) {
         SetMultimap multimap = Multimaps.newSetMultimap(new HashMap(), new Store$1(this));
         mmap = this.concurrent ? Multimaps.synchronizedSetMultimap(multimap) : multimap;
         this.storeMap.put(index, mmap);
      }

      return (Multimap)mmap;
   }

   public Multimap get(String index) {
      Multimap mmap = (Multimap)this.storeMap.get(index);
      if (mmap == null) {
         throw new ReflectionsException("Scanner " + index + " was not configured");
      } else {
         return mmap;
      }
   }

   public Iterable get(String index, String... keys) {
      return this.get(index, (Iterable)Arrays.asList(keys));
   }

   public Iterable get(String index, Iterable keys) {
      Multimap mmap = this.get(index);
      Store$IterableChain result = new Store$IterableChain((Store$1)null);
      Iterator var5 = keys.iterator();

      while(var5.hasNext()) {
         String key = (String)var5.next();
         Store$IterableChain.access$100(result, mmap.get(key));
      }

      return result;
   }

   private Iterable getAllIncluding(String index, Iterable keys, Store$IterableChain result) {
      Store$IterableChain.access$100(result, keys);
      Iterator var4 = keys.iterator();

      while(var4.hasNext()) {
         String key = (String)var4.next();
         Iterable values = this.get(index, key);
         if (values.iterator().hasNext()) {
            this.getAllIncluding(index, values, result);
         }
      }

      return result;
   }

   public Iterable getAll(String index, String key) {
      return this.getAllIncluding(index, this.get(index, key), new Store$IterableChain((Store$1)null));
   }

   public Iterable getAll(String index, Iterable keys) {
      return this.getAllIncluding(index, this.get(index, keys), new Store$IterableChain((Store$1)null));
   }
}
