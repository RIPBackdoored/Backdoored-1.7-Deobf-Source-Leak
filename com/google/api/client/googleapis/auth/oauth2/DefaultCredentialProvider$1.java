package com.google.api.client.googleapis.auth.oauth2;

// $FF: synthetic class
class DefaultCredentialProvider$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment = new int[DefaultCredentialProvider$Environment.values().length];

   static {
      try {
         $SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment[DefaultCredentialProvider$Environment.ENVIRONMENT_VARIABLE.ordinal()] = 1;
      } catch (NoSuchFieldError var5) {
      }

      try {
         $SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment[DefaultCredentialProvider$Environment.WELL_KNOWN_FILE.ordinal()] = 2;
      } catch (NoSuchFieldError var4) {
      }

      try {
         $SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment[DefaultCredentialProvider$Environment.APP_ENGINE.ordinal()] = 3;
      } catch (NoSuchFieldError var3) {
      }

      try {
         $SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment[DefaultCredentialProvider$Environment.CLOUD_SHELL.ordinal()] = 4;
      } catch (NoSuchFieldError var2) {
      }

      try {
         $SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment[DefaultCredentialProvider$Environment.COMPUTE_ENGINE.ordinal()] = 5;
      } catch (NoSuchFieldError var1) {
      }

   }
}
