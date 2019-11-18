package a.c;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class g {
   private static final char[] fok = "0123456789ABCDEF".toCharArray();

   public static byte[] ev() {
      byte[] var10000;
      try {
         MessageDigest v = MessageDigest.getInstance("MD5");
         String v = System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
         var10000 = v.digest(v.getBytes());
      } catch (NoSuchAlgorithmException var2) {
         throw new Error("Algorithm wasn't found.", var2);
      }

      return var10000;
   }

   public static byte[] fv(String v) {
      int v = v.length();
      byte[] v = new byte[v / 2];

      for(int v = 0; v < v; v += 2) {
         v[v / 2] = (byte)((Character.digit(v.charAt(v), 16) << 4) + Character.digit(v.charAt(v + 1), 16));
      }

      return v;
   }

   public static String k(byte[] v) {
      char[] v = new char[v.length * 2];

      for(int v = 0; v < v.length; ++v) {
         int v = v[v] & 255;
         v[v * 2] = fok[v >>> 4];
         v[v * 2 + 1] = fok[v & 15];
      }

      return new String(v);
   }
}
