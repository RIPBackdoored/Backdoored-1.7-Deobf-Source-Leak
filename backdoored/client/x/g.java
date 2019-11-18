package l.c.x;

import java.time.Duration;
import java.time.Instant;

public class g {
   public static final boolean fkn;
   public static final boolean fkr;

   public static Instant tc() {
      return Instant.now();
   }

   public static long k(Instant var0, Instant var1) {
      return Duration.between(var0, var1).getSeconds();
   }

   public static boolean k(Instant var0, Instant var1, long var2) {
      if (k(var0, var1) >= var2) {
         boolean var10000 = true;
      }

      return false;
   }

   public static long f(Instant var0, Instant var1) {
      return Duration.between(var0, var1).toMillis();
   }

   public static boolean f(Instant var0, Instant var1, long var2) {
      if (f(var0, var1) >= var2) {
         boolean var10000 = true;
      }

      return false;
   }
}
