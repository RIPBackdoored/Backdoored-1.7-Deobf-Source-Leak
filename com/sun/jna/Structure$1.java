package com.sun.jna;

import java.util.HashMap;
import java.util.Map;

final class Structure$1 extends ThreadLocal {
   protected synchronized Map initialValue() {
      return new HashMap();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object initialValue() {
      return this.initialValue();
   }
}
