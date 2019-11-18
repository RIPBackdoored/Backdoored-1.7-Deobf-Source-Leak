package l.c.v;

import l.c.x.d.a;

public class q extends d {
   public static final int frn;
   public static final boolean frr;

   public q() {
      super("prefix");
   }

   public boolean k(String[] var1) {
      if (var1.length > 0) {
         x.zd = var1[0];
         a.m("Set cmd prefix to " + x.zd, "red");
         return true;
      } else {
         return false;
      }
   }

   public String v() {
      return "Usage: .prefix <new prefix character>";
   }
}
