package com.google.api.client.repackaged.com.google.common.base;

import java.util.Arrays;

final class CharMatcher$Any extends CharMatcher$NamedFastMatcher {
   static final CharMatcher$Any INSTANCE = new CharMatcher$Any();

   private CharMatcher$Any() {
      super("CharMatcher.any()");
   }

   public boolean matches(char c) {
      return true;
   }

   public int indexIn(CharSequence sequence) {
      return sequence.length() == 0 ? -1 : 0;
   }

   public int indexIn(CharSequence sequence, int start) {
      int length = sequence.length();
      Preconditions.checkPositionIndex(start, length);
      return start == length ? -1 : start;
   }

   public int lastIndexIn(CharSequence sequence) {
      return sequence.length() - 1;
   }

   public boolean matchesAllOf(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return true;
   }

   public boolean matchesNoneOf(CharSequence sequence) {
      return sequence.length() == 0;
   }

   public String removeFrom(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return "";
   }

   public String replaceFrom(CharSequence sequence, char replacement) {
      char[] array = new char[sequence.length()];
      Arrays.fill(array, replacement);
      return new String(array);
   }

   public String replaceFrom(CharSequence sequence, CharSequence replacement) {
      StringBuilder result = new StringBuilder(sequence.length() * replacement.length());

      for(int i = 0; i < sequence.length(); ++i) {
         result.append(replacement);
      }

      return result.toString();
   }

   public String collapseFrom(CharSequence sequence, char replacement) {
      return sequence.length() == 0 ? "" : String.valueOf(replacement);
   }

   public String trimFrom(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return "";
   }

   public int countIn(CharSequence sequence) {
      return sequence.length();
   }

   public CharMatcher and(CharMatcher other) {
      return (CharMatcher)Preconditions.checkNotNull(other);
   }

   public CharMatcher or(CharMatcher other) {
      Preconditions.checkNotNull(other);
      return this;
   }

   public CharMatcher negate() {
      return none();
   }
}
