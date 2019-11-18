package org.reflections.vfs;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

public class JarInputFile implements Vfs$File {
   private final ZipEntry entry;
   private final JarInputDir jarInputDir;
   private final long fromIndex;
   private final long endIndex;

   public JarInputFile(ZipEntry entry, JarInputDir jarInputDir, long cursor, long nextCursor) {
      this.entry = entry;
      this.jarInputDir = jarInputDir;
      this.fromIndex = cursor;
      this.endIndex = nextCursor;
   }

   public String getName() {
      String name = this.entry.getName();
      return name.substring(name.lastIndexOf("/") + 1);
   }

   public String getRelativePath() {
      return this.entry.getName();
   }

   public InputStream openInputStream() throws IOException {
      return new JarInputFile$1(this);
   }

   // $FF: synthetic method
   static JarInputDir access$000(JarInputFile x0) {
      return x0.jarInputDir;
   }

   // $FF: synthetic method
   static long access$100(JarInputFile x0) {
      return x0.fromIndex;
   }

   // $FF: synthetic method
   static long access$200(JarInputFile x0) {
      return x0.endIndex;
   }
}
