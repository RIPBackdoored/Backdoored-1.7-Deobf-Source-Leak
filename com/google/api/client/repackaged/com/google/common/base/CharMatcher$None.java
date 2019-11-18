package com.google.api.client.repackaged.com.google.common.base;

final class CharMatcher$None extends CharMatcher$NamedFastMatcher {
   static final CharMatcher$None INSTANCE = new CharMatcher$None();

   private CharMatcher$None() {
      super("CharMatcher.none()");
   }

   public boolean matches(char c) {
      return false;
   }

   public int indexIn(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return -1;
   }

   public int indexIn(CharSequence sequence, int start) {
      int length = sequence.length();
      Preconditions.checkPositionIndex(start, length);
      return -1;
   }

   public int lastIndexIn(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return -1;
   }

   public boolean matchesAllOf(CharSequence sequence) {
      return sequence.length() == 0;
   }

   public boolean matchesNoneOf(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return true;
   }

   public String removeFrom(CharSequence sequence) {
      return sequence.toString();
   }

   public String replaceFrom(CharSequence sequence, char replacement) {
      return sequence.toString();
   }

   public String replaceFrom(CharSequence sequence, CharSequence replacement) {
      Preconditions.checkNotNull(replacement);
      return sequence.toString();
   }

   public String collapseFrom(CharSequence sequence, char replacement) {
      return sequence.toString();
   }

   public String trimFrom(CharSequence sequence) {
      return sequence.toString();
   }

   public String trimLeadingFrom(CharSequence sequence) {
      return sequence.toString();
   }

   public String trimTrailingFrom(CharSequence sequence) {
      return sequence.toString();
   }

   public int countIn(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return 0;
   }

   public CharMatcher and(CharMatcher other) {
      Preconditions.checkNotNull(other);
      return this;
   }

   public CharMatcher or(CharMatcher other) {
      return (CharMatcher)Preconditions.checkNotNull(other);
   }

   public CharMatcher negate() {
      return any();
   }
}
