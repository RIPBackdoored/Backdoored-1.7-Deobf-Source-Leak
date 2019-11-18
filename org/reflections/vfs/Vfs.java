package org.reflections.vfs;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import org.reflections.Reflections;
import org.reflections.ReflectionsException;

public abstract class Vfs {
   private static List defaultUrlTypes = Lists.newArrayList(Vfs$DefaultUrlTypes.values());

   public static List getDefaultUrlTypes() {
      return defaultUrlTypes;
   }

   public static void setDefaultURLTypes(List urlTypes) {
      defaultUrlTypes = urlTypes;
   }

   public static void addDefaultURLTypes(Vfs$UrlType urlType) {
      defaultUrlTypes.add(0, urlType);
   }

   public static Vfs$Dir fromURL(URL url) {
      return fromURL(url, defaultUrlTypes);
   }

   public static Vfs$Dir fromURL(URL url, List urlTypes) {
      Iterator var2 = urlTypes.iterator();

      while(true) {
         if (var2.hasNext()) {
            Vfs$UrlType type = (Vfs$UrlType)var2.next();

            Vfs$Dir var10000;
            try {
               if (!type.matches(url)) {
                  continue;
               }

               Vfs$Dir dir = type.createDir(url);
               if (dir == null) {
                  continue;
               }

               var10000 = dir;
            } catch (Throwable var5) {
               if (Reflections.log != null) {
                  Reflections.log.warn("could not create Dir using " + type + " from url " + url.toExternalForm() + ". skipping.", var5);
               }
               continue;
            }

            return var10000;
         }

         throw new ReflectionsException("could not create Vfs.Dir from url, no matching UrlType was found [" + url.toExternalForm() + "]\neither use fromURL(final URL url, final List<UrlType> urlTypes) or use the static setDefaultURLTypes(final List<UrlType> urlTypes) or addDefaultURLTypes(UrlType urlType) with your specialized UrlType.");
      }
   }

   public static Vfs$Dir fromURL(URL url, Vfs$UrlType... urlTypes) {
      return fromURL(url, (List)Lists.newArrayList(urlTypes));
   }

   public static Iterable findFiles(Collection inUrls, String packagePrefix, Predicate nameFilter) {
      Predicate fileNamePredicate = new Vfs$1(packagePrefix, nameFilter);
      return findFiles(inUrls, fileNamePredicate);
   }

   public static Iterable findFiles(Collection inUrls, Predicate filePredicate) {
      Iterable result = new ArrayList();
      Iterator var3 = inUrls.iterator();

      while(var3.hasNext()) {
         URL url = (URL)var3.next();

         try {
            result = Iterables.concat((Iterable)result, Iterables.filter(new Vfs$2(url), filePredicate));
         } catch (Throwable var6) {
            if (Reflections.log != null) {
               Reflections.log.error("could not findFiles for url. continuing. [" + url + "]", var6);
            }
         }
      }

      return (Iterable)result;
   }

   @Nullable
   public static java.io.File getFile(URL url) {
      java.io.File var10000;
      java.io.File file;
      String path;
      try {
         path = url.toURI().getSchemeSpecificPart();
         if ((file = new java.io.File(path)).exists()) {
            var10000 = file;
            return var10000;
         }
      } catch (URISyntaxException var6) {
      }

      try {
         path = URLDecoder.decode(url.getPath(), "UTF-8");
         if (path.contains(".jar!")) {
            path = path.substring(0, path.lastIndexOf(".jar!") + ".jar".length());
         }

         if ((file = new java.io.File(path)).exists()) {
            var10000 = file;
            return var10000;
         }
      } catch (UnsupportedEncodingException var5) {
      }

      try {
         path = url.toExternalForm();
         if (path.startsWith("jar:")) {
            path = path.substring("jar:".length());
         }

         if (path.startsWith("wsjar:")) {
            path = path.substring("wsjar:".length());
         }

         if (path.startsWith("file:")) {
            path = path.substring("file:".length());
         }

         if (path.contains(".jar!")) {
            path = path.substring(0, path.indexOf(".jar!") + ".jar".length());
         }

         if ((file = new java.io.File(path)).exists()) {
            var10000 = file;
            return var10000;
         }

         path = path.replace("%20", " ");
         if ((file = new java.io.File(path)).exists()) {
            var10000 = file;
            return var10000;
         }
      } catch (Exception var4) {
      }

      return null;
   }

   private static boolean hasJarFileInPath(URL url) {
      return url.toExternalForm().matches(".*\\.jar(\\!.*|$)");
   }

   // $FF: synthetic method
   static boolean access$100(URL x0) {
      return hasJarFileInPath(x0);
   }
}
