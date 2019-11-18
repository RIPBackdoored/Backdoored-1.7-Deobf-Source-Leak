package org.spongepowered.asm.mixin;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

class MixinEnvironment$MixinLogWatcher {
   static MixinEnvironment$MixinLogWatcher$MixinAppender appender = new MixinEnvironment$MixinLogWatcher$MixinAppender();
   static Logger log;
   static Level oldLevel = null;

   static void begin() {
      org.apache.logging.log4j.Logger fmlLog = LogManager.getLogger("FML");
      if (fmlLog instanceof Logger) {
         log = (Logger)fmlLog;
         oldLevel = log.getLevel();
         appender.start();
         log.addAppender(appender);
         log.setLevel(Level.ALL);
      }
   }

   static void end() {
      if (log != null) {
         log.removeAppender(appender);
      }

   }
}
