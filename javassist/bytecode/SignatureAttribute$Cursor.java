package javassist.bytecode;

class SignatureAttribute$Cursor {
   int position;

   private SignatureAttribute$Cursor() {
      this.position = 0;
   }

   int indexOf(String s, int ch) throws BadBytecode {
      int i = s.indexOf(ch, this.position);
      if (i < 0) {
         throw SignatureAttribute.access$000(s);
      } else {
         this.position = i + 1;
         return i;
      }
   }

   // $FF: synthetic method
   SignatureAttribute$Cursor(SignatureAttribute$1 x0) {
      this();
   }
}
