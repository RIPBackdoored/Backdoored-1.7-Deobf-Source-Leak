package org.reflections;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

class Store$IterableChain implements Iterable {
   private final List chain;

   private Store$IterableChain() {
      this.chain = Lists.newArrayList();
   }

   private void addAll(Iterable iterable) {
      this.chain.add(iterable);
   }

   public Iterator iterator() {
      return Iterables.concat(this.chain).iterator();
   }

   // $FF: synthetic method
   Store$IterableChain(Store$1 x0) {
      this();
   }

   // $FF: synthetic method
   static void access$100(Store$IterableChain x0, Iterable x1) {
      x0.addAll(x1);
   }
}
