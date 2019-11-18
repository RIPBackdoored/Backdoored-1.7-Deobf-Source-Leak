package l.c.v;

import l.c.x.d.a;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;

public class y extends d {
   public static final boolean foi;
   public static final int fod;
   public static final boolean fos;

   public y() {
      super("fakemsg", "msg", "impersonate");
   }

   public boolean k(String[] var1) {
      if (var1.length < 3) {
         return false;
      } else {
         String var2 = var1[0];
         byte var3 = -1;
         switch(var2.hashCode()) {
         case 3052376:
            if (!var2.equals("chat")) {
               break;
            }

            var3 = 0;
         case 1316693890:
            if (!var2.equals("whisper")) {
               break;
            }

            var3 = 2;
         case -905826493:
            if (!var2.equals("server")) {
               break;
            }

            var3 = 3;
         case -1861625298:
            if (!var2.equals("suicide")) {
               break;
            }

            var3 = 4;
         case 3291998:
            if (!var2.equals("kill")) {
               break;
            }

            var3 = 5;
         case -1458148582:
            if (var2.equals("killWeapon")) {
               var3 = 6;
            }
         }

         StringBuilder var4;
         String var7;
         String var8;
         String var9;
         byte var17;
         int var18;
         switch(var3) {
         case 0:
         case 1:
         default:
            var4 = new StringBuilder();
            var4.append("<").append(var1[1]).append("> ");
            byte var15 = 2;
            if (var15 < var1.length) {
               var4.append(var1[var15]).append(" ");
               int var16 = var15 + 1;
            }

            a.f(var4.toString(), false);
            return true;
         case 2:
            String var5 = var1[1];
            StringBuilder var6 = new StringBuilder();
            var17 = 2;
            if (var17 < var1.length) {
               var6.append(var1[var17]).append(" ");
               var18 = var17 + 1;
            }

            this.mc.ingameGUI.addChatMessage(ChatType.CHAT, new TextComponentString("\u00a7d" + var5 + " whispers: " + var6.toString()));
            return true;
         case 3:
            var4 = new StringBuilder("\u00a7e[SERVER] ");
            var17 = 1;
            if (var17 < var1.length) {
               var4.append(var1[var17]).append(" ");
               var18 = var17 + 1;
            }

            a.f(var4.toString(), false);
            return true;
         case 4:
            var7 = var1[1];
            var4 = new StringBuilder("\u00a74");
            byte var19 = 2;
            if (var19 < var1.length) {
               var4.append(var1[var19]).append(" ");
               int var21 = var19 + 1;
            }

            var8 = var4.toString();
            var8 = var8.replace(" player ", " \u00a73" + var7 + " \u00a74");
            a.f(var8, false);
            return true;
         case 5:
            var7 = var1[1];
            var9 = var1[2];
            var4 = new StringBuilder("\u00a74");
            byte var20 = 3;
            if (var20 < var1.length) {
               var4.append(var1[var20]).append(" ");
               int var22 = var20 + 1;
            }

            var8 = var4.toString();
            var8 = var8.replace(" player1 ", " \u00a73" + var7 + " \u00a74");
            var8 = var8.replace(" player2 ", " \u00a73" + var9 + " \u00a74");
            a.f(var8, false);
            return true;
         case 6:
            var7 = var1[1];
            var9 = var1[2];
            String var10 = var1[3];
            var4 = new StringBuilder("\u00a74");
            byte var11 = 4;
            if (var11 < var1.length) {
               var4.append(var1[var11]).append(" ");
               int var23 = var11 + 1;
            }

            var8 = var4.toString();
            var8 = var8.replace(" player1 ", " \u00a73" + var7 + " \u00a74");
            var8 = var8.replace(" player2 ", " \u00a73" + var9 + " \u00a74");
            var8 = var8.replace(" weapon ", " \u00a76" + var10 + " \u00a74");
            a.f(var8, false);
            return true;
         }
      }
   }

   public String v() {
      return "-fakemsg chat 4yl im kinda ez ngl\n-fakemsg whisper John200410 Backdoored client on top\n-fakemsg server buy prio pls";
   }
}
