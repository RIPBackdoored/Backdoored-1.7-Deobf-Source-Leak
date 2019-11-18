package javassist.bytecode;

public class StackMap$Walker {
   byte[] info;

   public StackMap$Walker(StackMap sm) {
      this.info = sm.get();
   }

   public void visit() {
      int num = ByteArray.readU16bit(this.info, 0);
      int pos = 2;

      for(int i = 0; i < num; ++i) {
         int offset = ByteArray.readU16bit(this.info, pos);
         int numLoc = ByteArray.readU16bit(this.info, pos + 2);
         pos = this.locals(pos + 4, offset, numLoc);
         int numStack = ByteArray.readU16bit(this.info, pos);
         pos = this.stack(pos + 2, offset, numStack);
      }

   }

   public int locals(int pos, int offset, int num) {
      return this.typeInfoArray(pos, offset, num, true);
   }

   public int stack(int pos, int offset, int num) {
      return this.typeInfoArray(pos, offset, num, false);
   }

   public int typeInfoArray(int pos, int offset, int num, boolean isLocals) {
      for(int k = 0; k < num; ++k) {
         pos = this.typeInfoArray2(k, pos);
      }

      return pos;
   }

   int typeInfoArray2(int k, int pos) {
      byte tag = this.info[pos];
      int offsetOfNew;
      if (tag == 7) {
         offsetOfNew = ByteArray.readU16bit(this.info, pos + 1);
         this.objectVariable(pos, offsetOfNew);
         pos += 3;
      } else if (tag == 8) {
         offsetOfNew = ByteArray.readU16bit(this.info, pos + 1);
         this.uninitialized(pos, offsetOfNew);
         pos += 3;
      } else {
         this.typeInfo(pos, tag);
         ++pos;
      }

      return pos;
   }

   public void typeInfo(int pos, byte tag) {
   }

   public void objectVariable(int pos, int clazz) {
   }

   public void uninitialized(int pos, int offset) {
   }
}
