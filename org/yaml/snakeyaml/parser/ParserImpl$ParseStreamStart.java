package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.tokens.StreamStartToken;

class ParserImpl$ParseStreamStart implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseStreamStart(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      StreamStartToken token = (StreamStartToken)this.this$0.scanner.getToken();
      Event event = new StreamStartEvent(token.getStartMark(), token.getEndMark());
      ParserImpl.access$102(this.this$0, new ParserImpl$ParseImplicitDocumentStart(this.this$0, (ParserImpl$1)null));
      return event;
   }

   // $FF: synthetic method
   ParserImpl$ParseStreamStart(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
