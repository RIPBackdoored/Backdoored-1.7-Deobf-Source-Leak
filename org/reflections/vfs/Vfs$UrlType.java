package org.reflections.vfs;

import java.net.URL;

public interface Vfs$UrlType {
   boolean matches(URL var1) throws Exception;

   Vfs$Dir createDir(URL var1) throws Exception;
}
