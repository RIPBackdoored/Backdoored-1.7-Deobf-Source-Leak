package l.c.h.j.combat;

import  l. c. h. j. j. d;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.j.d$c;
import l.c.x.k;
import net.minecraft.item.Item;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "HopperAura",
   description = "Break nearby hoppers",
   category = c.COMBAT
)
public class HopperAura extends w {
   private Set qj = new d$c(this);
   private int[] qc = new int[]{278, 285, 274, 270, 257};
   private j qo = new l.c.h.h.a.d.c("Distance", this, 5.0D, 1.0D, 10.0D);
   private j qp = new f("LockRotations", this, true);
   private j qz = new f("Break Own", this, false);
   public static final boolean qb;
   public static final int qy;
   public static final boolean qx;

   public void d() {
      if (this.qm()) {
         List var1 = (List)mc.world.loadedTileEntityList.stream().filter( d::k).collect(Collectors.toList());
         if (var1.size() > 0) {
            Iterator var2 = var1.iterator();
            if (var2.hasNext()) {
               TileEntity var3 = (TileEntity)var2.next();
               BlockPos var4 = var3.getPos();
               if (!(Boolean)this.qz.ti() && this.qj.contains(var4)) {
                  ;
               }

               if (mc.player.getDistance((double)var4.getX(), (double)var4.getY(), (double)var4.getZ()) <= (Double)this.qo.ti()) {
                  int[] var5 = this.qc;
                  int var6 = var5.length;
                  byte var7 = 0;
                  if (var7 < var6) {
                     int var8 = var5[var7];
                     int var9 = k.f(Item.getItemById(var8));
                     if (var9 != -1) {
                        mc.player.inventory.currentItem = var9;
                        if ((Boolean)this.qp.ti()) {
                           k.e(var4);
                        }

                        mc.player.connection.sendPacket(new CPacketPlayerDigging(Action.START_DESTROY_BLOCK, var3.getPos(), EnumFacing.UP));
                        mc.player.connection.sendPacket(new CPacketPlayerDigging(Action.STOP_DESTROY_BLOCK, var3.getPos(), EnumFacing.UP));
                        return;
                     }

                     int var13 = var7 + 1;
                  }
               }
            }
         }

      }
   }

   public void j() {
      this.qj.clear();
   }

   @SubscribeEvent
   public void k(RightClickBlock var1) {
      if (mc.player.inventory.getStackInSlot(mc.player.inventory.currentItem).getItem().equals(Item.getItemById(154))) {
         this.qj.add(mc.objectMouseOver.getBlockPos().offset(mc.objectMouseOver.sideHit));
      }

   }

   // $FF: synthetic method
   private static boolean k(TileEntity var0) {
      return var0 instanceof TileEntityHopper;
   }
}
