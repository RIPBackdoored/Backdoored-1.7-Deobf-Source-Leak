package org.reflections.vfs;

import com.google.common.base.Predicate;
import java.io.File;

class UrlTypeVFS$1 implements Predicate {
   // $FF: synthetic field
   final UrlTypeVFS this$0;

   UrlTypeVFS$1(UrlTypeVFS this$0) {
      this.this$0 = this$0;
   }

   public boolean apply(File file) {
      return file.exists() && file.isFile();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object var1) {
      return this.apply((File)var1);
   }
}
