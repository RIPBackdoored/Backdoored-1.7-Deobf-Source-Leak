package com.google.api.client.util;

public final class PemReader$Section {
   private final String title;
   private final byte[] base64decodedBytes;

   PemReader$Section(String title, byte[] base64decodedBytes) {
      this.title = (String)Preconditions.checkNotNull(title);
      this.base64decodedBytes = (byte[])Preconditions.checkNotNull(base64decodedBytes);
   }

   public String getTitle() {
      return this.title;
   }

   public byte[] getBase64DecodedBytes() {
      return this.base64decodedBytes;
   }
}
