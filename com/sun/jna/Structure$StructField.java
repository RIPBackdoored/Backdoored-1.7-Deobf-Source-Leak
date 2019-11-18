package com.sun.jna;

import java.lang.reflect.Field;

public class Structure$StructField {
   public String name;
   public Class type;
   public Field field;
   public int size = -1;
   public int offset = -1;
   public boolean isVolatile;
   public boolean isReadOnly;
   public FromNativeConverter readConverter;
   public ToNativeConverter writeConverter;
   public FromNativeContext context;

   protected Structure$StructField() {
   }

   public String toString() {
      return this.name + "@" + this.offset + "[" + this.size + "] (" + this.type + ")";
   }
}
