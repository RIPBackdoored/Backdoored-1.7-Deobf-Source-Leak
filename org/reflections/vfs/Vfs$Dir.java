package org.reflections.vfs;

public interface Vfs$Dir {
   String getPath();

   Iterable getFiles();

   void close();
}
