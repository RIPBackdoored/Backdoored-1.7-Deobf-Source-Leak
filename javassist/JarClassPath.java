package javassist;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

final class JarClassPath implements ClassPath {
   JarFile jarfile;
   String jarfileURL;

   JarClassPath(String pathname) throws NotFoundException {
      try {
         this.jarfile = new JarFile(pathname);
         this.jarfileURL = (new File(pathname)).getCanonicalFile().toURI().toURL().toString();
      } catch (IOException var3) {
         throw new NotFoundException(pathname);
      }

   }

   public InputStream openClassfile(String classname) throws NotFoundException {
      InputStream var10000;
      try {
         String jarname = classname.replace('.', '/') + ".class";
         JarEntry je = this.jarfile.getJarEntry(jarname);
         if (je != null) {
            var10000 = this.jarfile.getInputStream(je);
            return var10000;
         }

         var10000 = null;
      } catch (IOException var4) {
         throw new NotFoundException("broken jar file?: " + this.jarfile.getName());
      }

      return var10000;
   }

   public URL find(String classname) {
      String jarname = classname.replace('.', '/') + ".class";
      JarEntry je = this.jarfile.getJarEntry(jarname);
      if (je != null) {
         URL var10000;
         try {
            var10000 = new URL("jar:" + this.jarfileURL + "!/" + jarname);
         } catch (MalformedURLException var5) {
            return null;
         }

         return var10000;
      } else {
         return null;
      }
   }

   public void close() {
      try {
         this.jarfile.close();
         this.jarfile = null;
      } catch (IOException var2) {
      }

   }

   public String toString() {
      return this.jarfile == null ? "<null>" : this.jarfile.toString();
   }
}
