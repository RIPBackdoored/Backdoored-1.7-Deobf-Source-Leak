package org.yaml.snakeyaml;

import java.util.Iterator;

class Yaml$NodeIterable implements Iterable {
   private Iterator iterator;

   public Yaml$NodeIterable(Iterator iterator) {
      this.iterator = iterator;
   }

   public Iterator iterator() {
      return this.iterator;
   }
}
