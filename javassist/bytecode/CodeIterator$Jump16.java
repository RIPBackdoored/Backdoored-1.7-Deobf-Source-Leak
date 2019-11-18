package javassist.bytecode;

class CodeIterator$Jump16 extends CodeIterator$Branch16 {
   CodeIterator$Jump16(int p, int off) {
      super(p, off);
   }

   int deltaSize() {
      return this.state == 2 ? 2 : 0;
   }

   void write32(int src, byte[] code, int dest, byte[] newcode) {
      newcode[dest] = (byte)((code[src] & 255) == 167 ? 200 : 201);
      ByteArray.write32bit(this.offset, newcode, dest + 1);
   }
}
