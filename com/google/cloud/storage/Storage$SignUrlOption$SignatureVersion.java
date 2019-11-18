package com.google.cloud.storage;

final class Storage$SignUrlOption$SignatureVersion extends Enum {
   public static final Storage$SignUrlOption$SignatureVersion V2 = new Storage$SignUrlOption$SignatureVersion("V2", 0);
   public static final Storage$SignUrlOption$SignatureVersion V4 = new Storage$SignUrlOption$SignatureVersion("V4", 1);
   // $FF: synthetic field
   private static final Storage$SignUrlOption$SignatureVersion[] $VALUES = new Storage$SignUrlOption$SignatureVersion[]{V2, V4};

   public static Storage$SignUrlOption$SignatureVersion[] values() {
      return (Storage$SignUrlOption$SignatureVersion[])$VALUES.clone();
   }

   public static Storage$SignUrlOption$SignatureVersion valueOf(String name) {
      return (Storage$SignUrlOption$SignatureVersion)Enum.valueOf(Storage$SignUrlOption$SignatureVersion.class, name);
   }

   private Storage$SignUrlOption$SignatureVersion(String var1, int var2) {
      super(var1, var2);
   }
}
