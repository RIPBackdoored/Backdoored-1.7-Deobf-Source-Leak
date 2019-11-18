package javassist.bytecode.stackmap;

import javassist.bytecode.BadBytecode;

public class BasicBlock {
   protected int position;
   protected int length;
   protected int incoming;
   protected BasicBlock[] exit;
   protected boolean stop;
   protected BasicBlock$Catch toCatch;

   protected BasicBlock(int pos) {
      this.position = pos;
      this.length = 0;
      this.incoming = 0;
   }

   public static BasicBlock find(BasicBlock[] blocks, int pos) throws BadBytecode {
      for(int i = 0; i < blocks.length; ++i) {
         int iPos = blocks[i].position;
         if (iPos <= pos && pos < iPos + blocks[i].length) {
            return blocks[i];
         }
      }

      throw new BadBytecode("no basic block at " + pos);
   }

   public String toString() {
      StringBuffer sbuf = new StringBuffer();
      String cname = this.getClass().getName();
      int i = cname.lastIndexOf(46);
      sbuf.append(i < 0 ? cname : cname.substring(i + 1));
      sbuf.append("[");
      this.toString2(sbuf);
      sbuf.append("]");
      return sbuf.toString();
   }

   protected void toString2(StringBuffer sbuf) {
      sbuf.append("pos=").append(this.position).append(", len=").append(this.length).append(", in=").append(this.incoming).append(", exit{");
      if (this.exit != null) {
         for(int i = 0; i < this.exit.length; ++i) {
            sbuf.append(this.exit[i].position).append(",");
         }
      }

      sbuf.append("}, {");

      for(BasicBlock$Catch th = this.toCatch; th != null; th = th.next) {
         sbuf.append("(").append(th.body.position).append(", ").append(th.typeIndex).append("), ");
      }

      sbuf.append("}");
   }
}
