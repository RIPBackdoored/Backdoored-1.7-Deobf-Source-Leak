package javassist.bytecode.stackmap;

import java.util.HashSet;
import javassist.bytecode.ConstPool;

public class TypeData$UninitThis extends TypeData$UninitData {
   TypeData$UninitThis(String className) {
      super(-1, className);
   }

   public TypeData$UninitData copy() {
      return new TypeData$UninitThis(this.getName());
   }

   public int getTypeTag() {
      return 6;
   }

   public int getTypeData(ConstPool cp) {
      return 0;
   }

   String toString2(HashSet set) {
      return "uninit:this";
   }
}
