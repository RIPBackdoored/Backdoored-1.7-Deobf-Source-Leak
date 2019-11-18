package com.sun.jna;

import com.sun.jna.win32.DLLCallback;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class CallbackReference extends WeakReference {
   static final Map callbackMap = new WeakHashMap();
   static final Map directCallbackMap = new WeakHashMap();
   static final Map pointerCallbackMap = new WeakHashMap();
   static final Map allocations = new WeakHashMap();
   private static final Map allocatedMemory = Collections.synchronizedMap(new WeakHashMap());
   private static final Method PROXY_CALLBACK_METHOD;
   private static final Map initializers;
   Pointer cbstruct;
   Pointer trampoline;
   CallbackProxy proxy;
   Method method;
   int callingConvention;

   static CallbackThreadInitializer setCallbackThreadInitializer(Callback cb, CallbackThreadInitializer initializer) {
      CallbackThreadInitializer var10000;
      synchronized(initializers) {
         if (initializer != null) {
            var10000 = (CallbackThreadInitializer)initializers.put(cb, initializer);
            return var10000;
         }

         var10000 = (CallbackThreadInitializer)initializers.remove(cb);
      }

      return var10000;
   }

   private static ThreadGroup initializeThread(Callback cb, CallbackReference$AttachOptions args) {
      CallbackThreadInitializer init = null;
      if (cb instanceof CallbackReference$DefaultCallbackProxy) {
         cb = ((CallbackReference$DefaultCallbackProxy)cb).getCallback();
      }

      synchronized(initializers) {
         init = (CallbackThreadInitializer)initializers.get(cb);
      }

      ThreadGroup group = null;
      if (init != null) {
         group = init.getThreadGroup(cb);
         args.name = init.getName(cb);
         args.daemon = init.isDaemon(cb);
         args.detach = init.detach(cb);
         args.write();
      }

      return group;
   }

   public static Callback getCallback(Class type, Pointer p) {
      return getCallback(type, p, false);
   }

   private static Callback getCallback(Class type, Pointer p, boolean direct) {
      if (p == null) {
         return null;
      } else if (!type.isInterface()) {
         throw new IllegalArgumentException("Callback type must be an interface");
      } else {
         Map map = direct ? directCallbackMap : callbackMap;
         Callback var10000;
         synchronized(pointerCallbackMap) {
            Callback cb = null;
            Reference ref = (Reference)pointerCallbackMap.get(p);
            if (ref == null) {
               int ctype = AltCallingConvention.class.isAssignableFrom(type) ? 63 : 0;
               Map foptions = new HashMap(Native.getLibraryOptions(type));
               foptions.put("invoking-method", getCallbackMethod(type));
               CallbackReference$NativeFunctionHandler h = new CallbackReference$NativeFunctionHandler(p, ctype, foptions);
               cb = (Callback)Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, h);
               map.remove(cb);
               pointerCallbackMap.put(p, new WeakReference(cb));
               var10000 = cb;
               return var10000;
            }

            cb = (Callback)ref.get();
            if (cb != null && !type.isAssignableFrom(cb.getClass())) {
               throw new IllegalStateException("Pointer " + p + " already mapped to " + cb + ".\nNative code may be re-using a default function pointer, in which case you may need to use a common Callback class wherever the function pointer is reused.");
            }

            var10000 = cb;
         }

         return var10000;
      }
   }

   private CallbackReference(Callback callback, int callingConvention, boolean direct) {
      super(callback);
      TypeMapper mapper = Native.getTypeMapper(callback.getClass());
      this.callingConvention = callingConvention;
      boolean ppc = Platform.isPPC();
      if (direct) {
         Method m = getCallbackMethod(callback);
         Class[] ptypes = m.getParameterTypes();

         for(int i = 0; i < ptypes.length; ++i) {
            if (ppc && (ptypes[i] == Float.TYPE || ptypes[i] == Double.TYPE)) {
               direct = false;
               break;
            }

            if (mapper != null && mapper.getFromNativeConverter(ptypes[i]) != null) {
               direct = false;
               break;
            }
         }

         if (mapper != null && mapper.getToNativeConverter(m.getReturnType()) != null) {
            direct = false;
         }
      }

      String encoding = Native.getStringEncoding(callback.getClass());
      long peer = 0L;
      Class[] nativeParamTypes;
      Class returnType;
      int flags;
      if (direct) {
         this.method = getCallbackMethod(callback);
         nativeParamTypes = this.method.getParameterTypes();
         returnType = this.method.getReturnType();
         flags = 1;
         if (callback instanceof DLLCallback) {
            flags |= 2;
         }

         peer = Native.createNativeCallback(callback, this.method, nativeParamTypes, returnType, callingConvention, flags, encoding);
      } else {
         if (callback instanceof CallbackProxy) {
            this.proxy = (CallbackProxy)callback;
         } else {
            this.proxy = new CallbackReference$DefaultCallbackProxy(this, getCallbackMethod(callback), mapper, encoding);
         }

         nativeParamTypes = this.proxy.getParameterTypes();
         returnType = this.proxy.getReturnType();
         if (mapper != null) {
            for(flags = 0; flags < nativeParamTypes.length; ++flags) {
               FromNativeConverter rc = mapper.getFromNativeConverter(nativeParamTypes[flags]);
               if (rc != null) {
                  nativeParamTypes[flags] = rc.nativeType();
               }
            }

            ToNativeConverter tn = mapper.getToNativeConverter(returnType);
            if (tn != null) {
               returnType = tn.nativeType();
            }
         }

         for(flags = 0; flags < nativeParamTypes.length; ++flags) {
            nativeParamTypes[flags] = this.getNativeType(nativeParamTypes[flags]);
            if (!isAllowableNativeType(nativeParamTypes[flags])) {
               String msg = "Callback argument " + nativeParamTypes[flags] + " requires custom type conversion";
               throw new IllegalArgumentException(msg);
            }
         }

         returnType = this.getNativeType(returnType);
         if (!isAllowableNativeType(returnType)) {
            String msg = "Callback return type " + returnType + " requires custom type conversion";
            throw new IllegalArgumentException(msg);
         }

         flags = callback instanceof DLLCallback ? 2 : 0;
         peer = Native.createNativeCallback(this.proxy, PROXY_CALLBACK_METHOD, nativeParamTypes, returnType, callingConvention, flags, encoding);
      }

      this.cbstruct = peer != 0L ? new Pointer(peer) : null;
      allocatedMemory.put(this, new WeakReference(this));
   }

   private Class getNativeType(Class cls) {
      if (Structure.class.isAssignableFrom(cls)) {
         Structure.validate(cls);
         if (!Structure$ByValue.class.isAssignableFrom(cls)) {
            return Pointer.class;
         }
      } else {
         if (NativeMapped.class.isAssignableFrom(cls)) {
            return NativeMappedConverter.getInstance(cls).nativeType();
         }

         if (cls == String.class || cls == WString.class || cls == String[].class || cls == WString[].class || Callback.class.isAssignableFrom(cls)) {
            return Pointer.class;
         }
      }

      return cls;
   }

   private static Method checkMethod(Method m) {
      if (m.getParameterTypes().length > 256) {
         String msg = "Method signature exceeds the maximum parameter count: " + m;
         throw new UnsupportedOperationException(msg);
      } else {
         return m;
      }
   }

   static Class findCallbackClass(Class type) {
      if (!Callback.class.isAssignableFrom(type)) {
         throw new IllegalArgumentException(type.getName() + " is not derived from com.sun.jna.Callback");
      } else if (type.isInterface()) {
         return type;
      } else {
         Class[] ifaces = type.getInterfaces();
         int i = 0;

         while(true) {
            if (i < ifaces.length) {
               label38: {
                  if (!Callback.class.isAssignableFrom(ifaces[i])) {
                     ++i;
                     continue;
                  }

                  Class var10000;
                  try {
                     getCallbackMethod(ifaces[i]);
                     var10000 = ifaces[i];
                  } catch (IllegalArgumentException var4) {
                     break label38;
                  }

                  return var10000;
               }
            }

            if (Callback.class.isAssignableFrom(type.getSuperclass())) {
               return findCallbackClass(type.getSuperclass());
            }

            return type;
         }
      }
   }

   private static Method getCallbackMethod(Callback callback) {
      return getCallbackMethod(findCallbackClass(callback.getClass()));
   }

   private static Method getCallbackMethod(Class cls) {
      Method[] pubMethods = cls.getDeclaredMethods();
      Method[] classMethods = cls.getMethods();
      Set pmethods = new HashSet(Arrays.asList(pubMethods));
      pmethods.retainAll(Arrays.asList(classMethods));
      Iterator i = pmethods.iterator();

      while(i.hasNext()) {
         Method m = (Method)i.next();
         if (Callback.FORBIDDEN_NAMES.contains(m.getName())) {
            i.remove();
         }
      }

      Method[] methods = (Method[])pmethods.toArray(new Method[pmethods.size()]);
      if (methods.length == 1) {
         return checkMethod(methods[0]);
      } else {
         for(int i = 0; i < methods.length; ++i) {
            Method m = methods[i];
            if ("callback".equals(m.getName())) {
               return checkMethod(m);
            }
         }

         String msg = "Callback must implement a single public method, or one public method named 'callback'";
         throw new IllegalArgumentException(msg);
      }
   }

   private void setCallbackOptions(int options) {
      this.cbstruct.setInt((long)Pointer.SIZE, options);
   }

   public Pointer getTrampoline() {
      if (this.trampoline == null) {
         this.trampoline = this.cbstruct.getPointer(0L);
      }

      return this.trampoline;
   }

   protected void finalize() {
      this.dispose();
   }

   protected synchronized void dispose() {
      if (this.cbstruct != null) {
         try {
            Native.freeNativeCallback(this.cbstruct.peer);
         } finally {
            this.cbstruct.peer = 0L;
            this.cbstruct = null;
            allocatedMemory.remove(this);
         }
      }

   }

   static void disposeAll() {
      Collection refs = new LinkedList(allocatedMemory.keySet());
      Iterator var1 = refs.iterator();

      while(var1.hasNext()) {
         CallbackReference r = (CallbackReference)var1.next();
         r.dispose();
      }

   }

   private Callback getCallback() {
      return (Callback)this.get();
   }

   private static Pointer getNativeFunctionPointer(Callback cb) {
      if (Proxy.isProxyClass(cb.getClass())) {
         Object handler = Proxy.getInvocationHandler(cb);
         if (handler instanceof CallbackReference$NativeFunctionHandler) {
            return ((CallbackReference$NativeFunctionHandler)handler).getPointer();
         }
      }

      return null;
   }

   public static Pointer getFunctionPointer(Callback cb) {
      return getFunctionPointer(cb, false);
   }

   private static Pointer getFunctionPointer(Callback cb, boolean direct) {
      Pointer fp = null;
      if (cb == null) {
         return null;
      } else if ((fp = getNativeFunctionPointer(cb)) != null) {
         return fp;
      } else {
         Map options = Native.getLibraryOptions(cb.getClass());
         int callingConvention = cb instanceof AltCallingConvention ? 63 : (options != null && options.containsKey("calling-convention") ? (Integer)options.get("calling-convention") : 0);
         Map map = direct ? directCallbackMap : callbackMap;
         Pointer var10000;
         synchronized(pointerCallbackMap) {
            CallbackReference cbref = (CallbackReference)map.get(cb);
            if (cbref == null) {
               cbref = new CallbackReference(cb, callingConvention, direct);
               map.put(cb, cbref);
               pointerCallbackMap.put(cbref.getTrampoline(), new WeakReference(cb));
               if (initializers.containsKey(cb)) {
                  cbref.setCallbackOptions(1);
               }
            }

            var10000 = cbref.getTrampoline();
         }

         return var10000;
      }
   }

   private static boolean isAllowableNativeType(Class cls) {
      return cls == Void.TYPE || cls == Void.class || cls == Boolean.TYPE || cls == Boolean.class || cls == Byte.TYPE || cls == Byte.class || cls == Short.TYPE || cls == Short.class || cls == Character.TYPE || cls == Character.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class || Structure$ByValue.class.isAssignableFrom(cls) && Structure.class.isAssignableFrom(cls) || Pointer.class.isAssignableFrom(cls);
   }

   private static Pointer getNativeString(Object value, boolean wide) {
      if (value != null) {
         NativeString ns = new NativeString(value.toString(), wide);
         allocations.put(value, ns);
         return ns.getPointer();
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static Callback access$000(CallbackReference x0) {
      return x0.getCallback();
   }

   // $FF: synthetic method
   static Pointer access$100(Object x0, boolean x1) {
      return getNativeString(x0, x1);
   }

   static {
      try {
         PROXY_CALLBACK_METHOD = CallbackProxy.class.getMethod("callback", Object[].class);
      } catch (Exception var1) {
         throw new Error("Error looking up CallbackProxy.callback() method");
      }

      initializers = new WeakHashMap();
   }
}
