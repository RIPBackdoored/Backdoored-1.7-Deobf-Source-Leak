package org.spongepowered.asm.mixin.extensibility;

import org.apache.logging.log4j.Level;

public final class IMixinErrorHandler$ErrorAction extends Enum {
   public static final IMixinErrorHandler$ErrorAction NONE = new IMixinErrorHandler$ErrorAction("NONE", 0, Level.INFO);
   public static final IMixinErrorHandler$ErrorAction WARN = new IMixinErrorHandler$ErrorAction("WARN", 1, Level.WARN);
   public static final IMixinErrorHandler$ErrorAction ERROR = new IMixinErrorHandler$ErrorAction("ERROR", 2, Level.FATAL);
   public final Level logLevel;
   // $FF: synthetic field
   private static final IMixinErrorHandler$ErrorAction[] $VALUES = new IMixinErrorHandler$ErrorAction[]{NONE, WARN, ERROR};

   public static IMixinErrorHandler$ErrorAction[] values() {
      return (IMixinErrorHandler$ErrorAction[])$VALUES.clone();
   }

   public static IMixinErrorHandler$ErrorAction valueOf(String name) {
      return (IMixinErrorHandler$ErrorAction)Enum.valueOf(IMixinErrorHandler$ErrorAction.class, name);
   }

   private IMixinErrorHandler$ErrorAction(String var1, int var2, Level logLevel) {
      super(var1, var2);
      this.logLevel = logLevel;
   }
}
