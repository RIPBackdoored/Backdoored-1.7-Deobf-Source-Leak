package com.google.api.client.json;

public final class JsonToken extends Enum {
   public static final JsonToken START_ARRAY = new JsonToken("START_ARRAY", 0);
   public static final JsonToken END_ARRAY = new JsonToken("END_ARRAY", 1);
   public static final JsonToken START_OBJECT = new JsonToken("START_OBJECT", 2);
   public static final JsonToken END_OBJECT = new JsonToken("END_OBJECT", 3);
   public static final JsonToken FIELD_NAME = new JsonToken("FIELD_NAME", 4);
   public static final JsonToken VALUE_STRING = new JsonToken("VALUE_STRING", 5);
   public static final JsonToken VALUE_NUMBER_INT = new JsonToken("VALUE_NUMBER_INT", 6);
   public static final JsonToken VALUE_NUMBER_FLOAT = new JsonToken("VALUE_NUMBER_FLOAT", 7);
   public static final JsonToken VALUE_TRUE = new JsonToken("VALUE_TRUE", 8);
   public static final JsonToken VALUE_FALSE = new JsonToken("VALUE_FALSE", 9);
   public static final JsonToken VALUE_NULL = new JsonToken("VALUE_NULL", 10);
   public static final JsonToken NOT_AVAILABLE = new JsonToken("NOT_AVAILABLE", 11);
   // $FF: synthetic field
   private static final JsonToken[] $VALUES = new JsonToken[]{START_ARRAY, END_ARRAY, START_OBJECT, END_OBJECT, FIELD_NAME, VALUE_STRING, VALUE_NUMBER_INT, VALUE_NUMBER_FLOAT, VALUE_TRUE, VALUE_FALSE, VALUE_NULL, NOT_AVAILABLE};

   public static JsonToken[] values() {
      return (JsonToken[])$VALUES.clone();
   }

   public static JsonToken valueOf(String name) {
      return (JsonToken)Enum.valueOf(JsonToken.class, name);
   }

   private JsonToken(String var1, int var2) {
      super(var1, var2);
   }
}
