package l.c;

import  l. c. a;
import  l. c. h. j. w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import l.c.c.j;
import l.c.h.j.g.i;
import l.c.h.j.g.s;
import l.c.h.j.g.x;
import l.c.h.j.j.r;
import l.c.h.j.j.u;
import l.c.h.j.j.z;
import l.c.h.j.v.f;
import l.c.h.j.x.d;
import l.c.h.j.x.o;
import l.c.h.j.x.v;
import l.c.h.j.y.m;
import l.c.i.h;
import l.c.u.dp;
import l.c.u.w$a;
import l.c.u.w$c;
import l.c.v.b;
import l.c.v.e;
import l.c.v.k;
import l.c.v.n;
import l.c.v.p;
import l.c.v.y;
import l.c.x.j.c;
import l.c.x.x.g;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.world.border.WorldBorder;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.Display;

@Mod(
   modid = "backdoored",
   version = "1.7",
   clientSideOnly = true
)
@Mod(
   modid = "backdoored",
   version = "1.7",
   clientSideOnly = true
)
public class a {
   public static final String qfs = "backdoored";
   public static final String qfm = "1.7";
   public static String qfj = "";
   private static Boolean qfc = null;
   public static h qfo;
   static String qfp = "";
   public static final int qfz;
   public static final boolean qfb;
   public static final String qfs = "backdoored";
   public static final String qfm = "1.7";
   public static String qfj = "";
   private static Boolean qfc = null;
   public static h qfo;
   static String qfp = "";
   public static final int qfz;
   public static final boolean qfb;

   public a() {
   }

   public static boolean vt() {
      if (qfc != null) {
         return qfc;
      } else {
         boolean var10000;
         try {
            BufferedReader var0 = new BufferedReader(new FileReader("Backdoored/options.txt"));

            String var1;
            while((var1 = var0.readLine()) != null) {
               if (var1.equals("dev.enable.debugger")) {
                  var10000 = true;
                  return var10000;
               }
            }

            var10000 = false;
         } catch (Exception var5) {
            return false;
         }

         return var10000;
      }
   }

   @EventHandler
   public void k(FMLPreInitializationEvent var1) {
      FMLLog.log.info("\n$$$$$$$\\                      $$\\             $$\\                                               $$\\ \n$$  __$$\\                     $$ |            $$ |                                              $$ |\n$$ |  $$ | $$$$$$\\   $$$$$$$\\ $$ |  $$\\  $$$$$$$ | $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$$ |\n$$$$$$$\\ | \\____$$\\ $$  _____|$$ | $$  |$$  __$$ |$$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$ |\n$$  __$$\\  $$$$$$$ |$$ /      $$$$$$  / $$ /  $$ |$$ /  $$ |$$ /  $$ |$$ |  \\__|$$$$$$$$ |$$ /  $$ |\n$$ |  $$ |$$  __$$ |$$ |      $$  _$$<  $$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |      $$   ____|$$ |  $$ |\n$$$$$$$  |\\$$$$$$$ |\\$$$$$$$\\ $$ | \\$$\\ \\$$$$$$$ |\\$$$$$$  |\\$$$$$$  |$$ |      \\$$$$$$$\\ \\$$$$$$$ |\n\\_______/  \\_______| \\_______|\\__|  \\__| \\_______| \\______/  \\______/ \\__|       \\_______| \\_______|\n");
      FMLLog.log.info("Loading backdoored...");
      l.fl();
      File var2 = new File("Backdoored");
      if (!var2.exists()) {
         var2.mkdir();
      }

      if (!w.vp()) {
         throw new c("Couldnt load license, invalid drm");
      }
   }

   @EventHandler
   public void k(FMLInitializationEvent var1) {
      g.vb();
      MinecraftForge.EVENT_BUS.register(new l.c.k.h());
      MinecraftForge.EVENT_BUS.register(this);
      this.vu();
      this.vd();
      this.vi();
      this.vv();
      qfo = new h();
      System.out.println("Reading config");
      l.c.k.t.fa();
      Runtime.getRuntime().addShutdownHook(new Thread( a::vs));
      new l.c.x.x.c();
      ve();
   }

   public static void ve() {
      Display.setTitle("Backdoored 1.7");
   }

   private void vv() {
      j.k();
      MinecraftForge.EVENT_BUS.register(new l.c.c.h.j());
      MinecraftForge.EVENT_BUS.register(new l.c.c.h.g());
   }

   private void vu() {
      MinecraftForge.EVENT_BUS.post(new w$c());
      Class[] var1 = new Class[]{m.class, x.class, l.c.h.j.j.w.class, l.c.h.j.f.h.class, v.class, l.c.h.j.v.m.class, l.c.h.j.c.v.class, l.c.h.j.j.g.class, l.c.h.j.j.x.class, l.c.h.j.j.m.class, r.class, l.c.h.j.f.v.class, s.class, z.class, l.c.h.j.j.v.class, i.class, l.c.h.j.x.g.class, d.class, o.class, l.c.h.j.s.s.class, l.c.h.j.j.q.class, l.c.h.j.f.s.class, l.c.h.j.y.s.class, l.c.h.j.x.a.class, l.c.h.j.g.g.class, l.c.h.j.x.h.class, l.c.h.j.v.g.class, l.c.h.j.g.o.class, l.c.h.j.a.h.class, l.c.h.j.c.r.class, l.c.h.j.x.z.class, l.c.h.j.s.o.class, l.c.h.j.x.q.class, l.c.h.j.c.o.class, l.c.h.j.c.x.class, l.c.h.j.g.h.class, l.c.h.j.g.c.class, l.c.h.j.g.m.class, l.c.h.j.v.z.class, l.c.h.j.f.m.class, l.c.h.j.f.g.class, l.c.h.j.s.d.class, l.c.h.j.c.a.class, u.class, l.c.h.j.c.m.class, l.c.h.j.v.r.class, l.c.h.j.j.i.class, f.class, l.c.h.j.j.d.class, l.c.h.j.x.x.class, l.c.h.j.j.h.class, l.c.h.j.g.a.class, l.c.h.j.a.m.class, l.c.h.j.s.f.class, l.c.h.j.j.f.class, l.c.h.j.c.q.class, l.c.h.j.x.s.class, l.c.h.j.x.i.class, l.c.h.j.c.w.class, l.c.h.j.v.w.class, l.c.h.j.x.r.class, l.c.h.j.g.q.class, l.c.h.j.v.o.class, l.c.h.j.v.s.class, l.c.h.j.v.h.class, l.c.h.j.c.z.class, l.c.h.j.x.w.class, l.c.h.j.a.v.class, l.c.h.j.c.i.class, l.c.h.j.s.m.class, l.c.h.j.g.r.class, l.c.h.j.c.s.class, l.c.h.j.v.d.class, l.c.h.j.f.f.class, l.c.h.j.g.v.class, l.c.h.j.g.u.class, l.c.h.j.c.f.class, l.c.h.j.c.d.class, l.c.h.j.a.z.class, l.c.h.j.x.f.class, l.c.h.j.c.c.class, l.c.h.j.g.f.class, l.c.h.j.s.z.class, l.c.h.j.j.c.class, l.c.h.j.j.s.class, l.c.h.j.a.f.i.class, l.c.h.j.a.g.class, l.c.h.j.c.u.class, l.c.h.j.f.d.class, l.c.h.j.j.o.class, WorldBorder.class, l.c.h.j.a.o.i.class, l.c.h.j.a.r.class};
      Set var2 = (new l.c.n.j.a()).k(var1).to().tp();
      FMLLog.log.info("Backdoored tried to load " + var1.length + " hacks, out of which " + var2.size() + " failed");
      FMLLog.log.info("Failed hack: " + var2.toString());
      MinecraftForge.EVENT_BUS.post(new w$a(l.c.h.j.i.qg()));
      FMLLog.log.info("Backdoored startup finished ");
   }

   private void vi() {
      Class[] var1 = new Class[]{y.class, e.class, l.c.v.h.class, l.c.v.q.class, l.c.v.w.class, n.class, l.c.v.f.class, l.c.v.l.class, l.c.v.r.class, l.c.v.s.class, b.class, l.c.v.t.class, l.c.v.u.class, p.class, k.class, l.c.v.m.class, l.c.v.j.class};
      Set var2 = (new l.c.n.j.a()).k(var1).to().tp();
      FMLLog.log.info("Backdoored tried to load " + var1.length + " commands, out of which " + var2.size() + " failed");
      FMLLog.log.info("Failed commands: " + var2.toString());
      l.c.v.x var3 = new l.c.v.x();
      MinecraftForge.EVENT_BUS.register(var3);
   }

   private void vd() {
      MinecraftForge.EVENT_BUS.register(new l.c.h.h.g());
   }

   @SubscribeEvent
   public void t(ClientChatReceivedEvent var1) {
   }

   @SubscribeEvent
   public void t(GuiOpenEvent var1) {
      if (var1.getGui() instanceof GuiMainMenu) {
      }
   }

   public a() {
   }

   public static boolean vt() {
      if (qfc != null) {
         return qfc;
      } else {
         boolean var10000;
         try {
            BufferedReader var0 = new BufferedReader(new FileReader("Backdoored/options.txt"));

            String var1;
            while((var1 = var0.readLine()) != null) {
               if (var1.equals("dev.enable.debugger")) {
                  var10000 = true;
                  return var10000;
               }
            }

            var10000 = false;
         } catch (Exception var5) {
            return false;
         }

         return var10000;
      }
   }

   @EventHandler
   public void k(FMLPreInitializationEvent var1) {
      FMLLog.log.info("\n$$$$$$$\\                      $$\\             $$\\                                               $$\\ \n$$  __$$\\                     $$ |            $$ |                                              $$ |\n$$ |  $$ | $$$$$$\\   $$$$$$$\\ $$ |  $$\\  $$$$$$$ | $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$$ |\n$$$$$$$\\ | \\____$$\\ $$  _____|$$ | $$  |$$  __$$ |$$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$ |\n$$  __$$\\  $$$$$$$ |$$ /      $$$$$$  / $$ /  $$ |$$ /  $$ |$$ /  $$ |$$ |  \\__|$$$$$$$$ |$$ /  $$ |\n$$ |  $$ |$$  __$$ |$$ |      $$  _$$<  $$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |      $$   ____|$$ |  $$ |\n$$$$$$$  |\\$$$$$$$ |\\$$$$$$$\\ $$ | \\$$\\ \\$$$$$$$ |\\$$$$$$  |\\$$$$$$  |$$ |      \\$$$$$$$\\ \\$$$$$$$ |\n\\_______/  \\_______| \\_______|\\__|  \\__| \\_______| \\______/  \\______/ \\__|       \\_______| \\_______|\n");
      FMLLog.log.info("Loading backdoored...");
      l.fl();
      File var2 = new File("Backdoored");
      if (!var2.exists()) {
         var2.mkdir();
      }

      if (!w.vp()) {
         throw new c("Couldnt load license, invalid drm");
      }
   }

   @EventHandler
   public void k(FMLInitializationEvent var1) {
      g.vb();
      MinecraftForge.EVENT_BUS.register(new l.c.k.h());
      MinecraftForge.EVENT_BUS.register(this);
      this.vu();
      this.vd();
      this.vi();
      this.vv();
      qfo = new h();
      System.out.println("Reading config");
      l.c.k.t.fa();
      Runtime.getRuntime().addShutdownHook(new Thread( a::vs));
      new l.c.x.x.c();
      ve();
   }

   public static void ve() {
      Display.setTitle("Backdoored 1.7");
   }

   private void vv() {
      j.k();
      MinecraftForge.EVENT_BUS.register(new l.c.c.h.j());
      MinecraftForge.EVENT_BUS.register(new l.c.c.h.g());
   }

   private void vu() {
      MinecraftForge.EVENT_BUS.post(new w$c());
      Class[] var1 = new Class[]{m.class, x.class, l.c.h.j.j.w.class, l.c.h.j.f.h.class, v.class, l.c.h.j.v.m.class, l.c.h.j.c.v.class, l.c.h.j.j.g.class, l.c.h.j.j.x.class, l.c.h.j.j.m.class, r.class, l.c.h.j.f.v.class, s.class, z.class, l.c.h.j.j.v.class, i.class, l.c.h.j.x.g.class, d.class, o.class, l.c.h.j.s.s.class, l.c.h.j.j.q.class, l.c.h.j.f.s.class, l.c.h.j.y.s.class, l.c.h.j.x.a.class, l.c.h.j.g.g.class, l.c.h.j.x.h.class, l.c.h.j.v.g.class, l.c.h.j.g.o.class, l.c.h.j.a.h.class, l.c.h.j.c.r.class, l.c.h.j.x.z.class, l.c.h.j.s.o.class, l.c.h.j.x.q.class, l.c.h.j.c.o.class, l.c.h.j.c.x.class, l.c.h.j.g.h.class, l.c.h.j.g.c.class, l.c.h.j.g.m.class, l.c.h.j.v.z.class, l.c.h.j.f.m.class, l.c.h.j.f.g.class, l.c.h.j.s.d.class, l.c.h.j.c.a.class, u.class, l.c.h.j.c.m.class, l.c.h.j.v.r.class, l.c.h.j.j.i.class, f.class, l.c.h.j.j.d.class, l.c.h.j.x.x.class, l.c.h.j.j.h.class, l.c.h.j.g.a.class, l.c.h.j.a.m.class, l.c.h.j.s.f.class, l.c.h.j.j.f.class, l.c.h.j.c.q.class, l.c.h.j.x.s.class, l.c.h.j.x.i.class, l.c.h.j.c.w.class, l.c.h.j.v.w.class, l.c.h.j.x.r.class, l.c.h.j.g.q.class, l.c.h.j.v.o.class, l.c.h.j.v.s.class, l.c.h.j.v.h.class, l.c.h.j.c.z.class, l.c.h.j.x.w.class, l.c.h.j.a.v.class, l.c.h.j.c.i.class, l.c.h.j.s.m.class, l.c.h.j.g.r.class, l.c.h.j.c.s.class, l.c.h.j.v.d.class, l.c.h.j.f.f.class, l.c.h.j.g.v.class, l.c.h.j.g.u.class, l.c.h.j.c.f.class, l.c.h.j.c.d.class, l.c.h.j.a.z.class, l.c.h.j.x.f.class, l.c.h.j.c.c.class, l.c.h.j.g.f.class, l.c.h.j.s.z.class, l.c.h.j.j.c.class, l.c.h.j.j.s.class, l.c.h.j.a.f.i.class, l.c.h.j.a.g.class, l.c.h.j.c.u.class, l.c.h.j.f.d.class, l.c.h.j.j.o.class, WorldBorder.class, l.c.h.j.a.o.i.class, l.c.h.j.a.r.class};
      Set var2 = (new l.c.n.j.a()).k(var1).to().tp();
      FMLLog.log.info("Backdoored tried to load " + var1.length + " hacks, out of which " + var2.size() + " failed");
      FMLLog.log.info("Failed hack: " + var2.toString());
      MinecraftForge.EVENT_BUS.post(new w$a(l.c.h.j.i.qg()));
      FMLLog.log.info("Backdoored startup finished ");
   }

   private void vi() {
      Class[] var1 = new Class[]{y.class, e.class, l.c.v.h.class, l.c.v.q.class, l.c.v.w.class, n.class, l.c.v.f.class, l.c.v.l.class, l.c.v.r.class, l.c.v.s.class, b.class, l.c.v.t.class, l.c.v.u.class, p.class, k.class, l.c.v.m.class, l.c.v.j.class};
      Set var2 = (new l.c.n.j.a()).k(var1).to().tp();
      FMLLog.log.info("Backdoored tried to load " + var1.length + " commands, out of which " + var2.size() + " failed");
      FMLLog.log.info("Failed commands: " + var2.toString());
      l.c.v.x var3 = new l.c.v.x();
      MinecraftForge.EVENT_BUS.register(var3);
   }

   private void vd() {
      MinecraftForge.EVENT_BUS.register(new l.c.h.h.g());
   }

   @SubscribeEvent
   public void t(ClientChatReceivedEvent var1) {
   }

   @SubscribeEvent
   public void t(GuiOpenEvent var1) {
      if (var1.getGui() instanceof GuiMainMenu) {
      }
   }

   @SubscribeEvent
   public void q(l.c.u.s.g var1) {
      if (var1.packet instanceof SPacketTimeUpdate) {
         MinecraftForge.EVENT_BUS.post(new dp());
      }

   }

   // $FF: synthetic method
   private static void vs() {
      System.out.println("System shutdown, saving configs");
      l.c.h.j.i.qg().forEach( w::qj);
      g.vz();
      l.c.k.t.fg();
   }
}
