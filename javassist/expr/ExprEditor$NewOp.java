package javassist.expr;

final class ExprEditor$NewOp {
   ExprEditor$NewOp next;
   int pos;
   String type;

   ExprEditor$NewOp(ExprEditor$NewOp n, int p, String t) {
      this.next = n;
      this.pos = p;
      this.type = t;
   }
}
