package com.google.cloud.storage;

import com.google.auth.ServiceAccountSigner;
import java.io.Serializable;
import java.util.Map;

public class Storage$SignUrlOption implements Serializable {
   private static final long serialVersionUID = 7850569877451099267L;
   private final Storage$SignUrlOption$Option option;
   private final Object value;

   private Storage$SignUrlOption(Storage$SignUrlOption$Option option, Object value) {
      this.option = option;
      this.value = value;
   }

   Storage$SignUrlOption$Option getOption() {
      return this.option;
   }

   Object getValue() {
      return this.value;
   }

   public static Storage$SignUrlOption httpMethod(HttpMethod httpMethod) {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.HTTP_METHOD, httpMethod);
   }

   public static Storage$SignUrlOption withContentType() {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.CONTENT_TYPE, true);
   }

   public static Storage$SignUrlOption withMd5() {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.MD5, true);
   }

   public static Storage$SignUrlOption withExtHeaders(Map extHeaders) {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.EXT_HEADERS, extHeaders);
   }

   public static Storage$SignUrlOption withV2Signature() {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.SIGNATURE_VERSION, Storage$SignUrlOption$SignatureVersion.V2);
   }

   public static Storage$SignUrlOption withV4Signature() {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.SIGNATURE_VERSION, Storage$SignUrlOption$SignatureVersion.V4);
   }

   public static Storage$SignUrlOption signWith(ServiceAccountSigner signer) {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.SERVICE_ACCOUNT_CRED, signer);
   }

   public static Storage$SignUrlOption withHostName(String hostName) {
      return new Storage$SignUrlOption(Storage$SignUrlOption$Option.HOST_NAME, hostName);
   }
}
