package l.c.x;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import java.net.Proxy;
import net.minecraft.util.Session;

public class e {
   public static final int fur;
   public static final boolean fik;

   public static Session d(String var0, String var1) {
      if (var0 != null && var0.length() > 0 && var1 != null && var1.length() > 0) {
         YggdrasilAuthenticationService var2 = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
         YggdrasilUserAuthentication var3 = (YggdrasilUserAuthentication)var2.createUserAuthentication(Agent.MINECRAFT);
         var3.setUsername(var0);
         var3.setPassword(var1);

         Session var10000;
         try {
            var3.logIn();
            var10000 = new Session(var3.getSelectedProfile().getName(), var3.getSelectedProfile().getId().toString(), var3.getAuthenticatedToken(), "LEGACY");
         } catch (AuthenticationException var8) {
            var8.printStackTrace();
            System.out.println("Failed login: " + var0 + ":" + var1);
            return null;
         }

         return var10000;
      } else {
         return null;
      }
   }

   public static Session ft(String var0) {
      return new Session(var0, "", "", "LEGACY");
   }
}
