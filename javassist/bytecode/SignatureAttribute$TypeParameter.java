package javassist.bytecode;

public class SignatureAttribute$TypeParameter {
   String name;
   SignatureAttribute$ObjectType superClass;
   SignatureAttribute$ObjectType[] superInterfaces;

   SignatureAttribute$TypeParameter(String sig, int nb, int ne, SignatureAttribute$ObjectType sc, SignatureAttribute$ObjectType[] si) {
      this.name = sig.substring(nb, ne);
      this.superClass = sc;
      this.superInterfaces = si;
   }

   public SignatureAttribute$TypeParameter(String name, SignatureAttribute$ObjectType superClass, SignatureAttribute$ObjectType[] superInterfaces) {
      this.name = name;
      this.superClass = superClass;
      if (superInterfaces == null) {
         this.superInterfaces = new SignatureAttribute$ObjectType[0];
      } else {
         this.superInterfaces = superInterfaces;
      }

   }

   public SignatureAttribute$TypeParameter(String name) {
      this(name, (SignatureAttribute$ObjectType)null, (SignatureAttribute$ObjectType[])null);
   }

   public String getName() {
      return this.name;
   }

   public SignatureAttribute$ObjectType getClassBound() {
      return this.superClass;
   }

   public SignatureAttribute$ObjectType[] getInterfaceBound() {
      return this.superInterfaces;
   }

   public String toString() {
      StringBuffer sbuf = new StringBuffer(this.getName());
      if (this.superClass != null) {
         sbuf.append(" extends ").append(this.superClass.toString());
      }

      int len = this.superInterfaces.length;
      if (len > 0) {
         for(int i = 0; i < len; ++i) {
            if (i <= 0 && this.superClass == null) {
               sbuf.append(" extends ");
            } else {
               sbuf.append(" & ");
            }

            sbuf.append(this.superInterfaces[i].toString());
         }
      }

      return sbuf.toString();
   }

   static void toString(StringBuffer sbuf, SignatureAttribute$TypeParameter[] tp) {
      sbuf.append('<');

      for(int i = 0; i < tp.length; ++i) {
         if (i > 0) {
            sbuf.append(", ");
         }

         sbuf.append(tp[i]);
      }

      sbuf.append('>');
   }

   void encode(StringBuffer sb) {
      sb.append(this.name);
      if (this.superClass == null) {
         sb.append(":Ljava/lang/Object;");
      } else {
         sb.append(':');
         this.superClass.encode(sb);
      }

      for(int i = 0; i < this.superInterfaces.length; ++i) {
         sb.append(':');
         this.superInterfaces[i].encode(sb);
      }

   }
}
