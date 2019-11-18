package org.yaml.snakeyaml.scanner;

class ScannerImpl$Chomping {
   private final Boolean value;
   private final int increment;

   public ScannerImpl$Chomping(Boolean value, int increment) {
      this.value = value;
      this.increment = increment;
   }

   public boolean chompTailIsNotFalse() {
      return this.value == null || this.value;
   }

   public boolean chompTailIsTrue() {
      return this.value != null && this.value;
   }

   public int getIncrement() {
      return this.increment;
   }
}
