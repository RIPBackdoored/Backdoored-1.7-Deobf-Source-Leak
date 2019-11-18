package org.reflections.vfs;

import java.io.File;
import java.net.URL;
import java.util.jar.JarFile;
import org.reflections.util.ClasspathHelper;

final class Vfs$DefaultUrlTypes$4 extends Vfs$DefaultUrlTypes {
   Vfs$DefaultUrlTypes$4(String var1, int var2) {
      super(var1, var2, (Vfs$1)null);
   }

   public boolean matches(URL url) {
      return url.getProtocol().equals("vfs");
   }

   public Vfs$Dir createDir(URL url) throws Exception {
      Object content = url.openConnection().getContent();
      Class virtualFile = ClasspathHelper.contextClassLoader().loadClass("org.jboss.vfs.VirtualFile");
      File physicalFile = (File)virtualFile.getMethod("getPhysicalFile").invoke(content);
      String name = (String)virtualFile.getMethod("getName").invoke(content);
      File file = new File(physicalFile.getParentFile(), name);
      if (!file.exists() || !file.canRead()) {
         file = physicalFile;
      }

      return (Vfs$Dir)(file.isDirectory() ? new SystemDir(file) : new ZipDir(new JarFile(file)));
   }
}
