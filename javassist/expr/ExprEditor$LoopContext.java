package javassist.expr;

final class ExprEditor$LoopContext {
   ExprEditor$NewOp newList;
   int maxLocals;
   int maxStack;

   ExprEditor$LoopContext(int locals) {
      this.maxLocals = locals;
      this.maxStack = 0;
      this.newList = null;
   }

   void updateMax(int locals, int stack) {
      if (this.maxLocals < locals) {
         this.maxLocals = locals;
      }

      if (this.maxStack < stack) {
         this.maxStack = stack;
      }

   }
}
