package l.c.h.j.player;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.d.a;
import l.c.x.d.c.v;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Chat Modifier",
   description = "Modify your chat messages",
   category = c.PLAYER
)
public class ChatModifier extends w {
   private v[] lb;
   private j ly = new f("Emphasize", this, false);
   private j lx = new f("Reverse", this, false);
   private j ll = new f("Chav", this, false);
   private j lh = new f("JustLearntEngrish", this, false);
   private j la = new f("L33t", this, false);
   private j lg = new f("Disabled", this, false);
   private j lw = new f("Fancy", this, false);
   private j ln = new f("Soviet", this, false);
   public static final boolean lr;
   public static final int hk;
   public static final boolean hf;

   @SubscribeEvent
   public void k(l.c.u.s.c var1) {
      if (var1.packet instanceof CPacketChatMessage) {
         System.out.println("Was packet");
         if (this.qm()) {
            CPacketChatMessage var2 = (CPacketChatMessage)var1.packet;
            String var3 = var2.getMessage();
            if (var3.startsWith("/") || var3.startsWith("!")) {
               boolean var10000 = true;
            }

            boolean var4 = false;
            v[] var5 = this.lb;
            int var6 = var5.length;
            byte var7 = 0;
            Object var20;
            if (var7 < var6) {
               v var8 = var5[var7];

               Object var9;
               try {
                  var9 = false;
                  String var10 = var8.m();
                  byte var11 = -1;
                  switch(var10.hashCode()) {
                  case 219200290:
                     if (!var10.equals("Emphasize")) {
                        break;
                     }

                     var11 = 0;
                  case -1530467646:
                     if (!var10.equals("Reverse")) {
                        break;
                     }

                     var11 = 1;
                  case 2099066:
                     if (!var10.equals("Chav")) {
                        break;
                     }

                     var11 = 2;
                  case -180296146:
                     if (!var10.equals("JustLearntEngrish")) {
                        break;
                     }

                     var11 = 3;
                  case 2314824:
                     if (!var10.equals("L33t")) {
                        break;
                     }

                     var11 = 4;
                  case 335584924:
                     if (!var10.equals("Disabled")) {
                        break;
                     }

                     var11 = 5;
                  case 67645097:
                     if (!var10.equals("Fancy")) {
                        break;
                     }

                     var11 = 6;
                  case -1812617442:
                     if (var10.equals("Soviet")) {
                        var11 = 7;
                     }
                  }

                  boolean var19;
                  switch(var11) {
                  case 0:
                     var19 = (Boolean)this.ly.ti();
                  case 1:
                     var19 = (Boolean)this.lx.ti();
                  case 2:
                     var19 = (Boolean)this.ll.ti();
                  case 3:
                     var19 = (Boolean)this.lh.ti();
                  case 4:
                     var19 = (Boolean)this.la.ti();
                  case 5:
                     var19 = (Boolean)this.lg.ti();
                  case 6:
                     var19 = (Boolean)this.lw.ti();
                  case 7:
                     var9 = (Boolean)this.ln.ti();
                  }

                  var20 = var9;
                  if (var9 != false) {
                     var20 = var3 = var8.f(var3);
                  }
               } catch (Exception var16) {
                  var20 = var16;
               }

               var9 = var20;
               ((Exception)var9).printStackTrace();
               int var18 = var7 + 1;
            }

            try {
               var20 = CPacketChatMessage.class;
               ObfuscationReflectionHelper.setPrivateValue(CPacketChatMessage.class, var2, var3, new String[]{"message", "field_149440_a"});
            } catch (Exception var15) {
               var20 = var15;
            }

            Object var17 = var20;
            a.fs("Disabled chat modifier due to error: " + ((Exception)var17).getMessage());
            this.f(false);
            ((Exception)var17).printStackTrace();
         }
      }

   }
}
