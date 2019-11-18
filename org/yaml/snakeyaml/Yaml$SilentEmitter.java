package org.yaml.snakeyaml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.yaml.snakeyaml.emitter.Emitable;
import org.yaml.snakeyaml.events.Event;

class Yaml$SilentEmitter implements Emitable {
   private List events;

   private Yaml$SilentEmitter() {
      this.events = new ArrayList(100);
   }

   public List getEvents() {
      return this.events;
   }

   public void emit(Event event) throws IOException {
      this.events.add(event);
   }

   // $FF: synthetic method
   Yaml$SilentEmitter(Yaml$1 x0) {
      this();
   }
}
