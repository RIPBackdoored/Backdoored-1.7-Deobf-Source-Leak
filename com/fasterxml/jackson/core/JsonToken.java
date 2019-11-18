package com.fasterxml.jackson.core;

public final class JsonToken extends Enum {
   public static final JsonToken NOT_AVAILABLE = new JsonToken("NOT_AVAILABLE", 0, (String)null, -1);
   public static final JsonToken START_OBJECT = new JsonToken("START_OBJECT", 1, "{", 1);
   public static final JsonToken END_OBJECT = new JsonToken("END_OBJECT", 2, "}", 2);
   public static final JsonToken START_ARRAY = new JsonToken("START_ARRAY", 3, "[", 3);
   public static final JsonToken END_ARRAY = new JsonToken("END_ARRAY", 4, "]", 4);
   public static final JsonToken FIELD_NAME = new JsonToken("FIELD_NAME", 5, (String)null, 5);
   public static final JsonToken VALUE_EMBEDDED_OBJECT = new JsonToken("VALUE_EMBEDDED_OBJECT", 6, (String)null, 12);
   public static final JsonToken VALUE_STRING = new JsonToken("VALUE_STRING", 7, (String)null, 6);
   public static final JsonToken VALUE_NUMBER_INT = new JsonToken("VALUE_NUMBER_INT", 8, (String)null, 7);
   public static final JsonToken VALUE_NUMBER_FLOAT = new JsonToken("VALUE_NUMBER_FLOAT", 9, (String)null, 8);
   public static final JsonToken VALUE_TRUE = new JsonToken("VALUE_TRUE", 10, "true", 9);
   public static final JsonToken VALUE_FALSE = new JsonToken("VALUE_FALSE", 11, "false", 10);
   public static final JsonToken VALUE_NULL = new JsonToken("VALUE_NULL", 12, "null", 11);
   final String _serialized;
   final char[] _serializedChars;
   final byte[] _serializedBytes;
   final int _id;
   final boolean _isStructStart;
   final boolean _isStructEnd;
   final boolean _isNumber;
   final boolean _isBoolean;
   final boolean _isScalar;
   // $FF: synthetic field
   private static final JsonToken[] $VALUES = new JsonToken[]{NOT_AVAILABLE, START_OBJECT, END_OBJECT, START_ARRAY, END_ARRAY, FIELD_NAME, VALUE_EMBEDDED_OBJECT, VALUE_STRING, VALUE_NUMBER_INT, VALUE_NUMBER_FLOAT, VALUE_TRUE, VALUE_FALSE, VALUE_NULL};

   public static JsonToken[] values() {
      return (JsonToken[])$VALUES.clone();
   }

   public static JsonToken valueOf(String name) {
      return (JsonToken)Enum.valueOf(JsonToken.class, name);
   }

   private JsonToken(String var1, int var2, String token, int id) {
      super(var1, var2);
      if (token == null) {
         this._serialized = null;
         this._serializedChars = null;
         this._serializedBytes = null;
      } else {
         this._serialized = token;
         this._serializedChars = token.toCharArray();
         int len = this._serializedChars.length;
         this._serializedBytes = new byte[len];

         for(int i = 0; i < len; ++i) {
            this._serializedBytes[i] = (byte)this._serializedChars[i];
         }
      }

      this._id = id;
      this._isBoolean = id == 10 || id == 9;
      this._isNumber = id == 7 || id == 8;
      this._isStructStart = id == 1 || id == 3;
      this._isStructEnd = id == 2 || id == 4;
      this._isScalar = !this._isStructStart && !this._isStructEnd && id != 5 && id != -1;
   }

   public final int id() {
      return this._id;
   }

   public final String asString() {
      return this._serialized;
   }

   public final char[] asCharArray() {
      return this._serializedChars;
   }

   public final byte[] asByteArray() {
      return this._serializedBytes;
   }

   public final boolean isNumeric() {
      return this._isNumber;
   }

   public final boolean isStructStart() {
      return this._isStructStart;
   }

   public final boolean isStructEnd() {
      return this._isStructEnd;
   }

   public final boolean isScalarValue() {
      return this._isScalar;
   }

   public final boolean isBoolean() {
      return this._isBoolean;
   }
}
