package org.json;

import java.util.Iterator;

class XML$1$1 implements Iterator {
   private int nextIndex;
   private int length;
   // $FF: synthetic field
   final XML$1 this$0;

   XML$1$1(XML$1 this$0) {
      this.this$0 = this$0;
      this.nextIndex = 0;
      this.length = this.this$0.val$string.length();
   }

   public boolean hasNext() {
      return this.nextIndex < this.length;
   }

   public Integer next() {
      int result = this.this$0.val$string.codePointAt(this.nextIndex);
      this.nextIndex += Character.charCount(result);
      return result;
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
