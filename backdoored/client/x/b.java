package l.c.x;

import java.awt.Color;
import java.util.Map;
import l.c.q;

public class b implements q {
   public static final Map ry = new b$c();
   public static final boolean rx;
   public static final int rl;
   public static final boolean rh;

   public static Color qa() {
      // $FF: Couldn't be decompiled
   }

   public static void k(String var0, int var1, int var2) {
   }

   public static void k(String var0, int var1, int var2, boolean var3) {
      float var4 = (float)(System.currentTimeMillis() % 11520L) / 11520.0F;
      char[] var6 = var0.toCharArray();
      int var7 = var6.length;
      byte var8 = 0;
      if (var8 < var7) {
         char var9 = var6[var8];
         float var10 = var4 + (float)var2 / (float)mc.displayHeight + (float)var1 / (float)mc.displayWidth;
         int var11 = Color.HSBtoRGB(var10, 1.0F, 1.0F);
         mc.fontRenderer.drawString(String.valueOf(var9), (float)var1, (float)var2, var11, var3);
         int var5 = var1 + mc.fontRenderer.getCharWidth(var9);
         int var15 = var8 + 1;
      }

   }

   public static String n(String var0) {
      return (String)ry.getOrDefault(var0.replace(" ", "_").trim().toLowerCase(), "\u00a7d");
   }
}
