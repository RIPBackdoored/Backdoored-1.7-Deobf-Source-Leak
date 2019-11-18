package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;

public abstract class Token {
   private final Mark startMark;
   private final Mark endMark;

   public Token(Mark startMark, Mark endMark) {
      if (startMark != null && endMark != null) {
         this.startMark = startMark;
         this.endMark = endMark;
      } else {
         throw new YAMLException("Token requires marks.");
      }
   }

   public String toString() {
      return "<" + this.getClass().getName() + "(" + this.getArguments() + ")>";
   }

   public Mark getStartMark() {
      return this.startMark;
   }

   public Mark getEndMark() {
      return this.endMark;
   }

   protected String getArguments() {
      return "";
   }

   public abstract Token$ID getTokenId();

   public boolean equals(Object obj) {
      return obj instanceof Token ? this.toString().equals(obj.toString()) : false;
   }

   public int hashCode() {
      return this.toString().hashCode();
   }
}
