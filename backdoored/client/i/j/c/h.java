package l.c.i.j.c;

import java.awt.Color;
import l.c.i.d.a;
import l.c.i.j.j;
import l.c.x.h.c;
import l.c.x.h.c$d;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class h extends a {
   private static final Color fmj = new Color(64, 64, 64, 127);
   public static final int fmc;
   public static final boolean fmo;

   public h() {
      super("Obby Counter");
   }

   public void k(int var1, int var2, float var3) {
      this.g().fqs = 18;
      this.g().fqm = 18;
      super.k(var1, var2, var3);
      if (this.ey()) {
         if (!(mc.currentScreen instanceof j)) {
            l.c.x.f.j.q(this.a().fqs, this.a().fqm, this.a().fqs + this.g().fqs, this.a().fqm + this.g().fqm, fmj.getRGB());
         }

         ItemStack var4 = new ItemStack(Blocks.OBSIDIAN);
         var4.setCount(c.k(var4.getItem(), true, c$d.eq));
         l.c.x.f.j.k(this.a().fqs, this.a().fqm, var4);
      }
   }
}
