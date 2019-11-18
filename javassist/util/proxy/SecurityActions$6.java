package javassist.util.proxy;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;

final class SecurityActions$6 implements PrivilegedExceptionAction {
   // $FF: synthetic field
   final Field val$fld;
   // $FF: synthetic field
   final Object val$target;
   // $FF: synthetic field
   final Object val$value;

   SecurityActions$6(Field var1, Object var2, Object var3) {
      this.val$fld = var1;
      this.val$target = var2;
      this.val$value = var3;
   }

   public Object run() throws Exception {
      this.val$fld.set(this.val$target, this.val$value);
      return null;
   }
}
