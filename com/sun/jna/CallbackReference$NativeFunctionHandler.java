package com.sun.jna;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

class CallbackReference$NativeFunctionHandler implements InvocationHandler {
   private final Function function;
   private final Map options;

   public CallbackReference$NativeFunctionHandler(Pointer address, int callingConvention, Map options) {
      this.options = options;
      this.function = new Function(address, callingConvention, (String)options.get("string-encoding"));
   }

   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if (Library$Handler.OBJECT_TOSTRING.equals(method)) {
         String str = "Proxy interface to " + this.function;
         Method m = (Method)this.options.get("invoking-method");
         Class cls = CallbackReference.findCallbackClass(m.getDeclaringClass());
         str = str + " (" + cls.getName() + ")";
         return str;
      } else if (Library$Handler.OBJECT_HASHCODE.equals(method)) {
         return this.hashCode();
      } else if (Library$Handler.OBJECT_EQUALS.equals(method)) {
         Object o = args[0];
         return o != null && Proxy.isProxyClass(o.getClass()) ? Function.valueOf(Proxy.getInvocationHandler(o) == this) : Boolean.FALSE;
      } else {
         if (Function.isVarArgs(method)) {
            args = Function.concatenateVarArgs(args);
         }

         return this.function.invoke(method.getReturnType(), args, this.options);
      }
   }

   public Pointer getPointer() {
      return this.function;
   }
}
