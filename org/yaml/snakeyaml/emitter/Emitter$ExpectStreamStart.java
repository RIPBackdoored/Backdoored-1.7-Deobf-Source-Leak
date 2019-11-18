package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import org.yaml.snakeyaml.events.StreamStartEvent;

class Emitter$ExpectStreamStart implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectStreamStart(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      if (Emitter.access$100(this.this$0) instanceof StreamStartEvent) {
         this.this$0.writeStreamStart();
         Emitter.access$202(this.this$0, new Emitter$ExpectFirstDocumentStart(this.this$0, (Emitter$1)null));
      } else {
         throw new EmitterException("expected StreamStartEvent, but got " + Emitter.access$100(this.this$0));
      }
   }

   // $FF: synthetic method
   Emitter$ExpectStreamStart(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
