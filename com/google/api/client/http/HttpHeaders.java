package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Base64;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.GenericData$Flags;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpHeaders extends GenericData {
   @Key("Accept")
   private List accept;
   @Key("Accept-Encoding")
   private List acceptEncoding = new ArrayList(Collections.singleton("gzip"));
   @Key("Authorization")
   private List authorization;
   @Key("Cache-Control")
   private List cacheControl;
   @Key("Content-Encoding")
   private List contentEncoding;
   @Key("Content-Length")
   private List contentLength;
   @Key("Content-MD5")
   private List contentMD5;
   @Key("Content-Range")
   private List contentRange;
   @Key("Content-Type")
   private List contentType;
   @Key("Cookie")
   private List cookie;
   @Key("Date")
   private List date;
   @Key("ETag")
   private List etag;
   @Key("Expires")
   private List expires;
   @Key("If-Modified-Since")
   private List ifModifiedSince;
   @Key("If-Match")
   private List ifMatch;
   @Key("If-None-Match")
   private List ifNoneMatch;
   @Key("If-Unmodified-Since")
   private List ifUnmodifiedSince;
   @Key("If-Range")
   private List ifRange;
   @Key("Last-Modified")
   private List lastModified;
   @Key("Location")
   private List location;
   @Key("MIME-Version")
   private List mimeVersion;
   @Key("Range")
   private List range;
   @Key("Retry-After")
   private List retryAfter;
   @Key("User-Agent")
   private List userAgent;
   @Key("WWW-Authenticate")
   private List authenticate;
   @Key("Age")
   private List age;

   public HttpHeaders() {
      super(EnumSet.of(GenericData$Flags.IGNORE_CASE));
   }

   public HttpHeaders clone() {
      return (HttpHeaders)super.clone();
   }

   public HttpHeaders set(String fieldName, Object value) {
      return (HttpHeaders)super.set(fieldName, value);
   }

   public final String getAccept() {
      return (String)this.getFirstHeaderValue(this.accept);
   }

   public HttpHeaders setAccept(String accept) {
      this.accept = this.getAsList(accept);
      return this;
   }

   public final String getAcceptEncoding() {
      return (String)this.getFirstHeaderValue(this.acceptEncoding);
   }

   public HttpHeaders setAcceptEncoding(String acceptEncoding) {
      this.acceptEncoding = this.getAsList(acceptEncoding);
      return this;
   }

   public final String getAuthorization() {
      return (String)this.getFirstHeaderValue(this.authorization);
   }

   public final List getAuthorizationAsList() {
      return this.authorization;
   }

   public HttpHeaders setAuthorization(String authorization) {
      return this.setAuthorization(this.getAsList(authorization));
   }

   public HttpHeaders setAuthorization(List authorization) {
      this.authorization = authorization;
      return this;
   }

   public final String getCacheControl() {
      return (String)this.getFirstHeaderValue(this.cacheControl);
   }

   public HttpHeaders setCacheControl(String cacheControl) {
      this.cacheControl = this.getAsList(cacheControl);
      return this;
   }

   public final String getContentEncoding() {
      return (String)this.getFirstHeaderValue(this.contentEncoding);
   }

   public HttpHeaders setContentEncoding(String contentEncoding) {
      this.contentEncoding = this.getAsList(contentEncoding);
      return this;
   }

   public final Long getContentLength() {
      return (Long)this.getFirstHeaderValue(this.contentLength);
   }

   public HttpHeaders setContentLength(Long contentLength) {
      this.contentLength = this.getAsList(contentLength);
      return this;
   }

   public final String getContentMD5() {
      return (String)this.getFirstHeaderValue(this.contentMD5);
   }

   public HttpHeaders setContentMD5(String contentMD5) {
      this.contentMD5 = this.getAsList(contentMD5);
      return this;
   }

   public final String getContentRange() {
      return (String)this.getFirstHeaderValue(this.contentRange);
   }

   public HttpHeaders setContentRange(String contentRange) {
      this.contentRange = this.getAsList(contentRange);
      return this;
   }

   public final String getContentType() {
      return (String)this.getFirstHeaderValue(this.contentType);
   }

   public HttpHeaders setContentType(String contentType) {
      this.contentType = this.getAsList(contentType);
      return this;
   }

   public final String getCookie() {
      return (String)this.getFirstHeaderValue(this.cookie);
   }

   public HttpHeaders setCookie(String cookie) {
      this.cookie = this.getAsList(cookie);
      return this;
   }

   public final String getDate() {
      return (String)this.getFirstHeaderValue(this.date);
   }

   public HttpHeaders setDate(String date) {
      this.date = this.getAsList(date);
      return this;
   }

   public final String getETag() {
      return (String)this.getFirstHeaderValue(this.etag);
   }

   public HttpHeaders setETag(String etag) {
      this.etag = this.getAsList(etag);
      return this;
   }

   public final String getExpires() {
      return (String)this.getFirstHeaderValue(this.expires);
   }

   public HttpHeaders setExpires(String expires) {
      this.expires = this.getAsList(expires);
      return this;
   }

   public final String getIfModifiedSince() {
      return (String)this.getFirstHeaderValue(this.ifModifiedSince);
   }

   public HttpHeaders setIfModifiedSince(String ifModifiedSince) {
      this.ifModifiedSince = this.getAsList(ifModifiedSince);
      return this;
   }

   public final String getIfMatch() {
      return (String)this.getFirstHeaderValue(this.ifMatch);
   }

   public HttpHeaders setIfMatch(String ifMatch) {
      this.ifMatch = this.getAsList(ifMatch);
      return this;
   }

   public final String getIfNoneMatch() {
      return (String)this.getFirstHeaderValue(this.ifNoneMatch);
   }

   public HttpHeaders setIfNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = this.getAsList(ifNoneMatch);
      return this;
   }

   public final String getIfUnmodifiedSince() {
      return (String)this.getFirstHeaderValue(this.ifUnmodifiedSince);
   }

   public HttpHeaders setIfUnmodifiedSince(String ifUnmodifiedSince) {
      this.ifUnmodifiedSince = this.getAsList(ifUnmodifiedSince);
      return this;
   }

   public final String getIfRange() {
      return (String)this.getFirstHeaderValue(this.ifRange);
   }

   public HttpHeaders setIfRange(String ifRange) {
      this.ifRange = this.getAsList(ifRange);
      return this;
   }

   public final String getLastModified() {
      return (String)this.getFirstHeaderValue(this.lastModified);
   }

   public HttpHeaders setLastModified(String lastModified) {
      this.lastModified = this.getAsList(lastModified);
      return this;
   }

   public final String getLocation() {
      return (String)this.getFirstHeaderValue(this.location);
   }

   public HttpHeaders setLocation(String location) {
      this.location = this.getAsList(location);
      return this;
   }

   public final String getMimeVersion() {
      return (String)this.getFirstHeaderValue(this.mimeVersion);
   }

   public HttpHeaders setMimeVersion(String mimeVersion) {
      this.mimeVersion = this.getAsList(mimeVersion);
      return this;
   }

   public final String getRange() {
      return (String)this.getFirstHeaderValue(this.range);
   }

   public HttpHeaders setRange(String range) {
      this.range = this.getAsList(range);
      return this;
   }

   public final String getRetryAfter() {
      return (String)this.getFirstHeaderValue(this.retryAfter);
   }

   public HttpHeaders setRetryAfter(String retryAfter) {
      this.retryAfter = this.getAsList(retryAfter);
      return this;
   }

   public final String getUserAgent() {
      return (String)this.getFirstHeaderValue(this.userAgent);
   }

   public HttpHeaders setUserAgent(String userAgent) {
      this.userAgent = this.getAsList(userAgent);
      return this;
   }

   public final String getAuthenticate() {
      return (String)this.getFirstHeaderValue(this.authenticate);
   }

   public final List getAuthenticateAsList() {
      return this.authenticate;
   }

   public HttpHeaders setAuthenticate(String authenticate) {
      this.authenticate = this.getAsList(authenticate);
      return this;
   }

   public final Long getAge() {
      return (Long)this.getFirstHeaderValue(this.age);
   }

   public HttpHeaders setAge(Long age) {
      this.age = this.getAsList(age);
      return this;
   }

   public HttpHeaders setBasicAuthentication(String username, String password) {
      String userPass = (String)Preconditions.checkNotNull(username) + ":" + (String)Preconditions.checkNotNull(password);
      String encoded = Base64.encodeBase64String(StringUtils.getBytesUtf8(userPass));
      return this.setAuthorization("Basic " + encoded);
   }

   private static void addHeader(Logger logger, StringBuilder logbuf, StringBuilder curlbuf, LowLevelHttpRequest lowLevelHttpRequest, String name, Object value, Writer writer) throws IOException {
      if (value != null && !Data.isNull(value)) {
         String stringValue = toStringValue(value);
         String loggedStringValue = stringValue;
         if (("Authorization".equalsIgnoreCase(name) || "Cookie".equalsIgnoreCase(name)) && (logger == null || !logger.isLoggable(Level.ALL))) {
            loggedStringValue = "<Not Logged>";
         }

         if (logbuf != null) {
            logbuf.append(name).append(": ");
            logbuf.append(loggedStringValue);
            logbuf.append(StringUtils.LINE_SEPARATOR);
         }

         if (curlbuf != null) {
            curlbuf.append(" -H '").append(name).append(": ").append(loggedStringValue).append("'");
         }

         if (lowLevelHttpRequest != null) {
            lowLevelHttpRequest.addHeader(name, stringValue);
         }

         if (writer != null) {
            writer.write(name);
            writer.write(": ");
            writer.write(stringValue);
            writer.write("\r\n");
         }

      }
   }

   private static String toStringValue(Object headerValue) {
      return headerValue instanceof Enum ? FieldInfo.of((Enum)headerValue).getName() : headerValue.toString();
   }

   static void serializeHeaders(HttpHeaders headers, StringBuilder logbuf, StringBuilder curlbuf, Logger logger, LowLevelHttpRequest lowLevelHttpRequest) throws IOException {
      serializeHeaders(headers, logbuf, curlbuf, logger, lowLevelHttpRequest, (Writer)null);
   }

   public static void serializeHeadersForMultipartRequests(HttpHeaders headers, StringBuilder logbuf, Logger logger, Writer writer) throws IOException {
      serializeHeaders(headers, logbuf, (StringBuilder)null, logger, (LowLevelHttpRequest)null, writer);
   }

   static void serializeHeaders(HttpHeaders headers, StringBuilder logbuf, StringBuilder curlbuf, Logger logger, LowLevelHttpRequest lowLevelHttpRequest, Writer writer) throws IOException {
      HashSet headerNames = new HashSet();
      Iterator var7 = headers.entrySet().iterator();

      while(true) {
         while(true) {
            String name;
            Object value;
            do {
               if (!var7.hasNext()) {
                  if (writer != null) {
                     writer.flush();
                  }

                  return;
               }

               Entry headerEntry = (Entry)var7.next();
               name = (String)headerEntry.getKey();
               Preconditions.checkArgument(headerNames.add(name), "multiple headers of the same name (headers are case insensitive): %s", name);
               value = headerEntry.getValue();
            } while(value == null);

            String displayName = name;
            FieldInfo fieldInfo = headers.getClassInfo().getFieldInfo(name);
            if (fieldInfo != null) {
               displayName = fieldInfo.getName();
            }

            Class valueClass = value.getClass();
            if (!(value instanceof Iterable) && !valueClass.isArray()) {
               addHeader(logger, logbuf, curlbuf, lowLevelHttpRequest, displayName, value, writer);
            } else {
               Iterator var14 = Types.iterableOf(value).iterator();

               while(var14.hasNext()) {
                  Object repeatedValue = var14.next();
                  addHeader(logger, logbuf, curlbuf, lowLevelHttpRequest, displayName, repeatedValue, writer);
               }
            }
         }
      }
   }

   public final void fromHttpResponse(LowLevelHttpResponse response, StringBuilder logger) throws IOException {
      this.clear();
      HttpHeaders$ParseHeaderState state = new HttpHeaders$ParseHeaderState(this, logger);
      int headerCount = response.getHeaderCount();

      for(int i = 0; i < headerCount; ++i) {
         this.parseHeader(response.getHeaderName(i), response.getHeaderValue(i), state);
      }

      state.finish();
   }

   private Object getFirstHeaderValue(List internalValue) {
      return internalValue == null ? null : internalValue.get(0);
   }

   private List getAsList(Object passedValue) {
      if (passedValue == null) {
         return null;
      } else {
         List result = new ArrayList();
         result.add(passedValue);
         return result;
      }
   }

   public String getFirstHeaderStringValue(String name) {
      Object value = this.get(name.toLowerCase(Locale.US));
      if (value == null) {
         return null;
      } else {
         Class valueClass = value.getClass();
         if (value instanceof Iterable || valueClass.isArray()) {
            Iterator var4 = Types.iterableOf(value).iterator();
            if (var4.hasNext()) {
               Object repeatedValue = var4.next();
               return toStringValue(repeatedValue);
            }
         }

         return toStringValue(value);
      }
   }

   public List getHeaderStringValues(String name) {
      Object value = this.get(name.toLowerCase(Locale.US));
      if (value == null) {
         return Collections.emptyList();
      } else {
         Class valueClass = value.getClass();
         if (!(value instanceof Iterable) && !valueClass.isArray()) {
            return Collections.singletonList(toStringValue(value));
         } else {
            List values = new ArrayList();
            Iterator var5 = Types.iterableOf(value).iterator();

            while(var5.hasNext()) {
               Object repeatedValue = var5.next();
               values.add(toStringValue(repeatedValue));
            }

            return Collections.unmodifiableList(values);
         }
      }
   }

   public final void fromHttpHeaders(HttpHeaders headers) {
      try {
         HttpHeaders$ParseHeaderState state = new HttpHeaders$ParseHeaderState(this, (StringBuilder)null);
         serializeHeaders(headers, (StringBuilder)null, (StringBuilder)null, (Logger)null, new HttpHeaders$HeaderParsingFakeLevelHttpRequest(this, state));
         state.finish();
      } catch (IOException var3) {
         throw Throwables.propagate(var3);
      }

   }

   void parseHeader(String headerName, String headerValue, HttpHeaders$ParseHeaderState state) {
      List context = state.context;
      ClassInfo classInfo = state.classInfo;
      ArrayValueMap arrayValueMap = state.arrayValueMap;
      StringBuilder logger = state.logger;
      if (logger != null) {
         logger.append(headerName + ": " + headerValue).append(StringUtils.LINE_SEPARATOR);
      }

      FieldInfo fieldInfo = classInfo.getFieldInfo(headerName);
      if (fieldInfo != null) {
         Type type = Data.resolveWildcardTypeOrTypeVariable(context, fieldInfo.getGenericType());
         if (Types.isArray(type)) {
            Class rawArrayComponentType = Types.getRawArrayComponentType(context, Types.getArrayComponentType(type));
            arrayValueMap.put(fieldInfo.getField(), rawArrayComponentType, parseValue(rawArrayComponentType, context, headerValue));
         } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(context, type), Iterable.class)) {
            Collection collection = (Collection)fieldInfo.getValue(this);
            if (collection == null) {
               collection = Data.newCollectionInstance(type);
               fieldInfo.setValue(this, collection);
            }

            Type subFieldType = type == Object.class ? null : Types.getIterableParameter(type);
            collection.add(parseValue(subFieldType, context, headerValue));
         } else {
            fieldInfo.setValue(this, parseValue(type, context, headerValue));
         }
      } else {
         ArrayList listValue = (ArrayList)this.get(headerName);
         if (listValue == null) {
            listValue = new ArrayList();
            this.set(headerName, listValue);
         }

         listValue.add(headerValue);
      }

   }

   private static Object parseValue(Type valueType, List context, String value) {
      Type resolved = Data.resolveWildcardTypeOrTypeVariable(context, valueType);
      return Data.parsePrimitiveValue(resolved, value);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
