package com.google.api.client.util.escape;

final class Platform$1 extends ThreadLocal {
   protected char[] initialValue() {
      return new char[1024];
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object initialValue() {
      return this.initialValue();
   }
}
