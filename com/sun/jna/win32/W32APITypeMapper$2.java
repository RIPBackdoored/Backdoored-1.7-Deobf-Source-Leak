package com.sun.jna.win32;

import com.sun.jna.FromNativeContext;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;

class W32APITypeMapper$2 implements TypeConverter {
   // $FF: synthetic field
   final W32APITypeMapper this$0;

   W32APITypeMapper$2(W32APITypeMapper this$0) {
      this.this$0 = this$0;
   }

   public Object toNative(Object value, ToNativeContext context) {
      return Boolean.TRUE.equals(value) ? 1 : 0;
   }

   public Object fromNative(Object value, FromNativeContext context) {
      return (Integer)value != 0 ? Boolean.TRUE : Boolean.FALSE;
   }

   public Class nativeType() {
      return Integer.class;
   }
}
