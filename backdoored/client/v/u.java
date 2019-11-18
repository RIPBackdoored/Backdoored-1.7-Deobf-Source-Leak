package l.c.v;

import java.util.Iterator;
import l.c.x.d.a;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;

public class u extends d {
   public static final boolean iz;
   public static final int ib;
   public static final boolean iy;

   public u() {
      super("viewinv", "inventory", "inventoryview");
   }

   public boolean k(String[] var1) {
      if (var1.length < 1) {
         this.mc.displayGuiScreen(new GuiInventory(this.mc.player));
         return true;
      } else {
         Iterator var2 = this.mc.world.playerEntities.iterator();
         if (var2.hasNext()) {
            EntityPlayer var3 = (EntityPlayer)var2.next();
            if (var3.getDisplayNameString().equalsIgnoreCase(var1[0])) {
               this.mc.displayGuiScreen(new GuiInventory(var3));
               return true;
            }
         }

         a.fs("Could not find player " + var1[0]);
         return false;
      }
   }

   public String v() {
      return "-viewinv FitMC";
   }
}
