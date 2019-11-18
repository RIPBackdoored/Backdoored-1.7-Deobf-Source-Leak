package org.yaml.snakeyaml;

import org.yaml.snakeyaml.error.YAMLException;

public final class DumperOptions$ScalarStyle extends Enum {
   public static final DumperOptions$ScalarStyle DOUBLE_QUOTED = new DumperOptions$ScalarStyle("DOUBLE_QUOTED", 0, '"');
   public static final DumperOptions$ScalarStyle SINGLE_QUOTED = new DumperOptions$ScalarStyle("SINGLE_QUOTED", 1, '\'');
   public static final DumperOptions$ScalarStyle LITERAL = new DumperOptions$ScalarStyle("LITERAL", 2, '|');
   public static final DumperOptions$ScalarStyle FOLDED = new DumperOptions$ScalarStyle("FOLDED", 3, '>');
   public static final DumperOptions$ScalarStyle PLAIN = new DumperOptions$ScalarStyle("PLAIN", 4, (Character)null);
   private Character styleChar;
   // $FF: synthetic field
   private static final DumperOptions$ScalarStyle[] $VALUES = new DumperOptions$ScalarStyle[]{DOUBLE_QUOTED, SINGLE_QUOTED, LITERAL, FOLDED, PLAIN};

   public static DumperOptions$ScalarStyle[] values() {
      return (DumperOptions$ScalarStyle[])$VALUES.clone();
   }

   public static DumperOptions$ScalarStyle valueOf(String name) {
      return (DumperOptions$ScalarStyle)Enum.valueOf(DumperOptions$ScalarStyle.class, name);
   }

   private DumperOptions$ScalarStyle(String var1, int var2, Character style) {
      super(var1, var2);
      this.styleChar = style;
   }

   public Character getChar() {
      return this.styleChar;
   }

   public String toString() {
      return "Scalar style: '" + this.styleChar + "'";
   }

   public static DumperOptions$ScalarStyle createStyle(Character style) {
      if (style == null) {
         return PLAIN;
      } else {
         switch(style) {
         case '"':
            return DOUBLE_QUOTED;
         case '\'':
            return SINGLE_QUOTED;
         case '>':
            return FOLDED;
         case '|':
            return LITERAL;
         default:
            throw new YAMLException("Unknown scalar style character: " + style);
         }
      }
   }
}
