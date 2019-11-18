package l.c.i.j.c;

import java.awt.Color;
import l.c.i.d.a;
import l.c.i.j.j;
import l.c.x.h.c;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class g extends a {
   private static final Color fhw = new Color(64, 64, 64, 127);
   public static final int fhn;
   public static final boolean fhr;

   public g() {
      super("Totem Counter");
   }

   public void k(int var1, int var2, float var3) {
      this.g().fqs = 18;
      this.g().fqm = 18;
      super.k(var1, var2, var3);
      if (this.ey()) {
         if (!(mc.currentScreen instanceof j)) {
            l.c.x.f.j.q(this.a().fqs, this.a().fqm, this.a().fqs + this.g().fqs, this.a().fqm + this.g().fqm, fhw.getRGB());
         }

         ItemStack var4 = new ItemStack(Items.TOTEM_OF_UNDYING);
         var4.setCount(c.f(Items.TOTEM_OF_UNDYING, true));
         l.c.x.f.j.k(this.a().fqs, this.a().fqm, var4);
      }
   }
}
