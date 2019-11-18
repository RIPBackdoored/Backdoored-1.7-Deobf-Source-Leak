package l.c.h.j.combat;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Anti Death Screen",
   description = "Prevents the death screen from incorrectly coming up during combat",
   category = c.COMBAT
)
public class AntiDeathScreen extends w {
   public static l.c.h.j.j.w fjm;
   public static final boolean fjj;
   public static final int fjc;
   public static final boolean fjo;

   public AntiDeathScreen() {
      fjm = this;
   }

   @SubscribeEvent
   public void k(GuiOpenEvent param1) {
      // $FF: Couldn't be decompiled
   }
}
