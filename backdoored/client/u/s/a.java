package l.c.u.s;

import l.c.u.dw;
import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class a extends dw {
   public Packet packet;
   public static final int fcp;
   public static final boolean fcz;

   public a(Packet var1) {
      this.packet = var1;
   }

   public boolean isCancelable() {
      return true;
   }
}
