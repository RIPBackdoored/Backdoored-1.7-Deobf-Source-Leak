package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;

class ParserImpl$ParseBlockNode implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseBlockNode(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      return ParserImpl.access$1300(this.this$0, true, false);
   }

   // $FF: synthetic method
   ParserImpl$ParseBlockNode(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
