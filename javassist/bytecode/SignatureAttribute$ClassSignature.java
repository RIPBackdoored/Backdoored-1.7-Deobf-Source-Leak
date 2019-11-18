package javassist.bytecode;

public class SignatureAttribute$ClassSignature {
   SignatureAttribute$TypeParameter[] params;
   SignatureAttribute$ClassType superClass;
   SignatureAttribute$ClassType[] interfaces;

   public SignatureAttribute$ClassSignature(SignatureAttribute$TypeParameter[] params, SignatureAttribute$ClassType superClass, SignatureAttribute$ClassType[] interfaces) {
      this.params = params == null ? new SignatureAttribute$TypeParameter[0] : params;
      this.superClass = superClass == null ? SignatureAttribute$ClassType.OBJECT : superClass;
      this.interfaces = interfaces == null ? new SignatureAttribute$ClassType[0] : interfaces;
   }

   public SignatureAttribute$ClassSignature(SignatureAttribute$TypeParameter[] p) {
      this(p, (SignatureAttribute$ClassType)null, (SignatureAttribute$ClassType[])null);
   }

   public SignatureAttribute$TypeParameter[] getParameters() {
      return this.params;
   }

   public SignatureAttribute$ClassType getSuperClass() {
      return this.superClass;
   }

   public SignatureAttribute$ClassType[] getInterfaces() {
      return this.interfaces;
   }

   public String toString() {
      StringBuffer sbuf = new StringBuffer();
      SignatureAttribute$TypeParameter.toString(sbuf, this.params);
      sbuf.append(" extends ").append(this.superClass);
      if (this.interfaces.length > 0) {
         sbuf.append(" implements ");
         SignatureAttribute$Type.toString(sbuf, this.interfaces);
      }

      return sbuf.toString();
   }

   public String encode() {
      StringBuffer sbuf = new StringBuffer();
      int i;
      if (this.params.length > 0) {
         sbuf.append('<');

         for(i = 0; i < this.params.length; ++i) {
            this.params[i].encode(sbuf);
         }

         sbuf.append('>');
      }

      this.superClass.encode(sbuf);

      for(i = 0; i < this.interfaces.length; ++i) {
         this.interfaces[i].encode(sbuf);
      }

      return sbuf.toString();
   }
}
