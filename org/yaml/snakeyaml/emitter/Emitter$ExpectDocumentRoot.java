package org.yaml.snakeyaml.emitter;

import java.io.IOException;

class Emitter$ExpectDocumentRoot implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectDocumentRoot(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      Emitter.access$1500(this.this$0).push(new Emitter$ExpectDocumentEnd(this.this$0, (Emitter$1)null));
      Emitter.access$1600(this.this$0, true, false, false);
   }

   // $FF: synthetic method
   Emitter$ExpectDocumentRoot(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
