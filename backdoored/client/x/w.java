package l.c.x;

import net.minecraft.util.Session;

public class w {
   public e rt = new e();
   public String re;
   public String rv;
   private Session session;
   public static final boolean ri;
   public static final int rd;
   public static final boolean rs;

   public w(String var1, String var2) {
      this.re = var1;
      this.rv = var2;
   }

   public boolean qb() {
      e var10000;
      Session var1;
      if (this.rv != null && !this.rv.equals("")) {
         var10000 = this.rt;
         var1 = e.d(this.re, this.rv);
         if (var1 != null) {
            this.session = var1;
            return true;
         }
      }

      var10000 = this.rt;
      var1 = e.ft(this.re);
      this.session = var1;
      return true;
   }

   public Session qy() {
      return this.session;
   }
}
