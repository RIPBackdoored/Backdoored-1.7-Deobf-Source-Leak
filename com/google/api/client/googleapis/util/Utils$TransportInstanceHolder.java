package com.google.api.client.googleapis.util;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

class Utils$TransportInstanceHolder {
   static final HttpTransport INSTANCE = new NetHttpTransport();

   private Utils$TransportInstanceHolder() {
   }
}
