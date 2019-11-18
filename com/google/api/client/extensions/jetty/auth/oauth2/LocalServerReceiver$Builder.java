package com.google.api.client.extensions.jetty.auth.oauth2;

public final class LocalServerReceiver$Builder {
   private String host = "localhost";
   private int port = -1;
   private String successLandingPageUrl;
   private String failureLandingPageUrl;
   private String callbackPath = "/Callback";

   public LocalServerReceiver build() {
      return new LocalServerReceiver(this.host, this.port, this.callbackPath, this.successLandingPageUrl, this.failureLandingPageUrl);
   }

   public String getHost() {
      return this.host;
   }

   public LocalServerReceiver$Builder setHost(String host) {
      this.host = host;
      return this;
   }

   public int getPort() {
      return this.port;
   }

   public LocalServerReceiver$Builder setPort(int port) {
      this.port = port;
      return this;
   }

   public String getCallbackPath() {
      return this.callbackPath;
   }

   public LocalServerReceiver$Builder setCallbackPath(String callbackPath) {
      this.callbackPath = callbackPath;
      return this;
   }

   public LocalServerReceiver$Builder setLandingPages(String successLandingPageUrl, String failureLandingPageUrl) {
      this.successLandingPageUrl = successLandingPageUrl;
      this.failureLandingPageUrl = failureLandingPageUrl;
      return this;
   }
}
