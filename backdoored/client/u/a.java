package l.c.u;

import java.io.File;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class a extends dw {
   public File fuf;
   public String fuq;
   public int fut;
   public int fue;
   public Framebuffer framebuffer;
   public ITextComponent iTextComponent;
   public static final int fui;

   public a(File var1, String var2, int var3, int var4, Framebuffer var5) {
      this.fuf = var1;
      this.fuq = var2;
      this.fut = var3;
      this.fue = var4;
      this.framebuffer = var5;
      this.iTextComponent = new TextComponentString("Screenshot meant to be here?");
   }
}
