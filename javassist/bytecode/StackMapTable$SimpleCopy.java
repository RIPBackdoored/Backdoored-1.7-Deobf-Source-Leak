package javassist.bytecode;

class StackMapTable$SimpleCopy extends StackMapTable$Walker {
   private StackMapTable$Writer writer;

   public StackMapTable$SimpleCopy(byte[] data) {
      super(data);
      this.writer = new StackMapTable$Writer(data.length);
   }

   public byte[] doit() throws BadBytecode {
      this.parse();
      return this.writer.toByteArray();
   }

   public void sameFrame(int pos, int offsetDelta) {
      this.writer.sameFrame(offsetDelta);
   }

   public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
      this.writer.sameLocals(offsetDelta, stackTag, this.copyData(stackTag, stackData));
   }

   public void chopFrame(int pos, int offsetDelta, int k) {
      this.writer.chopFrame(offsetDelta, k);
   }

   public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) {
      this.writer.appendFrame(offsetDelta, tags, this.copyData(tags, data));
   }

   public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
      this.writer.fullFrame(offsetDelta, localTags, this.copyData(localTags, localData), stackTags, this.copyData(stackTags, stackData));
   }

   protected int copyData(int tag, int data) {
      return data;
   }

   protected int[] copyData(int[] tags, int[] data) {
      return data;
   }
}
