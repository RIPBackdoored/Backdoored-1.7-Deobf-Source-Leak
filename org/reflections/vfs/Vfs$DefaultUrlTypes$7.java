package org.reflections.vfs;

import java.net.URL;

final class Vfs$DefaultUrlTypes$7 extends Vfs$DefaultUrlTypes {
   Vfs$DefaultUrlTypes$7(String var1, int var2) {
      super(var1, var2, (Vfs$1)null);
   }

   public boolean matches(URL url) throws Exception {
      return url.toExternalForm().contains(".jar");
   }

   public Vfs$Dir createDir(URL url) throws Exception {
      return new JarInputDir(url);
   }
}
