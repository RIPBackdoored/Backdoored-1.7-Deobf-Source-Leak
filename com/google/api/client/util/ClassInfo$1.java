package com.google.api.client.util;

import java.util.Comparator;

class ClassInfo$1 implements Comparator {
   // $FF: synthetic field
   final ClassInfo this$0;

   ClassInfo$1(ClassInfo this$0) {
      this.this$0 = this$0;
   }

   public int compare(String s0, String s1) {
      return Objects.equal(s0, s1) ? 0 : (s0 == null ? -1 : (s1 == null ? 1 : s0.compareTo(s1)));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object var1, Object var2) {
      return this.compare((String)var1, (String)var2);
   }
}
