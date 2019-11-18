package l.c.i.j.c;

import java.awt.Color;
import l.c.i.d.a;
import l.c.i.j.j;
import l.c.x.h.c;
import l.c.x.h.c$d;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class r extends a {
   private static final Color fwz = new Color(64, 64, 64, 127);
   public static final int fwb;
   public static final boolean fwy;

   public r() {
      super("Crystal Counter");
   }

   public void k(int var1, int var2, float var3) {
      this.g().fqs = 18;
      this.g().fqm = 18;
      super.k(var1, var2, var3);
      if (this.ey()) {
         if (!(mc.currentScreen instanceof j)) {
            l.c.x.f.j.q(this.a().fqs, this.a().fqm, this.a().fqs + this.g().fqs, this.a().fqm + this.g().fqm, fwz.getRGB());
         }

         ItemStack var4 = new ItemStack(Items.END_CRYSTAL);
         var4.setCount(c.k(Items.END_CRYSTAL, true, c$d.eq));
         l.c.x.f.j.k(this.a().fqs, this.a().fqm, var4);
      }
   }
}
