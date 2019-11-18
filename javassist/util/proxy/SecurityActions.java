package javassist.util.proxy;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;

class SecurityActions {
   static Method[] getDeclaredMethods(Class clazz) {
      return System.getSecurityManager() == null ? clazz.getDeclaredMethods() : (Method[])((Method[])AccessController.doPrivileged(new SecurityActions$1(clazz)));
   }

   static Constructor[] getDeclaredConstructors(Class clazz) {
      return System.getSecurityManager() == null ? clazz.getDeclaredConstructors() : (Constructor[])((Constructor[])AccessController.doPrivileged(new SecurityActions$2(clazz)));
   }

   static Method getDeclaredMethod(Class clazz, String name, Class[] types) throws NoSuchMethodException {
      if (System.getSecurityManager() == null) {
         return clazz.getDeclaredMethod(name, types);
      } else {
         Method var10000;
         try {
            var10000 = (Method)AccessController.doPrivileged(new SecurityActions$3(clazz, name, types));
         } catch (PrivilegedActionException var4) {
            if (var4.getCause() instanceof NoSuchMethodException) {
               throw (NoSuchMethodException)var4.getCause();
            }

            throw new RuntimeException(var4.getCause());
         }

         return var10000;
      }
   }

   static Constructor getDeclaredConstructor(Class clazz, Class[] types) throws NoSuchMethodException {
      if (System.getSecurityManager() == null) {
         return clazz.getDeclaredConstructor(types);
      } else {
         Constructor var10000;
         try {
            var10000 = (Constructor)AccessController.doPrivileged(new SecurityActions$4(clazz, types));
         } catch (PrivilegedActionException var3) {
            if (var3.getCause() instanceof NoSuchMethodException) {
               throw (NoSuchMethodException)var3.getCause();
            }

            throw new RuntimeException(var3.getCause());
         }

         return var10000;
      }
   }

   static void setAccessible(AccessibleObject ao, boolean accessible) {
      if (System.getSecurityManager() == null) {
         ao.setAccessible(accessible);
      } else {
         AccessController.doPrivileged(new SecurityActions$5(ao, accessible));
      }

   }

   static void set(Field fld, Object target, Object value) throws IllegalAccessException {
      if (System.getSecurityManager() == null) {
         fld.set(target, value);
      } else {
         try {
            AccessController.doPrivileged(new SecurityActions$6(fld, target, value));
         } catch (PrivilegedActionException var4) {
            if (var4.getCause() instanceof NoSuchMethodException) {
               throw (IllegalAccessException)var4.getCause();
            }

            throw new RuntimeException(var4.getCause());
         }
      }

   }
}
