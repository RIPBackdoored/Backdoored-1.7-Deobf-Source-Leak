package com.sun.jna;

import java.io.File;
import java.io.FilenameFilter;

final class NativeLibrary$2 implements FilenameFilter {
   // $FF: synthetic field
   final String val$libName;

   NativeLibrary$2(String var1) {
      this.val$libName = var1;
   }

   public boolean accept(File dir, String filename) {
      return (filename.startsWith("lib" + this.val$libName + ".so") || filename.startsWith(this.val$libName + ".so") && this.val$libName.startsWith("lib")) && NativeLibrary.access$000(filename);
   }
}
