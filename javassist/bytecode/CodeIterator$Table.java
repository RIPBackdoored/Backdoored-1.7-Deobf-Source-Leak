package javassist.bytecode;

class CodeIterator$Table extends CodeIterator$Switcher {
   int low;
   int high;

   CodeIterator$Table(int pos, int defaultByte, int low, int high, int[] offsets, CodeIterator$Pointers ptrs) {
      super(pos, defaultByte, offsets, ptrs);
      this.low = low;
      this.high = high;
   }

   int write2(int dest, byte[] newcode) {
      ByteArray.write32bit(this.low, newcode, dest);
      ByteArray.write32bit(this.high, newcode, dest + 4);
      int n = this.offsets.length;
      dest += 8;

      for(int i = 0; i < n; ++i) {
         ByteArray.write32bit(this.offsets[i], newcode, dest);
         dest += 4;
      }

      return 8 + 4 * n;
   }

   int tableSize() {
      return 8 + 4 * this.offsets.length;
   }
}
