package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.util.Bytecode;

final class MixinPreProcessorStandard$SpecialMethod extends Enum {
   public static final MixinPreProcessorStandard$SpecialMethod MERGE = new MixinPreProcessorStandard$SpecialMethod("MERGE", 0, true);
   public static final MixinPreProcessorStandard$SpecialMethod OVERWRITE = new MixinPreProcessorStandard$SpecialMethod("OVERWRITE", 1, true, Overwrite.class);
   public static final MixinPreProcessorStandard$SpecialMethod SHADOW = new MixinPreProcessorStandard$SpecialMethod("SHADOW", 2, false, Shadow.class);
   public static final MixinPreProcessorStandard$SpecialMethod ACCESSOR = new MixinPreProcessorStandard$SpecialMethod("ACCESSOR", 3, false, Accessor.class);
   public static final MixinPreProcessorStandard$SpecialMethod INVOKER = new MixinPreProcessorStandard$SpecialMethod("INVOKER", 4, false, Invoker.class);
   final boolean isOverwrite;
   final Class annotation;
   final String description;
   // $FF: synthetic field
   private static final MixinPreProcessorStandard$SpecialMethod[] $VALUES = new MixinPreProcessorStandard$SpecialMethod[]{MERGE, OVERWRITE, SHADOW, ACCESSOR, INVOKER};

   public static MixinPreProcessorStandard$SpecialMethod[] values() {
      return (MixinPreProcessorStandard$SpecialMethod[])$VALUES.clone();
   }

   public static MixinPreProcessorStandard$SpecialMethod valueOf(String name) {
      return (MixinPreProcessorStandard$SpecialMethod)Enum.valueOf(MixinPreProcessorStandard$SpecialMethod.class, name);
   }

   private MixinPreProcessorStandard$SpecialMethod(String var1, int var2, boolean isOverwrite, Class type) {
      super(var1, var2);
      this.isOverwrite = isOverwrite;
      this.annotation = type;
      this.description = "@" + Bytecode.getSimpleName(type);
   }

   private MixinPreProcessorStandard$SpecialMethod(String var1, int var2, boolean isOverwrite) {
      super(var1, var2);
      this.isOverwrite = isOverwrite;
      this.annotation = null;
      this.description = "overwrite";
   }

   public String toString() {
      return this.description;
   }
}
