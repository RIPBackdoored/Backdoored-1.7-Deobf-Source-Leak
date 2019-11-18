package org.spongepowered.asm.mixin.injection;

public final class Constant$Condition extends Enum {
   public static final Constant$Condition LESS_THAN_ZERO = new Constant$Condition("LESS_THAN_ZERO", 0, new int[]{155, 156});
   public static final Constant$Condition LESS_THAN_OR_EQUAL_TO_ZERO = new Constant$Condition("LESS_THAN_OR_EQUAL_TO_ZERO", 1, new int[]{158, 157});
   public static final Constant$Condition GREATER_THAN_OR_EQUAL_TO_ZERO = new Constant$Condition("GREATER_THAN_OR_EQUAL_TO_ZERO", 2, LESS_THAN_ZERO);
   public static final Constant$Condition GREATER_THAN_ZERO = new Constant$Condition("GREATER_THAN_ZERO", 3, LESS_THAN_OR_EQUAL_TO_ZERO);
   private final int[] opcodes;
   private final Constant$Condition equivalence;
   // $FF: synthetic field
   private static final Constant$Condition[] $VALUES = new Constant$Condition[]{LESS_THAN_ZERO, LESS_THAN_OR_EQUAL_TO_ZERO, GREATER_THAN_OR_EQUAL_TO_ZERO, GREATER_THAN_ZERO};

   public static Constant$Condition[] values() {
      return (Constant$Condition[])$VALUES.clone();
   }

   public static Constant$Condition valueOf(String name) {
      return (Constant$Condition)Enum.valueOf(Constant$Condition.class, name);
   }

   private Constant$Condition(String var1, int var2, int... opcodes) {
      this(var1, var2, (Constant$Condition)null, opcodes);
   }

   private Constant$Condition(String var1, int var2, Constant$Condition equivalence) {
      this(var1, var2, equivalence, equivalence.opcodes);
   }

   private Constant$Condition(String var1, int var2, Constant$Condition equivalence, int... opcodes) {
      super(var1, var2);
      this.equivalence = equivalence != null ? equivalence : this;
      this.opcodes = opcodes;
   }

   public Constant$Condition getEquivalentCondition() {
      return this.equivalence;
   }

   public int[] getOpcodes() {
      return this.opcodes;
   }
}
