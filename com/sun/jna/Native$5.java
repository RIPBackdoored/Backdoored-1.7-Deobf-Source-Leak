package com.sun.jna;

import java.io.File;
import java.io.FilenameFilter;

final class Native$5 implements FilenameFilter {
   public boolean accept(File dir, String name) {
      return name.endsWith(".x") && name.startsWith("jna");
   }
}
