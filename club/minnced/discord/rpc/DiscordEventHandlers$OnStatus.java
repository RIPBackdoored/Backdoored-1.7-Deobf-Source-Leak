package club.minnced.discord.rpc;

import com.sun.jna.Callback;

public interface DiscordEventHandlers$OnStatus extends Callback {
   void accept(int var1, String var2);
}
