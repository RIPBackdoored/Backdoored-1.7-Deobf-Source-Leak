package com.google.cloud.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CanonicalExtensionHeadersSerializer {
   private static final char HEADER_SEPARATOR = ':';
   private static final char HEADER_NAME_SEPARATOR = ';';
   private final Storage$SignUrlOption$SignatureVersion signatureVersion;

   public CanonicalExtensionHeadersSerializer(Storage$SignUrlOption$SignatureVersion signatureVersion) {
      this.signatureVersion = signatureVersion;
   }

   public CanonicalExtensionHeadersSerializer() {
      this.signatureVersion = Storage$SignUrlOption$SignatureVersion.V2;
   }

   public StringBuilder serialize(Map canonicalizedExtensionHeaders) {
      StringBuilder serializedHeaders = new StringBuilder();
      if (canonicalizedExtensionHeaders != null && !canonicalizedExtensionHeaders.isEmpty()) {
         Map lowercaseHeaders = this.getLowercaseHeaders(canonicalizedExtensionHeaders);
         List sortedHeaderNames = new ArrayList(lowercaseHeaders.keySet());
         Collections.sort(sortedHeaderNames);
         Iterator var5 = sortedHeaderNames.iterator();

         while(var5.hasNext()) {
            String headerName = (String)var5.next();
            serializedHeaders.append(headerName).append(':').append(((String)lowercaseHeaders.get(headerName)).trim().replaceAll("[\\s]{2,}", " ").replaceAll("(\\t|\\r?\\n)+", " ")).append('\n');
         }

         return serializedHeaders;
      } else {
         return serializedHeaders;
      }
   }

   public StringBuilder serializeHeaderNames(Map canonicalizedExtensionHeaders) {
      StringBuilder serializedHeaders = new StringBuilder();
      if (canonicalizedExtensionHeaders != null && !canonicalizedExtensionHeaders.isEmpty()) {
         Map lowercaseHeaders = this.getLowercaseHeaders(canonicalizedExtensionHeaders);
         List sortedHeaderNames = new ArrayList(lowercaseHeaders.keySet());
         Collections.sort(sortedHeaderNames);
         Iterator var5 = sortedHeaderNames.iterator();

         while(var5.hasNext()) {
            String headerName = (String)var5.next();
            serializedHeaders.append(headerName).append(';');
         }

         serializedHeaders.setLength(serializedHeaders.length() - 1);
         return serializedHeaders;
      } else {
         return serializedHeaders;
      }
   }

   private Map getLowercaseHeaders(Map canonicalizedExtensionHeaders) {
      Map lowercaseHeaders = new HashMap();
      Iterator var3 = (new ArrayList(canonicalizedExtensionHeaders.keySet())).iterator();

      while(true) {
         String headerName;
         String lowercaseHeaderName;
         do {
            if (!var3.hasNext()) {
               return lowercaseHeaders;
            }

            headerName = (String)var3.next();
            lowercaseHeaderName = headerName.toLowerCase();
         } while(Storage$SignUrlOption$SignatureVersion.V2.equals(this.signatureVersion) && ("x-goog-encryption-key".equals(lowercaseHeaderName) || "x-goog-encryption-key-sha256".equals(lowercaseHeaderName)));

         lowercaseHeaders.put(lowercaseHeaderName, canonicalizedExtensionHeaders.get(headerName));
      }
   }
}
