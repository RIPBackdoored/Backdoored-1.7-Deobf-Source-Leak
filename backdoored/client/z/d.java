package l.c.z;

import java.util.HashMap;
import l.c.t;
import net.minecraftforge.fml.common.FMLLog;

public class d {
   private static final HashMap fgn = new d$c();
   public static final boolean fgr;
   public static final int fwk;
   public static final boolean fwf;

   public static String i(int var0) {
      String var1 = (String)fgn.get(var0);
      return var1;
   }

   public static void ew() {
      FMLLog.log.info("Encrypting things");
      long var0 = System.currentTimeMillis();
      byte var2 = 0;
      String[] var3 = new String[]{"Error initialising class ", "Backdoored tried to load ", " hack, out of which ", " failed", "Failed hack: ", "x", "y", "open", "prefix", "Backdoored startup finished", "Hack with name ", " not found", "Hack of class ", "Logging into an online account with email: ", "session", "field_71449_j", "Logged in successfully:", "Session ID: ", "Username: ", "textures/cape_backdoored.png", "textures/cape_backdoored_dev.png", "http://pastebin.com/raw/ZMZcF3nJ", "Gave capes to: ", "Could not fetch capes", "http://pastebin.com/raw/g4wjzg5U", "Could not fetch dev capes", "dark_red", "red", "gold", "yellow", "dark_green", "green", "aqua", "dark_aqua", "dark_blue", "blue", "light_purple", "dark_purple", "white", "gray", "dark_gray", "black", "Backdoored/friends.txt"};
      int var4 = var3.length;
      byte var5 = 0;
      if (var5 < var4) {
         String var6 = var3[var5];
         System.out.print("\nput(" + var2 + ",\"" + t.w(var6) + "\");      // " + var6);
         int var10 = var2 + 1;
         int var11 = var5 + 1;
      }

      System.out.print("\nTook " + (double)(System.currentTimeMillis() - var0) / 1000.0D + "s");
      System.exit(-1);
   }
}
