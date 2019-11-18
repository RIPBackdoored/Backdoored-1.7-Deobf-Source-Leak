package l.c.h.j.x;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.shader.Framebuffer;

class m implements Runnable {
   private static final SimpleDateFormat jk = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
   private int jf;
   private int jq;
   private int[] jt;
   private Framebuffer framebuffer;
   private File jv;
   public static final boolean ju;
   public static final int ji;
   public static final boolean jd;
   private static final SimpleDateFormat jk = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
   private int jf;
   private int jq;
   private int[] jt;
   private Framebuffer framebuffer;
   private File jv;
   public static final boolean ju;
   public static final int ji;
   public static final boolean jd;

   m(int var1, int var2, int[] var3, Framebuffer var4, File var5) {
      this.jf = var1;
      this.jq = var2;
      this.jt = var3;
      this.framebuffer = var4;
      this.jv = var5;
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   m(int var1, int var2, int[] var3, Framebuffer var4, File var5) {
      this.jf = var1;
      this.jq = var2;
      this.jt = var3;
      this.framebuffer = var4;
      this.jv = var5;
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   private static void k(int[] var0, int var1, int var2) {
      int[] var3 = new int[var1];
      int var4 = var2 / 2;
      byte var5 = 0;
      if (var5 < var4) {
         System.arraycopy(var0, var5 * var1, var3, 0, var1);
         System.arraycopy(var0, (var2 - 1 - var5) * var1, var0, var5 * var1, var1);
         System.arraycopy(var3, 0, var0, (var2 - 1 - var5) * var1, var1);
         int var9 = var5 + 1;
      }

   }

   private static File q(File var0) {
      String var1 = jk.format(new Date());
      byte var2 = 1;
      File var10000 = new File;
      StringBuilder var10003 = (new StringBuilder()).append(var1);
      if (var2 == 1) {
         String var10004 = "";
      }

      var10000.<init>(var0, var10003.append("_" + var2).append(".png").toString());
      File var3 = var10000;
      if (!var3.exists()) {
         return var3;
      } else {
         int var7 = var2 + 1;
      }
   }
}
