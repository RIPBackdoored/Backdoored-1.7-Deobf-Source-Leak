package com.google.cloud.storage;

import com.google.common.collect.ImmutableList;

public final class Cors$Builder {
   private Integer maxAgeSeconds;
   private ImmutableList methods;
   private ImmutableList origins;
   private ImmutableList responseHeaders;

   private Cors$Builder() {
   }

   public Cors$Builder setMaxAgeSeconds(Integer maxAgeSeconds) {
      this.maxAgeSeconds = maxAgeSeconds;
      return this;
   }

   public Cors$Builder setMethods(Iterable methods) {
      this.methods = methods != null ? ImmutableList.copyOf(methods) : null;
      return this;
   }

   public Cors$Builder setOrigins(Iterable origins) {
      this.origins = origins != null ? ImmutableList.copyOf(origins) : null;
      return this;
   }

   public Cors$Builder setResponseHeaders(Iterable headers) {
      this.responseHeaders = headers != null ? ImmutableList.copyOf(headers) : null;
      return this;
   }

   public Cors build() {
      return new Cors(this, (Cors$1)null);
   }

   // $FF: synthetic method
   static Integer access$100(Cors$Builder x0) {
      return x0.maxAgeSeconds;
   }

   // $FF: synthetic method
   static ImmutableList access$200(Cors$Builder x0) {
      return x0.methods;
   }

   // $FF: synthetic method
   static ImmutableList access$300(Cors$Builder x0) {
      return x0.origins;
   }

   // $FF: synthetic method
   static ImmutableList access$400(Cors$Builder x0) {
      return x0.responseHeaders;
   }

   // $FF: synthetic method
   Cors$Builder(Cors$1 x0) {
      this();
   }
}
