package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractIterator implements Iterator {
   private AbstractIterator$State state;
   private Object next;

   protected AbstractIterator() {
      this.state = AbstractIterator$State.NOT_READY;
   }

   protected abstract Object computeNext();

   @Nullable
   @CanIgnoreReturnValue
   protected final Object endOfData() {
      this.state = AbstractIterator$State.DONE;
      return null;
   }

   public final boolean hasNext() {
      // $FF: Couldn't be decompiled
   }

   private boolean tryToComputeNext() {
      this.state = AbstractIterator$State.FAILED;
      this.next = this.computeNext();
      if (this.state != AbstractIterator$State.DONE) {
         this.state = AbstractIterator$State.READY;
         return true;
      } else {
         return false;
      }
   }

   public final Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.state = AbstractIterator$State.NOT_READY;
         Object result = this.next;
         this.next = null;
         return result;
      }
   }

   public final void remove() {
      throw new UnsupportedOperationException();
   }
}
