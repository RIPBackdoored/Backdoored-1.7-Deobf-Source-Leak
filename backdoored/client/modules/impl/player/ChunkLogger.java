package l.c.h.j.player;

import  l. c. h. j. g. z;
import java.io.File;
import java.util.List;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.world.ChunkEvent.Load;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Chunk Logger",
   description = "Log chunks that contain a specified ammount of chest",
   category = c.PLAYER
)
@w$d(
   name = "Chunk Logger",
   description = "Log chunks that contain a specified ammount of chest",
   category = c.PLAYER
)
public class ChunkLogger extends w {
   private File zl = new File("Backdoored/ChunkLogs.txt");
   public static final boolean zh;
   public static final int za;
   public static final boolean zg;
   private File zl = new File("Backdoored/ChunkLogs.txt");
   public static final boolean zh;
   public static final int za;
   public static final boolean zg;

   public ChunkLogger() {
   }

   public void i() {
      this.f(false);
   }

   public void d() {
      List var1 = mc.world.loadedTileEntityList;
      var1.stream().filter( z::k);
   }

   @SubscribeEvent
   public void q(g var1) {
      if (var1.packet instanceof SPacketChunkData) {
      }
   }

   public ChunkLogger() {
   }

   public void i() {
      this.f(false);
   }

   public void d() {
      List var1 = mc.world.loadedTileEntityList;
      var1.stream().filter( z::k);
   }

   @SubscribeEvent
   public void q(g var1) {
      if (var1.packet instanceof SPacketChunkData) {
      }
   }

   @SubscribeEvent
   public void k(Load param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   private static boolean k(TileEntity var0) {
      if (mc.player.getDistance((double)var0.getPos().getX(), mc.player.posY, (double)var0.getPos().getZ()) < 500.0D) {
         boolean var10000 = true;
      }

      return false;
   }
}
