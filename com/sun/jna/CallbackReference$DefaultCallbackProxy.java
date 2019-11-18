package com.sun.jna;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CallbackReference$DefaultCallbackProxy implements CallbackProxy {
   private final Method callbackMethod;
   private ToNativeConverter toNative;
   private final FromNativeConverter[] fromNative;
   private final String encoding;
   // $FF: synthetic field
   final CallbackReference this$0;

   public CallbackReference$DefaultCallbackProxy(CallbackReference var1, Method callbackMethod, TypeMapper mapper, String encoding) {
      this.this$0 = var1;
      this.callbackMethod = callbackMethod;
      this.encoding = encoding;
      Class[] argTypes = callbackMethod.getParameterTypes();
      Class returnType = callbackMethod.getReturnType();
      this.fromNative = new FromNativeConverter[argTypes.length];
      if (NativeMapped.class.isAssignableFrom(returnType)) {
         this.toNative = NativeMappedConverter.getInstance(returnType);
      } else if (mapper != null) {
         this.toNative = mapper.getToNativeConverter(returnType);
      }

      for(int i = 0; i < this.fromNative.length; ++i) {
         if (NativeMapped.class.isAssignableFrom(argTypes[i])) {
            this.fromNative[i] = new NativeMappedConverter(argTypes[i]);
         } else if (mapper != null) {
            this.fromNative[i] = mapper.getFromNativeConverter(argTypes[i]);
         }
      }

      if (!callbackMethod.isAccessible()) {
         try {
            callbackMethod.setAccessible(true);
         } catch (SecurityException var8) {
            throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + callbackMethod);
         }
      }

   }

   public Callback getCallback() {
      return CallbackReference.access$000(this.this$0);
   }

   private Object invokeCallback(Object[] args) {
      Class[] paramTypes = this.callbackMethod.getParameterTypes();
      Object[] callbackArgs = new Object[args.length];

      for(int i = 0; i < args.length; ++i) {
         Class type = paramTypes[i];
         Object arg = args[i];
         if (this.fromNative[i] != null) {
            FromNativeContext context = new CallbackParameterContext(type, this.callbackMethod, args, i);
            callbackArgs[i] = this.fromNative[i].fromNative(arg, context);
         } else {
            callbackArgs[i] = this.convertArgument(arg, type);
         }
      }

      Object result = null;
      Callback cb = this.getCallback();
      if (cb != null) {
         try {
            result = this.convertResult(this.callbackMethod.invoke(cb, callbackArgs));
         } catch (IllegalArgumentException var8) {
            Native.getCallbackExceptionHandler().uncaughtException(cb, var8);
         } catch (IllegalAccessException var9) {
            Native.getCallbackExceptionHandler().uncaughtException(cb, var9);
         } catch (InvocationTargetException var10) {
            Native.getCallbackExceptionHandler().uncaughtException(cb, var10.getTargetException());
         }
      }

      for(int i = 0; i < callbackArgs.length; ++i) {
         if (callbackArgs[i] instanceof Structure && !(callbackArgs[i] instanceof Structure$ByValue)) {
            ((Structure)callbackArgs[i]).autoWrite();
         }
      }

      return result;
   }

   public Object callback(Object[] args) {
      Object var10000;
      try {
         var10000 = this.invokeCallback(args);
      } catch (Throwable var3) {
         Native.getCallbackExceptionHandler().uncaughtException(this.getCallback(), var3);
         return null;
      }

      return var10000;
   }

   private Object convertArgument(Object value, Class dstType) {
      if (value instanceof Pointer) {
         if (dstType == String.class) {
            value = ((Pointer)value).getString(0L, this.encoding);
         } else if (dstType == WString.class) {
            value = new WString(((Pointer)value).getWideString(0L));
         } else if (dstType == String[].class) {
            value = ((Pointer)value).getStringArray(0L, this.encoding);
         } else if (dstType == WString[].class) {
            value = ((Pointer)value).getWideStringArray(0L);
         } else if (Callback.class.isAssignableFrom(dstType)) {
            value = CallbackReference.getCallback(dstType, (Pointer)value);
         } else if (Structure.class.isAssignableFrom(dstType)) {
            Structure s;
            if (Structure$ByValue.class.isAssignableFrom(dstType)) {
               s = Structure.newInstance(dstType);
               byte[] buf = new byte[s.size()];
               ((Pointer)value).read(0L, (byte[])buf, 0, buf.length);
               s.getPointer().write(0L, (byte[])buf, 0, buf.length);
               s.read();
               value = s;
            } else {
               s = Structure.newInstance(dstType, (Pointer)value);
               s.conditionalAutoRead();
               value = s;
            }
         }
      } else if ((Boolean.TYPE == dstType || Boolean.class == dstType) && value instanceof Number) {
         value = Function.valueOf(((Number)value).intValue() != 0);
      }

      return value;
   }

   private Object convertResult(Object value) {
      if (this.toNative != null) {
         value = this.toNative.toNative(value, new CallbackResultContext(this.callbackMethod));
      }

      if (value == null) {
         return null;
      } else {
         Class cls = value.getClass();
         if (Structure.class.isAssignableFrom(cls)) {
            return Structure$ByValue.class.isAssignableFrom(cls) ? value : ((Structure)value).getPointer();
         } else if (cls != Boolean.TYPE && cls != Boolean.class) {
            if (cls != String.class && cls != WString.class) {
               if (cls != String[].class && cls != WString.class) {
                  return Callback.class.isAssignableFrom(cls) ? CallbackReference.getFunctionPointer((Callback)value) : value;
               } else {
                  StringArray sa = cls == String[].class ? new StringArray((String[])((String[])value), this.encoding) : new StringArray((WString[])((WString[])value));
                  CallbackReference.allocations.put(value, sa);
                  return sa;
               }
            } else {
               return CallbackReference.access$100(value, cls == WString.class);
            }
         } else {
            return Boolean.TRUE.equals(value) ? Function.INTEGER_TRUE : Function.INTEGER_FALSE;
         }
      }
   }

   public Class[] getParameterTypes() {
      return this.callbackMethod.getParameterTypes();
   }

   public Class getReturnType() {
      return this.callbackMethod.getReturnType();
   }
}
