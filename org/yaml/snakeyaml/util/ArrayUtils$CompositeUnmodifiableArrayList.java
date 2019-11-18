package org.yaml.snakeyaml.util;

import java.util.AbstractList;

class ArrayUtils$CompositeUnmodifiableArrayList extends AbstractList {
   private final Object[] array1;
   private final Object[] array2;

   ArrayUtils$CompositeUnmodifiableArrayList(Object[] array1, Object[] array2) {
      this.array1 = array1;
      this.array2 = array2;
   }

   public Object get(int index) {
      Object element;
      if (index < this.array1.length) {
         element = this.array1[index];
      } else {
         if (index - this.array1.length >= this.array2.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size());
         }

         element = this.array2[index - this.array1.length];
      }

      return element;
   }

   public int size() {
      return this.array1.length + this.array2.length;
   }
}
