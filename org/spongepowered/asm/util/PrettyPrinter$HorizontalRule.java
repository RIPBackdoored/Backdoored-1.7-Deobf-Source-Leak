package org.spongepowered.asm.util;

import com.google.common.base.Strings;

class PrettyPrinter$HorizontalRule implements PrettyPrinter$ISpecialEntry {
   private final char[] hrChars;
   // $FF: synthetic field
   final PrettyPrinter this$0;

   public PrettyPrinter$HorizontalRule(PrettyPrinter this$0, char... hrChars) {
      this.this$0 = this$0;
      this.hrChars = hrChars;
   }

   public String toString() {
      return Strings.repeat(new String(this.hrChars), this.this$0.width + 2);
   }
}
