package org.yaml.snakeyaml.emitter;

import java.io.IOException;

class Emitter$ExpectBlockMappingSimpleValue implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectBlockMappingSimpleValue(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      this.this$0.writeIndicator(":", false, false, false);
      Emitter.access$1500(this.this$0).push(new Emitter$ExpectBlockMappingKey(this.this$0, false));
      Emitter.access$1600(this.this$0, false, true, false);
   }

   // $FF: synthetic method
   Emitter$ExpectBlockMappingSimpleValue(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
