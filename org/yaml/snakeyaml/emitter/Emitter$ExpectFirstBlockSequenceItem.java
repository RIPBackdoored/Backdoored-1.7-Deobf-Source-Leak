package org.yaml.snakeyaml.emitter;

import java.io.IOException;

class Emitter$ExpectFirstBlockSequenceItem implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectFirstBlockSequenceItem(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      (new Emitter$ExpectBlockSequenceItem(this.this$0, true)).expect();
   }

   // $FF: synthetic method
   Emitter$ExpectFirstBlockSequenceItem(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
