package javassist.bytecode;

public abstract class SignatureAttribute$ObjectType extends SignatureAttribute$Type {
   public String encode() {
      StringBuffer sb = new StringBuffer();
      this.encode(sb);
      return sb.toString();
   }
}
