package com.backdoored.mixin;

import  l. c. u. v;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({GuiNewChat.class})
public abstract class MixinNewGuiChat {
   @Shadow
   @Final
   private Minecraft field_146247_f;
   @Shadow
   private int field_146250_j;
   @Shadow
   private boolean field_146251_k;
   @Shadow
   @Final
   private List field_146253_i;
   @Shadow
   @Final
   private List field_146252_h;

   @Shadow
   public abstract void func_146242_c(int var1);

   @Shadow
   public abstract int func_146228_f();

   @Shadow
   public abstract float func_146244_h();

   @Shadow
   public abstract boolean func_146241_e();

   @Shadow
   public abstract void func_146229_b(int var1);

   @Overwrite
   private void func_146237_a(ITextComponent chatComponent, int chatLineId, int updateCounter, boolean displayOnly) {
      if (chatLineId != 0) {
         this.func_146242_c(chatLineId);
      }

      ITextComponent itextcomponent;
      for(Iterator var5 = GuiUtilRenderComponents.func_178908_a(chatComponent, MathHelper.func_76141_d((float)this.func_146228_f() / this.func_146244_h()), this.field_146247_f.field_71466_p, false, false).iterator(); var5.hasNext(); this.field_146253_i.add(0, new ChatLine(updateCounter, itextcomponent, chatLineId))) {
         itextcomponent = (ITextComponent)var5.next();
         if (this.func_146241_e() && this.field_146250_j > 0) {
            this.field_146251_k = true;
            this.func_146229_b(1);
         }
      }

       v event = new  v();
      MinecraftForge.EVENT_BUS.post(event);
      if (event.getResult() == Result.ALLOW && !displayOnly) {
         this.field_146252_h.add(0, new ChatLine(updateCounter, chatComponent, chatLineId));
      } else {
         while(this.field_146253_i.size() > 100) {
            this.field_146253_i.remove(this.field_146253_i.size() - 1);
         }

         if (!displayOnly) {
            this.field_146252_h.add(0, new ChatLine(updateCounter, chatComponent, chatLineId));

            while(this.field_146252_h.size() > 100) {
               this.field_146252_h.remove(this.field_146252_h.size() - 1);
            }
         }
      }

   }
}
