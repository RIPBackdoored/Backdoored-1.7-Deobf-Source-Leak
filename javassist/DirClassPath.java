package javassist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

final class DirClassPath implements ClassPath {
   String directory;

   DirClassPath(String dirName) {
      this.directory = dirName;
   }

   public InputStream openClassfile(String classname) {
      try {
         char sep = File.separatorChar;
         String filename = this.directory + sep + classname.replace('.', sep) + ".class";
         FileInputStream var10000 = new FileInputStream(filename.toString());
         return var10000;
      } catch (FileNotFoundException var4) {
      } catch (SecurityException var5) {
      }

      return null;
   }

   public URL find(String classname) {
      char sep = File.separatorChar;
      String filename = this.directory + sep + classname.replace('.', sep) + ".class";
      File f = new File(filename);
      if (f.exists()) {
         URL var10000;
         try {
            var10000 = f.getCanonicalFile().toURI().toURL();
         } catch (MalformedURLException var6) {
            return null;
         } catch (IOException var7) {
            return null;
         }

         return var10000;
      } else {
         return null;
      }
   }

   public void close() {
   }

   public String toString() {
      return this.directory;
   }
}
