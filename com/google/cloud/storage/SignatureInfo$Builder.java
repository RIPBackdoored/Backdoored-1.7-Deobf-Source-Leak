package com.google.cloud.storage;

import com.google.common.base.Preconditions;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public final class SignatureInfo$Builder {
   private final HttpMethod httpVerb;
   private String contentMd5;
   private String contentType;
   private final long expiration;
   private Map canonicalizedExtensionHeaders;
   private final URI canonicalizedResource;
   private Storage$SignUrlOption$SignatureVersion signatureVersion;
   private String accountEmail;
   private long timestamp;

   public SignatureInfo$Builder(HttpMethod httpVerb, long expiration, URI canonicalizedResource) {
      this.httpVerb = httpVerb;
      this.expiration = expiration;
      this.canonicalizedResource = canonicalizedResource;
   }

   public SignatureInfo$Builder(SignatureInfo signatureInfo) {
      this.httpVerb = SignatureInfo.access$900(signatureInfo);
      this.contentMd5 = SignatureInfo.access$1000(signatureInfo);
      this.contentType = SignatureInfo.access$1100(signatureInfo);
      this.expiration = SignatureInfo.access$1200(signatureInfo);
      this.canonicalizedExtensionHeaders = SignatureInfo.access$1300(signatureInfo);
      this.canonicalizedResource = SignatureInfo.access$1400(signatureInfo);
      this.signatureVersion = SignatureInfo.access$1500(signatureInfo);
      this.accountEmail = SignatureInfo.access$1600(signatureInfo);
      this.timestamp = SignatureInfo.access$1700(signatureInfo);
   }

   public SignatureInfo$Builder setContentMd5(String contentMd5) {
      this.contentMd5 = contentMd5;
      return this;
   }

   public SignatureInfo$Builder setContentType(String contentType) {
      this.contentType = contentType;
      return this;
   }

   public SignatureInfo$Builder setCanonicalizedExtensionHeaders(Map canonicalizedExtensionHeaders) {
      this.canonicalizedExtensionHeaders = canonicalizedExtensionHeaders;
      return this;
   }

   public SignatureInfo$Builder setSignatureVersion(Storage$SignUrlOption$SignatureVersion signatureVersion) {
      this.signatureVersion = signatureVersion;
      return this;
   }

   public SignatureInfo$Builder setAccountEmail(String accountEmail) {
      this.accountEmail = accountEmail;
      return this;
   }

   public SignatureInfo$Builder setTimestamp(long timestamp) {
      this.timestamp = timestamp;
      return this;
   }

   public SignatureInfo build() {
      Preconditions.checkArgument(this.httpVerb != null, "Required HTTP method");
      Preconditions.checkArgument(this.canonicalizedResource != null, "Required canonicalized resource");
      Preconditions.checkArgument(this.expiration >= 0L, "Expiration must be greater than or equal to zero");
      if (Storage$SignUrlOption$SignatureVersion.V4.equals(this.signatureVersion)) {
         Preconditions.checkArgument(this.accountEmail != null, "Account email required to use V4 signing");
         Preconditions.checkArgument(this.timestamp > 0L, "Timestamp required to use V4 signing");
         Preconditions.checkArgument(this.expiration <= 604800L, "Expiration can't be longer than 7 days to use V4 signing");
      }

      if (this.canonicalizedExtensionHeaders == null) {
         this.canonicalizedExtensionHeaders = new HashMap();
      }

      return new SignatureInfo(this, (SignatureInfo$1)null);
   }

   // $FF: synthetic method
   static HttpMethod access$000(SignatureInfo$Builder x0) {
      return x0.httpVerb;
   }

   // $FF: synthetic method
   static String access$100(SignatureInfo$Builder x0) {
      return x0.contentMd5;
   }

   // $FF: synthetic method
   static String access$200(SignatureInfo$Builder x0) {
      return x0.contentType;
   }

   // $FF: synthetic method
   static long access$300(SignatureInfo$Builder x0) {
      return x0.expiration;
   }

   // $FF: synthetic method
   static URI access$400(SignatureInfo$Builder x0) {
      return x0.canonicalizedResource;
   }

   // $FF: synthetic method
   static Storage$SignUrlOption$SignatureVersion access$500(SignatureInfo$Builder x0) {
      return x0.signatureVersion;
   }

   // $FF: synthetic method
   static String access$600(SignatureInfo$Builder x0) {
      return x0.accountEmail;
   }

   // $FF: synthetic method
   static long access$700(SignatureInfo$Builder x0) {
      return x0.timestamp;
   }

   // $FF: synthetic method
   static Map access$800(SignatureInfo$Builder x0) {
      return x0.canonicalizedExtensionHeaders;
   }
}
