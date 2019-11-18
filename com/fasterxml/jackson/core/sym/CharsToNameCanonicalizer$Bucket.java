package com.fasterxml.jackson.core.sym;

final class CharsToNameCanonicalizer$Bucket {
   public final String symbol;
   public final CharsToNameCanonicalizer$Bucket next;
   public final int length;

   public CharsToNameCanonicalizer$Bucket(String s, CharsToNameCanonicalizer$Bucket n) {
      this.symbol = s;
      this.next = n;
      this.length = n == null ? 1 : n.length + 1;
   }

   public String has(char[] buf, int start, int len) {
      if (this.symbol.length() != len) {
         return null;
      } else {
         int i = 0;

         while(this.symbol.charAt(i) == buf[start + i]) {
            ++i;
            if (i >= len) {
               return this.symbol;
            }
         }

         return null;
      }
   }
}
