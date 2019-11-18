package org.spongepowered.asm.mixin.injection.points;

public final class BeforeInvoke$SearchType extends Enum {
   public static final BeforeInvoke$SearchType STRICT = new BeforeInvoke$SearchType("STRICT", 0);
   public static final BeforeInvoke$SearchType PERMISSIVE = new BeforeInvoke$SearchType("PERMISSIVE", 1);
   // $FF: synthetic field
   private static final BeforeInvoke$SearchType[] $VALUES = new BeforeInvoke$SearchType[]{STRICT, PERMISSIVE};

   public static BeforeInvoke$SearchType[] values() {
      return (BeforeInvoke$SearchType[])$VALUES.clone();
   }

   public static BeforeInvoke$SearchType valueOf(String name) {
      return (BeforeInvoke$SearchType)Enum.valueOf(BeforeInvoke$SearchType.class, name);
   }

   private BeforeInvoke$SearchType(String var1, int var2) {
      super(var1, var2);
   }
}
