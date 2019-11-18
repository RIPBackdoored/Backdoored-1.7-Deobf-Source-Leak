package org.reflections.vfs;

import com.google.common.collect.AbstractIterator;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

class ZipDir$1$1 extends AbstractIterator {
   final Enumeration entries;
   // $FF: synthetic field
   final ZipDir$1 this$1;

   ZipDir$1$1(ZipDir$1 this$1) {
      this.this$1 = this$1;
      this.entries = this.this$1.this$0.jarFile.entries();
   }

   protected Vfs$File computeNext() {
      while(true) {
         if (this.entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)this.entries.nextElement();
            if (entry.isDirectory()) {
               continue;
            }

            return new ZipFile(this.this$1.this$0, entry);
         }

         return (Vfs$File)this.endOfData();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object computeNext() {
      return this.computeNext();
   }
}
