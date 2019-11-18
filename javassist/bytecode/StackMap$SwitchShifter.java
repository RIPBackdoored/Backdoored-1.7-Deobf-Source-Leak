package javassist.bytecode;

class StackMap$SwitchShifter extends StackMap$Walker {
   private int where;
   private int gap;

   public StackMap$SwitchShifter(StackMap smt, int where, int gap) {
      super(smt);
      this.where = where;
      this.gap = gap;
   }

   public int locals(int pos, int offset, int num) {
      if (this.where == pos + offset) {
         ByteArray.write16bit(offset - this.gap, this.info, pos - 4);
      } else if (this.where == pos) {
         ByteArray.write16bit(offset + this.gap, this.info, pos - 4);
      }

      return super.locals(pos, offset, num);
   }
}
