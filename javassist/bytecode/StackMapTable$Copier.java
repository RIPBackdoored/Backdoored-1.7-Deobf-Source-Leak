package javassist.bytecode;

import java.util.Map;

class StackMapTable$Copier extends StackMapTable$SimpleCopy {
   private ConstPool srcPool;
   private ConstPool destPool;
   private Map classnames;

   public StackMapTable$Copier(ConstPool src, byte[] data, ConstPool dest, Map names) {
      super(data);
      this.srcPool = src;
      this.destPool = dest;
      this.classnames = names;
   }

   protected int copyData(int tag, int data) {
      return tag == 7 ? this.srcPool.copy(data, this.destPool, this.classnames) : data;
   }

   protected int[] copyData(int[] tags, int[] data) {
      int[] newData = new int[data.length];

      for(int i = 0; i < data.length; ++i) {
         if (tags[i] == 7) {
            newData[i] = this.srcPool.copy(data[i], this.destPool, this.classnames);
         } else {
            newData[i] = data[i];
         }
      }

      return newData;
   }
}
