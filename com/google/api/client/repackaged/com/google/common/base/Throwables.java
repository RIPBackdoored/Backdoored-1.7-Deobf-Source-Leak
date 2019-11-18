package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Throwables {
   @GwtIncompatible
   private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
   @GwtIncompatible
   @VisibleForTesting
   static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
   @Nullable
   @GwtIncompatible
   private static final Object jla = getJLA();
   @Nullable
   @GwtIncompatible
   private static final Method getStackTraceElementMethod;
   @Nullable
   @GwtIncompatible
   private static final Method getStackTraceDepthMethod;

   private Throwables() {
   }

   @GwtIncompatible
   public static void throwIfInstanceOf(Throwable throwable, Class declaredType) throws Throwable {
      Preconditions.checkNotNull(throwable);
      if (declaredType.isInstance(throwable)) {
         throw (Throwable)declaredType.cast(throwable);
      }
   }

   /** @deprecated */
   @Deprecated
   @GwtIncompatible
   public static void propagateIfInstanceOf(@Nullable Throwable throwable, Class declaredType) throws Throwable {
      if (throwable != null) {
         throwIfInstanceOf(throwable, declaredType);
      }

   }

   public static void throwIfUnchecked(Throwable throwable) {
      Preconditions.checkNotNull(throwable);
      if (throwable instanceof RuntimeException) {
         throw (RuntimeException)throwable;
      } else if (throwable instanceof Error) {
         throw (Error)throwable;
      }
   }

   /** @deprecated */
   @Deprecated
   @GwtIncompatible
   public static void propagateIfPossible(@Nullable Throwable throwable) {
      if (throwable != null) {
         throwIfUnchecked(throwable);
      }

   }

   @GwtIncompatible
   public static void propagateIfPossible(@Nullable Throwable throwable, Class declaredType) throws Throwable {
      propagateIfInstanceOf(throwable, declaredType);
      propagateIfPossible(throwable);
   }

   @GwtIncompatible
   public static void propagateIfPossible(@Nullable Throwable throwable, Class declaredType1, Class declaredType2) throws Throwable, Throwable {
      Preconditions.checkNotNull(declaredType2);
      propagateIfInstanceOf(throwable, declaredType1);
      propagateIfPossible(throwable, declaredType2);
   }

   /** @deprecated */
   @Deprecated
   @CanIgnoreReturnValue
   @GwtIncompatible
   public static RuntimeException propagate(Throwable throwable) {
      throwIfUnchecked(throwable);
      throw new RuntimeException(throwable);
   }

   public static Throwable getRootCause(Throwable throwable) {
      Throwable cause;
      while((cause = throwable.getCause()) != null) {
         throwable = cause;
      }

      return throwable;
   }

   @Beta
   public static List getCausalChain(Throwable throwable) {
      Preconditions.checkNotNull(throwable);

      ArrayList causes;
      for(causes = new ArrayList(4); throwable != null; throwable = throwable.getCause()) {
         causes.add(throwable);
      }

      return Collections.unmodifiableList(causes);
   }

   @GwtIncompatible
   public static String getStackTraceAsString(Throwable throwable) {
      StringWriter stringWriter = new StringWriter();
      throwable.printStackTrace(new PrintWriter(stringWriter));
      return stringWriter.toString();
   }

   @Beta
   @GwtIncompatible
   public static List lazyStackTrace(Throwable throwable) {
      return lazyStackTraceIsLazy() ? jlaStackTrace(throwable) : Collections.unmodifiableList(Arrays.asList(throwable.getStackTrace()));
   }

   @Beta
   @GwtIncompatible
   public static boolean lazyStackTraceIsLazy() {
      return getStackTraceElementMethod != null & getStackTraceDepthMethod != null;
   }

   @GwtIncompatible
   private static List jlaStackTrace(Throwable t) {
      Preconditions.checkNotNull(t);
      return new Throwables$1(t);
   }

   @GwtIncompatible
   private static Object invokeAccessibleNonThrowingMethod(Method method, Object receiver, Object... params) {
      Object var10000;
      try {
         var10000 = method.invoke(receiver, params);
      } catch (IllegalAccessException var4) {
         throw new RuntimeException(var4);
      } catch (InvocationTargetException var5) {
         throw propagate(var5.getCause());
      }

      return var10000;
   }

   @Nullable
   @GwtIncompatible
   private static Object getJLA() {
      Object var10000;
      try {
         Class sharedSecrets = Class.forName("sun.misc.SharedSecrets", false, (ClassLoader)null);
         Method langAccess = sharedSecrets.getMethod("getJavaLangAccess");
         var10000 = langAccess.invoke((Object)null);
      } catch (ThreadDeath var2) {
         throw var2;
      } catch (Throwable var3) {
         return null;
      }

      return var10000;
   }

   @Nullable
   @GwtIncompatible
   private static Method getGetMethod() {
      return getJlaMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
   }

   @Nullable
   @GwtIncompatible
   private static Method getSizeMethod() {
      return getJlaMethod("getStackTraceDepth", Throwable.class);
   }

   @Nullable
   @GwtIncompatible
   private static Method getJlaMethod(String name, Class... parameterTypes) throws ThreadDeath {
      Method var10000;
      try {
         var10000 = Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader)null).getMethod(name, parameterTypes);
      } catch (ThreadDeath var3) {
         throw var3;
      } catch (Throwable var4) {
         return null;
      }

      return var10000;
   }

   // $FF: synthetic method
   static Method access$000() {
      return getStackTraceElementMethod;
   }

   // $FF: synthetic method
   static Object access$100() {
      return jla;
   }

   // $FF: synthetic method
   static Object access$200(Method x0, Object x1, Object[] x2) {
      return invokeAccessibleNonThrowingMethod(x0, x1, x2);
   }

   // $FF: synthetic method
   static Method access$300() {
      return getStackTraceDepthMethod;
   }

   static {
      getStackTraceElementMethod = jla == null ? null : getGetMethod();
      getStackTraceDepthMethod = jla == null ? null : getSizeMethod();
   }
}
