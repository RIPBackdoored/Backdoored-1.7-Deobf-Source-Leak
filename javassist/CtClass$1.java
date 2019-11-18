package javassist;

class CtClass$1 extends ClassMap {
   // $FF: synthetic field
   final CtClass this$0;

   CtClass$1(CtClass this$0) {
      this.this$0 = this$0;
   }

   public void put(String oldname, String newname) {
      this.put0(oldname, newname);
   }

   public Object get(Object jvmClassName) {
      String n = toJavaName((String)jvmClassName);
      this.put0(n, n);
      return null;
   }

   public void fix(String name) {
   }
}
