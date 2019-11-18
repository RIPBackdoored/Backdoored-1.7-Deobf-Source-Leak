package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;

public final class TagToken extends Token {
   private final TagTuple value;

   public TagToken(TagTuple value, Mark startMark, Mark endMark) {
      super(startMark, endMark);
      this.value = value;
   }

   public TagTuple getValue() {
      return this.value;
   }

   protected String getArguments() {
      return "value=[" + this.value.getHandle() + ", " + this.value.getSuffix() + "]";
   }

   public Token$ID getTokenId() {
      return Token$ID.Tag;
   }
}
