package com.google.api.client.http.apache;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import java.io.IOException;
import java.net.ProxySelector;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class ApacheHttpTransport extends HttpTransport {
   private final HttpClient httpClient;

   public ApacheHttpTransport() {
      this(newDefaultHttpClient());
   }

   public ApacheHttpTransport(HttpClient httpClient) {
      this.httpClient = httpClient;
      HttpParams params = httpClient.getParams();
      if (params == null) {
         params = newDefaultHttpClient().getParams();
      }

      HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
      params.setBooleanParameter("http.protocol.handle-redirects", false);
   }

   public static DefaultHttpClient newDefaultHttpClient() {
      return newDefaultHttpClient(SSLSocketFactory.getSocketFactory(), newDefaultHttpParams(), ProxySelector.getDefault());
   }

   static HttpParams newDefaultHttpParams() {
      HttpParams params = new BasicHttpParams();
      HttpConnectionParams.setStaleCheckingEnabled(params, false);
      HttpConnectionParams.setSocketBufferSize(params, 8192);
      ConnManagerParams.setMaxTotalConnections(params, 200);
      ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(20));
      return params;
   }

   static DefaultHttpClient newDefaultHttpClient(SSLSocketFactory socketFactory, HttpParams params, ProxySelector proxySelector) {
      SchemeRegistry registry = new SchemeRegistry();
      registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      registry.register(new Scheme("https", socketFactory, 443));
      ClientConnectionManager connectionManager = new ThreadSafeClientConnManager(params, registry);
      DefaultHttpClient defaultHttpClient = new DefaultHttpClient(connectionManager, params);
      defaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
      if (proxySelector != null) {
         defaultHttpClient.setRoutePlanner(new ProxySelectorRoutePlanner(registry, proxySelector));
      }

      return defaultHttpClient;
   }

   public boolean supportsMethod(String method) {
      return true;
   }

   protected ApacheHttpRequest buildRequest(String method, String url) {
      Object requestBase;
      if (method.equals("DELETE")) {
         requestBase = new HttpDelete(url);
      } else if (method.equals("GET")) {
         requestBase = new HttpGet(url);
      } else if (method.equals("HEAD")) {
         requestBase = new HttpHead(url);
      } else if (method.equals("POST")) {
         requestBase = new HttpPost(url);
      } else if (method.equals("PUT")) {
         requestBase = new HttpPut(url);
      } else if (method.equals("TRACE")) {
         requestBase = new HttpTrace(url);
      } else if (method.equals("OPTIONS")) {
         requestBase = new HttpOptions(url);
      } else {
         requestBase = new HttpExtensionMethod(method, url);
      }

      return new ApacheHttpRequest(this.httpClient, (HttpRequestBase)requestBase);
   }

   public void shutdown() {
      this.httpClient.getConnectionManager().shutdown();
   }

   public HttpClient getHttpClient() {
      return this.httpClient;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected LowLevelHttpRequest buildRequest(String var1, String var2) throws IOException {
      return this.buildRequest(var1, var2);
   }
}
