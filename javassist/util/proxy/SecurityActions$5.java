package javassist.util.proxy;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;

final class SecurityActions$5 implements PrivilegedAction {
   // $FF: synthetic field
   final AccessibleObject val$ao;
   // $FF: synthetic field
   final boolean val$accessible;

   SecurityActions$5(AccessibleObject var1, boolean var2) {
      this.val$ao = var1;
      this.val$accessible = var2;
   }

   public Object run() {
      this.val$ao.setAccessible(this.val$accessible);
      return null;
   }
}
