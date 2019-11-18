package com.google.api.client.repackaged.com.google.common.base;

import java.util.Iterator;

class Optional$1$1 extends AbstractIterator {
   private final Iterator iterator;
   // $FF: synthetic field
   final Optional$1 this$0;

   Optional$1$1(Optional$1 var1) {
      this.this$0 = var1;
      this.iterator = (Iterator)Preconditions.checkNotNull(this.this$0.val$optionals.iterator());
   }

   protected Object computeNext() {
      while(true) {
         if (this.iterator.hasNext()) {
            Optional optional = (Optional)this.iterator.next();
            if (!optional.isPresent()) {
               continue;
            }

            return optional.get();
         }

         return this.endOfData();
      }
   }
}
