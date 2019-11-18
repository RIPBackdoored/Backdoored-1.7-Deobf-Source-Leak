package javassist.bytecode;

class StackMapTable$NewRemover extends StackMapTable$SimpleCopy {
   int posOfNew;

   public StackMapTable$NewRemover(byte[] data, int pos) {
      super(data);
      this.posOfNew = pos;
   }

   public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
      if (stackTag == 8 && stackData == this.posOfNew) {
         super.sameFrame(pos, offsetDelta);
      } else {
         super.sameLocals(pos, offsetDelta, stackTag, stackData);
      }

   }

   public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
      int n = stackTags.length - 1;

      for(int i = 0; i < n; ++i) {
         if (stackTags[i] == 8 && stackData[i] == this.posOfNew && stackTags[i + 1] == 8 && stackData[i + 1] == this.posOfNew) {
            ++n;
            int[] stackTags2 = new int[n - 2];
            int[] stackData2 = new int[n - 2];
            int k = 0;

            for(int j = 0; j < n; ++j) {
               if (j == i) {
                  ++j;
               } else {
                  stackTags2[k] = stackTags[j];
                  stackData2[k++] = stackData[j];
               }
            }

            stackTags = stackTags2;
            stackData = stackData2;
            break;
         }
      }

      super.fullFrame(pos, offsetDelta, localTags, localData, stackTags, stackData);
   }
}
