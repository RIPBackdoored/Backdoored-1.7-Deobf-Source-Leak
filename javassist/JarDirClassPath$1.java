package javassist;

import java.io.File;
import java.io.FilenameFilter;

class JarDirClassPath$1 implements FilenameFilter {
   // $FF: synthetic field
   final JarDirClassPath this$0;

   JarDirClassPath$1(JarDirClassPath this$0) {
      this.this$0 = this$0;
   }

   public boolean accept(File dir, String name) {
      name = name.toLowerCase();
      return name.endsWith(".jar") || name.endsWith(".zip");
   }
}
