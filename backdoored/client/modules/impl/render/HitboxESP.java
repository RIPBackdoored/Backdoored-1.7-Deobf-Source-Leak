package l.c.h.j.render;

import java.util.Iterator;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.f.g;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

@w$d(
   name = "Hitbox ESP",
   description = "See outlines of players through walls",
   category = c.RENDER,
   defaultOn = true,
   defaultIsVisible = false
)
public class HitboxESP extends w {
   private j fln = new f("Show friends hitbox", this, true);
   private j flr = new f("Show others hitbox", this, false);
   public static final boolean fhk;
   public static final int fhf;
   public static final boolean fhq;

   public void n() {
      if (this.qm() && mc.world.playerEntities.size() > 0) {
         g.k(0.0F, 0.0F, 0.0F, 1.0F);
         this.ez();
         this.ep();
         g.ec();
      }
   }

   private void ep() {
      if ((Boolean)this.fln.ti()) {
         Iterator var1 = mc.world.playerEntities.iterator();
         if (var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (l.c.x.x.g.q(var2) && !var2.getUniqueID().equals(mc.player.getUniqueID())) {
               AxisAlignedBB var3 = var2.getEntityBoundingBox();
               g.q(var3);
            }
         }
      }

   }

   private void ez() {
      if ((Boolean)this.flr.ti()) {
         Iterator var1 = mc.world.playerEntities.iterator();
         if (var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (!l.c.x.x.g.q(var2) && !var2.getUniqueID().equals(mc.player.getUniqueID())) {
               AxisAlignedBB var3 = var2.getEntityBoundingBox();
               g.q(var3);
            }
         }
      }

   }
}
