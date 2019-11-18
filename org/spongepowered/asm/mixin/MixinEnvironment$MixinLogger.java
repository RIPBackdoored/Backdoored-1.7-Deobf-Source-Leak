package org.spongepowered.asm.mixin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.Logger;

class MixinEnvironment$MixinLogger {
   static MixinEnvironment$MixinLogger$MixinAppender appender = new MixinEnvironment$MixinLogger$MixinAppender("MixinLogger", (Filter)null, (Layout)null);

   public MixinEnvironment$MixinLogger() {
      Logger log = (Logger)LogManager.getLogger("FML");
      appender.start();
      log.addAppender(appender);
   }
}
