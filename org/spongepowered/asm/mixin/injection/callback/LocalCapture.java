package org.spongepowered.asm.mixin.injection.callback;

public final class LocalCapture extends Enum {
   public static final LocalCapture NO_CAPTURE = new LocalCapture("NO_CAPTURE", 0, false, false);
   public static final LocalCapture PRINT = new LocalCapture("PRINT", 1, false, true);
   public static final LocalCapture CAPTURE_FAILSOFT = new LocalCapture("CAPTURE_FAILSOFT", 2);
   public static final LocalCapture CAPTURE_FAILHARD = new LocalCapture("CAPTURE_FAILHARD", 3);
   public static final LocalCapture CAPTURE_FAILEXCEPTION = new LocalCapture("CAPTURE_FAILEXCEPTION", 4);
   private final boolean captureLocals;
   private final boolean printLocals;
   // $FF: synthetic field
   private static final LocalCapture[] $VALUES = new LocalCapture[]{NO_CAPTURE, PRINT, CAPTURE_FAILSOFT, CAPTURE_FAILHARD, CAPTURE_FAILEXCEPTION};

   public static LocalCapture[] values() {
      return (LocalCapture[])$VALUES.clone();
   }

   public static LocalCapture valueOf(String name) {
      return (LocalCapture)Enum.valueOf(LocalCapture.class, name);
   }

   private LocalCapture(String var1, int var2) {
      this(var1, var2, true, false);
   }

   private LocalCapture(String var1, int var2, boolean captureLocals, boolean printLocals) {
      super(var1, var2);
      this.captureLocals = captureLocals;
      this.printLocals = printLocals;
   }

   boolean isCaptureLocals() {
      return this.captureLocals;
   }

   boolean isPrintLocals() {
      return this.printLocals;
   }
}
