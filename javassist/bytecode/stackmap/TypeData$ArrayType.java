package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.HashSet;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;

public class TypeData$ArrayType extends TypeData$AbsTypeVar {
   private TypeData$AbsTypeVar element;

   private TypeData$ArrayType(TypeData$AbsTypeVar elementType) {
      this.element = elementType;
   }

   static TypeData make(TypeData element) throws BadBytecode {
      if (element instanceof TypeData$ArrayElement) {
         return ((TypeData$ArrayElement)element).arrayType();
      } else if (element instanceof TypeData$AbsTypeVar) {
         return new TypeData$ArrayType((TypeData$AbsTypeVar)element);
      } else if (element instanceof TypeData$ClassName && !element.isNullType()) {
         return new TypeData$ClassName(typeName(element.getName()));
      } else {
         throw new BadBytecode("bad AASTORE: " + element);
      }
   }

   public void merge(TypeData t) {
      try {
         if (!t.isNullType()) {
            this.element.merge(TypeData$ArrayElement.make(t));
         }
      } catch (BadBytecode var3) {
         throw new RuntimeException("fatal: " + var3);
      }

   }

   public String getName() {
      return typeName(this.element.getName());
   }

   public TypeData$AbsTypeVar elementType() {
      return this.element;
   }

   public TypeData$BasicType isBasicType() {
      return null;
   }

   public boolean is2WordType() {
      return false;
   }

   public static String typeName(String elementType) {
      return elementType.charAt(0) == '[' ? "[" + elementType : "[L" + elementType.replace('.', '/') + ";";
   }

   public void setType(String s, ClassPool cp) throws BadBytecode {
      this.element.setType(TypeData$ArrayElement.access$000(s), cp);
   }

   protected TypeData$TypeVar toTypeVar(int dim) {
      return this.element.toTypeVar(dim + 1);
   }

   public TypeData getArrayType(int dim) throws NotFoundException {
      return this.element.getArrayType(dim + 1);
   }

   public int dfs(ArrayList order, int index, ClassPool cp) throws NotFoundException {
      return this.element.dfs(order, index, cp);
   }

   String toString2(HashSet set) {
      return "[" + this.element.toString2(set);
   }
}
