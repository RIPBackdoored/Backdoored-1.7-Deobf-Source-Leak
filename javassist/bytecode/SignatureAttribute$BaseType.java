package javassist.bytecode;

import javassist.CtClass;

public class SignatureAttribute$BaseType extends SignatureAttribute$Type {
   char descriptor;

   SignatureAttribute$BaseType(char c) {
      this.descriptor = c;
   }

   public SignatureAttribute$BaseType(String typeName) {
      this(Descriptor.of(typeName).charAt(0));
   }

   public char getDescriptor() {
      return this.descriptor;
   }

   public CtClass getCtlass() {
      return Descriptor.toPrimitiveClass(this.descriptor);
   }

   public String toString() {
      return Descriptor.toClassName(Character.toString(this.descriptor));
   }

   void encode(StringBuffer sb) {
      sb.append(this.descriptor);
   }
}
