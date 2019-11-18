package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import org.yaml.snakeyaml.events.SequenceEndEvent;

class Emitter$ExpectBlockSequenceItem implements EmitterState {
   private boolean first;
   // $FF: synthetic field
   final Emitter this$0;

   public Emitter$ExpectBlockSequenceItem(Emitter var1, boolean first) {
      this.this$0 = var1;
      this.first = first;
   }

   public void expect() throws IOException {
      if (!this.first && Emitter.access$100(this.this$0) instanceof SequenceEndEvent) {
         Emitter.access$1802(this.this$0, (Integer)Emitter.access$1900(this.this$0).pop());
         Emitter.access$202(this.this$0, (EmitterState)Emitter.access$1500(this.this$0).pop());
      } else {
         this.this$0.writeIndent();
         Emitter.access$3300(this.this$0, Emitter.access$3200(this.this$0));
         this.this$0.writeIndicator("-", true, false, true);
         Emitter.access$1500(this.this$0).push(new Emitter$ExpectBlockSequenceItem(this.this$0, false));
         Emitter.access$1600(this.this$0, false, false, false);
      }

   }
}
