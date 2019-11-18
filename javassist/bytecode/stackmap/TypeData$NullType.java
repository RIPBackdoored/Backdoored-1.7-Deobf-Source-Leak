package javassist.bytecode.stackmap;

import javassist.bytecode.ConstPool;

public class TypeData$NullType extends TypeData$ClassName {
   public TypeData$NullType() {
      super("null-type");
   }

   public int getTypeTag() {
      return 5;
   }

   public boolean isNullType() {
      return true;
   }

   public int getTypeData(ConstPool cp) {
      return 0;
   }

   public TypeData getArrayType(int dim) {
      return this;
   }
}
