package javassist.bytecode;

public class SignatureAttribute$TypeArgument {
   SignatureAttribute$ObjectType arg;
   char wildcard;

   SignatureAttribute$TypeArgument(SignatureAttribute$ObjectType a, char w) {
      this.arg = a;
      this.wildcard = w;
   }

   public SignatureAttribute$TypeArgument(SignatureAttribute$ObjectType t) {
      this(t, ' ');
   }

   public SignatureAttribute$TypeArgument() {
      this((SignatureAttribute$ObjectType)null, '*');
   }

   public static SignatureAttribute$TypeArgument subclassOf(SignatureAttribute$ObjectType t) {
      return new SignatureAttribute$TypeArgument(t, '+');
   }

   public static SignatureAttribute$TypeArgument superOf(SignatureAttribute$ObjectType t) {
      return new SignatureAttribute$TypeArgument(t, '-');
   }

   public char getKind() {
      return this.wildcard;
   }

   public boolean isWildcard() {
      return this.wildcard != ' ';
   }

   public SignatureAttribute$ObjectType getType() {
      return this.arg;
   }

   public String toString() {
      if (this.wildcard == '*') {
         return "?";
      } else {
         String type = this.arg.toString();
         if (this.wildcard == ' ') {
            return type;
         } else {
            return this.wildcard == '+' ? "? extends " + type : "? super " + type;
         }
      }
   }

   static void encode(StringBuffer sb, SignatureAttribute$TypeArgument[] args) {
      sb.append('<');

      for(int i = 0; i < args.length; ++i) {
         SignatureAttribute$TypeArgument ta = args[i];
         if (ta.isWildcard()) {
            sb.append(ta.wildcard);
         }

         if (ta.getType() != null) {
            ta.getType().encode(sb);
         }
      }

      sb.append('>');
   }
}
