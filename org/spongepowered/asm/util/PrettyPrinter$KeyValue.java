package org.spongepowered.asm.util;

class PrettyPrinter$KeyValue implements PrettyPrinter$IVariableWidthEntry {
   private final String key;
   private final Object value;
   // $FF: synthetic field
   final PrettyPrinter this$0;

   public PrettyPrinter$KeyValue(PrettyPrinter this$0, String key, Object value) {
      this.this$0 = this$0;
      this.key = key;
      this.value = value;
   }

   public String toString() {
      return String.format(this.this$0.kvFormat, this.key, this.value);
   }

   public int getWidth() {
      return this.toString().length();
   }
}
