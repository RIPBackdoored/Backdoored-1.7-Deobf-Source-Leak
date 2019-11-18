package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseBlockSequenceEntry implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseBlockSequenceEntry(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      if (this.this$0.scanner.checkToken(Token$ID.BlockEntry)) {
         BlockEntryToken token = (BlockEntryToken)this.this$0.scanner.getToken();
         if (!this.this$0.scanner.checkToken(Token$ID.BlockEntry, Token$ID.BlockEnd)) {
            ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseBlockSequenceEntry(this.this$0));
            return (new ParserImpl$ParseBlockNode(this.this$0, (ParserImpl$1)null)).produce();
         } else {
            ParserImpl.access$102(this.this$0, new ParserImpl$ParseBlockSequenceEntry(this.this$0));
            return ParserImpl.access$1200(this.this$0, token.getEndMark());
         }
      } else {
         Token token;
         if (!this.this$0.scanner.checkToken(Token$ID.BlockEnd)) {
            token = this.this$0.scanner.peekToken();
            throw new ParserException("while parsing a block collection", (Mark)ParserImpl.access$1100(this.this$0).pop(), "expected <block end>, but found " + token.getTokenId(), token.getStartMark());
         } else {
            token = this.this$0.scanner.getToken();
            Event event = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl.access$102(this.this$0, (Production)ParserImpl.access$600(this.this$0).pop());
            ParserImpl.access$1100(this.this$0).pop();
            return event;
         }
      }
   }

   // $FF: synthetic method
   ParserImpl$ParseBlockSequenceEntry(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
