package javassist.bytecode;

import java.io.PrintWriter;

class StackMap$Printer extends StackMap$Walker {
   private PrintWriter writer;

   public StackMap$Printer(StackMap map, PrintWriter out) {
      super(map);
      this.writer = out;
   }

   public void print() {
      int num = ByteArray.readU16bit(this.info, 0);
      this.writer.println(num + " entries");
      this.visit();
   }

   public int locals(int pos, int offset, int num) {
      this.writer.println("  * offset " + offset);
      return super.locals(pos, offset, num);
   }
}
