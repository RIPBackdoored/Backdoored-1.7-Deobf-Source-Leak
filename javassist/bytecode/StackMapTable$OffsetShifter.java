package javassist.bytecode;

class StackMapTable$OffsetShifter extends StackMapTable$Walker {
   int where;
   int gap;

   public StackMapTable$OffsetShifter(StackMapTable smt, int where, int gap) {
      super(smt);
      this.where = where;
      this.gap = gap;
   }

   public void objectOrUninitialized(int tag, int data, int pos) {
      if (tag == 8 && this.where <= data) {
         ByteArray.write16bit(data + this.gap, this.info, pos);
      }

   }
}
