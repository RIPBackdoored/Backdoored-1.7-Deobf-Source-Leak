package javassist.bytecode;

class CodeIterator$Lookup extends CodeIterator$Switcher {
   int[] matches;

   CodeIterator$Lookup(int pos, int defaultByte, int[] matches, int[] offsets, CodeIterator$Pointers ptrs) {
      super(pos, defaultByte, offsets, ptrs);
      this.matches = matches;
   }

   int write2(int dest, byte[] newcode) {
      int n = this.matches.length;
      ByteArray.write32bit(n, newcode, dest);
      dest += 4;

      for(int i = 0; i < n; ++i) {
         ByteArray.write32bit(this.matches[i], newcode, dest);
         ByteArray.write32bit(this.offsets[i], newcode, dest + 4);
         dest += 8;
      }

      return 4 + 8 * n;
   }

   int tableSize() {
      return 4 + 8 * this.matches.length;
   }
}
