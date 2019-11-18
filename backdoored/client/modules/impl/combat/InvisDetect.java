package l.c.h.j.combat;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.u;
import l.c.x.d.a;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "InvisDetect",
   description = "Can help locate people in entity god mode",
   category = c.COMBAT
)
public class InvisDetect extends w {
   public static final int zt;
   public static final boolean ze;

   @SubscribeEvent
   public void k(PlaySoundAtEntityEvent var1) {
      if (var1.getEntity() != null) {
         if (var1.getSound().equals(SoundEvents.ENTITY_PIG_STEP) || var1.getSound().equals(SoundEvents.ENTITY_HORSE_STEP) || var1.getSound().equals(SoundEvents.ENTITY_HORSE_STEP_WOOD) || var1.getSound().equals(SoundEvents.ENTITY_LLAMA_STEP)) {
            Vec3d var2 = var1.getEntity().getPositionVector();
            a.fs("Invis PlayerPreviewElement at: " + u.k(var2));
         }

      }
   }
}
