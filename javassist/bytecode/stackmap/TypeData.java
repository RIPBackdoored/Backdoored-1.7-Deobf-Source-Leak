package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.HashSet;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public abstract class TypeData {
   public static TypeData[] make(int size) {
      TypeData[] array = new TypeData[size];

      for(int i = 0; i < size; ++i) {
         array[i] = TypeTag.TOP;
      }

      return array;
   }

   protected TypeData() {
   }

   private static void setType(TypeData td, String className, ClassPool cp) throws BadBytecode {
      td.setType(className, cp);
   }

   public abstract int getTypeTag();

   public abstract int getTypeData(ConstPool var1);

   public TypeData join() {
      return new TypeData$TypeVar(this);
   }

   public abstract TypeData$BasicType isBasicType();

   public abstract boolean is2WordType();

   public boolean isNullType() {
      return false;
   }

   public boolean isUninit() {
      return false;
   }

   public abstract boolean eq(TypeData var1);

   public abstract String getName();

   public abstract void setType(String var1, ClassPool var2) throws BadBytecode;

   public abstract TypeData getArrayType(int var1) throws NotFoundException;

   public int dfs(ArrayList order, int index, ClassPool cp) throws NotFoundException {
      return index;
   }

   protected TypeData$TypeVar toTypeVar(int dim) {
      return null;
   }

   public void constructorCalled(int offset) {
   }

   public String toString() {
      return super.toString() + "(" + this.toString2(new HashSet()) + ")";
   }

   abstract String toString2(HashSet var1);

   public static CtClass commonSuperClassEx(CtClass one, CtClass two) throws NotFoundException {
      if (one == two) {
         return one;
      } else if (one.isArray() && two.isArray()) {
         CtClass ele1 = one.getComponentType();
         CtClass ele2 = two.getComponentType();
         CtClass element = commonSuperClassEx(ele1, ele2);
         if (element == ele1) {
            return one;
         } else {
            return element == ele2 ? two : one.getClassPool().get(element == null ? "java.lang.Object" : element.getName() + "[]");
         }
      } else if (!one.isPrimitive() && !two.isPrimitive()) {
         return !one.isArray() && !two.isArray() ? commonSuperClass(one, two) : one.getClassPool().get("java.lang.Object");
      } else {
         return null;
      }
   }

   public static CtClass commonSuperClass(CtClass one, CtClass two) throws NotFoundException {
      CtClass deep = one;
      CtClass shallow = two;
      CtClass backupDeep = one;

      while(true) {
         if (eq(deep, shallow) && deep.getSuperclass() != null) {
            return deep;
         }

         CtClass deepSuper = deep.getSuperclass();
         CtClass shallowSuper = shallow.getSuperclass();
         if (shallowSuper == null) {
            shallow = two;
            break;
         }

         if (deepSuper == null) {
            backupDeep = two;
            deep = shallow;
            shallow = one;
            break;
         }

         deep = deepSuper;
         shallow = shallowSuper;
      }

      while(true) {
         deep = deep.getSuperclass();
         if (deep == null) {
            for(deep = backupDeep; !eq(deep, shallow); shallow = shallow.getSuperclass()) {
               deep = deep.getSuperclass();
            }

            return deep;
         }

         backupDeep = backupDeep.getSuperclass();
      }
   }

   static boolean eq(CtClass one, CtClass two) {
      return one == two || one != null && two != null && one.getName().equals(two.getName());
   }

   public static void aastore(TypeData array, TypeData value, ClassPool cp) throws BadBytecode {
      if (array instanceof TypeData$AbsTypeVar && !value.isNullType()) {
         ((TypeData$AbsTypeVar)array).merge(TypeData$ArrayType.make(value));
      }

      if (value instanceof TypeData$AbsTypeVar) {
         if (array instanceof TypeData$AbsTypeVar) {
            TypeData$ArrayElement.make(array);
         } else {
            if (!(array instanceof TypeData$ClassName)) {
               throw new BadBytecode("bad AASTORE: " + array);
            }

            if (!array.isNullType()) {
               String type = TypeData$ArrayElement.access$000(array.getName());
               value.setType(type, cp);
            }
         }
      }

   }
}
