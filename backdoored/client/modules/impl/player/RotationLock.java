package l.c.h.j.player;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.o;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.g.v$c;

@w$d(
   name = "Rotation Lock",
   description = "Lock your rotation",
   category = c.PLAYER
)
@w$d(
   name = "Rotation Lock",
   description = "Lock your rotation",
   category = c.PLAYER
)
public class RotationLock extends w {
   private final j qti;
   public static final boolean qtd;
   public static final int qts;
   public static final boolean qtm;
   private final j qti;
   public static final boolean qtd;
   public static final int qts;
   public static final boolean qtm;

   public RotationLock() {
      this.qti = new o("Facing", this, v$c.lm);
   }

   public void i() {
      mc.player.setRotationYawHead((float)this.vx());
   }

   public void d() {
      if (this.qm()) {
      }
   }

   public RotationLock() {
      this.qti = new o("Facing", this, v$c.lm);
   }

   public void i() {
      mc.player.setRotationYawHead((float)this.vx());
   }

   public void d() {
      if (this.qm()) {
      }
   }

   private int vx() {
      // $FF: Couldn't be decompiled
   }
}
