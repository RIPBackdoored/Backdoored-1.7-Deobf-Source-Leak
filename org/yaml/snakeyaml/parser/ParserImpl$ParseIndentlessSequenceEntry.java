package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseIndentlessSequenceEntry implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseIndentlessSequenceEntry(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      Token token;
      if (this.this$0.scanner.checkToken(Token$ID.BlockEntry)) {
         token = this.this$0.scanner.getToken();
         if (!this.this$0.scanner.checkToken(Token$ID.BlockEntry, Token$ID.Key, Token$ID.Value, Token$ID.BlockEnd)) {
            ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseIndentlessSequenceEntry(this.this$0));
            return (new ParserImpl$ParseBlockNode(this.this$0, (ParserImpl$1)null)).produce();
         } else {
            ParserImpl.access$102(this.this$0, new ParserImpl$ParseIndentlessSequenceEntry(this.this$0));
            return ParserImpl.access$1200(this.this$0, token.getEndMark());
         }
      } else {
         token = this.this$0.scanner.peekToken();
         Event event = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
         ParserImpl.access$102(this.this$0, (Production)ParserImpl.access$600(this.this$0).pop());
         return event;
      }
   }

   // $FF: synthetic method
   ParserImpl$ParseIndentlessSequenceEntry(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
