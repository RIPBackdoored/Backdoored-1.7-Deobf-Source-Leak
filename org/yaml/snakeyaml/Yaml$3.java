package org.yaml.snakeyaml;

import java.util.Iterator;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.parser.Parser;

class Yaml$3 implements Iterator {
   // $FF: synthetic field
   final Parser val$parser;
   // $FF: synthetic field
   final Yaml this$0;

   Yaml$3(Yaml this$0, Parser var2) {
      this.this$0 = this$0;
      this.val$parser = var2;
   }

   public boolean hasNext() {
      return this.val$parser.peekEvent() != null;
   }

   public Event next() {
      return this.val$parser.getEvent();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object next() {
      return this.next();
   }
}
