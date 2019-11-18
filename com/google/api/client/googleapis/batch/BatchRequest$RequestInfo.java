package com.google.api.client.googleapis.batch;

import com.google.api.client.http.HttpRequest;

class BatchRequest$RequestInfo {
   final BatchCallback callback;
   final Class dataClass;
   final Class errorClass;
   final HttpRequest request;

   BatchRequest$RequestInfo(BatchCallback callback, Class dataClass, Class errorClass, HttpRequest request) {
      this.callback = callback;
      this.dataClass = dataClass;
      this.errorClass = errorClass;
      this.request = request;
   }
}
