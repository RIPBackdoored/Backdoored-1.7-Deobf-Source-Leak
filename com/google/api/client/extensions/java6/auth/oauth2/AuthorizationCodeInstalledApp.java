package com.google.api.client.extensions.java6.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.util.Preconditions;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorizationCodeInstalledApp {
   private final AuthorizationCodeFlow flow;
   private final VerificationCodeReceiver receiver;
   private static final Logger LOGGER = Logger.getLogger(AuthorizationCodeInstalledApp.class.getName());

   public AuthorizationCodeInstalledApp(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
      this.flow = (AuthorizationCodeFlow)Preconditions.checkNotNull(flow);
      this.receiver = (VerificationCodeReceiver)Preconditions.checkNotNull(receiver);
   }

   public Credential authorize(String userId) throws IOException {
      Credential var3;
      try {
         Credential credential = this.flow.loadCredential(userId);
         if (credential == null || credential.getRefreshToken() == null && credential.getExpiresInSeconds() != null && credential.getExpiresInSeconds() <= 60L) {
            String redirectUri = this.receiver.getRedirectUri();
            AuthorizationCodeRequestUrl authorizationUrl = this.flow.newAuthorizationUrl().setRedirectUri(redirectUri);
            this.onAuthorization(authorizationUrl);
            String code = this.receiver.waitForCode();
            TokenResponse response = this.flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
            Credential var7 = this.flow.createAndStoreCredential(response, userId);
            return var7;
         }

         var3 = credential;
      } finally {
         this.receiver.stop();
      }

      return var3;
   }

   protected void onAuthorization(AuthorizationCodeRequestUrl authorizationUrl) throws IOException {
      browse(authorizationUrl.build());
   }

   public static void browse(String url) {
      Preconditions.checkNotNull(url);
      System.out.println("Please open the following address in your browser:");
      PrintStream var10000 = System.out;
      String var10002 = String.valueOf(url);
      String var10001;
      if (var10002.length() != 0) {
         var10001 = "  ".concat(var10002);
      } else {
         String var10003 = new String;
         var10001 = var10003;
         var10003.<init>("  ");
      }

      var10000.println(var10001);

      try {
         if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Action.BROWSE)) {
               System.out.println("Attempting to open that address in the default browser now...");
               desktop.browse(URI.create(url));
            }
         }
      } catch (IOException var2) {
         LOGGER.log(Level.WARNING, "Unable to open browser", var2);
      } catch (InternalError var3) {
         LOGGER.log(Level.WARNING, "Unable to open browser", var3);
      }

   }

   public final AuthorizationCodeFlow getFlow() {
      return this.flow;
   }

   public final VerificationCodeReceiver getReceiver() {
      return this.receiver;
   }
}
