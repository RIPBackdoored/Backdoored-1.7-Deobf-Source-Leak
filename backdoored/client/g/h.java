package l.c.g;

import java.io.IOException;
import javax.annotation.Nullable;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.ITextComponent;

public class h extends GuiGameOver {
   public static final boolean dv;
   public static final int du;
   public static final boolean di;

   public h(@Nullable ITextComponent var1) {
      super(var1);
   }

   public void func_73866_w_() {
      super.initGui();
      GuiButton var1 = new GuiButton(420, this.width / 2 - 100, this.height / 4 + 120, "Hide Death Screen");
      this.buttonList.add(var1);
      var1.enabled = true;
   }

   protected void func_146284_a(GuiButton var1) throws IOException {
      if (var1.id == 420) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.player.isDead = false;
         this.mc.player.setHealth(1.0F);
      }

      super.actionPerformed(var1);
   }

   public void func_73876_c() {
      if (this.mc.player != null && !this.mc.player.isDead && this.mc.player.getHealth() > 0.0F) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      }

      super.updateScreen();
   }
}
