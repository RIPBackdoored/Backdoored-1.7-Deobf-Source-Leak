package l.c.h.j.player;

import  l. c. h. j. g. s;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.network.play.client.CPacketUpdateSign;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "AutoSign",
   description = "Automatically place signs with text",
   category = c.PLAYER
)
public class AutoSign extends w {
   private static final TextComponentString[] textComponentString = new TextComponentString[]{new TextComponentString(""), new TextComponentString(""), new TextComponentString(""), new TextComponentString("")};
   private String[] pg = new String[]{"Backdoored Client", "Is the best", "2b2t client", "discord/pdMhDwN"};
   private j pw = new f("Try Chunk Ban", this, false);
   public static final boolean pn;
   public static final int pr;
   public static final boolean zk;

   @SubscribeEvent
   public void f(GuiOpenEvent var1) {
      if (this.qm() && var1.getGui() instanceof GuiEditSign) {
         GuiEditSign var2 = (GuiEditSign)var1.getGui();
         TileEntitySign var3 = (TileEntitySign)ObfuscationReflectionHelper.getPrivateValue(GuiScreen.class, var2, new String[]{"tileSign", "field_146848_f"});
         if (var3 != null) {
            BlockPos var4 = var3.getPos();
            mc.player.connection.sendPacket(new CPacketUpdateSign(var4, textComponentString));
            var1.setCanceled(true);
         }
      }

   }

   @SubscribeEvent
   public void q(l.c.u.s.c var1) {
      if (this.qm() && var1.packet instanceof CPacketUpdateSign) {
         CPacketUpdateSign var2 = (CPacketUpdateSign)var1.packet;
         String[] var3 = var2.getLines();
         if ((Boolean)this.pw.ti()) {
            String var4 = fi();
            byte var5 = 0;
            if (var5 < 4) {
               var3[var5] = var4.substring(var5 * 384, (var5 + 1) * 384);
               int var9 = var5 + 1;
            }
         }

         var3 = this.pg;
         ObfuscationReflectionHelper.setPrivateValue(CPacketUpdateSign.class, var2, var3, new String[]{"lines", "field_149590_d"});
      }

   }

   private static String fi() {
      IntStream var0 = (new Random()).ints(128, 1112063).map( s::e);
      return (String)var0.limit(1536L).mapToObj( s::t).collect(Collectors.joining());
   }

   // $FF: synthetic method
   private static String t(int var0) {
      return String.valueOf((char)var0);
   }

   // $FF: synthetic method
   private static int e(int var0) {
      if (var0 < 55296) {
         ;
      }

      return var0 + 2048;
   }
}
