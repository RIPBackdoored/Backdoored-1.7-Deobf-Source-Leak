package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@GwtCompatible(
   emulated = true
)
public final class Enums {
   @GwtIncompatible
   private static final Map enumConstantCache = new WeakHashMap();

   private Enums() {
   }

   @GwtIncompatible
   public static Field getField(Enum enumValue) {
      Class clazz = enumValue.getDeclaringClass();

      Field var10000;
      try {
         var10000 = clazz.getDeclaredField(enumValue.name());
      } catch (NoSuchFieldException var3) {
         throw new AssertionError(var3);
      }

      return var10000;
   }

   public static Optional getIfPresent(Class enumClass, String value) {
      Preconditions.checkNotNull(enumClass);
      Preconditions.checkNotNull(value);
      return Platform.getEnumIfPresent(enumClass, value);
   }

   @GwtIncompatible
   private static Map populateCache(Class enumClass) {
      Map result = new HashMap();
      Iterator i$ = EnumSet.allOf(enumClass).iterator();

      while(i$.hasNext()) {
         Enum enumInstance = (Enum)i$.next();
         result.put(enumInstance.name(), new WeakReference(enumInstance));
      }

      enumConstantCache.put(enumClass, result);
      return result;
   }

   @GwtIncompatible
   static Map getEnumConstants(Class enumClass) {
      Map var10000;
      synchronized(enumConstantCache) {
         Map constants = (Map)enumConstantCache.get(enumClass);
         if (constants == null) {
            constants = populateCache(enumClass);
         }

         var10000 = constants;
      }

      return var10000;
   }

   public static Converter stringConverter(Class enumClass) {
      return new Enums$StringConverter(enumClass);
   }
}
