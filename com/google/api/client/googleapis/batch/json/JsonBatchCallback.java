package com.google.api.client.googleapis.batch.json;

import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.google.api.client.http.HttpHeaders;
import java.io.IOException;

public abstract class JsonBatchCallback implements BatchCallback {
   public final void onFailure(GoogleJsonErrorContainer e, HttpHeaders responseHeaders) throws IOException {
      this.onFailure(e.getError(), responseHeaders);
   }

   public abstract void onFailure(GoogleJsonError var1, HttpHeaders var2) throws IOException;

   // $FF: synthetic method
   // $FF: bridge method
   public void onFailure(Object var1, HttpHeaders var2) throws IOException {
      this.onFailure((GoogleJsonErrorContainer)var1, var2);
   }
}
