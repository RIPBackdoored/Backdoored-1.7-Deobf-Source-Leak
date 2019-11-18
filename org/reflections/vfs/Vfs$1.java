package org.reflections.vfs;

import com.google.common.base.Predicate;
import org.reflections.util.Utils;

final class Vfs$1 implements Predicate {
   // $FF: synthetic field
   final String val$packagePrefix;
   // $FF: synthetic field
   final Predicate val$nameFilter;

   Vfs$1(String var1, Predicate var2) {
      this.val$packagePrefix = var1;
      this.val$nameFilter = var2;
   }

   public boolean apply(Vfs$File file) {
      String path = file.getRelativePath();
      if (!path.startsWith(this.val$packagePrefix)) {
         return false;
      } else {
         String filename = path.substring(path.indexOf(this.val$packagePrefix) + this.val$packagePrefix.length());
         return !Utils.isEmpty(filename) && this.val$nameFilter.apply(filename.substring(1));
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object var1) {
      return this.apply((Vfs$File)var1);
   }
}
