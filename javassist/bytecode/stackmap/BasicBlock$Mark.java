package javassist.bytecode.stackmap;

class BasicBlock$Mark implements Comparable {
   int position;
   BasicBlock block;
   BasicBlock[] jump;
   boolean alwaysJmp;
   int size;
   BasicBlock$Catch catcher;

   BasicBlock$Mark(int p) {
      this.position = p;
      this.block = null;
      this.jump = null;
      this.alwaysJmp = false;
      this.size = 0;
      this.catcher = null;
   }

   public int compareTo(Object obj) {
      if (obj instanceof BasicBlock$Mark) {
         int pos = ((BasicBlock$Mark)obj).position;
         return this.position - pos;
      } else {
         return -1;
      }
   }

   void setJump(BasicBlock[] bb, int s, boolean always) {
      this.jump = bb;
      this.size = s;
      this.alwaysJmp = always;
   }
}
