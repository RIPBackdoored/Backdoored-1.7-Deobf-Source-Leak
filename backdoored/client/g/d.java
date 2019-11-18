package l.c.g;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public class d extends GuiScreen {
   private GuiScreen guiScreen;
   private GuiTextField guiTextField;
   private GuiTextField guiTextField;
   private String qg = "";
   public static final boolean qw;
   public static final int qn;
   public static final boolean qr;

   public d(GuiScreen var1) {
      this.guiScreen = var1;
   }

   public void func_73866_w_() {
      // $FF: Couldn't be decompiled
   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
   }

   public void func_73876_c() {
      this.guiTextField.updateCursorCounter();
      this.guiTextField.updateCursorCounter();
   }

   public void func_73864_a(int var1, int var2, int var3) throws IOException {
      this.guiTextField.mouseClicked(var1, var2, var3);
      this.guiTextField.mouseClicked(var1, var2, var3);
      super.mouseClicked(var1, var2, var3);
   }

   public void func_146284_a(GuiButton param1) {
      // $FF: Couldn't be decompiled
   }

   protected void func_73869_a(char var1, int var2) {
      this.guiTextField.textboxKeyTyped(var1, var2);
      this.guiTextField.textboxKeyTyped(var1, var2);
      if (var1 == '\t') {
         if (this.guiTextField.isFocused()) {
            this.guiTextField.setFocused(false);
            this.guiTextField.setFocused(true);
         }

         if (this.guiTextField.isFocused()) {
            this.guiTextField.setFocused(false);
            this.guiTextField.setFocused(false);
         }
      }

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

   }

   public void func_73863_a(int param1, int param2, float param3) {
      // $FF: Couldn't be decompiled
   }
}
