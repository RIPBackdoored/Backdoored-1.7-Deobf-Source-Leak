package l.c.n;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets$Builder;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

class d {
   private static String pe = "1_kxn8nNafDEUPpKNZ6ozlUaASlODC_Sf9hIniJvH33E";
   public static final boolean pv;
   public static final int pu;
   public static final boolean pi;

   private static Credential fe() throws IOException {
      InputStream var0 = d.class.getResourceAsStream("/resources/backdoored-client-340b78ae95c4.json");
      GoogleCredential var1 = GoogleCredential.fromStream(var0).createScoped(Collections.singleton("https://www.googleapis.com/auth/spreadsheets"));
      return var1;
   }

   private static Sheets fv() throws GeneralSecurityException, IOException {
      Sheets var0 = (new Sheets$Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), fe())).setApplicationName("Backdoored License Handler").build();
      return var0;
   }

   private static String s(String var0) throws IOException, GeneralSecurityException {
      ValueRange var1 = (ValueRange)fv().spreadsheets().values().get(pe, var0).execute();
      byte var2 = 0;
      if (var2 < var1.getValues().size()) {
         System.out.println(var1.getValues().get(var2));
         int var6 = var2 + 1;
      }

      if (var1.getValues() != null) {
         ((List)var1.getValues().get(0)).toString();
      }

      String var7 = "";
      return var7;
   }

   private static List m(String var0) throws IOException, GeneralSecurityException {
      ValueRange var1 = (ValueRange)fv().spreadsheets().values().get(pe, var0).execute();
      return var1.getValues();
   }

   public static boolean j(String var0) throws IOException, GeneralSecurityException {
      ValueRange var1 = (ValueRange)fv().spreadsheets().values().get(pe, "A2:A").execute();
      byte var2 = 0;
      if (((List)var1.getValues().get(var2)).toString().replace("[", "").replace("]", "").equals(var0)) {
         return true;
      } else {
         int var6 = var2 + 1;
         return false;
      }
   }
}
