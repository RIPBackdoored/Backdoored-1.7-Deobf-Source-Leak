package javassist.scopedpool;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class SoftValueHashMap$SoftValueRef extends SoftReference {
   public Object key;

   private SoftValueHashMap$SoftValueRef(Object key, Object val, ReferenceQueue q) {
      super(val, q);
      this.key = key;
   }

   private static SoftValueHashMap$SoftValueRef create(Object key, Object val, ReferenceQueue q) {
      return val == null ? null : new SoftValueHashMap$SoftValueRef(key, val, q);
   }

   // $FF: synthetic method
   static SoftValueHashMap$SoftValueRef access$000(Object x0, Object x1, ReferenceQueue x2) {
      return create(x0, x1, x2);
   }
}
