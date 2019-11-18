package com.fasterxml.jackson.core;

public final class JsonFactory$Feature extends Enum {
   public static final JsonFactory$Feature INTERN_FIELD_NAMES = new JsonFactory$Feature("INTERN_FIELD_NAMES", 0, true);
   public static final JsonFactory$Feature CANONICALIZE_FIELD_NAMES = new JsonFactory$Feature("CANONICALIZE_FIELD_NAMES", 1, true);
   public static final JsonFactory$Feature FAIL_ON_SYMBOL_HASH_OVERFLOW = new JsonFactory$Feature("FAIL_ON_SYMBOL_HASH_OVERFLOW", 2, true);
   public static final JsonFactory$Feature USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING = new JsonFactory$Feature("USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING", 3, true);
   private final boolean _defaultState;
   // $FF: synthetic field
   private static final JsonFactory$Feature[] $VALUES = new JsonFactory$Feature[]{INTERN_FIELD_NAMES, CANONICALIZE_FIELD_NAMES, FAIL_ON_SYMBOL_HASH_OVERFLOW, USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING};

   public static JsonFactory$Feature[] values() {
      return (JsonFactory$Feature[])$VALUES.clone();
   }

   public static JsonFactory$Feature valueOf(String name) {
      return (JsonFactory$Feature)Enum.valueOf(JsonFactory$Feature.class, name);
   }

   public static int collectDefaults() {
      int flags = 0;
      JsonFactory$Feature[] arr$ = values();
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         JsonFactory$Feature f = arr$[i$];
         if (f.enabledByDefault()) {
            flags |= f.getMask();
         }
      }

      return flags;
   }

   private JsonFactory$Feature(String var1, int var2, boolean defaultState) {
      super(var1, var2);
      this._defaultState = defaultState;
   }

   public boolean enabledByDefault() {
      return this._defaultState;
   }

   public boolean enabledIn(int flags) {
      return (flags & this.getMask()) != 0;
   }

   public int getMask() {
      return 1 << this.ordinal();
   }
}
