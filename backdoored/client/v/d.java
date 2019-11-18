package l.c.v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l.c.x.d.a;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public abstract class d implements g {
   public static ArrayList fg = new ArrayList();
   protected List fw;
   public Minecraft mc;
   public static final boolean fr;
   public static final int qk;
   public static final boolean qf;

   private d() {
      this.mc = Minecraft.getMinecraft();
   }

   d(String var1) {
      this(var1);
   }

   d(String... var1) {
      this(Arrays.asList(var1));
   }

   d(List var1) {
      this.mc = Minecraft.getMinecraft();
      this.fw = var1;
      fg.add(this);
      MinecraftForge.EVENT_BUS.register(this);
   }

   public abstract boolean k(String[] var1);

   public void k(String[] var1, String var2) {
      a.m("Usage: " + this.v(), "yellow");
   }

   public boolean k(String[] var1, String[] var2, String var3) {
      if (var1[0].equals("")) {
         this.k(var2, var3);
         return false;
      } else {
         byte var4 = 0;
         if (var4 <= var2.length) {
            if (var2[var4].equals(var1[0])) {
               return true;
            }

            if (!var2[var4].equals(var1[0]) && var4 == var2.length - 1) {
               this.k(var2, var3);
               return false;
            }

            int var8 = var4 + 1;
         }

         return true;
      }
   }

   public abstract String v();
}
