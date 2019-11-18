package javassist.bytecode;

public class SignatureAttribute$ClassType extends SignatureAttribute$ObjectType {
   String name;
   SignatureAttribute$TypeArgument[] arguments;
   public static SignatureAttribute$ClassType OBJECT = new SignatureAttribute$ClassType("java.lang.Object", (SignatureAttribute$TypeArgument[])null);

   static SignatureAttribute$ClassType make(String s, int b, int e, SignatureAttribute$TypeArgument[] targs, SignatureAttribute$ClassType parent) {
      return (SignatureAttribute$ClassType)(parent == null ? new SignatureAttribute$ClassType(s, b, e, targs) : new SignatureAttribute$NestedClassType(s, b, e, targs, parent));
   }

   SignatureAttribute$ClassType(String signature, int begin, int end, SignatureAttribute$TypeArgument[] targs) {
      this.name = signature.substring(begin, end).replace('/', '.');
      this.arguments = targs;
   }

   public SignatureAttribute$ClassType(String className, SignatureAttribute$TypeArgument[] args) {
      this.name = className;
      this.arguments = args;
   }

   public SignatureAttribute$ClassType(String className) {
      this(className, (SignatureAttribute$TypeArgument[])null);
   }

   public String getName() {
      return this.name;
   }

   public SignatureAttribute$TypeArgument[] getTypeArguments() {
      return this.arguments;
   }

   public SignatureAttribute$ClassType getDeclaringClass() {
      return null;
   }

   public String toString() {
      StringBuffer sbuf = new StringBuffer();
      SignatureAttribute$ClassType parent = this.getDeclaringClass();
      if (parent != null) {
         sbuf.append(parent.toString()).append('.');
      }

      return this.toString2(sbuf);
   }

   private String toString2(StringBuffer sbuf) {
      sbuf.append(this.name);
      if (this.arguments != null) {
         sbuf.append('<');
         int n = this.arguments.length;

         for(int i = 0; i < n; ++i) {
            if (i > 0) {
               sbuf.append(", ");
            }

            sbuf.append(this.arguments[i].toString());
         }

         sbuf.append('>');
      }

      return sbuf.toString();
   }

   public String jvmTypeName() {
      StringBuffer sbuf = new StringBuffer();
      SignatureAttribute$ClassType parent = this.getDeclaringClass();
      if (parent != null) {
         sbuf.append(parent.jvmTypeName()).append('$');
      }

      return this.toString2(sbuf);
   }

   void encode(StringBuffer sb) {
      sb.append('L');
      this.encode2(sb);
      sb.append(';');
   }

   void encode2(StringBuffer sb) {
      SignatureAttribute$ClassType parent = this.getDeclaringClass();
      if (parent != null) {
         parent.encode2(sb);
         sb.append('$');
      }

      sb.append(this.name.replace('.', '/'));
      if (this.arguments != null) {
         SignatureAttribute$TypeArgument.encode(sb, this.arguments);
      }

   }
}
