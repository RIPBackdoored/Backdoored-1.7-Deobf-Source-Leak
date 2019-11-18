package com.google.api.client.util;

import java.util.Collection;

public final class Collections2 {
   static Collection cast(Iterable iterable) {
      return (Collection)iterable;
   }

   private Collections2() {
   }
}
