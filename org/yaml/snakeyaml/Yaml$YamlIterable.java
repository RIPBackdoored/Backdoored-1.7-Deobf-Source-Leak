package org.yaml.snakeyaml;

import java.util.Iterator;

class Yaml$YamlIterable implements Iterable {
   private Iterator iterator;

   public Yaml$YamlIterable(Iterator iterator) {
      this.iterator = iterator;
   }

   public Iterator iterator() {
      return this.iterator;
   }
}
