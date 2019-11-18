package javassist.util.proxy;

import java.util.Comparator;
import java.util.Map.Entry;

final class ProxyFactory$3 implements Comparator {
   public int compare(Object o1, Object o2) {
      Entry e1 = (Entry)o1;
      Entry e2 = (Entry)o2;
      String key1 = (String)e1.getKey();
      String key2 = (String)e2.getKey();
      return key1.compareTo(key2);
   }
}
