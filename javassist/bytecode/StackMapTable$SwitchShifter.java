package javassist.bytecode;

class StackMapTable$SwitchShifter extends StackMapTable$Shifter {
   StackMapTable$SwitchShifter(StackMapTable smt, int where, int gap) {
      super(smt, where, gap, false);
   }

   void update(int pos, int offsetDelta, int base, int entry) {
      int oldPos = this.position;
      this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
      int newDelta;
      if (this.where == this.position) {
         newDelta = offsetDelta - this.gap;
      } else {
         if (this.where != oldPos) {
            return;
         }

         newDelta = offsetDelta + this.gap;
      }

      byte[] newinfo;
      if (offsetDelta < 64) {
         if (newDelta < 64) {
            this.info[pos] = (byte)(newDelta + base);
         } else {
            newinfo = insertGap(this.info, pos, 2);
            newinfo[pos] = (byte)entry;
            ByteArray.write16bit(newDelta, newinfo, pos + 1);
            this.updatedInfo = newinfo;
         }
      } else if (newDelta < 64) {
         newinfo = deleteGap(this.info, pos, 2);
         newinfo[pos] = (byte)(newDelta + base);
         this.updatedInfo = newinfo;
      } else {
         ByteArray.write16bit(newDelta, this.info, pos + 1);
      }

   }

   static byte[] deleteGap(byte[] info, int where, int gap) {
      where += gap;
      int len = info.length;
      byte[] newinfo = new byte[len - gap];

      for(int i = 0; i < len; ++i) {
         newinfo[i - (i < where ? 0 : gap)] = info[i];
      }

      return newinfo;
   }

   void update(int pos, int offsetDelta) {
      int oldPos = this.position;
      this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
      int newDelta;
      if (this.where == this.position) {
         newDelta = offsetDelta - this.gap;
      } else {
         if (this.where != oldPos) {
            return;
         }

         newDelta = offsetDelta + this.gap;
      }

      ByteArray.write16bit(newDelta, this.info, pos + 1);
   }
}
