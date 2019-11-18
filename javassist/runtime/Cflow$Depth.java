package javassist.runtime;

class Cflow$Depth {
   private int depth = 0;

   int get() {
      return this.depth;
   }

   void inc() {
      ++this.depth;
   }

   void dec() {
      --this.depth;
   }
}
