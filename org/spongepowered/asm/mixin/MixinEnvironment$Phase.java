package org.spongepowered.asm.mixin;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;

public final class MixinEnvironment$Phase {
   static final MixinEnvironment$Phase NOT_INITIALISED = new MixinEnvironment$Phase(-1, "NOT_INITIALISED");
   public static final MixinEnvironment$Phase PREINIT = new MixinEnvironment$Phase(0, "PREINIT");
   public static final MixinEnvironment$Phase INIT = new MixinEnvironment$Phase(1, "INIT");
   public static final MixinEnvironment$Phase DEFAULT = new MixinEnvironment$Phase(2, "DEFAULT");
   static final List phases;
   final int ordinal;
   final String name;
   private MixinEnvironment environment;

   private MixinEnvironment$Phase(int ordinal, String name) {
      this.ordinal = ordinal;
      this.name = name;
   }

   public String toString() {
      return this.name;
   }

   public static MixinEnvironment$Phase forName(String name) {
      Iterator var1 = phases.iterator();

      MixinEnvironment$Phase phase;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         phase = (MixinEnvironment$Phase)var1.next();
      } while(!phase.name.equals(name));

      return phase;
   }

   MixinEnvironment getEnvironment() {
      if (this.ordinal < 0) {
         throw new IllegalArgumentException("Cannot access the NOT_INITIALISED environment");
      } else {
         if (this.environment == null) {
            this.environment = new MixinEnvironment(this);
         }

         return this.environment;
      }
   }

   static {
      phases = ImmutableList.of(PREINIT, INIT, DEFAULT);
   }
}
