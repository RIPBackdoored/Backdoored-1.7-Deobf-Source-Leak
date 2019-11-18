package javassist.bytecode;

class CodeIterator$LdcW extends CodeIterator$Branch {
   int index;
   boolean state;

   CodeIterator$LdcW(int p, int i) {
      super(p);
      this.index = i;
      this.state = true;
   }

   boolean expanded() {
      if (this.state) {
         this.state = false;
         return true;
      } else {
         return false;
      }
   }

   int deltaSize() {
      return 1;
   }

   int write(int srcPos, byte[] code, int destPos, byte[] newcode) {
      newcode[destPos] = 19;
      ByteArray.write16bit(this.index, newcode, destPos + 1);
      return 2;
   }
}
