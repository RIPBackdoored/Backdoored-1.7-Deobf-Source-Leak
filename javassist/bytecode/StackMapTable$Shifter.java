package javassist.bytecode;

class StackMapTable$Shifter extends StackMapTable$Walker {
   private StackMapTable stackMap;
   int where;
   int gap;
   int position;
   byte[] updatedInfo;
   boolean exclusive;

   public StackMapTable$Shifter(StackMapTable smt, int where, int gap, boolean exclusive) {
      super(smt);
      this.stackMap = smt;
      this.where = where;
      this.gap = gap;
      this.position = 0;
      this.updatedInfo = null;
      this.exclusive = exclusive;
   }

   public void doit() throws BadBytecode {
      this.parse();
      if (this.updatedInfo != null) {
         this.stackMap.set(this.updatedInfo);
      }

   }

   public void sameFrame(int pos, int offsetDelta) {
      this.update(pos, offsetDelta, 0, 251);
   }

   public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
      this.update(pos, offsetDelta, 64, 247);
   }

   void update(int pos, int offsetDelta, int base, int entry) {
      int oldPos = this.position;
      this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
      boolean match;
      if (this.exclusive) {
         match = oldPos < this.where && this.where <= this.position;
      } else {
         match = oldPos <= this.where && this.where < this.position;
      }

      if (match) {
         int newDelta = offsetDelta + this.gap;
         this.position += this.gap;
         if (newDelta < 64) {
            this.info[pos] = (byte)(newDelta + base);
         } else if (offsetDelta < 64) {
            byte[] newinfo = insertGap(this.info, pos, 2);
            newinfo[pos] = (byte)entry;
            ByteArray.write16bit(newDelta, newinfo, pos + 1);
            this.updatedInfo = newinfo;
         } else {
            ByteArray.write16bit(newDelta, this.info, pos + 1);
         }
      }

   }

   static byte[] insertGap(byte[] info, int where, int gap) {
      int len = info.length;
      byte[] newinfo = new byte[len + gap];

      for(int i = 0; i < len; ++i) {
         newinfo[i + (i < where ? 0 : gap)] = info[i];
      }

      return newinfo;
   }

   public void chopFrame(int pos, int offsetDelta, int k) {
      this.update(pos, offsetDelta);
   }

   public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) {
      this.update(pos, offsetDelta);
   }

   public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
      this.update(pos, offsetDelta);
   }

   void update(int pos, int offsetDelta) {
      int oldPos = this.position;
      this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
      boolean match;
      if (this.exclusive) {
         match = oldPos < this.where && this.where <= this.position;
      } else {
         match = oldPos <= this.where && this.where < this.position;
      }

      if (match) {
         int newDelta = offsetDelta + this.gap;
         ByteArray.write16bit(newDelta, this.info, pos + 1);
         this.position += this.gap;
      }

   }
}
