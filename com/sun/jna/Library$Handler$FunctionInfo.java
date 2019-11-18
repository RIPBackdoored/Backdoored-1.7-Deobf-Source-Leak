package com.sun.jna;

import java.lang.reflect.InvocationHandler;
import java.util.Map;

final class Library$Handler$FunctionInfo {
   final InvocationHandler handler;
   final Function function;
   final boolean isVarArgs;
   final Map options;
   final Class[] parameterTypes;

   Library$Handler$FunctionInfo(InvocationHandler handler, Function function, Class[] parameterTypes, boolean isVarArgs, Map options) {
      this.handler = handler;
      this.function = function;
      this.isVarArgs = isVarArgs;
      this.options = options;
      this.parameterTypes = parameterTypes;
   }
}
