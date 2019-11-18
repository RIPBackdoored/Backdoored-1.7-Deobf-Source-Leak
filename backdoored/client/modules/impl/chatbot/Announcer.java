package l.c.h.j.chatbot;

import java.time.Instant;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.dg;
import l.c.u.dk;
import l.c.u.du$c;
import l.c.u.y;
import l.c.x.g;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Announcer",
   description = "Don't use this unless your a penis",
   category = c.CHATBOT
)
@w$d(
   name = "Announcer",
   description = "Don't use this unless your a penis",
   category = c.CHATBOT
)
public class Announcer extends w {
   private j ffo = new f("Movement", this, true);
   private Instant ffp = Instant.now();
   private Vec3d vec3d = null;
   private j ffb = new f("Block Place", this, true);
   private Instant ffy = Instant.now();
   private Block block = null;
   private int ffl = 0;
   private j ffh = new f("Block Break", this, true);
   private Instant ffa = Instant.now();
   private Block block = null;
   private int ffw;
   private j ffn;
   private Instant ffr;
   private j fqk;
   private j fqf;
   private l.c.h.j.y.f fqq;
   public static final boolean fqt;
   public static final int fqe;
   public static final boolean fqv;
   private j ffo = new f("Movement", this, true);
   private Instant ffp = Instant.now();
   private Vec3d vec3d = null;
   private j ffb = new f("Block Place", this, true);
   private Instant ffy = Instant.now();
   private Block block = null;
   private int ffl = 0;
   private j ffh = new f("Block Break", this, true);
   private Instant ffa = Instant.now();
   private Block block = null;
   private int ffw;
   private j ffn;
   private Instant ffr;
   private j fqk;
   private j fqf;
   private l.c.h.j.y.f fqq;
   public static final boolean fqt;
   public static final int fqe;
   public static final boolean fqv;

   public Announcer() {
      this.block = null;
      this.ffw = 0;
      this.ffn = new f("Attack Entities", this, true);
      this.ffr = Instant.now();
      this.fqf = new f("Screenshot", this, true);
   }

   public void i() {
      // $FF: Couldn't be decompiled
   }

   @SubscribeEvent
   public void k(du$c var1) {
      if (this.qm() && g.k(this.ffp, Instant.now(), 60L) && (Boolean)this.ffo.ti()) {
         if (this.vec3d == null) {
            this.vec3d = mc.player.getPositionVector();
            return;
         }

         int var2 = (int)Math.round(this.vec3d.distanceTo(mc.player.getPositionVector()));
         if (var2 > 0) {
            this.fq(this.fqq.v(var2));
            this.ffp = Instant.now();
         }
      }

   }

   @SubscribeEvent
   public void k(l.c.u.s.c param1) {
      // $FF: Couldn't be decompiled
   }

   public Announcer() {
      this.block = null;
      this.ffw = 0;
      this.ffn = new f("Attack Entities", this, true);
      this.ffr = Instant.now();
      this.fqf = new f("Screenshot", this, true);
   }

   public void i() {
      // $FF: Couldn't be decompiled
   }

   @SubscribeEvent
   public void k(du$c var1) {
      if (this.qm() && g.k(this.ffp, Instant.now(), 60L) && (Boolean)this.ffo.ti()) {
         if (this.vec3d == null) {
            this.vec3d = mc.player.getPositionVector();
            return;
         }

         int var2 = (int)Math.round(this.vec3d.distanceTo(mc.player.getPositionVector()));
         if (var2 > 0) {
            this.fq(this.fqq.v(var2));
            this.ffp = Instant.now();
         }
      }

   }

   @SubscribeEvent
   public void k(l.c.u.s.c param1) {
      // $FF: Couldn't be decompiled
   }

   @SubscribeEvent
   public void k(BreakEvent var1) {
      if (this.qm() && var1.getPlayer().equals(mc.player)) {
         Block var2 = var1.getState().getBlock();
         if (this.block == null) {
            this.block = var2;
         }

         if (this.block.equals(var2)) {
            ++this.ffw;
         }

         if (g.k(this.ffa, Instant.now(), 60L) && this.ffw > 0) {
            this.fq(this.fqq.f(this.ffw, var2.getLocalizedName()));
            this.ffa = Instant.now();
            this.block = null;
         }
      }

   }

   @SubscribeEvent
   public void k(AttackEntityEvent var1) {
      if (this.qm() && var1.getTarget() instanceof EntityLivingBase && g.k(this.ffr, Instant.now(), 60L)) {
         this.ffr = Instant.now();
      }

   }

   @SubscribeEvent
   public void q(GuiOpenEvent var1) {
      if (this.qm() && (Boolean)this.fqk.ti() && var1.getGui() != null && var1.getGui() instanceof GuiInventory) {
         this.fq(this.fqq.k((GuiInventory)var1.getGui()));
      }

   }

   @SubscribeEvent
   public void k(ScreenshotEvent var1) {
      if (this.qm() && (Boolean)this.fqf.ti()) {
         this.fq(this.fqq.tk());
      }

   }

   @SubscribeEvent
   public void k(y var1) {
      if (this.qm()) {
         this.fq(this.fqq.tf());
      }

   }

   @SubscribeEvent
   public void k(l.c.u.f var1) {
      if (this.qm()) {
         this.fq(this.fqq.tq());
      }

   }

   @SubscribeEvent
   public void k(dg var1) {
      if (this.qm()) {
      }

   }

   @SubscribeEvent
   public void k(dk var1) {
      if (this.qm()) {
         this.fq(this.fqq.te());
      }

   }

   private void fq(String var1) {
      if (var1 != null) {
         var1 = this.fqq.fk(var1);
         if (var1 != null) {
            if (this.qm()) {
               mc.player.sendChatMessage(var1 + " thanks to Backdoored Client");
            }

         }
      }
   }
}
