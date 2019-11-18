package javassist.bytecode.stackmap;

import java.util.HashSet;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public class TypeData$BasicType extends TypeData {
   private String name;
   private int typeTag;
   private char decodedName;

   public TypeData$BasicType(String type, int tag, char decoded) {
      this.name = type;
      this.typeTag = tag;
      this.decodedName = decoded;
   }

   public int getTypeTag() {
      return this.typeTag;
   }

   public int getTypeData(ConstPool cp) {
      return 0;
   }

   public TypeData join() {
      return (TypeData)(this == TypeTag.TOP ? this : super.join());
   }

   public TypeData$BasicType isBasicType() {
      return this;
   }

   public boolean is2WordType() {
      return this.typeTag == 4 || this.typeTag == 3;
   }

   public boolean eq(TypeData d) {
      return this == d;
   }

   public String getName() {
      return this.name;
   }

   public char getDecodedName() {
      return this.decodedName;
   }

   public void setType(String s, ClassPool cp) throws BadBytecode {
      throw new BadBytecode("conflict: " + this.name + " and " + s);
   }

   public TypeData getArrayType(int dim) throws NotFoundException {
      if (this == TypeTag.TOP) {
         return this;
      } else if (dim < 0) {
         throw new NotFoundException("no element type: " + this.name);
      } else if (dim == 0) {
         return this;
      } else {
         char[] name = new char[dim + 1];

         for(int i = 0; i < dim; ++i) {
            name[i] = '[';
         }

         name[dim] = this.decodedName;
         return new TypeData$ClassName(new String(name));
      }
   }

   String toString2(HashSet set) {
      return this.name;
   }

   // $FF: synthetic method
   static char access$100(TypeData$BasicType x0) {
      return x0.decodedName;
   }
}
