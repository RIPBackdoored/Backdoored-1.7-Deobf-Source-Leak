package javassist.bytecode;

public class SignatureAttribute$TypeVariable extends SignatureAttribute$ObjectType {
   String name;

   SignatureAttribute$TypeVariable(String sig, int begin, int end) {
      this.name = sig.substring(begin, end);
   }

   public SignatureAttribute$TypeVariable(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public String toString() {
      return this.name;
   }

   void encode(StringBuffer sb) {
      sb.append('T').append(this.name).append(';');
   }
}
