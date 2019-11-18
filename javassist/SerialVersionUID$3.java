package javassist;

import java.util.Comparator;

final class SerialVersionUID$3 implements Comparator {
   public int compare(Object o1, Object o2) {
      CtMethod m1 = (CtMethod)o1;
      CtMethod m2 = (CtMethod)o2;
      int value = m1.getName().compareTo(m2.getName());
      if (value == 0) {
         value = m1.getMethodInfo2().getDescriptor().compareTo(m2.getMethodInfo2().getDescriptor());
      }

      return value;
   }
}
