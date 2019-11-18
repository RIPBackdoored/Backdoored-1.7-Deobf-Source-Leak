package org.reflections.vfs;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarFile;

final class Vfs$DefaultUrlTypes$2 extends Vfs$DefaultUrlTypes {
   Vfs$DefaultUrlTypes$2(String var1, int var2) {
      super(var1, var2, (Vfs$1)null);
   }

   public boolean matches(URL url) {
      return "jar".equals(url.getProtocol()) || "zip".equals(url.getProtocol()) || "wsjar".equals(url.getProtocol());
   }

   public Vfs$Dir createDir(URL url) throws Exception {
      try {
         URLConnection urlConnection = url.openConnection();
         if (urlConnection instanceof JarURLConnection) {
            ZipDir var10000 = new ZipDir(((JarURLConnection)urlConnection).getJarFile());
            return var10000;
         }
      } catch (Throwable var3) {
      }

      File file = Vfs.getFile(url);
      if (file != null) {
         return new ZipDir(new JarFile(file));
      } else {
         return null;
      }
   }
}
