package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException$Builder;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

@Beta
public final class ClientLogin {
   public HttpTransport transport;
   public GenericUrl serverUrl = new GenericUrl("https://www.google.com");
   @Key("source")
   public String applicationName;
   @Key("service")
   public String authTokenType;
   @Key("Email")
   public String username;
   @Key("Passwd")
   public String password;
   @Key
   public String accountType;
   @Key("logintoken")
   public String captchaToken;
   @Key("logincaptcha")
   public String captchaAnswer;

   public ClientLogin$Response authenticate() throws IOException {
      GenericUrl url = this.serverUrl.clone();
      url.appendRawPath("/accounts/ClientLogin");
      HttpRequest request = this.transport.createRequestFactory().buildPostRequest(url, new UrlEncodedContent(this));
      request.setParser(AuthKeyValueParser.INSTANCE);
      request.setContentLoggingLimit(0);
      request.setThrowExceptionOnExecuteError(false);
      HttpResponse response = request.execute();
      if (response.isSuccessStatusCode()) {
         return (ClientLogin$Response)response.parseAs(ClientLogin$Response.class);
      } else {
         HttpResponseException$Builder builder = new HttpResponseException$Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders());
         ClientLogin$ErrorInfo details = (ClientLogin$ErrorInfo)response.parseAs(ClientLogin$ErrorInfo.class);
         String detailString = details.toString();
         StringBuilder message = HttpResponseException.computeMessageBuffer(response);
         if (!Strings.isNullOrEmpty(detailString)) {
            message.append(StringUtils.LINE_SEPARATOR).append(detailString);
            builder.setContent(detailString);
         }

         builder.setMessage(message.toString());
         throw new ClientLoginResponseException(builder, details);
      }
   }

   public static String getAuthorizationHeaderValue(String authToken) {
      String var10001 = String.valueOf(authToken);
      String var10000;
      if (var10001.length() != 0) {
         var10000 = "GoogleLogin auth=".concat(var10001);
      } else {
         String var10002 = new String;
         var10000 = var10002;
         var10002.<init>("GoogleLogin auth=");
      }

      return var10000;
   }
}
