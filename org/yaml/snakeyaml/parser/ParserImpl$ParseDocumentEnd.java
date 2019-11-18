package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseDocumentEnd implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseDocumentEnd(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      Token token = this.this$0.scanner.peekToken();
      Mark startMark = token.getStartMark();
      Mark endMark = startMark;
      boolean explicit = false;
      if (this.this$0.scanner.checkToken(Token$ID.DocumentEnd)) {
         token = this.this$0.scanner.getToken();
         endMark = token.getEndMark();
         explicit = true;
      }

      Event event = new DocumentEndEvent(startMark, endMark, explicit);
      ParserImpl.access$102(this.this$0, new ParserImpl$ParseDocumentStart(this.this$0, (ParserImpl$1)null));
      return event;
   }

   // $FF: synthetic method
   ParserImpl$ParseDocumentEnd(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
