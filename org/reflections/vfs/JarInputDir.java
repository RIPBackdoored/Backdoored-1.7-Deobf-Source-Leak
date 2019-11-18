package org.reflections.vfs;

import java.net.URL;
import java.util.jar.JarInputStream;
import org.reflections.util.Utils;

public class JarInputDir implements Vfs$Dir {
   private final URL url;
   JarInputStream jarInputStream;
   long cursor = 0L;
   long nextCursor = 0L;

   public JarInputDir(URL url) {
      this.url = url;
   }

   public String getPath() {
      return this.url.getPath();
   }

   public Iterable getFiles() {
      return new JarInputDir$1(this);
   }

   public void close() {
      Utils.close(this.jarInputStream);
   }

   // $FF: synthetic method
   static URL access$000(JarInputDir x0) {
      return x0.url;
   }
}
