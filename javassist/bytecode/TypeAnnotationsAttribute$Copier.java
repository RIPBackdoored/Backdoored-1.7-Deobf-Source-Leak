package javassist.bytecode;

import java.util.Map;
import javassist.bytecode.annotation.TypeAnnotationsWriter;

class TypeAnnotationsAttribute$Copier extends AnnotationsAttribute$Copier {
   TypeAnnotationsAttribute$SubCopier sub;

   TypeAnnotationsAttribute$Copier(byte[] attrInfo, ConstPool src, ConstPool dest, Map map) {
      super(attrInfo, src, dest, map, false);
      TypeAnnotationsWriter w = new TypeAnnotationsWriter(this.output, dest);
      this.writer = w;
      this.sub = new TypeAnnotationsAttribute$SubCopier(attrInfo, src, dest, map, w);
   }

   int annotationArray(int pos, int num) throws Exception {
      this.writer.numAnnotations(num);

      for(int i = 0; i < num; ++i) {
         int targetType = this.info[pos] & 255;
         pos = this.sub.targetInfo(pos + 1, targetType);
         pos = this.sub.typePath(pos);
         pos = this.annotation(pos);
      }

      return pos;
   }
}
