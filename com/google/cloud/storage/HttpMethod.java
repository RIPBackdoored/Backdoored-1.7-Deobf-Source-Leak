package com.google.cloud.storage;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;

public final class HttpMethod extends StringEnumValue {
   private static final long serialVersionUID = -1394461645628254471L;
   private static final ApiFunction CONSTRUCTOR = new HttpMethod$1();
   private static final StringEnumType type;
   public static final HttpMethod GET;
   public static final HttpMethod HEAD;
   public static final HttpMethod PUT;
   public static final HttpMethod POST;
   public static final HttpMethod DELETE;
   public static final HttpMethod OPTIONS;

   private HttpMethod(String constant) {
      super(constant);
   }

   public static HttpMethod valueOfStrict(String constant) {
      return (HttpMethod)type.valueOfStrict(constant);
   }

   public static HttpMethod valueOf(String constant) {
      return (HttpMethod)type.valueOf(constant);
   }

   public static HttpMethod[] values() {
      return (HttpMethod[])type.values();
   }

   // $FF: synthetic method
   HttpMethod(String x0, HttpMethod$1 x1) {
      this(x0);
   }

   static {
      type = new StringEnumType(HttpMethod.class, CONSTRUCTOR);
      GET = (HttpMethod)type.createAndRegister("GET");
      HEAD = (HttpMethod)type.createAndRegister("HEAD");
      PUT = (HttpMethod)type.createAndRegister("PUT");
      POST = (HttpMethod)type.createAndRegister("POST");
      DELETE = (HttpMethod)type.createAndRegister("DELETE");
      OPTIONS = (HttpMethod)type.createAndRegister("OPTIONS");
   }
}
