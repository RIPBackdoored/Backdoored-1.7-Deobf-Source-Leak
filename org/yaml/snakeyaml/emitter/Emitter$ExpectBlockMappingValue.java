package org.yaml.snakeyaml.emitter;

import java.io.IOException;

class Emitter$ExpectBlockMappingValue implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectBlockMappingValue(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      this.this$0.writeIndent();
      this.this$0.writeIndicator(":", true, false, true);
      Emitter.access$1500(this.this$0).push(new Emitter$ExpectBlockMappingKey(this.this$0, false));
      Emitter.access$1600(this.this$0, false, true, false);
   }

   // $FF: synthetic method
   Emitter$ExpectBlockMappingValue(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
