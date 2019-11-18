package com.sun.jna;

class Function$NativeMappedArray extends Memory implements Function$PostCallRead {
   private final NativeMapped[] original;

   public Function$NativeMappedArray(NativeMapped[] arg) {
      super((long)Native.getNativeSize(arg.getClass(), arg));
      this.original = arg;
      this.setValue(0L, this.original, this.original.getClass());
   }

   public void read() {
      this.getValue(0L, this.original.getClass(), this.original);
   }
}
