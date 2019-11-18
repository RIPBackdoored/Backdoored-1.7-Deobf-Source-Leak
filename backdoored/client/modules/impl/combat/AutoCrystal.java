package l.c.h.j.combat;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.f.g;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.CombatRules;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;

@w$d(
   name = "Auto Crystal",
   description = "Auto Place Crystals, Modified Kami paste",
   category = c.COMBAT
)
public class AutoCrystal extends w {
   private j fak = new i("Place Per Tick", this, 1, 0, 6);
   private j faf = new f("Place", this, true);
   private j faq = new f("Break", this, true);
   private j fat = new f("Switch", this, true);
   private j fae = new f("No Gapple Switch", this, true);
   private j fav = new f("Dont cancel mining", this, true);
   private j fau = new l.c.h.h.a.d.c("Place Range", this, 4.0D, 0.0D, 10.0D);
   private j fai = new l.c.h.h.a.d.c("Break Range", this, 4.0D, 0.0D, 10.0D);
   private j fad = new l.c.h.h.a.d.c("Raytrace Place Range", this, 3.0D, 0.0D, 10.0D);
   private j fas = new l.c.h.h.a.d.c("Min Damage", this, 4.0D, 0.0D, 20.0D);
   private BlockPos blockPos;
   private Entity entity;
   private long fac = -1L;
   public static final boolean fao;
   public static final int fap;
   public static final boolean faz;

   public void d() {
      if (this.qm()) {
         if ((Boolean)this.faq.ti()) {
            this.el();
         }

         if ((Boolean)this.faf.ti()) {
            byte var1 = 0;
            if (var1 < (Integer)this.fak.ti()) {
               this.ex();
               int var5 = var1 + 1;
            }
         }

      }
   }

   private void ex() {
      this.blockPos = null;
      boolean var10000;
      if (!(Boolean)this.fae.ti() || mc.player.getActiveItemStack().getItem() != Items.GOLDEN_APPLE) {
         var10000 = true;
      }

      boolean var1 = false;
      if (!(Boolean)this.fav.ti() || mc.player.getActiveItemStack().getItem() != Items.DIAMOND_PICKAXE) {
         var10000 = true;
      }

      boolean var2 = false;
      if (var1) {
      }

   }

   private void el() {
      // $FF: Couldn't be decompiled
   }

   public void n() {
      g.k(255.0F, 255.0F, 255.0F, 1.0F);
      if (this.blockPos != null) {
         AxisAlignedBB var1 = g.v(this.blockPos);
         g.q(var1);
      }

      if (this.entity != null) {
         g.q(this.entity.getEntityBoundingBox());
      }

      g.ec();
   }

   public void w() {
   }

   public void j() {
      this.entity = null;
   }

   private List eh() {
      double var1 = (Double)this.fau.ti();
      NonNullList var3 = NonNullList.create();
      var3.addAll((Collection)k(new BlockPos(Math.floor(mc.player.posX), Math.floor(mc.player.posY), Math.floor(mc.player.posZ)), (float)var1, (int)Math.round((Double)this.fau.ti()), false, true, 0).stream().filter(this::u).collect(Collectors.toList()));
      return var3;
   }

   public static List k(BlockPos param0, float param1, int param2, boolean param3, boolean param4, int param5) {
      // $FF: Couldn't be decompiled
   }

   private boolean u(BlockPos var1) {
      BlockPos var2 = var1.add(0, 1, 0);
      BlockPos var3 = var1.add(0, 2, 0);
      return (mc.world.getBlockState(var1).getBlock() == Blocks.BEDROCK || mc.world.getBlockState(var1).getBlock() == Blocks.OBSIDIAN) && mc.world.getBlockState(var2).getBlock() == Blocks.AIR && mc.world.getBlockState(var3).getBlock() == Blocks.AIR && mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(var2)).isEmpty();
   }

   private static float k(double var0, double var2, double var4, Entity var6) {
      float var7 = 12.0F;
      double var8 = var6.getDistance(var0, var2, var4) / 12.0D;
      Vec3d var10 = new Vec3d(var0, var2, var4);
      double var11 = (double)var6.world.getBlockDensity(var10, var6.getEntityBoundingBox());
      double var13 = (1.0D - var8) * var11;
      float var15 = (float)((int)((var13 * var13 + var13) / 2.0D * 7.0D * 12.0D + 1.0D));
      double var16 = 1.0D;
      if (var6 instanceof EntityLivingBase) {
         var16 = (double)k((EntityLivingBase)var6, q(var15), new Explosion(mc.world, (Entity)null, var0, var2, var4, 6.0F, false, true));
      }

      return (float)var16;
   }

   private static float k(EntityLivingBase var0, float var1, Explosion var2) {
      if (var0 instanceof EntityPlayer) {
         EntityPlayer var3 = (EntityPlayer)var0;
         var1 = CombatRules.getDamageAfterAbsorb(var1, (float)var3.getTotalArmorValue(), (float)var3.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue());
         return var1;
      } else {
         var1 = CombatRules.getDamageAfterAbsorb(var1, (float)var0.getTotalArmorValue(), (float)var0.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue());
         return var1;
      }
   }

   private static float q(float var0) {
      int var1 = mc.world.getDifficulty().getId();
      float var10002;
      if (var1 == 2) {
         var10002 = 1.0F;
      }

      if (var1 == 1) {
         var10002 = 0.5F;
      }

      return 0.0F * 1.5F;
   }

   // $FF: synthetic method
   private static Float k(EntityEnderCrystal var0) {
      return mc.player.getDistance(var0);
   }

   // $FF: synthetic method
   private static EntityEnderCrystal k(Entity var0) {
      return (EntityEnderCrystal)var0;
   }

   // $FF: synthetic method
   private static boolean f(Entity var0) {
      return var0 instanceof EntityEnderCrystal;
   }
}
