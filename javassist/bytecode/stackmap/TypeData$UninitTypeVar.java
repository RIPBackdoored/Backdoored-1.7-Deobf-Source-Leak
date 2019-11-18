package javassist.bytecode.stackmap;

import java.util.HashSet;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public class TypeData$UninitTypeVar extends TypeData$AbsTypeVar {
   protected TypeData type;

   public TypeData$UninitTypeVar(TypeData$UninitData t) {
      this.type = t;
   }

   public int getTypeTag() {
      return this.type.getTypeTag();
   }

   public int getTypeData(ConstPool cp) {
      return this.type.getTypeData(cp);
   }

   public TypeData$BasicType isBasicType() {
      return this.type.isBasicType();
   }

   public boolean is2WordType() {
      return this.type.is2WordType();
   }

   public boolean isUninit() {
      return this.type.isUninit();
   }

   public boolean eq(TypeData d) {
      return this.type.eq(d);
   }

   public String getName() {
      return this.type.getName();
   }

   protected TypeData$TypeVar toTypeVar(int dim) {
      return null;
   }

   public TypeData join() {
      return this.type.join();
   }

   public void setType(String s, ClassPool cp) throws BadBytecode {
      this.type.setType(s, cp);
   }

   public void merge(TypeData t) {
      if (!t.eq(this.type)) {
         this.type = TypeTag.TOP;
      }

   }

   public void constructorCalled(int offset) {
      this.type.constructorCalled(offset);
   }

   public int offset() {
      if (this.type instanceof TypeData$UninitData) {
         return ((TypeData$UninitData)this.type).offset;
      } else {
         throw new RuntimeException("not available");
      }
   }

   public TypeData getArrayType(int dim) throws NotFoundException {
      return this.type.getArrayType(dim);
   }

   String toString2(HashSet set) {
      return "";
   }
}
