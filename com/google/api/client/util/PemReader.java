package com.google.api.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Beta
public final class PemReader {
   private static final Pattern BEGIN_PATTERN = Pattern.compile("-----BEGIN ([A-Z ]+)-----");
   private static final Pattern END_PATTERN = Pattern.compile("-----END ([A-Z ]+)-----");
   private BufferedReader reader;

   public PemReader(Reader reader) {
      this.reader = new BufferedReader(reader);
   }

   public PemReader$Section readNextSection() throws IOException {
      return this.readNextSection((String)null);
   }

   public PemReader$Section readNextSection(String titleToLookFor) throws IOException {
      String title = null;
      StringBuilder keyBuilder = null;

      while(true) {
         String endTitle;
         do {
            Matcher m;
            do {
               while(true) {
                  String line = this.reader.readLine();
                  if (line == null) {
                     Preconditions.checkArgument(title == null, "missing end tag (%s)", title);
                     return null;
                  }

                  if (keyBuilder == null) {
                     m = BEGIN_PATTERN.matcher(line);
                     break;
                  }

                  m = END_PATTERN.matcher(line);
                  if (m.matches()) {
                     endTitle = m.group(1);
                     Preconditions.checkArgument(endTitle.equals(title), "end tag (%s) doesn't match begin tag (%s)", endTitle, title);
                     return new PemReader$Section(title, Base64.decodeBase64(keyBuilder.toString()));
                  }

                  keyBuilder.append(line);
               }
            } while(!m.matches());

            endTitle = m.group(1);
         } while(titleToLookFor != null && !endTitle.equals(titleToLookFor));

         keyBuilder = new StringBuilder();
         title = endTitle;
      }
   }

   public static PemReader$Section readFirstSectionAndClose(Reader reader) throws IOException {
      return readFirstSectionAndClose(reader, (String)null);
   }

   public static PemReader$Section readFirstSectionAndClose(Reader reader, String titleToLookFor) throws IOException {
      PemReader pemReader = new PemReader(reader);

      PemReader$Section var3;
      try {
         var3 = pemReader.readNextSection(titleToLookFor);
      } finally {
         pemReader.close();
      }

      return var3;
   }

   public void close() throws IOException {
      this.reader.close();
   }
}
