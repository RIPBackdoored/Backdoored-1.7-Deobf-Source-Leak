package com.google.api.client.googleapis.auth.oauth2;

final class DefaultCredentialProvider$Environment extends Enum {
   public static final DefaultCredentialProvider$Environment UNKNOWN = new DefaultCredentialProvider$Environment("UNKNOWN", 0);
   public static final DefaultCredentialProvider$Environment ENVIRONMENT_VARIABLE = new DefaultCredentialProvider$Environment("ENVIRONMENT_VARIABLE", 1);
   public static final DefaultCredentialProvider$Environment WELL_KNOWN_FILE = new DefaultCredentialProvider$Environment("WELL_KNOWN_FILE", 2);
   public static final DefaultCredentialProvider$Environment CLOUD_SHELL = new DefaultCredentialProvider$Environment("CLOUD_SHELL", 3);
   public static final DefaultCredentialProvider$Environment APP_ENGINE = new DefaultCredentialProvider$Environment("APP_ENGINE", 4);
   public static final DefaultCredentialProvider$Environment COMPUTE_ENGINE = new DefaultCredentialProvider$Environment("COMPUTE_ENGINE", 5);
   // $FF: synthetic field
   private static final DefaultCredentialProvider$Environment[] $VALUES = new DefaultCredentialProvider$Environment[]{UNKNOWN, ENVIRONMENT_VARIABLE, WELL_KNOWN_FILE, CLOUD_SHELL, APP_ENGINE, COMPUTE_ENGINE};

   public static DefaultCredentialProvider$Environment[] values() {
      return (DefaultCredentialProvider$Environment[])$VALUES.clone();
   }

   public static DefaultCredentialProvider$Environment valueOf(String name) {
      return (DefaultCredentialProvider$Environment)Enum.valueOf(DefaultCredentialProvider$Environment.class, name);
   }

   private DefaultCredentialProvider$Environment(String var1, int var2) {
      super(var1, var2);
   }
}
