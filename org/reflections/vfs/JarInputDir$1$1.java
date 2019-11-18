package org.reflections.vfs;

import com.google.common.collect.AbstractIterator;
import java.io.IOException;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import org.reflections.ReflectionsException;

class JarInputDir$1$1 extends AbstractIterator {
   // $FF: synthetic field
   final JarInputDir$1 this$1;

   JarInputDir$1$1(JarInputDir$1 this$1) throws Error {
      this.this$1 = this$1;

      try {
         this.this$1.this$0.jarInputStream = new JarInputStream(JarInputDir.access$000(this.this$1.this$0).openConnection().getInputStream());
      } catch (Exception var3) {
         throw new ReflectionsException("Could not open url connection", var3);
      }

   }

   protected Vfs$File computeNext() {
      while(true) {
         try {
            ZipEntry entry = this.this$1.this$0.jarInputStream.getNextJarEntry();
            if (entry == null) {
               Vfs$File var6 = (Vfs$File)this.endOfData();
               return var6;
            }

            long size = entry.getSize();
            if (size < 0L) {
               size += 4294967295L;
            }

            JarInputDir var10000 = this.this$1.this$0;
            var10000.nextCursor += size;
            if (!entry.isDirectory()) {
               JarInputFile var5 = new JarInputFile(entry, this.this$1.this$0, this.this$1.this$0.cursor, this.this$1.this$0.nextCursor);
               return var5;
            }
         } catch (IOException var4) {
            throw new ReflectionsException("could not get next zip entry", var4);
         }
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object computeNext() {
      return this.computeNext();
   }
}
