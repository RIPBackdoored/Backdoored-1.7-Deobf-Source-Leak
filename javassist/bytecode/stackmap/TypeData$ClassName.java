package javassist.bytecode.stackmap;

import java.util.HashSet;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public class TypeData$ClassName extends TypeData {
   private String name;

   public TypeData$ClassName(String n) {
      this.name = n;
   }

   public String getName() {
      return this.name;
   }

   public TypeData$BasicType isBasicType() {
      return null;
   }

   public boolean is2WordType() {
      return false;
   }

   public int getTypeTag() {
      return 7;
   }

   public int getTypeData(ConstPool cp) {
      return cp.addClassInfo(this.getName());
   }

   public boolean eq(TypeData d) {
      return this.name.equals(d.getName());
   }

   public void setType(String typeName, ClassPool cp) throws BadBytecode {
   }

   public TypeData getArrayType(int dim) throws NotFoundException {
      if (dim == 0) {
         return this;
      } else if (dim <= 0) {
         for(int i = 0; i < -dim; ++i) {
            if (this.name.charAt(i) != '[') {
               throw new NotFoundException("no " + dim + " dimensional array type: " + this.getName());
            }
         }

         char type = this.name.charAt(-dim);
         if (type == '[') {
            return new TypeData$ClassName(this.name.substring(-dim));
         } else if (type == 'L') {
            return new TypeData$ClassName(this.name.substring(-dim + 1, this.name.length() - 1).replace('/', '.'));
         } else if (type == TypeData$BasicType.access$100(TypeTag.DOUBLE)) {
            return TypeTag.DOUBLE;
         } else if (type == TypeData$BasicType.access$100(TypeTag.FLOAT)) {
            return TypeTag.FLOAT;
         } else if (type == TypeData$BasicType.access$100(TypeTag.LONG)) {
            return TypeTag.LONG;
         } else {
            return TypeTag.INTEGER;
         }
      } else {
         char[] dimType = new char[dim];

         for(int i = 0; i < dim; ++i) {
            dimType[i] = '[';
         }

         String elementType = this.getName();
         if (elementType.charAt(0) != '[') {
            elementType = "L" + elementType.replace('.', '/') + ";";
         }

         return new TypeData$ClassName(new String(dimType) + elementType);
      }
   }

   String toString2(HashSet set) {
      return this.name;
   }
}
