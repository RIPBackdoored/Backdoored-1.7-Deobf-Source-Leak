package com.sun.jna;

class Structure$AutoAllocated extends Memory {
   public Structure$AutoAllocated(int size) {
      super((long)size);
      super.clear();
   }

   public String toString() {
      return "auto-" + super.toString();
   }
}
