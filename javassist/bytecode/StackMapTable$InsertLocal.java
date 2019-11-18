package javassist.bytecode;

class StackMapTable$InsertLocal extends StackMapTable$SimpleCopy {
   private int varIndex;
   private int varTag;
   private int varData;

   public StackMapTable$InsertLocal(byte[] data, int varIndex, int varTag, int varData) {
      super(data);
      this.varIndex = varIndex;
      this.varTag = varTag;
      this.varData = varData;
   }

   public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
      int len = localTags.length;
      if (len < this.varIndex) {
         super.fullFrame(pos, offsetDelta, localTags, localData, stackTags, stackData);
      } else {
         int typeSize = this.varTag != 4 && this.varTag != 3 ? 1 : 2;
         int[] localTags2 = new int[len + typeSize];
         int[] localData2 = new int[len + typeSize];
         int index = this.varIndex;
         int j = 0;

         for(int i = 0; i < len; ++i) {
            if (j == index) {
               j += typeSize;
            }

            localTags2[j] = localTags[i];
            localData2[j++] = localData[i];
         }

         localTags2[index] = this.varTag;
         localData2[index] = this.varData;
         if (typeSize > 1) {
            localTags2[index + 1] = 0;
            localData2[index + 1] = 0;
         }

         super.fullFrame(pos, offsetDelta, localTags2, localData2, stackTags, stackData);
      }
   }
}
