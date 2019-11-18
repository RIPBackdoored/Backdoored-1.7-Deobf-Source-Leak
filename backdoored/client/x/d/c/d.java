package l.c.x.d.c;

import java.util.Map;

public class d extends v {
   private Map qe = new d$c(this);
   public static final boolean qv;
   public static final int qu;
   public static final boolean qi;

   public String m() {
      return "Chav";
   }

   public String f(String var1) {
      StringBuilder var2 = new StringBuilder();
      String[] var3 = var1.split(" ");
      int var5 = var3.length;
      byte var6 = 0;
      if (var6 < var5) {
         String var7 = var3[var6];
         var2.append((String)this.qe.getOrDefault(var7.toLowerCase(), var7)).append(" ");
         int var11 = var6 + 1;
      }

      return var2.toString();
   }
}
