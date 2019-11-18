package javassist.bytecode;

class TypeAnnotationsAttribute$TAWalker extends AnnotationsAttribute$Walker {
   TypeAnnotationsAttribute$SubWalker subWalker;

   TypeAnnotationsAttribute$TAWalker(byte[] attrInfo) {
      super(attrInfo);
      this.subWalker = new TypeAnnotationsAttribute$SubWalker(attrInfo);
   }

   int annotationArray(int pos, int num) throws Exception {
      for(int i = 0; i < num; ++i) {
         int targetType = this.info[pos] & 255;
         pos = this.subWalker.targetInfo(pos + 1, targetType);
         pos = this.subWalker.typePath(pos);
         pos = this.annotation(pos);
      }

      return pos;
   }
}
