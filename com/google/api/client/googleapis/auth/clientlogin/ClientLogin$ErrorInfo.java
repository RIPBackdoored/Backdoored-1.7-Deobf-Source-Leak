package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.util.Key;

public final class ClientLogin$ErrorInfo {
   @Key("Error")
   public String error;
   @Key("Url")
   public String url;
   @Key("CaptchaToken")
   public String captchaToken;
   @Key("CaptchaUrl")
   public String captchaUrl;
}
