package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;

final class SecurityActions$4 implements PrivilegedExceptionAction {
   // $FF: synthetic field
   final Class val$clazz;
   // $FF: synthetic field
   final Class[] val$types;

   SecurityActions$4(Class var1, Class[] var2) {
      this.val$clazz = var1;
      this.val$types = var2;
   }

   public Object run() throws Exception {
      return this.val$clazz.getDeclaredConstructor(this.val$types);
   }
}
