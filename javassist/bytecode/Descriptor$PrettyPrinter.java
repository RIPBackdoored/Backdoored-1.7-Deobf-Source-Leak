package javassist.bytecode;

import javassist.CtClass;

class Descriptor$PrettyPrinter {
   static String toString(String desc) {
      StringBuffer sbuf = new StringBuffer();
      if (desc.charAt(0) == '(') {
         int pos = 1;
         sbuf.append('(');

         for(; desc.charAt(pos) != ')'; pos = readType(sbuf, pos, desc)) {
            if (pos > 1) {
               sbuf.append(',');
            }
         }

         sbuf.append(')');
      } else {
         readType(sbuf, 0, desc);
      }

      return sbuf.toString();
   }

   static int readType(StringBuffer sbuf, int pos, String desc) {
      char c = desc.charAt(pos);

      int var4;
      for(var4 = 0; c == '['; c = desc.charAt(pos)) {
         ++var4;
         ++pos;
      }

      if (c == 'L') {
         while(true) {
            ++pos;
            c = desc.charAt(pos);
            if (c == ';') {
               break;
            }

            if (c == '/') {
               c = '.';
            }

            sbuf.append(c);
         }
      } else {
         CtClass t = Descriptor.toPrimitiveClass(c);
         sbuf.append(t.getName());
      }

      while(var4-- > 0) {
         sbuf.append("[]");
      }

      return pos + 1;
   }
}
