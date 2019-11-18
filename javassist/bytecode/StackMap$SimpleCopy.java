package javassist.bytecode;

class StackMap$SimpleCopy extends StackMap$Walker {
   StackMap$Writer writer = new StackMap$Writer();

   StackMap$SimpleCopy(StackMap map) {
      super(map);
   }

   byte[] doit() {
      this.visit();
      return this.writer.toByteArray();
   }

   public void visit() {
      int num = ByteArray.readU16bit(this.info, 0);
      this.writer.write16bit(num);
      super.visit();
   }

   public int locals(int pos, int offset, int num) {
      this.writer.write16bit(offset);
      return super.locals(pos, offset, num);
   }

   public int typeInfoArray(int pos, int offset, int num, boolean isLocals) {
      this.writer.write16bit(num);
      return super.typeInfoArray(pos, offset, num, isLocals);
   }

   public void typeInfo(int pos, byte tag) {
      this.writer.writeVerifyTypeInfo(tag, 0);
   }

   public void objectVariable(int pos, int clazz) {
      this.writer.writeVerifyTypeInfo(7, clazz);
   }

   public void uninitialized(int pos, int offset) {
      this.writer.writeVerifyTypeInfo(8, offset);
   }
}
