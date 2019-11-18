package com.sun.jna.win32;

import com.sun.jna.FromNativeContext;
import com.sun.jna.StringArray;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;
import com.sun.jna.WString;

class W32APITypeMapper$1 implements TypeConverter {
   // $FF: synthetic field
   final W32APITypeMapper this$0;

   W32APITypeMapper$1(W32APITypeMapper this$0) {
      this.this$0 = this$0;
   }

   public Object toNative(Object value, ToNativeContext context) {
      if (value == null) {
         return null;
      } else {
         return value instanceof String[] ? new StringArray((String[])((String[])value), true) : new WString(value.toString());
      }
   }

   public Object fromNative(Object value, FromNativeContext context) {
      return value == null ? null : value.toString();
   }

   public Class nativeType() {
      return WString.class;
   }
}
