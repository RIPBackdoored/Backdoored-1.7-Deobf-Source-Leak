package com.sun.jna;

import java.util.Set;

final class Structure$2 extends ThreadLocal {
   protected synchronized Set initialValue() {
      return new Structure$StructureSet();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object initialValue() {
      return this.initialValue();
   }
}
