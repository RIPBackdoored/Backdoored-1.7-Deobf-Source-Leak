package javassist.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TypeAnnotationsAttribute extends AttributeInfo {
   public static final String visibleTag = "RuntimeVisibleTypeAnnotations";
   public static final String invisibleTag = "RuntimeInvisibleTypeAnnotations";

   public TypeAnnotationsAttribute(ConstPool cp, String attrname, byte[] info) {
      super(cp, attrname, info);
   }

   TypeAnnotationsAttribute(ConstPool cp, int n, DataInputStream in) throws IOException {
      super(cp, n, in);
   }

   public int numAnnotations() {
      return ByteArray.readU16bit(this.info, 0);
   }

   public AttributeInfo copy(ConstPool newCp, Map classnames) {
      TypeAnnotationsAttribute$Copier copier = new TypeAnnotationsAttribute$Copier(this.info, this.constPool, newCp, classnames);

      TypeAnnotationsAttribute var10000;
      try {
         copier.annotationArray();
         var10000 = new TypeAnnotationsAttribute(newCp, this.getName(), copier.close());
      } catch (Exception var5) {
         throw new RuntimeException(var5);
      }

      return var10000;
   }

   void renameClass(String oldname, String newname) {
      HashMap map = new HashMap();
      map.put(oldname, newname);
      this.renameClass(map);
   }

   void renameClass(Map classnames) {
      TypeAnnotationsAttribute$Renamer renamer = new TypeAnnotationsAttribute$Renamer(this.info, this.getConstPool(), classnames);

      try {
         renamer.annotationArray();
      } catch (Exception var4) {
         throw new RuntimeException(var4);
      }

   }

   void getRefClasses(Map classnames) {
      this.renameClass(classnames);
   }
}
