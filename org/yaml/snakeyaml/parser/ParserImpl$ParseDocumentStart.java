package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseDocumentStart implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseDocumentStart(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      while(this.this$0.scanner.checkToken(Token$ID.DocumentEnd)) {
         this.this$0.scanner.getToken();
      }

      Object event;
      if (!this.this$0.scanner.checkToken(Token$ID.StreamEnd)) {
         Token token = this.this$0.scanner.peekToken();
         Mark startMark = token.getStartMark();
         VersionTagsTuple tuple = ParserImpl.access$900(this.this$0);
         if (!this.this$0.scanner.checkToken(Token$ID.DocumentStart)) {
            throw new ParserException((String)null, (Mark)null, "expected '<document start>', but found " + this.this$0.scanner.peekToken().getTokenId(), this.this$0.scanner.peekToken().getStartMark());
         }

         token = this.this$0.scanner.getToken();
         Mark endMark = token.getEndMark();
         event = new DocumentStartEvent(startMark, endMark, true, tuple.getVersion(), tuple.getTags());
         ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseDocumentEnd(this.this$0, (ParserImpl$1)null));
         ParserImpl.access$102(this.this$0, new ParserImpl$ParseDocumentContent(this.this$0, (ParserImpl$1)null));
      } else {
         StreamEndToken token = (StreamEndToken)this.this$0.scanner.getToken();
         event = new StreamEndEvent(token.getStartMark(), token.getEndMark());
         if (!ParserImpl.access$600(this.this$0).isEmpty()) {
            throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.access$600(this.this$0));
         }

         if (!ParserImpl.access$1100(this.this$0).isEmpty()) {
            throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.access$1100(this.this$0));
         }

         ParserImpl.access$102(this.this$0, (Production)null);
      }

      return (Event)event;
   }

   // $FF: synthetic method
   ParserImpl$ParseDocumentStart(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
