package org.reflections.vfs;

import java.net.URL;
import org.reflections.util.ClasspathHelper;

final class Vfs$DefaultUrlTypes$6 extends Vfs$DefaultUrlTypes {
   Vfs$DefaultUrlTypes$6(String var1, int var2) {
      super(var1, var2, (Vfs$1)null);
   }

   public boolean matches(URL url) throws Exception {
      return url.getProtocol().startsWith("bundle");
   }

   public Vfs$Dir createDir(URL url) throws Exception {
      return Vfs.fromURL((URL)ClasspathHelper.contextClassLoader().loadClass("org.eclipse.core.runtime.FileLocator").getMethod("resolve", URL.class).invoke((Object)null, url));
   }
}
