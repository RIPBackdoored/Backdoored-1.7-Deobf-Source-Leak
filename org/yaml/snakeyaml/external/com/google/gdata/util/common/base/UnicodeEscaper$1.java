package org.yaml.snakeyaml.external.com.google.gdata.util.common.base;

import java.io.IOException;

class UnicodeEscaper$1 implements Appendable {
   int pendingHighSurrogate;
   char[] decodedChars;
   // $FF: synthetic field
   final Appendable val$out;
   // $FF: synthetic field
   final UnicodeEscaper this$0;

   UnicodeEscaper$1(UnicodeEscaper this$0, Appendable var2) {
      this.this$0 = this$0;
      this.val$out = var2;
      this.pendingHighSurrogate = -1;
      this.decodedChars = new char[2];
   }

   public Appendable append(CharSequence csq) throws IOException {
      return this.append(csq, 0, csq.length());
   }

   public Appendable append(CharSequence csq, int start, int end) throws IOException {
      int index = start;
      if (start < end) {
         int unescapedChunkStart = start;
         char[] escaped;
         if (this.pendingHighSurrogate != -1) {
            index = start + 1;
            char c = csq.charAt(start);
            if (!Character.isLowSurrogate(c)) {
               throw new IllegalArgumentException("Expected low surrogate character but got " + c);
            }

            escaped = this.this$0.escape(Character.toCodePoint((char)this.pendingHighSurrogate, c));
            if (escaped != null) {
               this.outputChars(escaped, escaped.length);
               unescapedChunkStart = start + 1;
            } else {
               this.val$out.append((char)this.pendingHighSurrogate);
            }

            this.pendingHighSurrogate = -1;
         }

         while(true) {
            index = this.this$0.nextEscapeIndex(csq, index, end);
            if (index > unescapedChunkStart) {
               this.val$out.append(csq, unescapedChunkStart, index);
            }

            if (index == end) {
               break;
            }

            int cp = UnicodeEscaper.codePointAt(csq, index, end);
            if (cp < 0) {
               this.pendingHighSurrogate = -cp;
               break;
            }

            escaped = this.this$0.escape(cp);
            if (escaped != null) {
               this.outputChars(escaped, escaped.length);
            } else {
               int len = Character.toChars(cp, this.decodedChars, 0);
               this.outputChars(this.decodedChars, len);
            }

            index += Character.isSupplementaryCodePoint(cp) ? 2 : 1;
            unescapedChunkStart = index;
         }
      }

      return this;
   }

   public Appendable append(char c) throws IOException {
      char[] escaped;
      if (this.pendingHighSurrogate != -1) {
         if (!Character.isLowSurrogate(c)) {
            throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + c);
         }

         escaped = this.this$0.escape(Character.toCodePoint((char)this.pendingHighSurrogate, c));
         if (escaped != null) {
            this.outputChars(escaped, escaped.length);
         } else {
            this.val$out.append((char)this.pendingHighSurrogate);
            this.val$out.append(c);
         }

         this.pendingHighSurrogate = -1;
      } else if (Character.isHighSurrogate(c)) {
         this.pendingHighSurrogate = c;
      } else {
         if (Character.isLowSurrogate(c)) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + c);
         }

         escaped = this.this$0.escape(c);
         if (escaped != null) {
            this.outputChars(escaped, escaped.length);
         } else {
            this.val$out.append(c);
         }
      }

      return this;
   }

   private void outputChars(char[] chars, int len) throws IOException {
      for(int n = 0; n < len; ++n) {
         this.val$out.append(chars[n]);
      }

   }
}
