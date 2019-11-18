package com.sun.jna;

final class Native$7 extends ThreadLocal {
   protected Memory initialValue() {
      Memory m = new Memory(4L);
      m.clear();
      return m;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object initialValue() {
      return this.initialValue();
   }
}
