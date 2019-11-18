package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.ClassInfo;
import java.util.Arrays;
import java.util.List;

final class HttpHeaders$ParseHeaderState {
   final ArrayValueMap arrayValueMap;
   final StringBuilder logger;
   final ClassInfo classInfo;
   final List context;

   public HttpHeaders$ParseHeaderState(HttpHeaders headers, StringBuilder logger) {
      Class clazz = headers.getClass();
      this.context = Arrays.asList(clazz);
      this.classInfo = ClassInfo.of(clazz, true);
      this.logger = logger;
      this.arrayValueMap = new ArrayValueMap(headers);
   }

   void finish() {
      this.arrayValueMap.setValues();
   }
}
