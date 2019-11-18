package com.sun.jna;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class Native$3 implements InvocationHandler {
   // $FF: synthetic field
   final Library$Handler val$handler;
   // $FF: synthetic field
   final Library val$library;

   Native$3(Library$Handler var1, Library var2) {
      this.val$handler = var1;
      this.val$library = var2;
   }

   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Object var10000;
      synchronized(this.val$handler.getNativeLibrary()) {
         var10000 = this.val$handler.invoke(this.val$library, method, args);
      }

      return var10000;
   }
}
