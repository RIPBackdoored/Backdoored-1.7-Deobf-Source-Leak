package javassist.bytecode.annotation;

import java.io.IOException;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

public abstract class MemberValue {
   ConstPool cp;
   char tag;

   MemberValue(char tag, ConstPool cp) {
      this.cp = cp;
      this.tag = tag;
   }

   abstract Object getValue(ClassLoader var1, ClassPool var2, Method var3) throws ClassNotFoundException;

   abstract Class getType(ClassLoader var1) throws ClassNotFoundException;

   static Class loadClass(ClassLoader cl, String classname) throws ClassNotFoundException, NoSuchClassError {
      Class var10000;
      try {
         var10000 = Class.forName(convertFromArray(classname), true, cl);
      } catch (LinkageError var3) {
         throw new NoSuchClassError(classname, var3);
      }

      return var10000;
   }

   private static String convertFromArray(String classname) {
      int index = classname.indexOf("[]");
      if (index == -1) {
         return classname;
      } else {
         String rawType = classname.substring(0, index);

         StringBuffer sb;
         for(sb = new StringBuffer(Descriptor.of(rawType)); index != -1; index = classname.indexOf("[]", index + 1)) {
            sb.insert(0, "[");
         }

         return sb.toString().replace('/', '.');
      }
   }

   public abstract void accept(MemberValueVisitor var1);

   public abstract void write(AnnotationsWriter var1) throws IOException;
}
