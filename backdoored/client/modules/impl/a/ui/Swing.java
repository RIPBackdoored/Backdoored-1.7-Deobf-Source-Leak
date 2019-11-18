package l.c.h.j.a.ui;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.a;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.fml.common.FMLLog;

@w$d(
   name = "Swing",
   description = "Popup console",
   category = c.UI
)
public class Swing extends w {
   public static j jy;
   private boolean jx = false;
   private l.c.h.j.a.f.c jl;
   public static final int jh;
   public static final boolean ja;

   public Swing() {
      jy = new f("Show Chat", this, true);
   }

   public void i() {
      if (this.jl == null || this.jx) {
         this.jl = new l.c.h.j.a.f.c();
      }

      this.jx = false;
      z();
   }

   public void j() {
      this.jl.y();
      this.jx = true;
      z();
   }

   public void d() {
      if (this.jl != null) {
         this.jl.b();
      }

   }

   private static String p() {
      String var0 = System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
      return Hashing.sha512().hashString(var0, StandardCharsets.UTF_8).toString();
   }

   private static String q(String var0) {
      String var1 = Hashing.sha1().hashString(var0, StandardCharsets.UTF_8).toString();
      String var2 = Hashing.sha512().hashString(var1 + var0 + var1, StandardCharsets.UTF_8).toString();
      return var2;
   }

   private static boolean t(String var0) {
      String var1 = p();
      String var2 = q(var1);
      return var2.equalsIgnoreCase(var0);
   }

   private static void z() {
      if (!t(a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}
