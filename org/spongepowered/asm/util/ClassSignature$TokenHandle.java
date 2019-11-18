package org.spongepowered.asm.util;

class ClassSignature$TokenHandle implements ClassSignature$IToken {
   final ClassSignature$Token token;
   boolean array;
   char wildcard;
   // $FF: synthetic field
   final ClassSignature this$0;

   ClassSignature$TokenHandle(ClassSignature this$0) {
      this(this$0, new ClassSignature$Token());
   }

   ClassSignature$TokenHandle(ClassSignature this$0, ClassSignature$Token token) {
      this.this$0 = this$0;
      this.token = token;
   }

   public ClassSignature$IToken setArray(boolean array) {
      this.array |= array;
      return this;
   }

   public ClassSignature$IToken setWildcard(char wildcard) {
      if ("+-".indexOf(wildcard) > -1) {
         this.wildcard = wildcard;
      }

      return this;
   }

   public String asBound() {
      return this.token.asBound();
   }

   public String asType() {
      StringBuilder sb = new StringBuilder();
      if (this.wildcard > 0) {
         sb.append(this.wildcard);
      }

      if (this.array) {
         sb.append('[');
      }

      return sb.append(this.this$0.getTypeVar(this)).toString();
   }

   public ClassSignature$Token asToken() {
      return this.token;
   }

   public String toString() {
      return this.token.toString();
   }

   public ClassSignature$TokenHandle clone() {
      return new ClassSignature$TokenHandle(this.this$0, this.token);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
