package javassist.util.proxy;

final class ProxyFactory$2 implements ProxyFactory$UniqueName {
   private final String sep = "_$$_jvst" + Integer.toHexString(this.hashCode() & 4095) + "_";
   private int counter = 0;

   public String get(String classname) {
      return classname + this.sep + Integer.toHexString(this.counter++);
   }
}
