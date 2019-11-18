package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

class ParserImpl$ParseBlockSequenceFirstEntry implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseBlockSequenceFirstEntry(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      Token token = this.this$0.scanner.getToken();
      ParserImpl.access$1100(this.this$0).push(token.getStartMark());
      return (new ParserImpl$ParseBlockSequenceEntry(this.this$0, (ParserImpl$1)null)).produce();
   }

   // $FF: synthetic method
   ParserImpl$ParseBlockSequenceFirstEntry(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
