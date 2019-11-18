package l.c.i.j.c;

import java.text.SimpleDateFormat;
import java.util.Date;
import l.c.i.d.a;
import l.c.x.b;

public class d extends a {
   public static final int r;
   public static final boolean fk;

   public d() {
      super("Time");
   }

   public void k(int var1, int var2, float var3) {
      super.k(var1, var2, var3);
      if (this.ey()) {
         String var4 = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
         b.k(var4, this.a().fqs, this.a().fqm);
         this.g().fqs = mc.fontRenderer.getStringWidth(var4);
         this.g().fqm = mc.fontRenderer.FONT_HEIGHT;
      }
   }
}
