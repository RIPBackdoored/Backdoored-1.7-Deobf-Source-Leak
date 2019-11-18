package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseFlowMappingKey implements Production {
   private boolean first;
   // $FF: synthetic field
   final ParserImpl this$0;

   public ParserImpl$ParseFlowMappingKey(ParserImpl var1, boolean first) {
      this.this$0 = var1;
      this.first = false;
      this.first = first;
   }

   public Event produce() {
      Token token;
      if (!this.this$0.scanner.checkToken(Token$ID.FlowMappingEnd)) {
         if (!this.first) {
            if (!this.this$0.scanner.checkToken(Token$ID.FlowEntry)) {
               token = this.this$0.scanner.peekToken();
               throw new ParserException("while parsing a flow mapping", (Mark)ParserImpl.access$1100(this.this$0).pop(), "expected ',' or '}', but got " + token.getTokenId(), token.getStartMark());
            }

            this.this$0.scanner.getToken();
         }

         if (this.this$0.scanner.checkToken(Token$ID.Key)) {
            token = this.this$0.scanner.getToken();
            if (!this.this$0.scanner.checkToken(Token$ID.Value, Token$ID.FlowEntry, Token$ID.FlowMappingEnd)) {
               ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseFlowMappingValue(this.this$0, (ParserImpl$1)null));
               return ParserImpl.access$2400(this.this$0);
            }

            ParserImpl.access$102(this.this$0, new ParserImpl$ParseFlowMappingValue(this.this$0, (ParserImpl$1)null));
            return ParserImpl.access$1200(this.this$0, token.getEndMark());
         }

         if (!this.this$0.scanner.checkToken(Token$ID.FlowMappingEnd)) {
            ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseFlowMappingEmptyValue(this.this$0, (ParserImpl$1)null));
            return ParserImpl.access$2400(this.this$0);
         }
      }

      token = this.this$0.scanner.getToken();
      Event event = new MappingEndEvent(token.getStartMark(), token.getEndMark());
      ParserImpl.access$102(this.this$0, (Production)ParserImpl.access$600(this.this$0).pop());
      ParserImpl.access$1100(this.this$0).pop();
      return event;
   }
}
