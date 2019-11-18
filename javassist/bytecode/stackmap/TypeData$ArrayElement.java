package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.HashSet;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;

public class TypeData$ArrayElement extends TypeData$AbsTypeVar {
   private TypeData$AbsTypeVar array;

   private TypeData$ArrayElement(TypeData$AbsTypeVar a) {
      this.array = a;
   }

   public static TypeData make(TypeData array) throws BadBytecode {
      if (array instanceof TypeData$ArrayType) {
         return ((TypeData$ArrayType)array).elementType();
      } else if (array instanceof TypeData$AbsTypeVar) {
         return new TypeData$ArrayElement((TypeData$AbsTypeVar)array);
      } else if (array instanceof TypeData$ClassName && !array.isNullType()) {
         return new TypeData$ClassName(typeName(array.getName()));
      } else {
         throw new BadBytecode("bad AASTORE: " + array);
      }
   }

   public void merge(TypeData t) {
      try {
         if (!t.isNullType()) {
            this.array.merge(TypeData$ArrayType.make(t));
         }
      } catch (BadBytecode var3) {
         throw new RuntimeException("fatal: " + var3);
      }

   }

   public String getName() {
      return typeName(this.array.getName());
   }

   public TypeData$AbsTypeVar arrayType() {
      return this.array;
   }

   public TypeData$BasicType isBasicType() {
      return null;
   }

   public boolean is2WordType() {
      return false;
   }

   private static String typeName(String arrayType) {
      if (arrayType.length() > 1 && arrayType.charAt(0) == '[') {
         char c = arrayType.charAt(1);
         if (c == 'L') {
            return arrayType.substring(2, arrayType.length() - 1).replace('/', '.');
         }

         if (c == '[') {
            return arrayType.substring(1);
         }
      }

      return "java.lang.Object";
   }

   public void setType(String s, ClassPool cp) throws BadBytecode {
      this.array.setType(TypeData$ArrayType.typeName(s), cp);
   }

   protected TypeData$TypeVar toTypeVar(int dim) {
      return this.array.toTypeVar(dim - 1);
   }

   public TypeData getArrayType(int dim) throws NotFoundException {
      return this.array.getArrayType(dim - 1);
   }

   public int dfs(ArrayList order, int index, ClassPool cp) throws NotFoundException {
      return this.array.dfs(order, index, cp);
   }

   String toString2(HashSet set) {
      return "*" + this.array.toString2(set);
   }

   // $FF: synthetic method
   static String access$000(String x0) {
      return typeName(x0);
   }
}
