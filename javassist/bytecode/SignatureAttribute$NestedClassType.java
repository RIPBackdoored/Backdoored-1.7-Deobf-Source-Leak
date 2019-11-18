package javassist.bytecode;

public class SignatureAttribute$NestedClassType extends SignatureAttribute$ClassType {
   SignatureAttribute$ClassType parent;

   SignatureAttribute$NestedClassType(String s, int b, int e, SignatureAttribute$TypeArgument[] targs, SignatureAttribute$ClassType p) {
      super(s, b, e, targs);
      this.parent = p;
   }

   public SignatureAttribute$NestedClassType(SignatureAttribute$ClassType parent, String className, SignatureAttribute$TypeArgument[] args) {
      super(className, args);
      this.parent = parent;
   }

   public SignatureAttribute$ClassType getDeclaringClass() {
      return this.parent;
   }
}
