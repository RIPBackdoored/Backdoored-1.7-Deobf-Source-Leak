package com.sun.jna;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;

final class Native$4 implements PrivilegedAction {
   public Method run() {
      Method var10000;
      try {
         Method m = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
         m.setAccessible(true);
         var10000 = m;
      } catch (Exception var2) {
         return null;
      }

      return var10000;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object run() {
      return this.run();
   }
}
