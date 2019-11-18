package net.jodah.typetools;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class TypeResolver$1 implements PrivilegedExceptionAction {
   public Unsafe run() throws Exception {
      Field f = Unsafe.class.getDeclaredField("theUnsafe");
      f.setAccessible(true);
      return (Unsafe)f.get((Object)null);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object run() throws Exception {
      return this.run();
   }
}
