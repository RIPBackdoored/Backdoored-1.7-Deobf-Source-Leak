package org.yaml.snakeyaml.util;

import java.util.AbstractList;

class ArrayUtils$UnmodifiableArrayList extends AbstractList {
   private final Object[] array;

   ArrayUtils$UnmodifiableArrayList(Object[] array) {
      this.array = array;
   }

   public Object get(int index) {
      if (index >= this.array.length) {
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size());
      } else {
         return this.array[index];
      }
   }

   public int size() {
      return this.array.length;
   }
}
