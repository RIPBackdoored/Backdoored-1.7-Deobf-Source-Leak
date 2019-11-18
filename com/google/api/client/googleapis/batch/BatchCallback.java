package com.google.api.client.googleapis.batch;

import com.google.api.client.http.HttpHeaders;
import java.io.IOException;

public interface BatchCallback {
   void onSuccess(Object var1, HttpHeaders var2) throws IOException;

   void onFailure(Object var1, HttpHeaders var2) throws IOException;
}
