package org.reflections.vfs;

import java.io.File;
import java.net.URL;

final class Vfs$DefaultUrlTypes$3 extends Vfs$DefaultUrlTypes {
   Vfs$DefaultUrlTypes$3(String var1, int var2) {
      super(var1, var2, (Vfs$1)null);
   }

   public boolean matches(URL url) {
      if (url.getProtocol().equals("file") && !Vfs.access$100(url)) {
         File file = Vfs.getFile(url);
         return file != null && file.isDirectory();
      } else {
         return false;
      }
   }

   public Vfs$Dir createDir(URL url) throws Exception {
      return new SystemDir(Vfs.getFile(url));
   }
}
