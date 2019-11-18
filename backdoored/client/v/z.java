package l.c.v;

import l.c.x.d.a;
import net.minecraft.world.border.WorldBorder;

public class z extends d {
   public static final int qkn;
   public static final boolean qkr;

   public boolean k(String[] var1) {
      WorldBorder var2 = this.mc.world.getWorldBorder();
      double var3 = var2.maxX();
      double var5 = var2.maxZ();
      double var7 = var2.minX();
      double var9 = var2.minZ();
      a.m("World border is at:\nMinX: " + var7 + "\nMinZ: " + var9 + "\nMaxX: " + var3 + "\nMaxZ: " + var5 + "\n", "green");
      return true;
   }

   public String v() {
      return "-worldborder";
   }
}
