package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseFlowMappingValue implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseFlowMappingValue(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      Token token;
      if (this.this$0.scanner.checkToken(Token$ID.Value)) {
         token = this.this$0.scanner.getToken();
         if (!this.this$0.scanner.checkToken(Token$ID.FlowEntry, Token$ID.FlowMappingEnd)) {
            ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseFlowMappingKey(this.this$0, false));
            return ParserImpl.access$2400(this.this$0);
         } else {
            ParserImpl.access$102(this.this$0, new ParserImpl$ParseFlowMappingKey(this.this$0, false));
            return ParserImpl.access$1200(this.this$0, token.getEndMark());
         }
      } else {
         ParserImpl.access$102(this.this$0, new ParserImpl$ParseFlowMappingKey(this.this$0, false));
         token = this.this$0.scanner.peekToken();
         return ParserImpl.access$1200(this.this$0, token.getStartMark());
      }
   }

   // $FF: synthetic method
   ParserImpl$ParseFlowMappingValue(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
