package javassist;

import java.util.Comparator;

final class SerialVersionUID$1 implements Comparator {
   public int compare(Object o1, Object o2) {
      CtField field1 = (CtField)o1;
      CtField field2 = (CtField)o2;
      return field1.getName().compareTo(field2.getName());
   }
}
