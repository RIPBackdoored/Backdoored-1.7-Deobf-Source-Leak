package org.yaml.snakeyaml;

import java.util.Iterator;

class Yaml$EventIterable implements Iterable {
   private Iterator iterator;

   public Yaml$EventIterable(Iterator iterator) {
      this.iterator = iterator;
   }

   public Iterator iterator() {
      return this.iterator;
   }
}
