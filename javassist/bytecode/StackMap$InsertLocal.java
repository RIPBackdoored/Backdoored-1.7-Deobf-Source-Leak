package javassist.bytecode;

class StackMap$InsertLocal extends StackMap$SimpleCopy {
   private int varIndex;
   private int varTag;
   private int varData;

   StackMap$InsertLocal(StackMap map, int varIndex, int varTag, int varData) {
      super(map);
      this.varIndex = varIndex;
      this.varTag = varTag;
      this.varData = varData;
   }

   public int typeInfoArray(int pos, int offset, int num, boolean isLocals) {
      if (isLocals && num >= this.varIndex) {
         this.writer.write16bit(num + 1);

         for(int k = 0; k < num; ++k) {
            if (k == this.varIndex) {
               this.writeVarTypeInfo();
            }

            pos = this.typeInfoArray2(k, pos);
         }

         if (num == this.varIndex) {
            this.writeVarTypeInfo();
         }

         return pos;
      } else {
         return super.typeInfoArray(pos, offset, num, isLocals);
      }
   }

   private void writeVarTypeInfo() {
      if (this.varTag == 7) {
         this.writer.writeVerifyTypeInfo(7, this.varData);
      } else if (this.varTag == 8) {
         this.writer.writeVerifyTypeInfo(8, this.varData);
      } else {
         this.writer.writeVerifyTypeInfo(this.varTag, 0);
      }

   }
}
