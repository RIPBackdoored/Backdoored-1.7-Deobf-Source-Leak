package l.c.h.j.client;

import  l. c. h. j. x. f;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import l.c.f.h;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.x.f;
import l.c.x.t;
import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderTooltipEvent.PostText;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

@w$d(
   name = "Shulker Preview",
   description = "Preview Shulkers via tooltip",
   category = c.CLIENT
)
public class ShulkerPreview extends w {
   static String[] mp;
   private static final ResourceLocation resourceLocation;
   private static List mb;
   private static final int[][] my;
   private static final int mx = 5;
   private static final int ml = 1;
   private static final int mh = 18;
   // $FF: synthetic field
   static final boolean ma;
   public static final boolean mg;
   public static final int mw;
   public static final boolean mn;

   @SubscribeEvent(
      priority = EventPriority.HIGHEST
   )
   public void k(ItemTooltipEvent var1) {
      if (k(var1.getItemStack(), mb) && var1.getItemStack().hasTagCompound()) {
         NBTTagCompound var2 = t.q(var1.getItemStack(), "BlockEntityTag", true);
         if (var2 != null) {
            if (!var2.hasKey("id", 8)) {
               var2 = var2.copy();
               var2.setString("id", "minecraft:shulker_box");
            }

            TileEntity var3 = TileEntity.create(mc.world, var2);
            if (var3 != null && var3.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null)) {
               List var4 = var1.getToolTip();
               ArrayList var5 = new ArrayList(var4);
               byte var6 = 1;
               if (var6 < var5.size()) {
                  String var7 = (String)var5.get(var6);
                  if (!var7.startsWith("\u00a7") || var7.startsWith("\u00a7o")) {
                     var4.remove(var7);
                  }

                  int var11 = var6 + 1;
               }
            }
         }
      }

   }

   @SubscribeEvent
   public void k(PostText var1) {
      if (this.qm()) {
         if (k(var1.getStack(), mb) && var1.getStack().hasTagCompound()) {
            NBTTagCompound var2 = t.q(var1.getStack(), "BlockEntityTag", true);
            if (var2 != null) {
               if (!var2.hasKey("id", 8)) {
                  var2 = var2.copy();
                  var2.setString("id", "minecraft:shulker_box");
               }

               TileEntity var3 = TileEntity.create(mc.world, var2);
               if (var3 != null && var3.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null)) {
                  ItemStack var4 = var1.getStack();
                  int var5 = var1.getX() - 5;
                  int var6 = var1.getY() - 70;
                  IItemHandler var7 = (IItemHandler)var3.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null);
                  if (!ma && var7 == null) {
                     throw new AssertionError();
                  }

                  int var8 = var7.getSlots();
                  int[] var9 = new int[]{Math.min(var8, 9), Math.max(var8 / 9, 1)};
                  int[][] var10 = my;
                  int var11 = var10.length;
                  byte var12 = 0;
                  int var24;
                  if (var12 < var11) {
                     int[] var13 = var10[var12];
                     if (var13[0] * var13[1] == var8) {
                        var9 = var13;
                     }

                     var24 = var12 + 1;
                  }

                  int var22 = 10 + 18 * var9[0];
                  if (var6 < 0) {
                     var6 = var1.getY() + var1.getLines().size() * 10 + 5;
                  }

                  ScaledResolution var23 = new ScaledResolution(mc);
                  var24 = var5 + var22;
                  if (var24 > var23.getScaledWidth()) {
                     var5 -= var24 - var23.getScaledWidth();
                  }

                  GlStateManager.pushMatrix();
                  RenderHelper.enableStandardItemLighting();
                  GlStateManager.enableRescaleNormal();
                  GlStateManager.color(1.0F, 1.0F, 1.0F);
                  GlStateManager.translate(0.0F, 0.0F, 700.0F);
                  mc.getTextureManager().bindTexture(resourceLocation);
                  RenderHelper.disableStandardItemLighting();
                  int var25 = -1;
                  if (((ItemBlock)var4.getItem()).getBlock() instanceof BlockShulkerBox) {
                     EnumDyeColor var14 = ((BlockShulkerBox)((ItemBlock)var4.getItem()).getBlock()).getColor();
                     var25 = ItemDye.DYE_COLORS[var14.getDyeDamage()];
                  }

                  k(var5, var6, var9[0], var9[1], var25);
                  RenderItem var26 = mc.getRenderItem();
                  RenderHelper.enableGUIStandardItemLighting();
                  GlStateManager.enableDepth();
                  byte var15 = 0;
                  if (var15 < var8) {
                     ItemStack var16 = var7.getStackInSlot(var15);
                     int var17 = var5 + 6 + var15 % 9 * 18;
                     int var18 = var6 + 6 + var15 / 9 * 18;
                     if (!var16.isEmpty()) {
                        var26.renderItemAndEffectIntoGUI(var16, var17, var18);
                        var26.renderItemOverlays(h.fontRenderer, var16, var17, var18);
                     }

                     int var27 = var15 + 1;
                  }

                  GlStateManager.disableDepth();
                  GlStateManager.disableRescaleNormal();
                  GlStateManager.popMatrix();
               }
            }
         }

      }
   }

   private static void k(int var0, int var1, int var2, int var3, int var4) {
      mc.getTextureManager().bindTexture(resourceLocation);
      GlStateManager.color((float)((var4 & 16711680) >> 16) / 255.0F, (float)((var4 & '\uff00') >> 8) / 255.0F, (float)(var4 & 255) / 255.0F);
      RenderHelper.disableStandardItemLighting();
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, 5, 5, 256.0F, 256.0F);
      Gui.drawModalRectWithCustomSizedTexture(var0 + 5 + 18 * var2, var1 + 5 + 18 * var3, 25.0F, 25.0F, 5, 5, 256.0F, 256.0F);
      Gui.drawModalRectWithCustomSizedTexture(var0 + 5 + 18 * var2, var1, 25.0F, 0.0F, 5, 5, 256.0F, 256.0F);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1 + 5 + 18 * var3, 0.0F, 25.0F, 5, 5, 256.0F, 256.0F);
      byte var5 = 0;
      if (var5 < var3) {
         Gui.drawModalRectWithCustomSizedTexture(var0, var1 + 5 + 18 * var5, 0.0F, 6.0F, 5, 18, 256.0F, 256.0F);
         Gui.drawModalRectWithCustomSizedTexture(var0 + 5 + 18 * var2, var1 + 5 + 18 * var5, 25.0F, 6.0F, 5, 18, 256.0F, 256.0F);
         byte var6 = 0;
         if (var6 < var2) {
            Gui.drawModalRectWithCustomSizedTexture(var0 + 5 + 18 * var6, var1, 6.0F, 0.0F, 18, 5, 256.0F, 256.0F);
            Gui.drawModalRectWithCustomSizedTexture(var0 + 5 + 18 * var6, var1 + 5 + 18 * var3, 6.0F, 25.0F, 18, 5, 256.0F, 256.0F);
            Gui.drawModalRectWithCustomSizedTexture(var0 + 5 + 18 * var6, var1 + 5 + 18 * var5, 6.0F, 6.0F, 18, 18, 256.0F, 256.0F);
            int var11 = var6 + 1;
         }

         int var10 = var5 + 1;
      }

      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }

   private static boolean k(ItemStack var0, List var1) {
      if (!var0.isEmpty() && k(var0.getItem().getRegistryName(), var1)) {
         boolean var10000 = true;
      }

      return false;
   }

   private static boolean k(ResourceLocation var0, List var1) {
      return var0 == null ? false : var1.contains(var0);
   }

   // $FF: synthetic method
   private static String[] q(int var0) {
      return new String[var0];
   }

   static {
      if (!f.class.desiredAssertionStatus()) {
         boolean var10000 = true;
      }

      ma = false;
      mp = (String[])ImmutableSet.of(Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, new Block[]{Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX}).stream().map(Impl::getRegistryName).map(Objects::toString).toArray( f::q);
      resourceLocation = new ResourceLocation("backdoored", "textures/inv_slot.png");
      mb = (List)Arrays.stream(mp).map(ResourceLocation::new).collect(Collectors.toList());
      my = new int[][]{{1, 1}, {9, 3}, {9, 5}, {9, 6}, {9, 8}, {9, 9}, {12, 9}};
   }
}
