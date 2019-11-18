package com.fasterxml.jackson.core.sym;

final class CharsToNameCanonicalizer$TableInfo {
   final int size;
   final int longestCollisionList;
   final String[] symbols;
   final CharsToNameCanonicalizer$Bucket[] buckets;

   public CharsToNameCanonicalizer$TableInfo(int size, int longestCollisionList, String[] symbols, CharsToNameCanonicalizer$Bucket[] buckets) {
      this.size = size;
      this.longestCollisionList = longestCollisionList;
      this.symbols = symbols;
      this.buckets = buckets;
   }

   public CharsToNameCanonicalizer$TableInfo(CharsToNameCanonicalizer src) {
      this.size = CharsToNameCanonicalizer.access$000(src);
      this.longestCollisionList = CharsToNameCanonicalizer.access$100(src);
      this.symbols = CharsToNameCanonicalizer.access$200(src);
      this.buckets = CharsToNameCanonicalizer.access$300(src);
   }

   public static CharsToNameCanonicalizer$TableInfo createInitial(int sz) {
      return new CharsToNameCanonicalizer$TableInfo(0, 0, new String[sz], new CharsToNameCanonicalizer$Bucket[sz >> 1]);
   }
}
