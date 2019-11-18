package org.spongepowered.asm.util;

class PrettyPrinter$CentredText {
   private final Object centred;
   // $FF: synthetic field
   final PrettyPrinter this$0;

   public PrettyPrinter$CentredText(PrettyPrinter this$0, Object centred) {
      this.this$0 = this$0;
      this.centred = centred;
   }

   public String toString() {
      String text = this.centred.toString();
      return String.format("%" + ((this.this$0.width - text.length()) / 2 + text.length()) + "s", text);
   }
}
