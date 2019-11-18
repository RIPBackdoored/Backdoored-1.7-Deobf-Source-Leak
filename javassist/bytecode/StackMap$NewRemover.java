package javassist.bytecode;

class StackMap$NewRemover extends StackMap$SimpleCopy {
   int posOfNew;

   StackMap$NewRemover(StackMap map, int where) {
      super(map);
      this.posOfNew = where;
   }

   public int stack(int pos, int offset, int num) {
      return this.stackTypeInfoArray(pos, offset, num);
   }

   private int stackTypeInfoArray(int pos, int offset, int num) {
      int p = pos;
      int count = 0;

      int k;
      byte tag;
      int offsetOfNew;
      for(k = 0; k < num; ++k) {
         tag = this.info[p];
         if (tag == 7) {
            p += 3;
         } else if (tag == 8) {
            offsetOfNew = ByteArray.readU16bit(this.info, p + 1);
            if (offsetOfNew == this.posOfNew) {
               ++count;
            }

            p += 3;
         } else {
            ++p;
         }
      }

      this.writer.write16bit(num - count);

      for(k = 0; k < num; ++k) {
         tag = this.info[pos];
         if (tag == 7) {
            offsetOfNew = ByteArray.readU16bit(this.info, pos + 1);
            this.objectVariable(pos, offsetOfNew);
            pos += 3;
         } else if (tag == 8) {
            offsetOfNew = ByteArray.readU16bit(this.info, pos + 1);
            if (offsetOfNew != this.posOfNew) {
               this.uninitialized(pos, offsetOfNew);
            }

            pos += 3;
         } else {
            this.typeInfo(pos, tag);
            ++pos;
         }
      }

      return pos;
   }
}
