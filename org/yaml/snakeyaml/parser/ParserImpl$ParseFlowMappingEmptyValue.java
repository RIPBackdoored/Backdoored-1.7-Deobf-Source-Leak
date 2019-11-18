package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;

class ParserImpl$ParseFlowMappingEmptyValue implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseFlowMappingEmptyValue(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      ParserImpl.access$102(this.this$0, new ParserImpl$ParseFlowMappingKey(this.this$0, false));
      return ParserImpl.access$1200(this.this$0, this.this$0.scanner.peekToken().getStartMark());
   }

   // $FF: synthetic method
   ParserImpl$ParseFlowMappingEmptyValue(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
