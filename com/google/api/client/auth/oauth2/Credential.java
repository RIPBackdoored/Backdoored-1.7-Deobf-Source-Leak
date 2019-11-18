package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Credential implements HttpExecuteInterceptor, HttpRequestInitializer, HttpUnsuccessfulResponseHandler {
   static final Logger LOGGER = Logger.getLogger(Credential.class.getName());
   private final Lock lock;
   private final Credential$AccessMethod method;
   private final Clock clock;
   private String accessToken;
   private Long expirationTimeMilliseconds;
   private String refreshToken;
   private final HttpTransport transport;
   private final HttpExecuteInterceptor clientAuthentication;
   private final JsonFactory jsonFactory;
   private final String tokenServerEncodedUrl;
   private final Collection refreshListeners;
   private final HttpRequestInitializer requestInitializer;

   public Credential(Credential$AccessMethod method) {
      this(new Credential$Builder(method));
   }

   protected Credential(Credential$Builder builder) {
      this.lock = new ReentrantLock();
      this.method = (Credential$AccessMethod)Preconditions.checkNotNull(builder.method);
      this.transport = builder.transport;
      this.jsonFactory = builder.jsonFactory;
      this.tokenServerEncodedUrl = builder.tokenServerUrl == null ? null : builder.tokenServerUrl.build();
      this.clientAuthentication = builder.clientAuthentication;
      this.requestInitializer = builder.requestInitializer;
      this.refreshListeners = Collections.unmodifiableCollection(builder.refreshListeners);
      this.clock = (Clock)Preconditions.checkNotNull(builder.clock);
   }

   public void intercept(HttpRequest request) throws IOException {
      this.lock.lock();

      try {
         Long expiresIn = this.getExpiresInSeconds();
         if (this.accessToken == null || expiresIn != null && expiresIn <= 60L) {
            this.refreshToken();
            if (this.accessToken == null) {
               return;
            }
         }

         this.method.intercept(request, this.accessToken);
      } finally {
         this.lock.unlock();
      }
   }

   public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) {
      boolean refreshToken = false;
      boolean bearer = false;
      List authenticateList = response.getHeaders().getAuthenticateAsList();
      if (authenticateList != null) {
         Iterator var7 = authenticateList.iterator();

         while(var7.hasNext()) {
            String authenticate = (String)var7.next();
            if (authenticate.startsWith("Bearer ")) {
               bearer = true;
               refreshToken = BearerToken.INVALID_TOKEN_ERROR.matcher(authenticate).find();
               break;
            }
         }
      }

      if (!bearer) {
         refreshToken = response.getStatusCode() == 401;
      }

      if (refreshToken) {
         boolean var14;
         try {
            this.lock.lock();

            try {
               var14 = !Objects.equal(this.accessToken, this.method.getAccessTokenFromRequest(request)) || this.refreshToken();
            } finally {
               this.lock.unlock();
            }
         } catch (IOException var13) {
            LOGGER.log(Level.SEVERE, "unable to refresh token", var13);
            return false;
         }

         return var14;
      } else {
         return false;
      }
   }

   public void initialize(HttpRequest request) throws IOException {
      request.setInterceptor(this);
      request.setUnsuccessfulResponseHandler(this);
   }

   public final String getAccessToken() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.accessToken;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setAccessToken(String accessToken) {
      this.lock.lock();

      try {
         this.accessToken = accessToken;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public final Credential$AccessMethod getMethod() {
      return this.method;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final String getTokenServerEncodedUrl() {
      return this.tokenServerEncodedUrl;
   }

   public final String getRefreshToken() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.refreshToken;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setRefreshToken(String refreshToken) {
      this.lock.lock();

      try {
         if (refreshToken != null) {
            Preconditions.checkArgument(this.jsonFactory != null && this.transport != null && this.clientAuthentication != null && this.tokenServerEncodedUrl != null, "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl");
         }

         this.refreshToken = refreshToken;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public final Long getExpirationTimeMilliseconds() {
      this.lock.lock();

      Long var1;
      try {
         var1 = this.expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setExpirationTimeMilliseconds(Long expirationTimeMilliseconds) {
      this.lock.lock();

      try {
         this.expirationTimeMilliseconds = expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public final Long getExpiresInSeconds() {
      this.lock.lock();

      Long var1;
      try {
         if (this.expirationTimeMilliseconds != null) {
            var1 = (this.expirationTimeMilliseconds - this.clock.currentTimeMillis()) / 1000L;
            return var1;
         }

         var1 = null;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setExpiresInSeconds(Long expiresIn) {
      return this.setExpirationTimeMilliseconds(expiresIn == null ? null : this.clock.currentTimeMillis() + expiresIn * 1000L);
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public final boolean refreshToken() throws IOException {
      this.lock.lock();

      try {
         boolean statusCode4xx;
         try {
            TokenResponse tokenResponse = this.executeRefreshToken();
            if (tokenResponse != null) {
               this.setFromTokenResponse(tokenResponse);
               Iterator var12 = this.refreshListeners.iterator();

               while(var12.hasNext()) {
                  CredentialRefreshListener refreshListener = (CredentialRefreshListener)var12.next();
                  refreshListener.onTokenResponse(this, tokenResponse);
               }

               statusCode4xx = true;
               return statusCode4xx;
            }
         } catch (TokenResponseException var8) {
            TokenResponseException e = var8;
            statusCode4xx = 400 <= var8.getStatusCode() && var8.getStatusCode() < 500;
            if (var8.getDetails() != null && statusCode4xx) {
               this.setAccessToken((String)null);
               this.setExpiresInSeconds((Long)null);
            }

            Iterator var3 = this.refreshListeners.iterator();

            while(true) {
               if (!var3.hasNext()) {
                  if (statusCode4xx) {
                     throw e;
                  }
                  break;
               }

               CredentialRefreshListener refreshListener = (CredentialRefreshListener)var3.next();
               refreshListener.onTokenErrorResponse(this, e.getDetails());
            }
         }

         boolean var11 = false;
         return var11;
      } finally {
         this.lock.unlock();
      }
   }

   public Credential setFromTokenResponse(TokenResponse tokenResponse) {
      this.setAccessToken(tokenResponse.getAccessToken());
      if (tokenResponse.getRefreshToken() != null) {
         this.setRefreshToken(tokenResponse.getRefreshToken());
      }

      this.setExpiresInSeconds(tokenResponse.getExpiresInSeconds());
      return this;
   }

   protected TokenResponse executeRefreshToken() throws IOException {
      return this.refreshToken == null ? null : (new RefreshTokenRequest(this.transport, this.jsonFactory, new GenericUrl(this.tokenServerEncodedUrl), this.refreshToken)).setClientAuthentication(this.clientAuthentication).setRequestInitializer(this.requestInitializer).execute();
   }

   public final Collection getRefreshListeners() {
      return this.refreshListeners;
   }
}
