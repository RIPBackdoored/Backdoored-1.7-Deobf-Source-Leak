package com.google.cloud.storage;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public final class Cors implements Serializable {
   private static final long serialVersionUID = -8637770919343335655L;
   static final Function FROM_PB_FUNCTION = new Cors$1();
   static final Function TO_PB_FUNCTION = new Cors$2();
   private final Integer maxAgeSeconds;
   private final ImmutableList methods;
   private final ImmutableList origins;
   private final ImmutableList responseHeaders;

   private Cors(Cors$Builder builder) {
      this.maxAgeSeconds = Cors$Builder.access$100(builder);
      this.methods = Cors$Builder.access$200(builder);
      this.origins = Cors$Builder.access$300(builder);
      this.responseHeaders = Cors$Builder.access$400(builder);
   }

   public Integer getMaxAgeSeconds() {
      return this.maxAgeSeconds;
   }

   public List getMethods() {
      return this.methods;
   }

   public List getOrigins() {
      return this.origins;
   }

   public List getResponseHeaders() {
      return this.responseHeaders;
   }

   public Cors$Builder toBuilder() {
      return newBuilder().setMaxAgeSeconds(this.maxAgeSeconds).setMethods(this.methods).setOrigins(this.origins).setResponseHeaders(this.responseHeaders);
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.maxAgeSeconds, this.methods, this.origins, this.responseHeaders});
   }

   public boolean equals(Object obj) {
      if (!(obj instanceof Cors)) {
         return false;
      } else {
         Cors other = (Cors)obj;
         return Objects.equals(this.maxAgeSeconds, other.maxAgeSeconds) && Objects.equals(this.methods, other.methods) && Objects.equals(this.origins, other.origins) && Objects.equals(this.responseHeaders, other.responseHeaders);
      }
   }

   public static Cors$Builder newBuilder() {
      return new Cors$Builder((Cors$1)null);
   }

   com.google.api.services.storage.model.Bucket.Cors toPb() {
      com.google.api.services.storage.model.Bucket.Cors pb = new com.google.api.services.storage.model.Bucket.Cors();
      pb.setMaxAgeSeconds(this.maxAgeSeconds);
      pb.setResponseHeader(this.responseHeaders);
      if (this.methods != null) {
         pb.setMethod(Lists.newArrayList(Iterables.transform(this.methods, Functions.toStringFunction())));
      }

      if (this.origins != null) {
         pb.setOrigin(Lists.newArrayList(Iterables.transform(this.origins, Functions.toStringFunction())));
      }

      return pb;
   }

   static Cors fromPb(com.google.api.services.storage.model.Bucket.Cors cors) {
      Cors$Builder builder = newBuilder().setMaxAgeSeconds(cors.getMaxAgeSeconds());
      if (cors.getMethod() != null) {
         builder.setMethods(Iterables.transform(cors.getMethod(), new Cors$3()));
      }

      if (cors.getOrigin() != null) {
         builder.setOrigins(Iterables.transform(cors.getOrigin(), new Cors$4()));
      }

      builder.setResponseHeaders(cors.getResponseHeader());
      return builder.build();
   }

   // $FF: synthetic method
   Cors(Cors$Builder x0, Cors$1 x1) {
      this(x0);
   }
}
