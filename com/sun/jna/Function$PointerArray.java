package com.sun.jna;

class Function$PointerArray extends Memory implements Function$PostCallRead {
   private final Pointer[] original;

   public Function$PointerArray(Pointer[] arg) {
      super((long)(Pointer.SIZE * (arg.length + 1)));
      this.original = arg;

      for(int i = 0; i < arg.length; ++i) {
         this.setPointer((long)(i * Pointer.SIZE), arg[i]);
      }

      this.setPointer((long)(Pointer.SIZE * arg.length), (Pointer)null);
   }

   public void read() {
      this.read(0L, this.original, 0, this.original.length);
   }
}
