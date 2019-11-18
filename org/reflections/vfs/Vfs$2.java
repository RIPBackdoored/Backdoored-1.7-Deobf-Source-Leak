package org.reflections.vfs;

import java.net.URL;
import java.util.Iterator;

final class Vfs$2 implements Iterable {
   // $FF: synthetic field
   final URL val$url;

   Vfs$2(URL var1) {
      this.val$url = var1;
   }

   public Iterator iterator() {
      return Vfs.fromURL(this.val$url).getFiles().iterator();
   }
}
