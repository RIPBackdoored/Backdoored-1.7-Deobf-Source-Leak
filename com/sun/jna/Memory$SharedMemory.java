package com.sun.jna;

class Memory$SharedMemory extends Memory {
   // $FF: synthetic field
   final Memory this$0;

   public Memory$SharedMemory(Memory var1, long offset, long size) {
      this.this$0 = var1;
      this.size = size;
      this.peer = var1.peer + offset;
   }

   protected void dispose() {
      this.peer = 0L;
   }

   protected void boundsCheck(long off, long sz) {
      this.this$0.boundsCheck(this.peer - this.this$0.peer + off, sz);
   }

   public String toString() {
      return super.toString() + " (shared from " + this.this$0.toString() + ")";
   }
}
