package org.reflections;

import com.google.common.base.Supplier;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Store$1 implements Supplier {
   // $FF: synthetic field
   final Store this$0;

   Store$1(Store this$0) {
      this.this$0 = this$0;
   }

   public Set get() {
      return Sets.newSetFromMap(new ConcurrentHashMap());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object get() {
      return this.get();
   }
}
