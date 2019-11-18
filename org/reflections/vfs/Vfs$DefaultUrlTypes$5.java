package org.reflections.vfs;

import java.net.URL;

final class Vfs$DefaultUrlTypes$5 extends Vfs$DefaultUrlTypes {
   Vfs$DefaultUrlTypes$5(String var1, int var2) {
      super(var1, var2, (Vfs$1)null);
   }

   public boolean matches(URL url) throws Exception {
      return "vfszip".equals(url.getProtocol()) || "vfsfile".equals(url.getProtocol());
   }

   public Vfs$Dir createDir(URL url) throws Exception {
      return (new UrlTypeVFS()).createDir(url);
   }
}
