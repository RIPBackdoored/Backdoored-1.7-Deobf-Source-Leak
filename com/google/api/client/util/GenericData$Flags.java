package com.google.api.client.util;

public final class GenericData$Flags extends Enum {
   public static final GenericData$Flags IGNORE_CASE = new GenericData$Flags("IGNORE_CASE", 0);
   // $FF: synthetic field
   private static final GenericData$Flags[] $VALUES = new GenericData$Flags[]{IGNORE_CASE};

   public static GenericData$Flags[] values() {
      return (GenericData$Flags[])$VALUES.clone();
   }

   public static GenericData$Flags valueOf(String name) {
      return (GenericData$Flags)Enum.valueOf(GenericData$Flags.class, name);
   }

   private GenericData$Flags(String var1, int var2) {
      super(var1, var2);
   }
}
