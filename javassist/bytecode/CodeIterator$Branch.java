package javassist.bytecode;

abstract class CodeIterator$Branch {
   int pos;
   int orgPos;

   CodeIterator$Branch(int p) {
      this.pos = this.orgPos = p;
   }

   void shift(int where, int gapLength, boolean exclusive) {
      if (where < this.pos || where == this.pos && exclusive) {
         this.pos += gapLength;
      }

   }

   static int shiftOffset(int i, int offset, int where, int gapLength, boolean exclusive) {
      int target = i + offset;
      if (i < where) {
         if (where < target || exclusive && where == target) {
            offset += gapLength;
         }
      } else if (i == where) {
         if (target < where && exclusive) {
            offset -= gapLength;
         } else if (where < target && !exclusive) {
            offset += gapLength;
         }
      } else if (target < where || !exclusive && where == target) {
         offset -= gapLength;
      }

      return offset;
   }

   boolean expanded() {
      return false;
   }

   int gapChanged() {
      return 0;
   }

   int deltaSize() {
      return 0;
   }

   abstract int write(int var1, byte[] var2, int var3, byte[] var4) throws BadBytecode;
}
