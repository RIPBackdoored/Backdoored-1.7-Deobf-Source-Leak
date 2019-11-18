package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class NetHttpTransport extends HttpTransport {
   private static final String[] SUPPORTED_METHODS = new String[]{"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
   private static final String SHOULD_USE_PROXY_FLAG = "com.google.api.client.should_use_proxy";
   private final ConnectionFactory connectionFactory;
   private final SSLSocketFactory sslSocketFactory;
   private final HostnameVerifier hostnameVerifier;

   private static Proxy defaultProxy() {
      return new Proxy(Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort"))));
   }

   public NetHttpTransport() {
      this((ConnectionFactory)((ConnectionFactory)null), (SSLSocketFactory)null, (HostnameVerifier)null);
   }

   NetHttpTransport(Proxy proxy, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {
      this((ConnectionFactory)(new DefaultConnectionFactory(proxy)), sslSocketFactory, hostnameVerifier);
   }

   NetHttpTransport(ConnectionFactory connectionFactory, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {
      this.connectionFactory = this.getConnectionFactory(connectionFactory);
      this.sslSocketFactory = sslSocketFactory;
      this.hostnameVerifier = hostnameVerifier;
   }

   private ConnectionFactory getConnectionFactory(ConnectionFactory connectionFactory) {
      if (connectionFactory == null) {
         return System.getProperty("com.google.api.client.should_use_proxy") != null ? new DefaultConnectionFactory(defaultProxy()) : new DefaultConnectionFactory();
      } else {
         return connectionFactory;
      }
   }

   public boolean supportsMethod(String method) {
      return Arrays.binarySearch(SUPPORTED_METHODS, method) >= 0;
   }

   protected NetHttpRequest buildRequest(String method, String url) throws IOException {
      Preconditions.checkArgument(this.supportsMethod(method), "HTTP method %s not supported", method);
      URL connUrl = new URL(url);
      HttpURLConnection connection = this.connectionFactory.openConnection(connUrl);
      connection.setRequestMethod(method);
      if (connection instanceof HttpsURLConnection) {
         HttpsURLConnection secureConnection = (HttpsURLConnection)connection;
         if (this.hostnameVerifier != null) {
            secureConnection.setHostnameVerifier(this.hostnameVerifier);
         }

         if (this.sslSocketFactory != null) {
            secureConnection.setSSLSocketFactory(this.sslSocketFactory);
         }
      }

      return new NetHttpRequest(connection);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected LowLevelHttpRequest buildRequest(String var1, String var2) throws IOException {
      return this.buildRequest(var1, var2);
   }

   // $FF: synthetic method
   static Proxy access$000() {
      return defaultProxy();
   }

   static {
      Arrays.sort(SUPPORTED_METHODS);
   }
}
