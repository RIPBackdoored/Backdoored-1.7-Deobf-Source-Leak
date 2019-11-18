package com.google.api.client.repackaged.com.google.common.base;

import java.util.Iterator;

final class Optional$1 implements Iterable {
   // $FF: synthetic field
   final Iterable val$optionals;

   Optional$1(Iterable var1) {
      this.val$optionals = var1;
   }

   public Iterator iterator() {
      return new Optional$1$1(this);
   }
}
