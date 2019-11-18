package javassist.bytecode.stackmap;

import javassist.bytecode.ConstPool;

public abstract class TypeData$AbsTypeVar extends TypeData {
   public abstract void merge(TypeData var1);

   public int getTypeTag() {
      return 7;
   }

   public int getTypeData(ConstPool cp) {
      return cp.addClassInfo(this.getName());
   }

   public boolean eq(TypeData d) {
      return this.getName().equals(d.getName());
   }
}
