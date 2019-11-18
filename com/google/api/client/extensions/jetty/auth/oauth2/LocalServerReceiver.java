package com.google.api.client.extensions.jetty.auth.oauth2;

import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.util.Throwables;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;

public final class LocalServerReceiver implements VerificationCodeReceiver {
   private static final String LOCALHOST = "localhost";
   private static final String CALLBACK_PATH = "/Callback";
   private Server server;
   String code;
   String error;
   final Semaphore waitUnlessSignaled;
   private int port;
   private final String host;
   private final String callbackPath;
   private String successLandingPageUrl;
   private String failureLandingPageUrl;

   public LocalServerReceiver() {
      this("localhost", -1, "/Callback", (String)null, (String)null);
   }

   LocalServerReceiver(String host, int port, String successLandingPageUrl, String failureLandingPageUrl) {
      this(host, port, "/Callback", successLandingPageUrl, failureLandingPageUrl);
   }

   LocalServerReceiver(String host, int port, String callbackPath, String successLandingPageUrl, String failureLandingPageUrl) {
      this.waitUnlessSignaled = new Semaphore(0);
      this.host = host;
      this.port = port;
      this.callbackPath = callbackPath;
      this.successLandingPageUrl = successLandingPageUrl;
      this.failureLandingPageUrl = failureLandingPageUrl;
   }

   public String getRedirectUri() throws IOException {
      this.server = new Server(this.port != -1 ? this.port : 0);
      Connector connector = this.server.getConnectors()[0];
      connector.setHost(this.host);
      this.server.addHandler(new LocalServerReceiver$CallbackHandler(this));

      try {
         this.server.start();
         this.port = connector.getLocalPort();
      } catch (Exception var5) {
         Throwables.propagateIfPossible(var5);
         throw new IOException(var5);
      }

      String var2 = String.valueOf(String.valueOf(this.host));
      int var3 = this.port;
      String var4 = String.valueOf(String.valueOf(this.callbackPath));
      return (new StringBuilder(19 + var2.length() + var4.length())).append("http://").append(var2).append(":").append(var3).append(var4).toString();
   }

   public String waitForCode() throws IOException {
      this.waitUnlessSignaled.acquireUninterruptibly();
      if (this.error != null) {
         String var1 = String.valueOf(String.valueOf(this.error));
         throw new IOException((new StringBuilder(28 + var1.length())).append("User authorization failed (").append(var1).append(")").toString());
      } else {
         return this.code;
      }
   }

   public void stop() throws IOException {
      this.waitUnlessSignaled.release();
      if (this.server != null) {
         try {
            this.server.stop();
         } catch (Exception var2) {
            Throwables.propagateIfPossible(var2);
            throw new IOException(var2);
         }

         this.server = null;
      }

   }

   public String getHost() {
      return this.host;
   }

   public int getPort() {
      return this.port;
   }

   public String getCallbackPath() {
      return this.callbackPath;
   }

   // $FF: synthetic method
   static String access$000(LocalServerReceiver x0) {
      return x0.successLandingPageUrl;
   }

   // $FF: synthetic method
   static String access$100(LocalServerReceiver x0) {
      return x0.failureLandingPageUrl;
   }
}
