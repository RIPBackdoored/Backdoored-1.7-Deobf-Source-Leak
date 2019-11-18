package com.google.api.client.googleapis.compute;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.Credential$Builder;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public class ComputeCredential extends Credential {
   public static final String TOKEN_SERVER_ENCODED_URL = String.valueOf(OAuth2Utils.getMetadataServerUrl()).concat("/computeMetadata/v1/instance/service-accounts/default/token");

   public ComputeCredential(HttpTransport transport, JsonFactory jsonFactory) {
      this(new ComputeCredential$Builder(transport, jsonFactory));
   }

   protected ComputeCredential(ComputeCredential$Builder builder) {
      super((Credential$Builder)builder);
   }

   protected TokenResponse executeRefreshToken() throws IOException {
      GenericUrl tokenUrl = new GenericUrl(this.getTokenServerEncodedUrl());
      HttpRequest request = this.getTransport().createRequestFactory().buildGetRequest(tokenUrl);
      request.setParser(new JsonObjectParser(this.getJsonFactory()));
      request.getHeaders().set("Metadata-Flavor", "Google");
      return (TokenResponse)request.execute().parseAs(TokenResponse.class);
   }
}
