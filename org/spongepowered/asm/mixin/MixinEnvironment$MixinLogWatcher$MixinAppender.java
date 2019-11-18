package org.spongepowered.asm.mixin;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;

class MixinEnvironment$MixinLogWatcher$MixinAppender extends AbstractAppender {
   MixinEnvironment$MixinLogWatcher$MixinAppender() {
      super("MixinLogWatcherAppender", (Filter)null, (Layout)null);
   }

   public void append(LogEvent event) {
      if (event.getLevel() == Level.DEBUG && "Validating minecraft".equals(event.getMessage().getFormattedMessage())) {
         MixinEnvironment.gotoPhase(MixinEnvironment$Phase.INIT);
         if (MixinEnvironment$MixinLogWatcher.log.getLevel() == Level.ALL) {
            MixinEnvironment$MixinLogWatcher.log.setLevel(MixinEnvironment$MixinLogWatcher.oldLevel);
         }

      }
   }
}
