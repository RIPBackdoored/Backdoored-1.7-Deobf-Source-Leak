package l.c.v;

import java.util.Iterator;
import l.c.x.d.a;

public class h extends d {
   public static final boolean qd;
   public static final int qs;
   public static final boolean qm;

   public h() {
      super("help", "commands");
   }

   public boolean k(String[] var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = d.fg.iterator();
      if (var3.hasNext()) {
         d var4 = (d)var3.next();
         var2.append((String)var4.fw.get(0)).append(", ");
      }

      a.fs("Commands:\n" + var2.toString());
      return true;
   }

   public String v() {
      return "-help";
   }
}
