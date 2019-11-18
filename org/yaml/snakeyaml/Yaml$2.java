package org.yaml.snakeyaml;

import java.util.Iterator;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.nodes.Node;

class Yaml$2 implements Iterator {
   // $FF: synthetic field
   final Composer val$composer;
   // $FF: synthetic field
   final Yaml this$0;

   Yaml$2(Yaml this$0, Composer var2) {
      this.this$0 = this$0;
      this.val$composer = var2;
   }

   public boolean hasNext() {
      return this.val$composer.checkNode();
   }

   public Node next() {
      return this.val$composer.getNode();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object next() {
      return this.next();
   }
}
