package com.google.cloud.storage;

import com.google.common.hash.Hashing;
import com.google.common.net.UrlEscapers;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class SignatureInfo {
   public static final char COMPONENT_SEPARATOR = '\n';
   public static final String GOOG4_RSA_SHA256 = "GOOG4-RSA-SHA256";
   public static final String SCOPE = "/auto/storage/goog4_request";
   private final HttpMethod httpVerb;
   private final String contentMd5;
   private final String contentType;
   private final long expiration;
   private final Map canonicalizedExtensionHeaders;
   private final URI canonicalizedResource;
   private final Storage$SignUrlOption$SignatureVersion signatureVersion;
   private final String accountEmail;
   private final long timestamp;
   private final String yearMonthDay;
   private final String exactDate;

   private SignatureInfo(SignatureInfo$Builder builder) {
      this.httpVerb = SignatureInfo$Builder.access$000(builder);
      this.contentMd5 = SignatureInfo$Builder.access$100(builder);
      this.contentType = SignatureInfo$Builder.access$200(builder);
      this.expiration = SignatureInfo$Builder.access$300(builder);
      this.canonicalizedResource = SignatureInfo$Builder.access$400(builder);
      this.signatureVersion = SignatureInfo$Builder.access$500(builder);
      this.accountEmail = SignatureInfo$Builder.access$600(builder);
      this.timestamp = SignatureInfo$Builder.access$700(builder);
      if (Storage$SignUrlOption$SignatureVersion.V4.equals(this.signatureVersion) && !SignatureInfo$Builder.access$800(builder).containsKey("host")) {
         this.canonicalizedExtensionHeaders = (new com.google.common.collect.ImmutableMap.Builder()).putAll(SignatureInfo$Builder.access$800(builder)).put("host", "storage.googleapis.com").build();
      } else {
         this.canonicalizedExtensionHeaders = SignatureInfo$Builder.access$800(builder);
      }

      Date date = new Date(this.timestamp);
      SimpleDateFormat yearMonthDayFormat = new SimpleDateFormat("yyyyMMdd");
      SimpleDateFormat exactDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
      yearMonthDayFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      exactDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      this.yearMonthDay = yearMonthDayFormat.format(date);
      this.exactDate = exactDateFormat.format(date);
   }

   public String constructUnsignedPayload() {
      return Storage$SignUrlOption$SignatureVersion.V4.equals(this.signatureVersion) ? this.constructV4UnsignedPayload() : this.constructV2UnsignedPayload();
   }

   private String constructV2UnsignedPayload() {
      StringBuilder payload = new StringBuilder();
      payload.append(this.httpVerb.name()).append('\n');
      if (this.contentMd5 != null) {
         payload.append(this.contentMd5);
      }

      payload.append('\n');
      if (this.contentType != null) {
         payload.append(this.contentType);
      }

      payload.append('\n');
      payload.append(this.expiration).append('\n');
      if (this.canonicalizedExtensionHeaders != null) {
         payload.append((new CanonicalExtensionHeadersSerializer(Storage$SignUrlOption$SignatureVersion.V2)).serialize(this.canonicalizedExtensionHeaders));
      }

      payload.append(this.canonicalizedResource);
      return payload.toString();
   }

   private String constructV4UnsignedPayload() {
      StringBuilder payload = new StringBuilder();
      payload.append("GOOG4-RSA-SHA256").append('\n');
      payload.append(this.exactDate).append('\n');
      payload.append(this.yearMonthDay).append("/auto/storage/goog4_request").append('\n');
      payload.append(this.constructV4CanonicalRequestHash());
      return payload.toString();
   }

   private String constructV4CanonicalRequestHash() {
      StringBuilder canonicalRequest = new StringBuilder();
      CanonicalExtensionHeadersSerializer serializer = new CanonicalExtensionHeadersSerializer(Storage$SignUrlOption$SignatureVersion.V4);
      canonicalRequest.append(this.httpVerb.name()).append('\n');
      canonicalRequest.append(this.canonicalizedResource).append('\n');
      canonicalRequest.append(this.constructV4QueryString()).append('\n');
      canonicalRequest.append(serializer.serialize(this.canonicalizedExtensionHeaders)).append('\n');
      canonicalRequest.append(serializer.serializeHeaderNames(this.canonicalizedExtensionHeaders)).append('\n');
      canonicalRequest.append("UNSIGNED-PAYLOAD");
      return Hashing.sha256().hashString(canonicalRequest.toString(), StandardCharsets.UTF_8).toString();
   }

   public String constructV4QueryString() {
      StringBuilder signedHeaders = (new CanonicalExtensionHeadersSerializer(Storage$SignUrlOption$SignatureVersion.V4)).serializeHeaderNames(this.canonicalizedExtensionHeaders);
      StringBuilder queryString = new StringBuilder();
      queryString.append("X-Goog-Algorithm=").append("GOOG4-RSA-SHA256").append("&");
      queryString.append("X-Goog-Credential=" + UrlEscapers.urlFormParameterEscaper().escape(this.accountEmail + "/" + this.yearMonthDay + "/auto/storage/goog4_request") + "&");
      queryString.append("X-Goog-Date=" + this.exactDate + "&");
      queryString.append("X-Goog-Expires=" + this.expiration + "&");
      queryString.append("X-Goog-SignedHeaders=" + UrlEscapers.urlFormParameterEscaper().escape(signedHeaders.toString()));
      return queryString.toString();
   }

   public HttpMethod getHttpVerb() {
      return this.httpVerb;
   }

   public String getContentMd5() {
      return this.contentMd5;
   }

   public String getContentType() {
      return this.contentType;
   }

   public long getExpiration() {
      return this.expiration;
   }

   public Map getCanonicalizedExtensionHeaders() {
      return this.canonicalizedExtensionHeaders;
   }

   public URI getCanonicalizedResource() {
      return this.canonicalizedResource;
   }

   public Storage$SignUrlOption$SignatureVersion getSignatureVersion() {
      return this.signatureVersion;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public String getAccountEmail() {
      return this.accountEmail;
   }

   // $FF: synthetic method
   static HttpMethod access$900(SignatureInfo x0) {
      return x0.httpVerb;
   }

   // $FF: synthetic method
   static String access$1000(SignatureInfo x0) {
      return x0.contentMd5;
   }

   // $FF: synthetic method
   static String access$1100(SignatureInfo x0) {
      return x0.contentType;
   }

   // $FF: synthetic method
   static long access$1200(SignatureInfo x0) {
      return x0.expiration;
   }

   // $FF: synthetic method
   static Map access$1300(SignatureInfo x0) {
      return x0.canonicalizedExtensionHeaders;
   }

   // $FF: synthetic method
   static URI access$1400(SignatureInfo x0) {
      return x0.canonicalizedResource;
   }

   // $FF: synthetic method
   static Storage$SignUrlOption$SignatureVersion access$1500(SignatureInfo x0) {
      return x0.signatureVersion;
   }

   // $FF: synthetic method
   static String access$1600(SignatureInfo x0) {
      return x0.accountEmail;
   }

   // $FF: synthetic method
   static long access$1700(SignatureInfo x0) {
      return x0.timestamp;
   }

   // $FF: synthetic method
   SignatureInfo(SignatureInfo$Builder x0, SignatureInfo$1 x1) {
      this(x0);
   }
}
