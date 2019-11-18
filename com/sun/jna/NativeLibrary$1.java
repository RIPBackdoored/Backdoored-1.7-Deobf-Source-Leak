package com.sun.jna;

import java.lang.reflect.Method;
import java.util.Map;

class NativeLibrary$1 extends Function {
   // $FF: synthetic field
   final NativeLibrary this$0;

   NativeLibrary$1(NativeLibrary this$0, NativeLibrary library, String functionName, int callFlags, String encoding) {
      super(library, functionName, callFlags, encoding);
      this.this$0 = this$0;
   }

   Object invoke(Object[] args, Class returnType, boolean b, int fixedArgs) {
      return Native.getLastError();
   }

   Object invoke(Method invokingMethod, Class[] paramTypes, Class returnType, Object[] inArgs, Map options) {
      return Native.getLastError();
   }
}
