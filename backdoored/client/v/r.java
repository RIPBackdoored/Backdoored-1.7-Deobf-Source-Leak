package l.c.v;

import java.io.File;
import l.c.x.d.a;

public class r extends d {
   public static final int fra;
   public static final boolean frg;

   public r() {
      super("load");
   }

   public boolean k(String[] var1) {
      if (var1.length <= 0) {
         return false;
      } else {
         l.c.k.b.f(new File("Backdoored/config-" + var1[0].toLowerCase() + ".json"));
         a.m("Loaded " + var1[0].toLowerCase() + " config", "red");
         return true;
      }
   }

   public String v() {
      return "-load <config name>";
   }
}
