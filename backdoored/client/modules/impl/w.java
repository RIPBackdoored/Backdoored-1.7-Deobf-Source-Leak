package l.c.h.j;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import l.c.q;
import l.c.h.d.a;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.s;
import l.c.x.j.c;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class w {
   protected static final Minecraft mc;
   public final String gw = (String)Objects.requireNonNull(this.qs().name());
   public final a gn;
   public final String gr;
   public final j wk;
   public final j wf;
   private boolean wq;
   private boolean wt;
   public static final boolean we;
   public static final int wv;
   public static final boolean wu;

   public w() {
      this.gn = (a)Objects.requireNonNull(this.qs().category().eb);
      this.gr = this.qs().description();
      this.f(this.qs().defaultOn());
      this.wk = new f("Is Visible", this, this.qs().defaultIsVisible());
      this.wf = new s("Bind", this, this.qs().defaultBind());
      i.qg().add(this);
      i.rg.put(this.gw, this);
      this.gn.et().add(this);
      MinecraftForge.EVENT_BUS.register(this);
   }

   private w$d qs() {
      return (w$d)this.getClass().getAnnotation(w$d.class);
   }

   public void f(boolean var1) {
      this.wq = var1;
   }

   public static void k(String var0, boolean var1) {
      ((w)i.rg.get(var0)).wq = var1;
   }

   public boolean qm() {
      return this.wt;
   }

   public static boolean l(String var0) {
      return ((w)i.rg.get(var0)).wt;
   }

   protected void d() {
   }

   protected void w() {
   }

   protected void n() {
   }

   protected void i() {
   }

   protected void j() {
      z();
   }

   public void qj() {
      MinecraftForge.EVENT_BUS.unregister(this);
   }

   public boolean qc() {
      return this.wq;
   }

   @SubscribeEvent
   public void k(ClientTickEvent param1) {
      // $FF: Couldn't be decompiled
   }

   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public void k(Post param1) {
      // $FF: Couldn't be decompiled
   }

   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public void k(RenderWorldLastEvent param1) {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      return this.gw + ":" + this.wt;
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
      if (!t(l.c.a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + l.c.a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new c("Invalid License");
      }
   }

   static {
      mc = q.mc;
   }
}
