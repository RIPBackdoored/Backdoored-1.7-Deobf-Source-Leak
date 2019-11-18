package javassist.bytecode;

import java.util.Map;

class AnnotationsAttribute$Renamer extends AnnotationsAttribute$Walker {
   ConstPool cpool;
   Map classnames;

   AnnotationsAttribute$Renamer(byte[] info, ConstPool cp, Map map) {
      super(info);
      this.cpool = cp;
      this.classnames = map;
   }

   int annotation(int pos, int type, int numPairs) throws Exception {
      this.renameType(pos - 4, type);
      return super.annotation(pos, type, numPairs);
   }

   void enumMemberValue(int pos, int typeNameIndex, int constNameIndex) throws Exception {
      this.renameType(pos + 1, typeNameIndex);
      super.enumMemberValue(pos, typeNameIndex, constNameIndex);
   }

   void classMemberValue(int pos, int index) throws Exception {
      this.renameType(pos + 1, index);
      super.classMemberValue(pos, index);
   }

   private void renameType(int pos, int index) {
      String name = this.cpool.getUtf8Info(index);
      String newName = Descriptor.rename(name, this.classnames);
      if (!name.equals(newName)) {
         int index2 = this.cpool.addUtf8Info(newName);
         ByteArray.write16bit(index2, this.info, pos);
      }

   }
}
