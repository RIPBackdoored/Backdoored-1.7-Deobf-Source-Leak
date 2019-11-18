package org.spongepowered.asm.mixin.injection.invoke.util;

final class InsnFinder$AnalyzerState extends Enum {
   public static final InsnFinder$AnalyzerState SEARCH = new InsnFinder$AnalyzerState("SEARCH", 0);
   public static final InsnFinder$AnalyzerState ANALYSE = new InsnFinder$AnalyzerState("ANALYSE", 1);
   public static final InsnFinder$AnalyzerState COMPLETE = new InsnFinder$AnalyzerState("COMPLETE", 2);
   // $FF: synthetic field
   private static final InsnFinder$AnalyzerState[] $VALUES = new InsnFinder$AnalyzerState[]{SEARCH, ANALYSE, COMPLETE};

   public static InsnFinder$AnalyzerState[] values() {
      return (InsnFinder$AnalyzerState[])$VALUES.clone();
   }

   public static InsnFinder$AnalyzerState valueOf(String name) {
      return (InsnFinder$AnalyzerState)Enum.valueOf(InsnFinder$AnalyzerState.class, name);
   }

   private InsnFinder$AnalyzerState(String var1, int var2) {
      super(var1, var2);
   }
}
