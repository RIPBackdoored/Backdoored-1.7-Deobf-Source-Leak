package com.sun.jna;

import java.lang.reflect.Method;

final class VarArgsChecker$NoVarArgsChecker extends VarArgsChecker {
   private VarArgsChecker$NoVarArgsChecker() {
      super((VarArgsChecker$1)null);
   }

   boolean isVarArgs(Method m) {
      return false;
   }

   int fixedArgs(Method m) {
      return 0;
   }

   // $FF: synthetic method
   VarArgsChecker$NoVarArgsChecker(VarArgsChecker$1 x0) {
      this();
   }
}
