package com.google.api.client.util.escape;

final class Platform {
   private static final ThreadLocal DEST_TL = new Platform$1();

   private Platform() {
   }

   static char[] charBufferFromThreadLocal() {
      return (char[])DEST_TL.get();
   }
}
