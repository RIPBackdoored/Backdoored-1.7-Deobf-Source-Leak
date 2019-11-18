package org.yaml.snakeyaml;

import java.util.Iterator;

class Yaml$1 implements Iterator {
   // $FF: synthetic field
   final Yaml this$0;

   Yaml$1(Yaml this$0) {
      this.this$0 = this$0;
   }

   public boolean hasNext() {
      return this.this$0.constructor.checkData();
   }

   public Object next() {
      return this.this$0.constructor.getData();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
