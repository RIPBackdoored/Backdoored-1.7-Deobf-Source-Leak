package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseDocumentContent implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseDocumentContent(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      if (this.this$0.scanner.checkToken(Token$ID.Directive, Token$ID.DocumentStart, Token$ID.DocumentEnd, Token$ID.StreamEnd)) {
         Event event = ParserImpl.access$1200(this.this$0, this.this$0.scanner.peekToken().getStartMark());
         ParserImpl.access$102(this.this$0, (Production)ParserImpl.access$600(this.this$0).pop());
         return event;
      } else {
         Production p = new ParserImpl$ParseBlockNode(this.this$0, (ParserImpl$1)null);
         return p.produce();
      }
   }

   // $FF: synthetic method
   ParserImpl$ParseDocumentContent(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
