package javassist.util.proxy;

import java.io.Serializable;
import java.lang.reflect.Method;

class RuntimeSupport$DefaultMethodHandler implements MethodHandler, Serializable {
   public Object invoke(Object self, Method m, Method proceed, Object[] args) throws Exception {
      return proceed.invoke(self, args);
   }
}
