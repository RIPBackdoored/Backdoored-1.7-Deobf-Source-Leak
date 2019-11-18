package com.sun.jna;

import java.lang.reflect.Method;

abstract class VarArgsChecker {
   private VarArgsChecker() {
   }

   static VarArgsChecker create() {
      VarArgsChecker$NoVarArgsChecker var10000;
      try {
         Method isVarArgsMethod = Method.class.getMethod("isVarArgs");
         if (isVarArgsMethod != null) {
            VarArgsChecker$RealVarArgsChecker var3 = new VarArgsChecker$RealVarArgsChecker((VarArgsChecker$1)null);
            return var3;
         }

         var10000 = new VarArgsChecker$NoVarArgsChecker((VarArgsChecker$1)null);
      } catch (NoSuchMethodException var1) {
         return new VarArgsChecker$NoVarArgsChecker((VarArgsChecker$1)null);
      } catch (SecurityException var2) {
         return new VarArgsChecker$NoVarArgsChecker((VarArgsChecker$1)null);
      }

      return var10000;
   }

   abstract boolean isVarArgs(Method var1);

   abstract int fixedArgs(Method var1);

   // $FF: synthetic method
   VarArgsChecker(VarArgsChecker$1 x0) {
      this();
   }
}
