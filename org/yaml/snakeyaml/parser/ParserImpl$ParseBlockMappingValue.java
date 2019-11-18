package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;

class ParserImpl$ParseBlockMappingValue implements Production {
   // $FF: synthetic field
   final ParserImpl this$0;

   private ParserImpl$ParseBlockMappingValue(ParserImpl var1) {
      this.this$0 = var1;
   }

   public Event produce() {
      Token token;
      if (this.this$0.scanner.checkToken(Token$ID.Value)) {
         token = this.this$0.scanner.getToken();
         if (!this.this$0.scanner.checkToken(Token$ID.Key, Token$ID.Value, Token$ID.BlockEnd)) {
            ParserImpl.access$600(this.this$0).push(new ParserImpl$ParseBlockMappingKey(this.this$0, (ParserImpl$1)null));
            return ParserImpl.access$2200(this.this$0);
         } else {
            ParserImpl.access$102(this.this$0, new ParserImpl$ParseBlockMappingKey(this.this$0, (ParserImpl$1)null));
            return ParserImpl.access$1200(this.this$0, token.getEndMark());
         }
      } else {
         ParserImpl.access$102(this.this$0, new ParserImpl$ParseBlockMappingKey(this.this$0, (ParserImpl$1)null));
         token = this.this$0.scanner.peekToken();
         return ParserImpl.access$1200(this.this$0, token.getStartMark());
      }
   }

   // $FF: synthetic method
   ParserImpl$ParseBlockMappingValue(ParserImpl x0, ParserImpl$1 x1) {
      this(x0);
   }
}
