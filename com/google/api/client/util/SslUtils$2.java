package com.google.api.client.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class SslUtils$2 implements HostnameVerifier {
   public boolean verify(String arg0, SSLSession arg1) {
      return true;
   }
}
