package org.spongepowered.asm.mixin.transformer;

class MixinApplicatorStandard$Range {
   final int start;
   final int end;
   final int marker;
   // $FF: synthetic field
   final MixinApplicatorStandard this$0;

   MixinApplicatorStandard$Range(MixinApplicatorStandard this$0, int start, int end, int marker) {
      this.this$0 = this$0;
      this.start = start;
      this.end = end;
      this.marker = marker;
   }

   boolean isValid() {
      return this.start != 0 && this.end != 0 && this.end >= this.start;
   }

   boolean contains(int value) {
      return value >= this.start && value <= this.end;
   }

   boolean excludes(int value) {
      return value < this.start || value > this.end;
   }

   public String toString() {
      return String.format("Range[%d-%d,%d,valid=%s)", this.start, this.end, this.marker, this.isValid());
   }
}
