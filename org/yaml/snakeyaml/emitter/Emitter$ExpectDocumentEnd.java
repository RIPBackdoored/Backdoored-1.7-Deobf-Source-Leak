package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import org.yaml.snakeyaml.events.DocumentEndEvent;

class Emitter$ExpectDocumentEnd implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectDocumentEnd(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      if (Emitter.access$100(this.this$0) instanceof DocumentEndEvent) {
         this.this$0.writeIndent();
         if (((DocumentEndEvent)Emitter.access$100(this.this$0)).getExplicit()) {
            this.this$0.writeIndicator("...", true, false, false);
            this.this$0.writeIndent();
         }

         this.this$0.flushStream();
         Emitter.access$202(this.this$0, new Emitter$ExpectDocumentStart(this.this$0, false));
      } else {
         throw new EmitterException("expected DocumentEndEvent, but got " + Emitter.access$100(this.this$0));
      }
   }

   // $FF: synthetic method
   Emitter$ExpectDocumentEnd(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
