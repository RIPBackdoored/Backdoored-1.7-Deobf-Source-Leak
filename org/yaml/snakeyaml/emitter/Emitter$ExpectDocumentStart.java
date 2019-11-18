package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;

class Emitter$ExpectDocumentStart implements EmitterState {
   private boolean first;
   // $FF: synthetic field
   final Emitter this$0;

   public Emitter$ExpectDocumentStart(Emitter var1, boolean first) {
      this.this$0 = var1;
      this.first = first;
   }

   public void expect() throws IOException {
      if (Emitter.access$100(this.this$0) instanceof DocumentStartEvent) {
         DocumentStartEvent ev = (DocumentStartEvent)Emitter.access$100(this.this$0);
         if ((ev.getVersion() != null || ev.getTags() != null) && Emitter.access$400(this.this$0)) {
            this.this$0.writeIndicator("...", true, false, false);
            this.this$0.writeIndent();
         }

         if (ev.getVersion() != null) {
            String versionText = Emitter.access$500(this.this$0, ev.getVersion());
            this.this$0.writeVersionDirective(versionText);
         }

         Emitter.access$602(this.this$0, new LinkedHashMap(Emitter.access$700()));
         if (ev.getTags() != null) {
            Set handles = new TreeSet(ev.getTags().keySet());
            Iterator var3 = handles.iterator();

            while(var3.hasNext()) {
               String handle = (String)var3.next();
               String prefix = (String)ev.getTags().get(handle);
               Emitter.access$600(this.this$0).put(prefix, handle);
               String handleText = Emitter.access$800(this.this$0, handle);
               String prefixText = Emitter.access$900(this.this$0, prefix);
               this.this$0.writeTagDirective(handleText, prefixText);
            }
         }

         boolean implicit = this.first && !ev.getExplicit() && !Emitter.access$1000(this.this$0) && ev.getVersion() == null && (ev.getTags() == null || ev.getTags().isEmpty()) && !Emitter.access$1100(this.this$0);
         if (!implicit) {
            this.this$0.writeIndent();
            this.this$0.writeIndicator("---", true, false, false);
            if (Emitter.access$1000(this.this$0)) {
               this.this$0.writeIndent();
            }
         }

         Emitter.access$202(this.this$0, new Emitter$ExpectDocumentRoot(this.this$0, (Emitter$1)null));
      } else {
         if (!(Emitter.access$100(this.this$0) instanceof StreamEndEvent)) {
            throw new EmitterException("expected DocumentStartEvent, but got " + Emitter.access$100(this.this$0));
         }

         this.this$0.writeStreamEnd();
         Emitter.access$202(this.this$0, new Emitter$ExpectNothing(this.this$0, (Emitter$1)null));
      }

   }
}
