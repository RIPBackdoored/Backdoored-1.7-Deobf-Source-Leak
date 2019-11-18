package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;

class SerializedProxy$1 implements PrivilegedExceptionAction {
   // $FF: synthetic field
   final String val$className;
   // $FF: synthetic field
   final SerializedProxy this$0;

   SerializedProxy$1(SerializedProxy this$0, String var2) {
      this.this$0 = this$0;
      this.val$className = var2;
   }

   public Object run() throws Exception {
      ClassLoader cl = Thread.currentThread().getContextClassLoader();
      return Class.forName(this.val$className, true, cl);
   }
}
