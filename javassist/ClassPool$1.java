package javassist;

import java.net.URL;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;

final class ClassPool$1 implements PrivilegedExceptionAction {
   public Object run() throws Exception {
      Class cl = Class.forName("java.lang.ClassLoader");
      ClassPool.access$002(cl.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE));
      ClassPool.access$102(cl.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class));
      ClassPool.access$202(cl.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class));
      return null;
   }
}
