package com.google.cloud.storage;

final class Storage$SignUrlOption$Option extends Enum {
   public static final Storage$SignUrlOption$Option HTTP_METHOD = new Storage$SignUrlOption$Option("HTTP_METHOD", 0);
   public static final Storage$SignUrlOption$Option CONTENT_TYPE = new Storage$SignUrlOption$Option("CONTENT_TYPE", 1);
   public static final Storage$SignUrlOption$Option MD5 = new Storage$SignUrlOption$Option("MD5", 2);
   public static final Storage$SignUrlOption$Option EXT_HEADERS = new Storage$SignUrlOption$Option("EXT_HEADERS", 3);
   public static final Storage$SignUrlOption$Option SERVICE_ACCOUNT_CRED = new Storage$SignUrlOption$Option("SERVICE_ACCOUNT_CRED", 4);
   public static final Storage$SignUrlOption$Option SIGNATURE_VERSION = new Storage$SignUrlOption$Option("SIGNATURE_VERSION", 5);
   public static final Storage$SignUrlOption$Option HOST_NAME = new Storage$SignUrlOption$Option("HOST_NAME", 6);
   // $FF: synthetic field
   private static final Storage$SignUrlOption$Option[] $VALUES = new Storage$SignUrlOption$Option[]{HTTP_METHOD, CONTENT_TYPE, MD5, EXT_HEADERS, SERVICE_ACCOUNT_CRED, SIGNATURE_VERSION, HOST_NAME};

   public static Storage$SignUrlOption$Option[] values() {
      return (Storage$SignUrlOption$Option[])$VALUES.clone();
   }

   public static Storage$SignUrlOption$Option valueOf(String name) {
      return (Storage$SignUrlOption$Option)Enum.valueOf(Storage$SignUrlOption$Option.class, name);
   }

   private Storage$SignUrlOption$Option(String var1, int var2) {
      super(var1, var2);
   }
}
