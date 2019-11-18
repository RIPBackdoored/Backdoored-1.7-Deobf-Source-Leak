package javassist.bytecode;

import java.io.PrintWriter;

class StackMapTable$Printer extends StackMapTable$Walker {
   private PrintWriter writer;
   private int offset;

   public static void print(StackMapTable smt, PrintWriter writer) {
      try {
         (new StackMapTable$Printer(smt.get(), writer)).parse();
      } catch (BadBytecode var3) {
         writer.println(var3.getMessage());
      }

   }

   StackMapTable$Printer(byte[] data, PrintWriter pw) {
      super(data);
      this.writer = pw;
      this.offset = -1;
   }

   public void sameFrame(int pos, int offsetDelta) {
      this.offset += offsetDelta + 1;
      this.writer.println(this.offset + " same frame: " + offsetDelta);
   }

   public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
      this.offset += offsetDelta + 1;
      this.writer.println(this.offset + " same locals: " + offsetDelta);
      this.printTypeInfo(stackTag, stackData);
   }

   public void chopFrame(int pos, int offsetDelta, int k) {
      this.offset += offsetDelta + 1;
      this.writer.println(this.offset + " chop frame: " + offsetDelta + ",    " + k + " last locals");
   }

   public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) {
      this.offset += offsetDelta + 1;
      this.writer.println(this.offset + " append frame: " + offsetDelta);

      for(int i = 0; i < tags.length; ++i) {
         this.printTypeInfo(tags[i], data[i]);
      }

   }

   public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
      this.offset += offsetDelta + 1;
      this.writer.println(this.offset + " full frame: " + offsetDelta);
      this.writer.println("[locals]");

      int i;
      for(i = 0; i < localTags.length; ++i) {
         this.printTypeInfo(localTags[i], localData[i]);
      }

      this.writer.println("[stack]");

      for(i = 0; i < stackTags.length; ++i) {
         this.printTypeInfo(stackTags[i], stackData[i]);
      }

   }

   private void printTypeInfo(int tag, int data) {
      String msg = null;
      switch(tag) {
      case 0:
         msg = "top";
         break;
      case 1:
         msg = "integer";
         break;
      case 2:
         msg = "float";
         break;
      case 3:
         msg = "double";
         break;
      case 4:
         msg = "long";
         break;
      case 5:
         msg = "null";
         break;
      case 6:
         msg = "this";
         break;
      case 7:
         msg = "object (cpool_index " + data + ")";
         break;
      case 8:
         msg = "uninitialized (offset " + data + ")";
      }

      this.writer.print("    ");
      this.writer.println(msg);
   }
}
