package javassist.bytecode;

import java.util.Map;

class StackMap$Copier extends StackMap$Walker {
   byte[] dest;
   ConstPool srcCp;
   ConstPool destCp;
   Map classnames;

   StackMap$Copier(StackMap map, ConstPool newCp, Map classnames) {
      super(map);
      this.srcCp = map.getConstPool();
      this.dest = new byte[this.info.length];
      this.destCp = newCp;
      this.classnames = classnames;
   }

   public void visit() {
      int num = ByteArray.readU16bit(this.info, 0);
      ByteArray.write16bit(num, this.dest, 0);
      super.visit();
   }

   public int locals(int pos, int offset, int num) {
      ByteArray.write16bit(offset, this.dest, pos - 4);
      return super.locals(pos, offset, num);
   }

   public int typeInfoArray(int pos, int offset, int num, boolean isLocals) {
      ByteArray.write16bit(num, this.dest, pos - 2);
      return super.typeInfoArray(pos, offset, num, isLocals);
   }

   public void typeInfo(int pos, byte tag) {
      this.dest[pos] = tag;
   }

   public void objectVariable(int pos, int clazz) {
      this.dest[pos] = 7;
      int newClazz = this.srcCp.copy(clazz, this.destCp, this.classnames);
      ByteArray.write16bit(newClazz, this.dest, pos + 1);
   }

   public void uninitialized(int pos, int offset) {
      this.dest[pos] = 8;
      ByteArray.write16bit(offset, this.dest, pos + 1);
   }

   public StackMap getStackMap() {
      return new StackMap(this.destCp, this.dest);
   }
}
