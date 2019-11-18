package com.google.api.client.http.javanet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public interface ConnectionFactory {
   HttpURLConnection openConnection(URL var1) throws IOException, ClassCastException;
}
