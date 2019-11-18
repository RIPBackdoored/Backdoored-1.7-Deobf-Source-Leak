package com.google.api.client.repackaged.com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

class Joiner$2 extends Joiner {
   // $FF: synthetic field
   final Joiner this$0;

   Joiner$2(Joiner var1, Joiner x0) {
      super(x0, (Joiner$1)null);
      this.this$0 = var1;
   }

   public Appendable appendTo(Appendable appendable, Iterator parts) throws IOException {
      Preconditions.checkNotNull(appendable, "appendable");
      Preconditions.checkNotNull(parts, "parts");

      Object part;
      while(parts.hasNext()) {
         part = parts.next();
         if (part != null) {
            appendable.append(this.this$0.toString(part));
            break;
         }
      }

      while(parts.hasNext()) {
         part = parts.next();
         if (part != null) {
            appendable.append(Joiner.access$100(this.this$0));
            appendable.append(this.this$0.toString(part));
         }
      }

      return appendable;
   }

   public Joiner useForNull(String nullText) {
      throw new UnsupportedOperationException("already specified skipNulls");
   }

   public Joiner$MapJoiner withKeyValueSeparator(String kvs) {
      throw new UnsupportedOperationException("can't use .skipNulls() with maps");
   }
}
