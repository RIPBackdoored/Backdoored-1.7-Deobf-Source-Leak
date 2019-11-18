package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

@GwtCompatible(
   emulated = true
)
public abstract class CharMatcher implements Predicate {
   /** @deprecated */
   @Deprecated
   public static final CharMatcher WHITESPACE = whitespace();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher BREAKING_WHITESPACE = breakingWhitespace();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher ASCII = ascii();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher DIGIT = digit();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher JAVA_DIGIT = javaDigit();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher JAVA_LETTER = javaLetter();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher JAVA_LETTER_OR_DIGIT = javaLetterOrDigit();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher JAVA_UPPER_CASE = javaUpperCase();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher JAVA_LOWER_CASE = javaLowerCase();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher JAVA_ISO_CONTROL = javaIsoControl();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher INVISIBLE = invisible();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher SINGLE_WIDTH = singleWidth();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher ANY = any();
   /** @deprecated */
   @Deprecated
   public static final CharMatcher NONE = none();
   private static final int DISTINCT_CHARS = 65536;

   public static CharMatcher any() {
      return CharMatcher$Any.INSTANCE;
   }

   public static CharMatcher none() {
      return CharMatcher$None.INSTANCE;
   }

   public static CharMatcher whitespace() {
      return CharMatcher$Whitespace.INSTANCE;
   }

   public static CharMatcher breakingWhitespace() {
      return CharMatcher$BreakingWhitespace.INSTANCE;
   }

   public static CharMatcher ascii() {
      return CharMatcher$Ascii.INSTANCE;
   }

   public static CharMatcher digit() {
      return CharMatcher$Digit.INSTANCE;
   }

   public static CharMatcher javaDigit() {
      return CharMatcher$JavaDigit.INSTANCE;
   }

   public static CharMatcher javaLetter() {
      return CharMatcher$JavaLetter.INSTANCE;
   }

   public static CharMatcher javaLetterOrDigit() {
      return CharMatcher$JavaLetterOrDigit.INSTANCE;
   }

   public static CharMatcher javaUpperCase() {
      return CharMatcher$JavaUpperCase.INSTANCE;
   }

   public static CharMatcher javaLowerCase() {
      return CharMatcher$JavaLowerCase.INSTANCE;
   }

   public static CharMatcher javaIsoControl() {
      return CharMatcher$JavaIsoControl.INSTANCE;
   }

   public static CharMatcher invisible() {
      return CharMatcher$Invisible.INSTANCE;
   }

   public static CharMatcher singleWidth() {
      return CharMatcher$SingleWidth.INSTANCE;
   }

   public static CharMatcher is(char match) {
      return new CharMatcher$Is(match);
   }

   public static CharMatcher isNot(char match) {
      return new CharMatcher$IsNot(match);
   }

   public static CharMatcher anyOf(CharSequence sequence) {
      switch(sequence.length()) {
      case 0:
         return none();
      case 1:
         return is(sequence.charAt(0));
      case 2:
         return isEither(sequence.charAt(0), sequence.charAt(1));
      default:
         return new CharMatcher$AnyOf(sequence);
      }
   }

   public static CharMatcher noneOf(CharSequence sequence) {
      return anyOf(sequence).negate();
   }

   public static CharMatcher inRange(char startInclusive, char endInclusive) {
      return new CharMatcher$InRange(startInclusive, endInclusive);
   }

   public static CharMatcher forPredicate(Predicate predicate) {
      return (CharMatcher)(predicate instanceof CharMatcher ? (CharMatcher)predicate : new CharMatcher$ForPredicate(predicate));
   }

   protected CharMatcher() {
   }

   public abstract boolean matches(char var1);

   public CharMatcher negate() {
      return new CharMatcher$Negated(this);
   }

   public CharMatcher and(CharMatcher other) {
      return new CharMatcher$And(this, other);
   }

   public CharMatcher or(CharMatcher other) {
      return new CharMatcher$Or(this, other);
   }

   public CharMatcher precomputed() {
      return Platform.precomputeCharMatcher(this);
   }

   @GwtIncompatible
   CharMatcher precomputedInternal() {
      BitSet table = new BitSet();
      this.setBits(table);
      int totalCharacters = table.cardinality();
      if (totalCharacters * 2 <= 65536) {
         return precomputedPositive(totalCharacters, table, this.toString());
      } else {
         table.flip(0, 65536);
         int negatedCharacters = 65536 - totalCharacters;
         String suffix = ".negate()";
         String description = this.toString();
         String negatedDescription = description.endsWith(suffix) ? description.substring(0, description.length() - suffix.length()) : description + suffix;
         return new CharMatcher$1(this, precomputedPositive(negatedCharacters, table, negatedDescription), description);
      }
   }

   @GwtIncompatible
   private static CharMatcher precomputedPositive(int totalCharacters, BitSet table, String description) {
      switch(totalCharacters) {
      case 0:
         return none();
      case 1:
         return is((char)table.nextSetBit(0));
      case 2:
         char c1 = (char)table.nextSetBit(0);
         char c2 = (char)table.nextSetBit(c1 + 1);
         return isEither(c1, c2);
      default:
         return (CharMatcher)(isSmall(totalCharacters, table.length()) ? SmallCharMatcher.from(table, description) : new CharMatcher$BitSetMatcher(table, description, (CharMatcher$1)null));
      }
   }

   @GwtIncompatible
   private static boolean isSmall(int totalCharacters, int tableLength) {
      return totalCharacters <= 1023 && tableLength > totalCharacters * 4 * 16;
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      for(int c = 65535; c >= 0; --c) {
         if (this.matches((char)c)) {
            table.set(c);
         }
      }

   }

   public boolean matchesAnyOf(CharSequence sequence) {
      return !this.matchesNoneOf(sequence);
   }

   public boolean matchesAllOf(CharSequence sequence) {
      for(int i = sequence.length() - 1; i >= 0; --i) {
         if (!this.matches(sequence.charAt(i))) {
            return false;
         }
      }

      return true;
   }

   public boolean matchesNoneOf(CharSequence sequence) {
      return this.indexIn(sequence) == -1;
   }

   public int indexIn(CharSequence sequence) {
      return this.indexIn(sequence, 0);
   }

   public int indexIn(CharSequence sequence, int start) {
      int length = sequence.length();
      Preconditions.checkPositionIndex(start, length);

      for(int i = start; i < length; ++i) {
         if (this.matches(sequence.charAt(i))) {
            return i;
         }
      }

      return -1;
   }

   public int lastIndexIn(CharSequence sequence) {
      for(int i = sequence.length() - 1; i >= 0; --i) {
         if (this.matches(sequence.charAt(i))) {
            return i;
         }
      }

      return -1;
   }

   public int countIn(CharSequence sequence) {
      int count = 0;

      for(int i = 0; i < sequence.length(); ++i) {
         if (this.matches(sequence.charAt(i))) {
            ++count;
         }
      }

      return count;
   }

   public String removeFrom(CharSequence sequence) {
      String string = sequence.toString();
      int pos = this.indexIn(string);
      if (pos == -1) {
         return string;
      } else {
         char[] chars = string.toCharArray();
         int spread = 1;

         label25:
         while(true) {
            ++pos;

            while(pos != chars.length) {
               if (this.matches(chars[pos])) {
                  ++spread;
                  continue label25;
               }

               chars[pos - spread] = chars[pos];
               ++pos;
            }

            return new String(chars, 0, pos - spread);
         }
      }
   }

   public String retainFrom(CharSequence sequence) {
      return this.negate().removeFrom(sequence);
   }

   public String replaceFrom(CharSequence sequence, char replacement) {
      String string = sequence.toString();
      int pos = this.indexIn(string);
      if (pos == -1) {
         return string;
      } else {
         char[] chars = string.toCharArray();
         chars[pos] = replacement;

         for(int i = pos + 1; i < chars.length; ++i) {
            if (this.matches(chars[i])) {
               chars[i] = replacement;
            }
         }

         return new String(chars);
      }
   }

   public String replaceFrom(CharSequence sequence, CharSequence replacement) {
      int replacementLen = replacement.length();
      if (replacementLen == 0) {
         return this.removeFrom(sequence);
      } else if (replacementLen == 1) {
         return this.replaceFrom(sequence, replacement.charAt(0));
      } else {
         String string = sequence.toString();
         int pos = this.indexIn(string);
         if (pos == -1) {
            return string;
         } else {
            int len = string.length();
            StringBuilder buf = new StringBuilder(len * 3 / 2 + 16);
            int oldpos = 0;

            do {
               buf.append(string, oldpos, pos);
               buf.append(replacement);
               oldpos = pos + 1;
               pos = this.indexIn(string, oldpos);
            } while(pos != -1);

            buf.append(string, oldpos, len);
            return buf.toString();
         }
      }
   }

   public String trimFrom(CharSequence sequence) {
      int len = sequence.length();

      int first;
      for(first = 0; first < len && this.matches(sequence.charAt(first)); ++first) {
      }

      int last;
      for(last = len - 1; last > first && this.matches(sequence.charAt(last)); --last) {
      }

      return sequence.subSequence(first, last + 1).toString();
   }

   public String trimLeadingFrom(CharSequence sequence) {
      int len = sequence.length();

      for(int first = 0; first < len; ++first) {
         if (!this.matches(sequence.charAt(first))) {
            return sequence.subSequence(first, len).toString();
         }
      }

      return "";
   }

   public String trimTrailingFrom(CharSequence sequence) {
      int len = sequence.length();

      for(int last = len - 1; last >= 0; --last) {
         if (!this.matches(sequence.charAt(last))) {
            return sequence.subSequence(0, last + 1).toString();
         }
      }

      return "";
   }

   public String collapseFrom(CharSequence sequence, char replacement) {
      int len = sequence.length();

      for(int i = 0; i < len; ++i) {
         char c = sequence.charAt(i);
         if (this.matches(c)) {
            if (c != replacement || i != len - 1 && this.matches(sequence.charAt(i + 1))) {
               StringBuilder builder = (new StringBuilder(len)).append(sequence, 0, i).append(replacement);
               return this.finishCollapseFrom(sequence, i + 1, len, replacement, builder, true);
            }

            ++i;
         }
      }

      return sequence.toString();
   }

   public String trimAndCollapseFrom(CharSequence sequence, char replacement) {
      int len = sequence.length();
      int first = 0;

      int last;
      for(last = len - 1; first < len && this.matches(sequence.charAt(first)); ++first) {
      }

      while(last > first && this.matches(sequence.charAt(last))) {
         --last;
      }

      return first == 0 && last == len - 1 ? this.collapseFrom(sequence, replacement) : this.finishCollapseFrom(sequence, first, last + 1, replacement, new StringBuilder(last + 1 - first), false);
   }

   private String finishCollapseFrom(CharSequence sequence, int start, int end, char replacement, StringBuilder builder, boolean inMatchingGroup) {
      for(int i = start; i < end; ++i) {
         char c = sequence.charAt(i);
         if (this.matches(c)) {
            if (!inMatchingGroup) {
               builder.append(replacement);
               inMatchingGroup = true;
            }
         } else {
            builder.append(c);
            inMatchingGroup = false;
         }
      }

      return builder.toString();
   }

   /** @deprecated */
   @Deprecated
   public boolean apply(Character character) {
      return this.matches(character);
   }

   public String toString() {
      return super.toString();
   }

   private static String showCharacter(char c) {
      String hex = "0123456789ABCDEF";
      char[] tmp = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};

      for(int i = 0; i < 4; ++i) {
         tmp[5 - i] = hex.charAt(c & 15);
         c = (char)(c >> 4);
      }

      return String.copyValueOf(tmp);
   }

   private static CharMatcher$IsEither isEither(char c1, char c2) {
      return new CharMatcher$IsEither(c1, c2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return this.apply((Character)x0);
   }

   // $FF: synthetic method
   static String access$100(char x0) {
      return showCharacter(x0);
   }
}
