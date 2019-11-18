package javassist.bytecode.stackmap;

import java.util.HashSet;
import javassist.bytecode.ConstPool;

public class TypeData$UninitData extends TypeData$ClassName {
   int offset;
   boolean initialized;

   TypeData$UninitData(int offset, String className) {
      super(className);
      this.offset = offset;
      this.initialized = false;
   }

   public TypeData$UninitData copy() {
      return new TypeData$UninitData(this.offset, this.getName());
   }

   public int getTypeTag() {
      return 8;
   }

   public int getTypeData(ConstPool cp) {
      return this.offset;
   }

   public TypeData join() {
      return (TypeData)(this.initialized ? new TypeData$TypeVar(new TypeData$ClassName(this.getName())) : new TypeData$UninitTypeVar(this.copy()));
   }

   public boolean isUninit() {
      return true;
   }

   public boolean eq(TypeData d) {
      if (!(d instanceof TypeData$UninitData)) {
         return false;
      } else {
         TypeData$UninitData ud = (TypeData$UninitData)d;
         return this.offset == ud.offset && this.getName().equals(ud.getName());
      }
   }

   public int offset() {
      return this.offset;
   }

   public void constructorCalled(int offset) {
      if (offset == this.offset) {
         this.initialized = true;
      }

   }

   String toString2(HashSet set) {
      return this.getName() + "," + this.offset;
   }
}
