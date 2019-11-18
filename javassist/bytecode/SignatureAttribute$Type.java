package javassist.bytecode;

public abstract class SignatureAttribute$Type {
   abstract void encode(StringBuffer var1);

   static void toString(StringBuffer sbuf, SignatureAttribute$Type[] ts) {
      for(int i = 0; i < ts.length; ++i) {
         if (i > 0) {
            sbuf.append(", ");
         }

         sbuf.append(ts[i]);
      }

   }

   public String jvmTypeName() {
      return this.toString();
   }
}
