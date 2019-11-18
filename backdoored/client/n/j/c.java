package l.c.n.j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class c {
   public final LaunchClassLoader launchClassLoader;
   public static final boolean co;
   public static final int cp;
   public static final boolean cz;

   public List k(String var1, String var2, String... var3) throws MalformedURLException, ClassNotFoundException {
      URL var4 = new URL(var1 + "/" + var2);
      this.launchClassLoader.addURL(var4);
      ArrayList var5 = new ArrayList();
      int var7 = var3.length;
      byte var8 = 0;
      if (var8 < var7) {
         String var9 = var3[var8];
         var5.add(this.launchClassLoader.loadClass(var9));
         int var13 = var8 + 1;
      }

      return var5;
   }
}
