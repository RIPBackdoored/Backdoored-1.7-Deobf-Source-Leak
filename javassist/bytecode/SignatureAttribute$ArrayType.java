package javassist.bytecode;

public class SignatureAttribute$ArrayType extends SignatureAttribute$ObjectType {
   int dim;
   SignatureAttribute$Type componentType;

   public SignatureAttribute$ArrayType(int d, SignatureAttribute$Type comp) {
      this.dim = d;
      this.componentType = comp;
   }

   public int getDimension() {
      return this.dim;
   }

   public SignatureAttribute$Type getComponentType() {
      return this.componentType;
   }

   public String toString() {
      StringBuffer sbuf = new StringBuffer(this.componentType.toString());

      for(int i = 0; i < this.dim; ++i) {
         sbuf.append("[]");
      }

      return sbuf.toString();
   }

   void encode(StringBuffer sb) {
      for(int i = 0; i < this.dim; ++i) {
         sb.append('[');
      }

      this.componentType.encode(sb);
   }
}
