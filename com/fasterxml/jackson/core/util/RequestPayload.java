package com.fasterxml.jackson.core.util;

import java.io.IOException;
import java.io.Serializable;

public class RequestPayload implements Serializable {
   private static final long serialVersionUID = 1L;
   protected byte[] _payloadAsBytes;
   protected CharSequence _payloadAsText;
   protected String _charset;

   public RequestPayload(byte[] bytes, String charset) {
      if (bytes == null) {
         throw new IllegalArgumentException();
      } else {
         this._payloadAsBytes = bytes;
         this._charset = charset != null && !charset.isEmpty() ? charset : "UTF-8";
      }
   }

   public RequestPayload(CharSequence str) {
      if (str == null) {
         throw new IllegalArgumentException();
      } else {
         this._payloadAsText = str;
      }
   }

   public Object getRawPayload() {
      return this._payloadAsBytes != null ? this._payloadAsBytes : this._payloadAsText;
   }

   public String toString() {
      if (this._payloadAsBytes != null) {
         String var10000;
         try {
            var10000 = new String(this._payloadAsBytes, this._charset);
         } catch (IOException var2) {
            throw new RuntimeException(var2);
         }

         return var10000;
      } else {
         return this._payloadAsText.toString();
      }
   }
}
