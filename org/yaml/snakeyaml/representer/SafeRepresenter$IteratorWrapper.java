package org.yaml.snakeyaml.representer;

import java.util.Iterator;

class SafeRepresenter$IteratorWrapper implements Iterable {
   private Iterator iter;

   public SafeRepresenter$IteratorWrapper(Iterator iter) {
      this.iter = iter;
   }

   public Iterator iterator() {
      return this.iter;
   }
}
