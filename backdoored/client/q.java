package l.c;

import net.minecraft.client.Minecraft;
import net.minecraft.network.NetworkManager;
import net.minecraftforge.fml.client.FMLClientHandler;

public interface q {
   Minecraft mc = Minecraft.getMinecraft();
   boolean fyy = true;
   boolean fyx;

   static NetworkManager ei() {
      return FMLClientHandler.instance().getClientToServerNetworkManager();
   }
}
