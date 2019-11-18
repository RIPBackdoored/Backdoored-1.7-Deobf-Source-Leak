package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseFlowSequenceEntry implements Production {
   private boolean first;
   // $FF: synthetic field
   final ParserImpl this$0;

   public ParserImpl$ParseFlowSequenceEntry(ParserImpl var1, boolean first) {
      this.this$0 = var1;
      this.first = false;
      this.first = first;
   }

   public Event produce() {
      Token token;
      if (!this.this$0.scanner.checkToken(Token$ID.FlowSequenceEnd)) {
         if (!this.first) {
            if (!this.this$0.scanner.checkToken(Token$ID.FlowEntry)) {
               token = this.this$0.scanner.peekToken();
               throw new ParserException("while parsing a flow sequence", (Mark)ParserImpl.access$1100(this.this$0).pop(), "expected ',' or ']', but got " + token.getTokenId(), token.getStartMark());
            }

            this.this$0.scanner.getToken();
         }

         if (this.this$0.scanner.checkToken(Token$ID.Key)) {
            token = this.this$0.scanner.peekToken();
            Event event = new MappingStartEvent((String)null, (String)null, true, token.getStartMark(), token.getEndMark(), Boolean.TRUE);
            ParserImpl.access$102(this.this$0, new ParserImpl$ParseFlowSequenceEntryMappingKey(this.this$0, (ParserImpl$1)null));
            return event;
         }

         if (!this.this$0.scanner.checkToken(Token$ID.FlowSequenceEnd)) {
            ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseFlowSequenceEntry(this.this$0, false));
            return ParserImpl.access$2400(this.this$0);
         }
      }

      token = this.this$0.scanner.getToken();
      Event event = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
      ParserImpl.access$102(this.this$0, (Production)ParserImpl.access$600(this.this$0).pop());
      ParserImpl.access$1100(this.this$0).pop();
      return event;
   }
}
