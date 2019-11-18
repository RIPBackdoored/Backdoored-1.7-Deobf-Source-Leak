package l.c.x.d.c;

import java.util.Map;

public class s extends v {
   private Map fxf = new s$c(this);
   public static final boolean fxq;
   public static final int fxt;
   public static final boolean fxe;

   public String m() {
      return "L33t";
   }

   public String f(String var1) {
      StringBuilder var2 = new StringBuilder();
      String[] var3 = var1.split("");
      int var4 = var3.length;
      byte var5 = 0;
      if (var5 < var4) {
         String var6 = var3[var5];
         var2.append((String)this.fxf.getOrDefault(var6.toLowerCase(), var6));
      }

      return var2.toString();
   }
}
