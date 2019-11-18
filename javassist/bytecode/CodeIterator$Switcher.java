package javassist.bytecode;

abstract class CodeIterator$Switcher extends CodeIterator$Branch {
   int gap;
   int defaultByte;
   int[] offsets;
   CodeIterator$Pointers pointers;

   CodeIterator$Switcher(int pos, int defaultByte, int[] offsets, CodeIterator$Pointers ptrs) {
      super(pos);
      this.gap = 3 - (pos & 3);
      this.defaultByte = defaultByte;
      this.offsets = offsets;
      this.pointers = ptrs;
   }

   void shift(int where, int gapLength, boolean exclusive) {
      int p = this.pos;
      this.defaultByte = shiftOffset(p, this.defaultByte, where, gapLength, exclusive);
      int num = this.offsets.length;

      for(int i = 0; i < num; ++i) {
         this.offsets[i] = shiftOffset(p, this.offsets[i], where, gapLength, exclusive);
      }

      super.shift(where, gapLength, exclusive);
   }

   int gapChanged() {
      int newGap = 3 - (this.pos & 3);
      if (newGap > this.gap) {
         int diff = newGap - this.gap;
         this.gap = newGap;
         return diff;
      } else {
         return 0;
      }
   }

   int deltaSize() {
      return this.gap - (3 - (this.orgPos & 3));
   }

   int write(int src, byte[] code, int dest, byte[] newcode) throws BadBytecode {
      int padding = 3 - (this.pos & 3);
      int nops = this.gap - padding;
      int bytecodeSize = 5 + (3 - (this.orgPos & 3)) + this.tableSize();
      if (nops > 0) {
         this.adjustOffsets(bytecodeSize, nops);
      }

      for(newcode[dest++] = code[src]; padding-- > 0; newcode[dest++] = 0) {
      }

      ByteArray.write32bit(this.defaultByte, newcode, dest);
      int size = this.write2(dest + 4, newcode);

      for(dest += size + 4; nops-- > 0; newcode[dest++] = 0) {
      }

      return 5 + (3 - (this.orgPos & 3)) + size;
   }

   abstract int write2(int var1, byte[] var2);

   abstract int tableSize();

   void adjustOffsets(int size, int nops) throws BadBytecode {
      this.pointers.shiftForSwitch(this.pos + size, nops);
      if (this.defaultByte == size) {
         this.defaultByte -= nops;
      }

      for(int i = 0; i < this.offsets.length; ++i) {
         if (this.offsets[i] == size) {
            int[] var10000 = this.offsets;
            var10000[i] -= nops;
         }
      }

   }
}
