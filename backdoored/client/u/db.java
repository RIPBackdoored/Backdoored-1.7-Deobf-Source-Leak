package l.c.u;

import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;

public class db extends dw {
   public NetworkPlayerInfo networkPlayerInfo;
   public ResourceLocation resourceLocation;
   public static final int fyp;

   public db(NetworkPlayerInfo var1) {
      this.networkPlayerInfo = var1;
      this.resourceLocation = null;
   }
}
