package club.minnced.discord.rpc;

import com.sun.jna.Callback;

public interface DiscordEventHandlers$OnJoinRequest extends Callback {
   void accept(DiscordUser var1);
}
