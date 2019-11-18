package l.c.i.j.c;

import l.c.i.d.a;
import l.c.x.b;
import net.minecraft.client.Minecraft;

public class v extends a {
   public static final int foh;
   public static final boolean foa;

   public v() {
      super("Fps");
   }

   public void k(int var1, int var2, float var3) {
      super.k(var1, var2, var3);
      if (this.ey()) {
         String var4 = Minecraft.getDebugFPS() + " fps";
         b.k(var4, this.a().fqs, this.a().fqm);
         this.g().fqs = mc.fontRenderer.getStringWidth(var4);
         this.g().fqm = mc.fontRenderer.FONT_HEIGHT;
      }
   }
}
