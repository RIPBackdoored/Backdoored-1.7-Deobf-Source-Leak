package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;

final class SecurityActions$3 implements PrivilegedExceptionAction {
   // $FF: synthetic field
   final Class val$clazz;
   // $FF: synthetic field
   final String val$name;
   // $FF: synthetic field
   final Class[] val$types;

   SecurityActions$3(Class var1, String var2, Class[] var3) {
      this.val$clazz = var1;
      this.val$name = var2;
      this.val$types = var3;
   }

   public Object run() throws Exception {
      return this.val$clazz.getDeclaredMethod(this.val$name, this.val$types);
   }
}
