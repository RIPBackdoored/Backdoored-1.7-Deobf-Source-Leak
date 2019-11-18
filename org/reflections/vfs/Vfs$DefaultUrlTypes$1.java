package org.reflections.vfs;

import java.net.URL;
import java.util.jar.JarFile;

final class Vfs$DefaultUrlTypes$1 extends Vfs$DefaultUrlTypes {
   Vfs$DefaultUrlTypes$1(String var1, int var2) {
      super(var1, var2, (Vfs$1)null);
   }

   public boolean matches(URL url) {
      return url.getProtocol().equals("file") && Vfs.access$100(url);
   }

   public Vfs$Dir createDir(URL url) throws Exception {
      return new ZipDir(new JarFile(Vfs.getFile(url)));
   }
}
