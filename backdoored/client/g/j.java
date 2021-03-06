package l.c.g;

import  l. c. g. j;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketUpdateSign;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.input.Keyboard;

public class j extends GuiScreen {
   public final TileEntitySign tileEntitySign;
   private static int p = 0;
   private List z;
   private String[] b;
   public static final boolean y;
   public static final int x;
   public static final boolean l;

   public j(TileEntitySign var1) {
      this.tileEntitySign = var1;
   }

   public void func_73866_w_() {
      this.buttonList.clear();
      Keyboard.enableRepeatEvents(true);
      this.z = new LinkedList();
      this.b = new String[4];
      byte var1 = 0;
      if (var1 < 4) {
         GuiTextField var2 = new GuiTextField(var1, this.fontRenderer, this.width / 2 + 4, 75 + var1 * 24, 120, 20);
         var2.setValidator(this::k);
         var2.setMaxStringLength(100);
         String var3 = this.tileEntitySign.signText[var1].getUnformattedText();
         this.b[var1] = var3;
         var2.setText(var3);
         this.z.add(var2);
         int var7 = var1 + 1;
      }

      ((GuiTextField)this.z.get(p)).setFocused(true);
      this.addButton(new GuiButton(4, this.width / 2 + 5, this.height / 4 + 120, 120, 20, "Done"));
      this.addButton(new GuiButton(5, this.width / 2 - 125, this.height / 4 + 120, 120, 20, "Cancel"));
      this.addButton(new GuiButton(6, this.width / 2 - 41, 147, 40, 20, "Shift"));
      this.addButton(new GuiButton(7, this.width / 2 - 41, 123, 40, 20, "Clear"));
      this.tileEntitySign.setEditable(false);
   }

   protected void func_73864_a(int param1, int param2, int param3) throws IOException {
      // $FF: Couldn't be decompiled
   }

   protected void func_73869_a(char var1, int var2) {
      switch(var2) {
      case 1:
         this.e();
      case 15:
         if (isShiftKeyDown()) {
            boolean var10000 = true;
         }

         byte var3 = 1;
         this.k(var3);
      case 200:
         this.k(-1);
      case 28:
      case 156:
      case 208:
         this.k(1);
      default:
         this.z.forEach( j::k);
         this.tileEntitySign.signText[p] = new TextComponentString(((GuiTextField)this.z.get(p)).getText());
      }
   }

   protected void func_146284_a(GuiButton var1) throws IOException {
      super.actionPerformed(var1);
      switch(var1.id) {
      case 5:
         byte var2 = 0;
         if (var2 < 4) {
            this.tileEntitySign.signText[var2] = new TextComponentString(this.b[var2]);
            int var9 = var2 + 1;
         }
      case 4:
         this.e();
      case 6:
         String[] var10 = new String[4];
         byte var3 = 0;
         if (var3 < 4) {
            if (isShiftKeyDown()) {
               boolean var10000 = true;
            }

            byte var4 = -1;
            int var5 = this.f(var3 + var4);
            var10[var3] = this.tileEntitySign.signText[var5].getUnformattedText();
            int var11 = var3 + 1;
         }

         this.z.forEach(this::k);
      case 7:
         this.z.forEach(this::f);
      default:
      }
   }

   public void func_73863_a(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRenderer, I18n.format("sign.edit", new Object[0]), this.width / 2, 40, 16777215);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.translate((float)(this.width / 2) - 63.0F, 0.0F, 50.0F);
      float var4 = 93.75F;
      GlStateManager.scale(-93.75F, -93.75F, -93.75F);
      GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
      Block var5 = this.tileEntitySign.getBlockType();
      if (var5 == Blocks.STANDING_SIGN) {
         float var6 = (float)(this.tileEntitySign.getBlockMetadata() * 360) / 16.0F;
         GlStateManager.rotate(var6, 0.0F, 1.0F, 0.0F);
         GlStateManager.translate(0.0F, -1.0625F, 0.0F);
      }

      int var11 = this.tileEntitySign.getBlockMetadata();
      float var7 = 0.0F;
      if (var11 == 2) {
         var7 = 180.0F;
      }

      if (var11 == 4) {
         var7 = 90.0F;
      }

      if (var11 == 5) {
         var7 = -90.0F;
      }

      GlStateManager.rotate(var7, 0.0F, 1.0F, 0.0F);
      GlStateManager.translate(0.0F, -0.7625F, 0.0F);
      this.tileEntitySign.lineBeingEdited = -1;
      TileEntityRendererDispatcher.instance.render(this.tileEntitySign, -0.5D, -0.75D, -0.5D, 0.0F);
      GlStateManager.popMatrix();
      this.z.forEach(GuiTextField::func_146194_f);
      super.drawScreen(var1, var2, var3);
   }

   void t() {
      this.z.forEach( j::k);
   }

   void e() {
      this.tileEntitySign.markDirty();
      this.mc.displayGuiScreen((GuiScreen)null);
   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
      NetHandlerPlayClient var1 = this.mc.getConnection();
      if (var1 != null) {
         var1.sendPacket(new CPacketUpdateSign(this.tileEntitySign.getPos(), this.tileEntitySign.signText));
      }

      this.tileEntitySign.setEditable(true);
   }

   void k(int var1) {
      ((GuiTextField)this.z.get(p)).setFocused(false);
      p = this.f(p + var1);
      ((GuiTextField)this.z.get(p)).setFocused(true);
   }

   int f(int var1) {
      if (var1 > 3) {
         return 0;
      } else {
         return var1 < 0 ? 3 : var1;
      }
   }

   boolean k(String var1) {
      if (this.fontRenderer.getStringWidth(var1) > 90) {
         return false;
      } else {
         char[] var2 = var1.toCharArray();
         int var4 = var2.length;
         byte var5 = 0;
         if (var5 < var4) {
            char var6 = var2[var5];
            if (!ChatAllowedCharacters.isAllowedCharacter(var6)) {
               return false;
            }

            int var10 = var5 + 1;
         }

         return true;
      }
   }

   // $FF: synthetic method
   private static void k(GuiTextField var0) {
      p = var0.getId();
   }

   // $FF: synthetic method
   private void f(GuiTextField var1) {
      int var2 = var1.getId();
      var1.setText("");
      this.tileEntitySign.signText[var2] = new TextComponentString("");
   }

   // $FF: synthetic method
   private void k(String[] var1, GuiTextField var2) {
      int var3 = var2.getId();
      var2.setText(var1[var3]);
      this.tileEntitySign.signText[var3] = new TextComponentString(var1[var3]);
   }

   // $FF: synthetic method
   private static void k(char var0, int var1, GuiTextField var2) {
      var2.textboxKeyTyped(var0, var1);
   }

   // $FF: synthetic method
   private static void k(int var0, int var1, int var2, GuiTextField var3) {
      var3.mouseClicked(var0, var1, var2);
   }
}
