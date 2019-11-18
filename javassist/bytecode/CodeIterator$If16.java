package javassist.bytecode;

class CodeIterator$If16 extends CodeIterator$Branch16 {
   CodeIterator$If16(int p, int off) {
      super(p, off);
   }

   int deltaSize() {
      return this.state == 2 ? 5 : 0;
   }

   void write32(int src, byte[] code, int dest, byte[] newcode) {
      newcode[dest] = (byte)this.opcode(code[src] & 255);
      newcode[dest + 1] = 0;
      newcode[dest + 2] = 8;
      newcode[dest + 3] = -56;
      ByteArray.write32bit(this.offset - 3, newcode, dest + 4);
   }

   int opcode(int op) {
      if (op == 198) {
         return 199;
      } else if (op == 199) {
         return 198;
      } else {
         return (op - 153 & 1) == 0 ? op + 1 : op - 1;
      }
   }
}
