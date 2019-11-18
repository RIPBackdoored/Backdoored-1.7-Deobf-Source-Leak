package javassist.bytecode;

abstract class CodeIterator$Branch16 extends CodeIterator$Branch {
   int offset;
   int state;
   static final int BIT16 = 0;
   static final int EXPAND = 1;
   static final int BIT32 = 2;

   CodeIterator$Branch16(int p, int off) {
      super(p);
      this.offset = off;
      this.state = 0;
   }

   void shift(int where, int gapLength, boolean exclusive) {
      this.offset = shiftOffset(this.pos, this.offset, where, gapLength, exclusive);
      super.shift(where, gapLength, exclusive);
      if (this.state == 0 && (this.offset < -32768 || 32767 < this.offset)) {
         this.state = 1;
      }

   }

   boolean expanded() {
      if (this.state == 1) {
         this.state = 2;
         return true;
      } else {
         return false;
      }
   }

   abstract int deltaSize();

   abstract void write32(int var1, byte[] var2, int var3, byte[] var4);

   int write(int src, byte[] code, int dest, byte[] newcode) {
      if (this.state == 2) {
         this.write32(src, code, dest, newcode);
      } else {
         newcode[dest] = code[src];
         ByteArray.write16bit(this.offset, newcode, dest + 1);
      }

      return 3;
   }
}
