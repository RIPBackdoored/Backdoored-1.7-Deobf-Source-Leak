package l.c.h.j.client;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.event.RenderTooltipEvent.PostText;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Map Tooltip",
   description = "Tooltips to preview maps",
   category = c.CLIENT
)
public class MapTooltip extends w {
   private static final ResourceLocation resourceLocation = new ResourceLocation("textures/map/map_background.png");
   public static final int fmz;
   public static final boolean fmb;

   @SubscribeEvent(
      priority = EventPriority.HIGHEST
   )
   public void k(ItemTooltipEvent var1) {
   }

   @SubscribeEvent
   public void k(PostText var1) {
      if (this.qm()) {
         if (!var1.getStack().isEmpty() && var1.getStack().getItem() instanceof ItemMap) {
            MapData var2 = Items.FILLED_MAP.getMapData(var1.getStack(), mc.world);
            if (var2 != null) {
               GlStateManager.pushMatrix();
               GlStateManager.color(1.0F, 1.0F, 1.0F);
               RenderHelper.disableStandardItemLighting();
               mc.getTextureManager().bindTexture(resourceLocation);
               Tessellator var3 = Tessellator.getInstance();
               BufferBuilder var4 = var3.getBuffer();
               byte var5 = 7;
               float var6 = 135.0F;
               float var7 = 0.5F;
               GlStateManager.translate((float)var1.getX(), (float)var1.getY() - var6 * var7 - 5.0F, 0.0F);
               GlStateManager.scale(var7, var7, var7);
               var4.begin(7, DefaultVertexFormats.POSITION_TEX);
               var4.pos((double)(-var5), (double)var6, 0.0D).tex(0.0D, 1.0D).endVertex();
               var4.pos((double)var6, (double)var6, 0.0D).tex(1.0D, 1.0D).endVertex();
               var4.pos((double)var6, (double)(-var5), 0.0D).tex(1.0D, 0.0D).endVertex();
               var4.pos((double)(-var5), (double)(-var5), 0.0D).tex(0.0D, 0.0D).endVertex();
               var3.draw();
               mc.entityRenderer.getMapItemRenderer().renderMap(var2, false);
               GlStateManager.enableLighting();
               GlStateManager.popMatrix();
            }
         }

      }
   }
}
