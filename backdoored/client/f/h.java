package l.c.f;

import l.c.q;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class h {
   public static final FontRenderer fontRenderer;
   public static final Class qfv;
   public static final d qfu;
   public static final int qfi;
   public static final boolean qfd;

   static {
      fontRenderer = q.mc.fontRenderer;
      qfv = GlStateManager.class;
      qfu = new d(q.mc);
   }
}
