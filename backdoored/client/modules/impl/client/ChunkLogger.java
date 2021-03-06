package l.c.h.j.client;

import  l. c. h. j. x. c;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import l.c.x.p;
import l.c.x.d.a;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Chunk Logger",
   description = "Save chunks with chests in them to a text file",
   category = c.CLIENT
)
public class ChunkLogger extends w {
   private final j fgf = new i("Min Chests", this, 10, 1, 50);
   private final j fgq;
   private final j fgt = new f("Notifications", this, true);
   public static final boolean fge;
   public static final int fgv;
   public static final boolean fgu;

   @SubscribeEvent
   public void f(g var1) {
      if (this.qm() && var1.packet instanceof SPacketChunkData) {
         SPacketChunkData var2 = (SPacketChunkData)var1.packet;
         long var3 = var2.getTileEntityTags().stream().map( c::k).filter( c::fd).count();
         if (var3 >= (long)(Integer)this.fgf.ti()) {
            this.k(var2, var3);
         }
      }

   }

   private void k(SPacketChunkData var1, long var2) {
      int var4 = var1.getChunkX() * 16;
      int var5 = var1.getChunkZ() * 16;
      String var6 = "(" + var4 + ", " + var5 + "):" + var2 + " chests";
      a.fs(var6);
      if ((Boolean)this.fgt.ti()) {
         p.k("Visual Range", var6);
      }

      (new Thread(this::fi, "Backdoored Chunk Logger File Saving Thread")).start();
   }

   // $FF: synthetic method
   private void fi(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   private static void k(Exception var0) {
   }

   // $FF: synthetic method
   private static boolean fd(String var0) {
      return var0.equals("minecraft:chest");
   }

   // $FF: synthetic method
   private static String k(NBTTagCompound var0) {
      return var0.getString("id");
   }
}
