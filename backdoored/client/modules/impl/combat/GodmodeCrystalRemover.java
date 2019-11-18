package l.c.h.j.combat;

import java.util.Iterator;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Godmode Crystal Remover",
   description = "fixes crystals not removing when in god mode",
   category = c.COMBAT
)
public class GodmodeCrystalRemover extends w {
   public static final boolean fan;
   public static final int far;
   public static final boolean fgk;

   @SubscribeEvent
   public void t(g var1) {
      if (this.qm() && var1.packet instanceof SPacketSoundEffect) {
         SPacketSoundEffect var2 = (SPacketSoundEffect)var1.packet;
         if (var2.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE) {
            Iterator var3 = mc.world.loadedEntityList.iterator();
            if (var3.hasNext()) {
               Entity var4 = (Entity)var3.next();
               if (var4 instanceof EntityEnderCrystal) {
                  double var5 = var4.getDistance(var2.getX(), var2.getY(), var2.getZ());
                  if (var5 <= 6.0D) {
                     var4.setDead();
                  }
               }
            }
         }
      }

   }
}
