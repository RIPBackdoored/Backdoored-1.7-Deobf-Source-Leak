package l.c.u;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class q extends dw {
   public ItemRenderer itemRenderer;
   public AbstractClientPlayer abstractClientPlayer;
   public float wb;
   public float wy;
   public EnumHand enumHand;
   public float wl;
   public ItemStack itemStack;
   public float wa;
   public static final int wg;

   public q(ItemRenderer var1, AbstractClientPlayer var2, float var3, float var4, EnumHand var5, float var6, ItemStack var7, float var8) {
      this.itemRenderer = var1;
      this.abstractClientPlayer = var2;
      this.wb = var3;
      this.wy = var4;
      this.enumHand = var5;
      this.wl = var6;
      this.itemStack = var7;
      this.wa = var8;
   }
}
