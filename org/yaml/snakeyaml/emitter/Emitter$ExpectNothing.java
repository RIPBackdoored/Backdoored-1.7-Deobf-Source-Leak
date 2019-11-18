package org.yaml.snakeyaml.emitter;

import java.io.IOException;

class Emitter$ExpectNothing implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectNothing(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      throw new EmitterException("expecting nothing, but got " + Emitter.access$100(this.this$0));
   }

   // $FF: synthetic method
   Emitter$ExpectNothing(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
