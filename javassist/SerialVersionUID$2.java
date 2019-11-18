package javassist;

import java.util.Comparator;

final class SerialVersionUID$2 implements Comparator {
   public int compare(Object o1, Object o2) {
      CtConstructor c1 = (CtConstructor)o1;
      CtConstructor c2 = (CtConstructor)o2;
      return c1.getMethodInfo2().getDescriptor().compareTo(c2.getMethodInfo2().getDescriptor());
   }
}
