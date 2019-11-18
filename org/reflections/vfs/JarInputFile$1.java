package org.reflections.vfs;

import java.io.IOException;
import java.io.InputStream;

class JarInputFile$1 extends InputStream {
   // $FF: synthetic field
   final JarInputFile this$0;

   JarInputFile$1(JarInputFile this$0) {
      this.this$0 = this$0;
   }

   public int read() throws IOException {
      if (JarInputFile.access$000(this.this$0).cursor >= JarInputFile.access$100(this.this$0) && JarInputFile.access$000(this.this$0).cursor <= JarInputFile.access$200(this.this$0)) {
         int read = JarInputFile.access$000(this.this$0).jarInputStream.read();
         ++JarInputFile.access$000(this.this$0).cursor;
         return read;
      } else {
         return -1;
      }
   }
}
