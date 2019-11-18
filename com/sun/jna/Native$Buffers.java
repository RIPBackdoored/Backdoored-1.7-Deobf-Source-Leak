package com.sun.jna;

import java.nio.Buffer;

class Native$Buffers {
   private Native$Buffers() {
   }

   static boolean isBuffer(Class cls) {
      return Buffer.class.isAssignableFrom(cls);
   }
}
