package javassist.bytecode;

import java.util.Map;

class TypeAnnotationsAttribute$Renamer extends AnnotationsAttribute$Renamer {
   TypeAnnotationsAttribute$SubWalker sub;

   TypeAnnotationsAttribute$Renamer(byte[] attrInfo, ConstPool cp, Map map) {
      super(attrInfo, cp, map);
      this.sub = new TypeAnnotationsAttribute$SubWalker(attrInfo);
   }

   int annotationArray(int pos, int num) throws Exception {
      for(int i = 0; i < num; ++i) {
         int targetType = this.info[pos] & 255;
         pos = this.sub.targetInfo(pos + 1, targetType);
         pos = this.sub.typePath(pos);
         pos = this.annotation(pos);
      }

      return pos;
   }
}
