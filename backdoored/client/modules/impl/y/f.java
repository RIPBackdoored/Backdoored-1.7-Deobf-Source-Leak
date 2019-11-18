package l.c.h.j.y;

import java.util.Objects;
import net.minecraft.client.gui.inventory.GuiInventory;

public class f extends d {
   private static final String fkj = "Backdoored/announcer.js";
   public static final int fkc;
   public static final boolean fko;

   public f() throws Exception {
      this.ni = (new o()).fe(h("Backdoored/announcer.js")).k(nd);
   }

   String fk(String var1) {
      String var10000;
      try {
         var10000 = (String)Objects.requireNonNull((String)this.ni.f("onSendMessage", var1));
      } catch (Exception var6) {
         var6.printStackTrace();
         return var1;
      }

      return var10000;
   }

   String v(int var1) {
      return this.k("onMove", var1);
   }

   String ff(String var1) {
      return this.k("onAttack", var1);
   }

   String f(int var1, String var2) {
      return this.k("onBlocksBreak", var1, var2);
   }

   String q(int var1, String var2) {
      return this.k("onBlocksPlace", var1, var2);
   }

   String k(GuiInventory var1) {
      return this.k("onOpenInventory");
   }

   String tk() {
      return this.k("onScreenshot");
   }

   String tf() {
      return this.k("onModuleEnabled");
   }

   String tq() {
      return this.k("onModuleDisabled");
   }

   String tt() {
      return this.k("onPlayerJoin");
   }

   String te() {
      return this.k("onPlayerLeave");
   }

   private String k(String var1, Object... var2) {
      String var10000;
      try {
         var10000 = (String)this.ni.f(var1, var2);
      } catch (Exception var7) {
         var7.printStackTrace();
         return null;
      }

      return var10000;
   }
}
