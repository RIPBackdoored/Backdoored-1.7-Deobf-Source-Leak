package com.sun.jna;

import java.lang.reflect.Method;

final class VarArgsChecker$RealVarArgsChecker extends VarArgsChecker {
   private VarArgsChecker$RealVarArgsChecker() {
      super((VarArgsChecker$1)null);
   }

   boolean isVarArgs(Method m) {
      return m.isVarArgs();
   }

   int fixedArgs(Method m) {
      return m.isVarArgs() ? m.getParameterTypes().length - 1 : 0;
   }

   // $FF: synthetic method
   VarArgsChecker$RealVarArgsChecker(VarArgsChecker$1 x0) {
      this();
   }
}
