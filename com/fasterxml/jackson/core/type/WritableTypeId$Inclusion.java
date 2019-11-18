package com.fasterxml.jackson.core.type;

public final class WritableTypeId$Inclusion extends Enum {
   public static final WritableTypeId$Inclusion WRAPPER_ARRAY = new WritableTypeId$Inclusion("WRAPPER_ARRAY", 0);
   public static final WritableTypeId$Inclusion WRAPPER_OBJECT = new WritableTypeId$Inclusion("WRAPPER_OBJECT", 1);
   public static final WritableTypeId$Inclusion METADATA_PROPERTY = new WritableTypeId$Inclusion("METADATA_PROPERTY", 2);
   public static final WritableTypeId$Inclusion PAYLOAD_PROPERTY = new WritableTypeId$Inclusion("PAYLOAD_PROPERTY", 3);
   public static final WritableTypeId$Inclusion PARENT_PROPERTY = new WritableTypeId$Inclusion("PARENT_PROPERTY", 4);
   // $FF: synthetic field
   private static final WritableTypeId$Inclusion[] $VALUES = new WritableTypeId$Inclusion[]{WRAPPER_ARRAY, WRAPPER_OBJECT, METADATA_PROPERTY, PAYLOAD_PROPERTY, PARENT_PROPERTY};

   public static WritableTypeId$Inclusion[] values() {
      return (WritableTypeId$Inclusion[])$VALUES.clone();
   }

   public static WritableTypeId$Inclusion valueOf(String name) {
      return (WritableTypeId$Inclusion)Enum.valueOf(WritableTypeId$Inclusion.class, name);
   }

   private WritableTypeId$Inclusion(String var1, int var2) {
      super(var1, var2);
   }

   public boolean requiresObjectContext() {
      return this == METADATA_PROPERTY || this == PAYLOAD_PROPERTY;
   }
}
