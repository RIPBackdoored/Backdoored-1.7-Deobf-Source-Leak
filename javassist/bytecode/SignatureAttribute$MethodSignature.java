package javassist.bytecode;

public class SignatureAttribute$MethodSignature {
   SignatureAttribute$TypeParameter[] typeParams;
   SignatureAttribute$Type[] params;
   SignatureAttribute$Type retType;
   SignatureAttribute$ObjectType[] exceptions;

   public SignatureAttribute$MethodSignature(SignatureAttribute$TypeParameter[] tp, SignatureAttribute$Type[] params, SignatureAttribute$Type ret, SignatureAttribute$ObjectType[] ex) {
      this.typeParams = tp == null ? new SignatureAttribute$TypeParameter[0] : tp;
      this.params = params == null ? new SignatureAttribute$Type[0] : params;
      this.retType = (SignatureAttribute$Type)(ret == null ? new SignatureAttribute$BaseType("void") : ret);
      this.exceptions = ex == null ? new SignatureAttribute$ObjectType[0] : ex;
   }

   public SignatureAttribute$TypeParameter[] getTypeParameters() {
      return this.typeParams;
   }

   public SignatureAttribute$Type[] getParameterTypes() {
      return this.params;
   }

   public SignatureAttribute$Type getReturnType() {
      return this.retType;
   }

   public SignatureAttribute$ObjectType[] getExceptionTypes() {
      return this.exceptions;
   }

   public String toString() {
      StringBuffer sbuf = new StringBuffer();
      SignatureAttribute$TypeParameter.toString(sbuf, this.typeParams);
      sbuf.append(" (");
      SignatureAttribute$Type.toString(sbuf, this.params);
      sbuf.append(") ");
      sbuf.append(this.retType);
      if (this.exceptions.length > 0) {
         sbuf.append(" throws ");
         SignatureAttribute$Type.toString(sbuf, this.exceptions);
      }

      return sbuf.toString();
   }

   public String encode() {
      StringBuffer sbuf = new StringBuffer();
      int i;
      if (this.typeParams.length > 0) {
         sbuf.append('<');

         for(i = 0; i < this.typeParams.length; ++i) {
            this.typeParams[i].encode(sbuf);
         }

         sbuf.append('>');
      }

      sbuf.append('(');

      for(i = 0; i < this.params.length; ++i) {
         this.params[i].encode(sbuf);
      }

      sbuf.append(')');
      this.retType.encode(sbuf);
      if (this.exceptions.length > 0) {
         for(i = 0; i < this.exceptions.length; ++i) {
            sbuf.append('^');
            this.exceptions[i].encode(sbuf);
         }
      }

      return sbuf.toString();
   }
}
