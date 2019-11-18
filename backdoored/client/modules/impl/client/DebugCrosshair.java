package l.c.h.j.client;

import l.c.q;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Debug Crosshair",
   description = "Show f3 crosshair",
   category = c.CLIENT
)
public class DebugCrosshair extends w {
   public static final int zf;
   public static final boolean zq;

   @SubscribeEvent
   public void k(RenderGameOverlayEvent var1) {
      if (this.qm() && var1.getType() == ElementType.CROSSHAIRS) {
         int var2 = (new ScaledResolution(mc)).getScaledWidth();
         int var3 = (new ScaledResolution(mc)).getScaledHeight();
         float var4 = (Float)ObfuscationReflectionHelper.getPrivateValue(Gui.class, q.mc.ingameGUI, new String[]{"zLevel", "field_73735_i"});
         k(var1.getPartialTicks(), var2, var3, var4);
      }

   }

   private static void k(float var0, int var1, int var2, float var3) {
      GameSettings var4 = mc.gameSettings;
      if (var4.thirdPersonView == 0) {
         RayTraceResult var5;
         if (mc.playerController.isSpectator() && mc.pointedEntity == null) {
            var5 = mc.objectMouseOver;
            if (var5 == null || var5.typeOfHit != Type.BLOCK) {
               return;
            }

            BlockPos var6 = var5.getBlockPos();
            IBlockState var7 = mc.world.getBlockState(var6);
            if (!var7.getBlock().hasTileEntity(var7) || !(mc.world.getTileEntity(var6) instanceof IInventory)) {
               return;
            }
         }

         if (!var4.hideGUI) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)(var1 / 2), (float)(var2 / 2), var3);
            if (var5 != null) {
               GlStateManager.rotate(var5.prevRotationPitch + (var5.rotationPitch - var5.prevRotationPitch) * var0, -1.0F, 0.0F, 0.0F);
               GlStateManager.rotate(var5.prevRotationYaw + (var5.rotationYaw - var5.prevRotationYaw) * var0, 0.0F, 1.0F, 0.0F);
               GlStateManager.scale(-1.0F, -1.0F, -1.0F);
               OpenGlHelper.renderDirections(10);
               GlStateManager.popMatrix();
            }
         }
      }

   }
}
