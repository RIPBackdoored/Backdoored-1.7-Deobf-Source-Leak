package l.c.x.x;

public class a {
   public int fqs;
   public int fqm;
   public static final boolean fqj;
   public static final int fqc;
   public static final boolean fqo;

   public a(int var1, int var2) {
      this.fqm = var2;
   }

   public boolean equals(Object var1) {
      if (var1 instanceof a) {
         a var2 = (a)var1;
         if (var2.fqs == this.fqs && var2.fqm == this.fqm) {
            boolean var10000 = true;
         }

         return false;
      } else {
         return super.equals(var1);
      }
   }

   public String toString() {
      return "(" + this.fqs + ", " + this.fqm + ")";
   }
}
