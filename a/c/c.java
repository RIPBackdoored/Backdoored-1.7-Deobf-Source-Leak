package a.c;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Random;

public class c {
   public final String fib;
   private final long fiy;
   private Random fix;
   private static final String[] fil = new String[]{"MD2", "MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"};

   public c(long v) {
      v.fiy = v;
      v.fix = new Random(v.fiy);
      v.fib = v.qz();
   }

   public c(long v, String v) {
      v.fiy = v;
      v.fix = new Random(v.fiy);
      v.fib = v;
   }

   private String qz() {
      return g.k(g.ev());
   }

   public String ek() {
      try {
         String v = Long.toString(v.fiy) + v.fib;
         int v = v.fix.nextInt(20);

         int v;
         for(v = 1; v <= v; ++v) {
            v = v.k(v.getBytes(), v.ef());
            if (v.fix.nextBoolean()) {
               byte[] v = new byte[7];
               v.fix.nextBytes(v);
               v = v + new String(v, Charset.forName("UTF-8"));
            }
         }

         v = v.fix.nextInt(3);

         for(v = 1; v <= v; ++v) {
            if (v.fix.nextBoolean()) {
               v = v + v.k(v.getBytes(), v.ef());
            } else {
               v = v.k(v.getBytes(), v.ef()) + v;
            }
         }

         v = v.k((v + v + v).getBytes(), v.ef());
         String var10000 = v;
         return var10000;
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }

   private String k(byte[] v, String v2) {
      String var10000;
      try {
         MessageDigest v = MessageDigest.getInstance("SHA-256");
         v.update(v);
         var10000 = g.k(v.digest());
      } catch (Exception var4) {
         var4.printStackTrace();
         return "";
      }

      return var10000;
   }

   private String ef() {
      int v = v.fix.nextInt(fil.length);
      return fil[v];
   }
}
