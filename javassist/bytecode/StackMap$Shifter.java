package javassist.bytecode;

class StackMap$Shifter extends StackMap$Walker {
   private int where;
   private int gap;
   private boolean exclusive;

   public StackMap$Shifter(StackMap smt, int where, int gap, boolean exclusive) {
      super(smt);
      this.where = where;
      this.gap = gap;
      this.exclusive = exclusive;
   }

   public int locals(int pos, int offset, int num) {
      if (this.exclusive) {
         if (this.where > offset) {
            return super.locals(pos, offset, num);
         }
      } else if (this.where >= offset) {
         return super.locals(pos, offset, num);
      }

      ByteArray.write16bit(offset + this.gap, this.info, pos - 4);
      return super.locals(pos, offset, num);
   }

   public void uninitialized(int pos, int offset) {
      if (this.where <= offset) {
         ByteArray.write16bit(offset + this.gap, this.info, pos + 1);
      }

   }
}
