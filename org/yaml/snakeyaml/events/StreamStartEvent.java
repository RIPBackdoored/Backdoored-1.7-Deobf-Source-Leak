package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

public final class StreamStartEvent extends Event {
   public StreamStartEvent(Mark startMark, Mark endMark) {
      super(startMark, endMark);
   }

   public boolean is(Event$ID id) {
      return Event$ID.StreamStart == id;
   }
}
