package com.fasterxml.jackson.core;

public final class JsonParser$Feature extends Enum {
   public static final JsonParser$Feature AUTO_CLOSE_SOURCE = new JsonParser$Feature("AUTO_CLOSE_SOURCE", 0, true);
   public static final JsonParser$Feature ALLOW_COMMENTS = new JsonParser$Feature("ALLOW_COMMENTS", 1, false);
   public static final JsonParser$Feature ALLOW_YAML_COMMENTS = new JsonParser$Feature("ALLOW_YAML_COMMENTS", 2, false);
   public static final JsonParser$Feature ALLOW_UNQUOTED_FIELD_NAMES = new JsonParser$Feature("ALLOW_UNQUOTED_FIELD_NAMES", 3, false);
   public static final JsonParser$Feature ALLOW_SINGLE_QUOTES = new JsonParser$Feature("ALLOW_SINGLE_QUOTES", 4, false);
   public static final JsonParser$Feature ALLOW_UNQUOTED_CONTROL_CHARS = new JsonParser$Feature("ALLOW_UNQUOTED_CONTROL_CHARS", 5, false);
   public static final JsonParser$Feature ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER = new JsonParser$Feature("ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER", 6, false);
   public static final JsonParser$Feature ALLOW_NUMERIC_LEADING_ZEROS = new JsonParser$Feature("ALLOW_NUMERIC_LEADING_ZEROS", 7, false);
   public static final JsonParser$Feature ALLOW_NON_NUMERIC_NUMBERS = new JsonParser$Feature("ALLOW_NON_NUMERIC_NUMBERS", 8, false);
   public static final JsonParser$Feature ALLOW_MISSING_VALUES = new JsonParser$Feature("ALLOW_MISSING_VALUES", 9, false);
   public static final JsonParser$Feature ALLOW_TRAILING_COMMA = new JsonParser$Feature("ALLOW_TRAILING_COMMA", 10, false);
   public static final JsonParser$Feature STRICT_DUPLICATE_DETECTION = new JsonParser$Feature("STRICT_DUPLICATE_DETECTION", 11, false);
   public static final JsonParser$Feature IGNORE_UNDEFINED = new JsonParser$Feature("IGNORE_UNDEFINED", 12, false);
   public static final JsonParser$Feature INCLUDE_SOURCE_IN_LOCATION = new JsonParser$Feature("INCLUDE_SOURCE_IN_LOCATION", 13, true);
   private final boolean _defaultState;
   private final int _mask = 1 << this.ordinal();
   // $FF: synthetic field
   private static final JsonParser$Feature[] $VALUES = new JsonParser$Feature[]{AUTO_CLOSE_SOURCE, ALLOW_COMMENTS, ALLOW_YAML_COMMENTS, ALLOW_UNQUOTED_FIELD_NAMES, ALLOW_SINGLE_QUOTES, ALLOW_UNQUOTED_CONTROL_CHARS, ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, ALLOW_NUMERIC_LEADING_ZEROS, ALLOW_NON_NUMERIC_NUMBERS, ALLOW_MISSING_VALUES, ALLOW_TRAILING_COMMA, STRICT_DUPLICATE_DETECTION, IGNORE_UNDEFINED, INCLUDE_SOURCE_IN_LOCATION};

   public static JsonParser$Feature[] values() {
      return (JsonParser$Feature[])$VALUES.clone();
   }

   public static JsonParser$Feature valueOf(String name) {
      return (JsonParser$Feature)Enum.valueOf(JsonParser$Feature.class, name);
   }

   public static int collectDefaults() {
      int flags = 0;
      JsonParser$Feature[] arr$ = values();
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         JsonParser$Feature f = arr$[i$];
         if (f.enabledByDefault()) {
            flags |= f.getMask();
         }
      }

      return flags;
   }

   private JsonParser$Feature(String var1, int var2, boolean defaultState) {
      super(var1, var2);
      this._defaultState = defaultState;
   }

   public boolean enabledByDefault() {
      return this._defaultState;
   }

   public boolean enabledIn(int flags) {
      return (flags & this._mask) != 0;
   }

   public int getMask() {
      return this._mask;
   }
}
