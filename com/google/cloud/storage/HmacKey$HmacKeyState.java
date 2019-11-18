package com.google.cloud.storage;

public final class HmacKey$HmacKeyState extends Enum {
   public static final HmacKey$HmacKeyState ACTIVE = new HmacKey$HmacKeyState("ACTIVE", 0, "ACTIVE");
   public static final HmacKey$HmacKeyState INACTIVE = new HmacKey$HmacKeyState("INACTIVE", 1, "INACTIVE");
   public static final HmacKey$HmacKeyState DELETED = new HmacKey$HmacKeyState("DELETED", 2, "DELETED");
   private final String state;
   // $FF: synthetic field
   private static final HmacKey$HmacKeyState[] $VALUES = new HmacKey$HmacKeyState[]{ACTIVE, INACTIVE, DELETED};

   public static HmacKey$HmacKeyState[] values() {
      return (HmacKey$HmacKeyState[])$VALUES.clone();
   }

   public static HmacKey$HmacKeyState valueOf(String name) {
      return (HmacKey$HmacKeyState)Enum.valueOf(HmacKey$HmacKeyState.class, name);
   }

   private HmacKey$HmacKeyState(String var1, int var2, String state) {
      super(var1, var2);
      this.state = state;
   }
}
