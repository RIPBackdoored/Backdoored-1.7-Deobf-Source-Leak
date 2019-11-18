package l.c.v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l.c.x.d.a;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class m extends d {
   private static int qfh = 0;
   private static final int qfa = 0;
   private static final int qfg = 1;
   private static final int qfw = 2;
   private static final int qfn = 3;
   private static Map qfr = new HashMap();
   private static ArrayList qqk = new ArrayList();
   private String qqf;
   private ArrayList qqq;
   private int qqt;
   private int qqe;
   public static final boolean qqv;
   public static final int qqu;
   public static final boolean qqi;
   private static int qfh = 0;
   private static final int qfa = 0;
   private static final int qfg = 1;
   private static final int qfw = 2;
   private static final int qfn = 3;
   private static Map qfr = new HashMap();
   private static ArrayList qqk = new ArrayList();
   private String qqf;
   private ArrayList qqq;
   private int qqt;
   private int qqe;
   public static final boolean qqv;
   public static final int qqu;
   public static final boolean qqi;

   public m() {
      this.qqq = new ArrayList();
      this.qqt = 0;
      this.qqe = 6;
   }

   public String v() {
      return "-builder/br <mode> [arg]";
   }

   public boolean k(String[] var1) {
      if (var1.length == 1) {
         if (var1[0].equalsIgnoreCase("stop")) {
            if (this.qqq.size() > 0) {
               qfr.put(this.qqf, this.qqq);
            }

            this.qqq.clear();
            qfh = 0;
            return true;
         }

         if (var1[0].equalsIgnoreCase("list")) {
            StringBuilder var2 = new StringBuilder("Available configs: ");
            Iterator var3 = qfr.keySet().iterator();
            if (var3.hasNext()) {
               String var4 = (String)var3.next();
               var2.append(var4);
               var2.append(" ");
            }

            a.m(var2.toString(), "red");
            return true;
         }

         if (qfr.containsKey(var1[0])) {
            qqk = (ArrayList)qfr.get(var1[0]);
            qfh = 2;
            return true;
         }
      }

      if (var1.length == 2) {
         if (var1[0].equalsIgnoreCase("record")) {
            this.qqf = var1[1];
            this.qqq.clear();
            qfh = 1;
            return true;
         }

         if (var1[0].equalsIgnoreCase("loop")) {
            if (qfr.containsKey(var1[1])) {
               qqk = (ArrayList)qfr.get(var1[1]);
               qfh = 3;
               return true;
            }

            a.m("Config not found! Use 'br list' to see all configs", "red");
            return false;
         }
      }

      return false;
   }

   @SubscribeEvent
   public void f(ClientTickEvent var1) {
      if (qfh == 0) {
         this.qqt = 0;
      } else {
         if (qfh == 1) {
            this.vm();
         }

         if (qfh == 2) {
            this.vj();
         }

         if (qfh == 3) {
            this.vc();
         }

      }
   }

   private void vm() {
      Iterator var1 = this.qqq.iterator();
      if (var1.hasNext()) {
         Vec3d var2 = (Vec3d)var1.next();
         BlockPos var3 = new BlockPos(this.mc.player.getPositionVector().add(var2).x, this.mc.player.getPositionVector().add(var2).y, this.mc.player.getPositionVector().add(var2).z);
         AxisAlignedBB var4 = l.c.x.f.g.v(var3);
         l.c.x.f.g.q(var4);
      }

      l.c.x.f.g.ec();
   }

   @SubscribeEvent
   public void f(RightClickBlock var1) {
      if (qfh == 1) {
         BlockPos var2 = this.mc.objectMouseOver.getBlockPos().offset(this.mc.objectMouseOver.sideHit);
         this.qqq.add(new Vec3d((double)var2.getX() - this.mc.player.getPositionVector().x, (double)var2.getY() - this.mc.player.getPositionVector().y, (double)var2.getZ() - this.mc.player.getPositionVector().z));
      }
   }

   public m() {
      this.qqq = new ArrayList();
      this.qqt = 0;
      this.qqe = 6;
   }

   public String v() {
      return "-builder/br <mode> [arg]";
   }

   public boolean k(String[] var1) {
      if (var1.length == 1) {
         if (var1[0].equalsIgnoreCase("stop")) {
            if (this.qqq.size() > 0) {
               qfr.put(this.qqf, this.qqq);
            }

            this.qqq.clear();
            qfh = 0;
            return true;
         }

         if (var1[0].equalsIgnoreCase("list")) {
            StringBuilder var2 = new StringBuilder("Available configs: ");
            Iterator var3 = qfr.keySet().iterator();
            if (var3.hasNext()) {
               String var4 = (String)var3.next();
               var2.append(var4);
               var2.append(" ");
            }

            a.m(var2.toString(), "red");
            return true;
         }

         if (qfr.containsKey(var1[0])) {
            qqk = (ArrayList)qfr.get(var1[0]);
            qfh = 2;
            return true;
         }
      }

      if (var1.length == 2) {
         if (var1[0].equalsIgnoreCase("record")) {
            this.qqf = var1[1];
            this.qqq.clear();
            qfh = 1;
            return true;
         }

         if (var1[0].equalsIgnoreCase("loop")) {
            if (qfr.containsKey(var1[1])) {
               qqk = (ArrayList)qfr.get(var1[1]);
               qfh = 3;
               return true;
            }

            a.m("Config not found! Use 'br list' to see all configs", "red");
            return false;
         }
      }

      return false;
   }

   @SubscribeEvent
   public void f(ClientTickEvent var1) {
      if (qfh == 0) {
         this.qqt = 0;
      } else {
         if (qfh == 1) {
            this.vm();
         }

         if (qfh == 2) {
            this.vj();
         }

         if (qfh == 3) {
            this.vc();
         }

      }
   }

   private void vm() {
      Iterator var1 = this.qqq.iterator();
      if (var1.hasNext()) {
         Vec3d var2 = (Vec3d)var1.next();
         BlockPos var3 = new BlockPos(this.mc.player.getPositionVector().add(var2).x, this.mc.player.getPositionVector().add(var2).y, this.mc.player.getPositionVector().add(var2).z);
         AxisAlignedBB var4 = l.c.x.f.g.v(var3);
         l.c.x.f.g.q(var4);
      }

      l.c.x.f.g.ec();
   }

   @SubscribeEvent
   public void f(RightClickBlock var1) {
      if (qfh == 1) {
         BlockPos var2 = this.mc.objectMouseOver.getBlockPos().offset(this.mc.objectMouseOver.sideHit);
         this.qqq.add(new Vec3d((double)var2.getX() - this.mc.player.getPositionVector().x, (double)var2.getY() - this.mc.player.getPositionVector().y, (double)var2.getZ() - this.mc.player.getPositionVector().z));
      }
   }

   private void vj() {
      if (this.qqt % this.qqe != 0) {
         ++this.qqt;
      } else {
         int var1 = this.mc.player.inventory.currentItem;
         int var2 = l.c.x.k.ee();
         if (var2 == -1) {
            qfh = 0;
            a.m("Blocks were not found in your hotbar!", "red");
         } else {
            this.mc.player.inventory.currentItem = var2;
            Iterator var3 = this.vo().iterator();
            if (var3.hasNext()) {
               BlockPos var4 = (BlockPos)var3.next();
               if (this.mc.world.getBlockState(var4).getMaterial().isReplaceable()) {
                  l.c.x.k.t(var4);
                  a.fs("place");
                  ++this.qqt;
                  return;
               }
            }

            this.mc.player.inventory.currentItem = var1;
            qfh = 0;
         }
      }
   }

   private void vc() {
      if (this.qqt % this.qqe != 0) {
         ++this.qqt;
      } else {
         int var1 = this.mc.player.inventory.currentItem;
         int var2 = l.c.x.k.ee();
         if (var2 == -1) {
            qfh = 0;
            a.m("Blocks were not found in your hotbar!", "red");
         } else {
            this.mc.player.inventory.currentItem = var2;
            Iterator var3 = this.vo().iterator();
            if (var3.hasNext()) {
               BlockPos var4 = (BlockPos)var3.next();
               if (this.mc.world.getBlockState(var4).getMaterial().isReplaceable()) {
                  l.c.x.k.t(var4);
                  a.fs("place");
                  ++this.qqt;
                  return;
               }
            }

            this.mc.player.inventory.currentItem = var1;
         }
      }
   }

   private ArrayList vo() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = qqk.iterator();
      if (var2.hasNext()) {
         Vec3d var3 = (Vec3d)var2.next();
         var1.add(new BlockPos(this.mc.player.getPositionVector().add(var3)));
      }

      return var1;
   }
}
