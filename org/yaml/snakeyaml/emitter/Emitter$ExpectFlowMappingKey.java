package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import org.yaml.snakeyaml.events.MappingEndEvent;

class Emitter$ExpectFlowMappingKey implements EmitterState {
   // $FF: synthetic field
   final Emitter this$0;

   private Emitter$ExpectFlowMappingKey(Emitter var1) {
      this.this$0 = var1;
   }

   public void expect() throws IOException {
      if (Emitter.access$100(this.this$0) instanceof MappingEndEvent) {
         Emitter.access$1802(this.this$0, (Integer)Emitter.access$1900(this.this$0).pop());
         Emitter.access$2010(this.this$0);
         if (Emitter.access$1000(this.this$0)) {
            this.this$0.writeIndicator(",", false, false, false);
            this.this$0.writeIndent();
         }

         if (Emitter.access$2400(this.this$0)) {
            this.this$0.writeIndent();
         }

         this.this$0.writeIndicator("}", false, false, false);
         Emitter.access$202(this.this$0, (EmitterState)Emitter.access$1500(this.this$0).pop());
      } else {
         this.this$0.writeIndicator(",", false, false, false);
         if (Emitter.access$1000(this.this$0) || Emitter.access$2100(this.this$0) > Emitter.access$2200(this.this$0) && Emitter.access$2300(this.this$0) || Emitter.access$2400(this.this$0)) {
            this.this$0.writeIndent();
         }

         if (!Emitter.access$1000(this.this$0) && Emitter.access$2700(this.this$0)) {
            Emitter.access$1500(this.this$0).push(new Emitter$ExpectFlowMappingSimpleValue(this.this$0, (Emitter$1)null));
            Emitter.access$1600(this.this$0, false, true, true);
         } else {
            this.this$0.writeIndicator("?", true, false, false);
            Emitter.access$1500(this.this$0).push(new Emitter$ExpectFlowMappingValue(this.this$0, (Emitter$1)null));
            Emitter.access$1600(this.this$0, false, true, false);
         }
      }

   }

   // $FF: synthetic method
   Emitter$ExpectFlowMappingKey(Emitter x0, Emitter$1 x1) {
      this(x0);
   }
}
