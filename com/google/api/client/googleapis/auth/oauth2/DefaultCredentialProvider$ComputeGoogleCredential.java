package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import java.io.IOException;
import java.io.InputStream;

class DefaultCredentialProvider$ComputeGoogleCredential extends GoogleCredential {
   private static final String TOKEN_SERVER_ENCODED_URL = String.valueOf(OAuth2Utils.getMetadataServerUrl()).concat("/computeMetadata/v1/instance/service-accounts/default/token");

   DefaultCredentialProvider$ComputeGoogleCredential(HttpTransport transport, JsonFactory jsonFactory) {
      super((new GoogleCredential$Builder()).setTransport(transport).setJsonFactory(jsonFactory).setTokenServerEncodedUrl(TOKEN_SERVER_ENCODED_URL));
   }

   protected TokenResponse executeRefreshToken() throws IOException {
      GenericUrl tokenUrl = new GenericUrl(this.getTokenServerEncodedUrl());
      HttpRequest request = this.getTransport().createRequestFactory().buildGetRequest(tokenUrl);
      JsonObjectParser parser = new JsonObjectParser(this.getJsonFactory());
      request.setParser(parser);
      request.getHeaders().set("Metadata-Flavor", "Google");
      request.setThrowExceptionOnExecuteError(false);
      HttpResponse response = request.execute();
      int statusCode = response.getStatusCode();
      if (statusCode == 200) {
         InputStream content = response.getContent();
         if (content == null) {
            throw new IOException("Empty content from metadata token server request.");
         } else {
            return (TokenResponse)parser.parseAndClose(content, response.getContentCharset(), TokenResponse.class);
         }
      } else if (statusCode == 404) {
         throw new IOException(String.format("Error code %s trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified.", statusCode));
      } else {
         throw new IOException(String.format("Unexpected Error code %s trying to get security access token from Compute Engine metadata for the default service account: %s", statusCode, response.parseAsString()));
      }
   }
}
