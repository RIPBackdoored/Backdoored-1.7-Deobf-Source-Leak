package l.c.h.j.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.o;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.f.d$c;
import l.c.x.b$a;
import l.c.x.u;
import l.c.x.d.a;
import net.minecraft.entity.player.EntityPlayer;

@w$d(
   name = "Visual Range",
   description = "Get notified when someone enters your render distance",
   category = c.MISC
)
public class VisualRange extends w {
   private List md = new ArrayList();
   private j ms;
   private j mm;
   public static final boolean mj;
   public static final int mc;
   public static final boolean mo;

   public VisualRange() {
      this.mm = new o("Mode", this, d$c.flq);
   }

   public void d() {
      if (this.qm()) {
         ArrayList var1 = new ArrayList(mc.world.playerEntities);
         var1.removeAll(this.md);
         Iterator var2 = var1.iterator();
         if (var2.hasNext()) {
            EntityPlayer var3 = (EntityPlayer)var2.next();
            if (mc.world.playerEntities.contains(var3)) {
               this.k("PlayerPreviewElement '" + var3.getDisplayNameString() + "' entered your render distance at " + u.k(var3.getPositionVector()), ((b$a)this.ms.ti()).toString());
               l.c.h.j.x.w.fuy.f(var3);
            }

            if (this.md.contains(var3)) {
               this.k("PlayerPreviewElement '" + var3.getDisplayNameString() + "' left your render distance at " + u.k(var3.getPositionVector()), ((b$a)this.ms.ti()).toString());
            }
         }

         this.md = mc.world.playerEntities;
      }
   }

   private void k(String var1, String var2) {
      if (this.mm.ti() == d$c.flq) {
         a.m(var1, var2);
      }

      mc.player.sendChatMessage(var1);
   }
}
