package org.reflections.vfs;

import com.google.common.collect.Lists;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class SystemDir implements Vfs$Dir {
   private final File file;

   public SystemDir(File file) {
      if (file == null || file.isDirectory() && file.canRead()) {
         this.file = file;
      } else {
         throw new RuntimeException("cannot use dir " + file);
      }
   }

   public String getPath() {
      return this.file == null ? "/NO-SUCH-DIRECTORY/" : this.file.getPath().replace("\\", "/");
   }

   public Iterable getFiles() {
      return (Iterable)(this.file != null && this.file.exists() ? new SystemDir$1(this) : Collections.emptyList());
   }

   private static List listFiles(File file) {
      File[] files = file.listFiles();
      return files != null ? Lists.newArrayList(files) : Lists.newArrayList();
   }

   public void close() {
   }

   public String toString() {
      return this.getPath();
   }

   // $FF: synthetic method
   static File access$000(SystemDir x0) {
      return x0.file;
   }

   // $FF: synthetic method
   static List access$100(File x0) {
      return listFiles(x0);
   }
}
