package javassist.util.proxy;

import java.security.PrivilegedAction;

final class SecurityActions$2 implements PrivilegedAction {
   // $FF: synthetic field
   final Class val$clazz;

   SecurityActions$2(Class var1) {
      this.val$clazz = var1;
   }

   public Object run() {
      return this.val$clazz.getDeclaredConstructors();
   }
}
