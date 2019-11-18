package org.reflections.vfs;

import com.google.common.collect.AbstractIterator;
import java.io.File;
import java.util.Stack;

class SystemDir$1$1 extends AbstractIterator {
   final Stack stack;
   // $FF: synthetic field
   final SystemDir$1 this$1;

   SystemDir$1$1(SystemDir$1 this$1) {
      this.this$1 = this$1;
      this.stack = new Stack();
      this.stack.addAll(SystemDir.access$100(SystemDir.access$000(this.this$1.this$0)));
   }

   protected Vfs$File computeNext() {
      while(true) {
         if (!this.stack.isEmpty()) {
            File file = (File)this.stack.pop();
            if (file.isDirectory()) {
               this.stack.addAll(SystemDir.access$100(file));
               continue;
            }

            return new SystemFile(this.this$1.this$0, file);
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
