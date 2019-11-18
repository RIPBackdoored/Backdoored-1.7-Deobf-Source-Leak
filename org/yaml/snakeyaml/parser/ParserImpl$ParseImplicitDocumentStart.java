package org.yaml.snakeyaml.parser;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions$Version;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseImplicitDocumentStart implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseImplicitDocumentStart(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      if (!this.this$0.scanner.checkToken(Token$ID.Directive, Token$ID.DocumentStart, Token$ID.StreamEnd)) {
         ParserImpl.access$302(this.this$0, new VersionTagsTuple((DumperOptions$Version)null, ParserImpl.access$400()));
         Token token = this.this$0.scanner.peekToken();
         Mark startMark = token.getStartMark();
         Event event = new DocumentStartEvent(startMark, startMark, false, (DumperOptions$Version)null, (Map)null);
         ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseDocumentEnd(this.this$0, (ParserImpl$1)null));
         ParserImpl.access$102(this.this$0, new ParserImpl$ParseBlockNode(this.this$0, (ParserImpl$1)null));
         return event;
      } else {
         Production p = new ParserImpl$ParseDocumentStart(this.this$0, (ParserImpl$1)null);
         return p.produce();
      }
   }

   // $FF: synthetic method
   ParserImpl$ParseImplicitDocumentStart(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
