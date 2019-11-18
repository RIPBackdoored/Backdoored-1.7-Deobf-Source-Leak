package javassist.bytecode;

class CodeIterator$Jump32 extends CodeIterator$Branch {
   int offset;

   CodeIterator$Jump32(int p, int off) {
      super(p);
      this.offset = off;
   }

   void shift(int where, int gapLength, boolean exclusive) {
      this.offset = shiftOffset(this.pos, this.offset, where, gapLength, exclusive);
      super.shift(where, gapLength, exclusive);
   }

   int write(int src, byte[] code, int dest, byte[] newcode) {
      newcode[dest] = code[src];
      ByteArray.write32bit(this.offset, newcode, dest + 1);
      return 5;
   }
}
