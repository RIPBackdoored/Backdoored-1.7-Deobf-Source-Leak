package l.c.h.j.misc;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.f.z$i;
import net.minecraft.util.math.BlockPos;

@w$d(
   name = "Highway Bot",
   description = "Automate highway building",
   category = c.MISC
)
public class HighwayBot extends w {
   public static final int fgl;
   public static final boolean fgh;

   public void d() {
      BlockPos var1 = new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ);
      z$i var2 = eg();
      if (var2 == z$i.qks) {
         BlockPos[] var10000 = new BlockPos[]{var1.add(1, 0, -1), var1.add(1, 0, 0), var1.add(1, 0, 1), var1.add(1, 1, -1), var1.add(1, 1, 0), var1.add(1, 1, 1), var1.add(1, 2, -1), var1.add(1, 2, 0), var1.add(1, 2, 1)};
         var10000 = new BlockPos[]{var1.add(1, -1, -1), var1.add(1, -1, 0), var1.add(1, -1, 1), var1.add(1, 0, -2), var1.add(1, 0, 2)};
      }

   }

   public static z$i eg() {
      // $FF: Couldn't be decompiled
   }
}
