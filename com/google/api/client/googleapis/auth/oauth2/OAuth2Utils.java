package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class OAuth2Utils {
   static final Charset UTF_8 = Charset.forName("UTF-8");
   private static final Logger LOGGER = Logger.getLogger(OAuth2Utils.class.getName());
   private static final String DEFAULT_METADATA_SERVER_URL = "http://169.254.169.254";
   private static final int MAX_COMPUTE_PING_TRIES = 3;
   private static final int COMPUTE_PING_CONNECTION_TIMEOUT_MS = 500;

   static Throwable exceptionWithCause(Throwable exception, Throwable cause) {
      exception.initCause(cause);
      return exception;
   }

   static boolean headersContainValue(HttpHeaders headers, String headerName, String value) {
      Object values = headers.get(headerName);
      if (values instanceof Collection) {
         Collection valuesList = (Collection)values;
         Iterator i$ = valuesList.iterator();

         while(i$.hasNext()) {
            Object headerValue = i$.next();
            if (headerValue instanceof String && ((String)headerValue).equals(value)) {
               return true;
            }
         }
      }

      return false;
   }

   static boolean runningOnComputeEngine(HttpTransport transport, SystemEnvironmentProvider environment) {
      if (Boolean.parseBoolean(environment.getEnv("NO_GCE_CHECK"))) {
         return false;
      } else {
         GenericUrl tokenUrl = new GenericUrl(getMetadataServerUrl(environment));

         for(int i = 1; i <= 3; ++i) {
            try {
               HttpRequest request = transport.createRequestFactory().buildGetRequest(tokenUrl);
               request.setConnectTimeout(500);
               HttpResponse response = request.execute();

               try {
                  HttpHeaders headers = response.getHeaders();
                  boolean var7 = headersContainValue(headers, "Metadata-Flavor", "Google");
                  return var7;
               } finally {
                  response.disconnect();
               }
            } catch (SocketTimeoutException var13) {
            } catch (IOException var14) {
               LOGGER.log(Level.WARNING, "Failed to detect whether we are running on Google Compute Engine.", var14);
            }
         }

         return false;
      }
   }

   public static String getMetadataServerUrl() {
      return getMetadataServerUrl(SystemEnvironmentProvider.INSTANCE);
   }

   static String getMetadataServerUrl(SystemEnvironmentProvider environment) {
      String metadataServerAddress = environment.getEnv("GCE_METADATA_HOST");
      if (metadataServerAddress != null) {
         String var10001 = String.valueOf(metadataServerAddress);
         String var10000;
         if (var10001.length() != 0) {
            var10000 = "http://".concat(var10001);
         } else {
            String var10002 = new String;
            var10000 = var10002;
            var10002.<init>("http://");
         }

         return var10000;
      } else {
         return "http://169.254.169.254";
      }
   }
}
