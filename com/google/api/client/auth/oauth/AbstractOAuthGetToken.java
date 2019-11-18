package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedParser;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public abstract class AbstractOAuthGetToken extends GenericUrl {
   public HttpTransport transport;
   public String consumerKey;
   public OAuthSigner signer;
   protected boolean usePost;

   protected AbstractOAuthGetToken(String authorizationServerUrl) {
      super(authorizationServerUrl);
   }

   public final OAuthCredentialsResponse execute() throws IOException {
      HttpRequestFactory requestFactory = this.transport.createRequestFactory();
      HttpRequest request = requestFactory.buildRequest(this.usePost ? "POST" : "GET", this, (HttpContent)null);
      this.createParameters().intercept(request);
      HttpResponse response = request.execute();
      response.setContentLoggingLimit(0);
      OAuthCredentialsResponse oauthResponse = new OAuthCredentialsResponse();
      UrlEncodedParser.parse((String)response.parseAsString(), oauthResponse);
      return oauthResponse;
   }

   public OAuthParameters createParameters() {
      OAuthParameters result = new OAuthParameters();
      result.consumerKey = this.consumerKey;
      result.signer = this.signer;
      return result;
   }
}
