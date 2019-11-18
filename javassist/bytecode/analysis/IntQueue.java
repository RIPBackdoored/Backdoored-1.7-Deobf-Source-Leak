package javassist.bytecode.analysis;

import java.util.NoSuchElementException;

class IntQueue {
   private IntQueue$Entry head;
   private IntQueue$Entry tail;

   void add(int value) {
      IntQueue$Entry entry = new IntQueue$Entry(value, (IntQueue$1)null);
      if (this.tail != null) {
         IntQueue$Entry.access$102(this.tail, entry);
      }

      this.tail = entry;
      if (this.head == null) {
         this.head = entry;
      }

   }

   boolean isEmpty() {
      return this.head == null;
   }

   int take() {
      if (this.head == null) {
         throw new NoSuchElementException();
      } else {
         int value = IntQueue$Entry.access$200(this.head);
         this.head = IntQueue$Entry.access$100(this.head);
         if (this.head == null) {
            this.tail = null;
         }

         return value;
      }
   }
}
