package l.c.g;

import java.awt.Color;
import java.io.IOException;
import l.c.q;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;

public class b extends GuiMainMenu {
   public static final boolean fqu;
   public static final int fqi;
   public static final boolean fqd;

   public void func_73866_w_() {
      super.initGui();
      this.buttonList.add(new GuiButton(62, 2, 2, 98, 20, "Login"));
   }

   protected void func_146284_a(GuiButton var1) throws IOException {
      System.out.println("Button pressed: " + var1.displayString);
      if (var1.displayString.equals("Login")) {
         q.mc.displayGuiScreen(new d(this));
      }

      super.actionPerformed(var1);
   }

   public void func_73863_a(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
      String var4 = "[ONLINE]";
      Color var5 = Color.GREEN;
      if (!l.c.n.h.fc()) {
         var4 = "[OFFLINE]";
         var5 = Color.RED;
      }

      String var6 = "[ONLINE]";
      Color var7 = Color.GREEN;
      if (!l.c.n.h.fo()) {
         var6 = "[OFFLINE]";
         var7 = Color.RED;
      }

      this.mc.fontRenderer.drawString("Auth Server:     " + var4, 2.0F, 25.0F, var5.getRGB(), true);
      this.mc.fontRenderer.drawString("Session Server: " + var6, 2.0F, (float)(25 + this.mc.fontRenderer.FONT_HEIGHT + 2), var7.getRGB(), true);
   }
}
