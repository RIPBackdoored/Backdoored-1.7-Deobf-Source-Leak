package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.tokens.Token;

class ParserImpl$ParseFlowSequenceEntryMappingEnd implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseFlowSequenceEntryMappingEnd(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      ParserImpl.access$102(this.this$0, new ParserImpl$ParseFlowSequenceEntry(this.this$0, false));
      Token token = this.this$0.scanner.peekToken();
      return new MappingEndEvent(token.getStartMark(), token.getEndMark());
   }

   // $FF: synthetic method
   ParserImpl$ParseFlowSequenceEntryMappingEnd(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
