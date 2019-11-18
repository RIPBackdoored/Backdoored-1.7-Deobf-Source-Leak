package org.spongepowered.asm.mixin;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;

class MixinEnvironment$MixinLogger$MixinAppender extends AbstractAppender {
   protected MixinEnvironment$MixinLogger$MixinAppender(String name, Filter filter, Layout layout) {
      super(name, filter, layout);
   }

   public void append(LogEvent event) {
      if (event.getLevel() == Level.DEBUG && "Validating minecraft".equals(event.getMessage().getFormat())) {
         MixinEnvironment.gotoPhase(MixinEnvironment$Phase.INIT);
      }

   }
}
