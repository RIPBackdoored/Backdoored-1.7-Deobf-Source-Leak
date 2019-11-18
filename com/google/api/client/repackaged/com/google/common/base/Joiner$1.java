package com.google.api.client.repackaged.com.google.common.base;

import javax.annotation.Nullable;

class Joiner$1 extends Joiner {
   // $FF: synthetic field
   final String val$nullText;
   // $FF: synthetic field
   final Joiner this$0;

   Joiner$1(Joiner var1, Joiner x0, String var3) {
      super(x0, (Joiner$1)null);
      this.this$0 = var1;
      this.val$nullText = var3;
   }

   CharSequence toString(@Nullable Object part) {
      return (CharSequence)(part == null ? this.val$nullText : this.this$0.toString(part));
   }

   public Joiner useForNull(String nullText) {
      throw new UnsupportedOperationException("already specified useForNull");
   }

   public Joiner skipNulls() {
      throw new UnsupportedOperationException("already specified useForNull");
   }
}
