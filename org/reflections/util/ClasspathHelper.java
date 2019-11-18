package org.reflections.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.jar.Attributes.Name;
import javax.servlet.ServletContext;
import org.reflections.Reflections;

public abstract class ClasspathHelper {
   public static ClassLoader contextClassLoader() {
      return Thread.currentThread().getContextClassLoader();
   }

   public static ClassLoader staticClassLoader() {
      return Reflections.class.getClassLoader();
   }

   public static ClassLoader[] classLoaders(ClassLoader... classLoaders) {
      if (classLoaders != null && classLoaders.length != 0) {
         return classLoaders;
      } else {
         ClassLoader contextClassLoader = contextClassLoader();
         ClassLoader staticClassLoader = staticClassLoader();
         return contextClassLoader != null ? (staticClassLoader != null && contextClassLoader != staticClassLoader ? new ClassLoader[]{contextClassLoader, staticClassLoader} : new ClassLoader[]{contextClassLoader}) : new ClassLoader[0];
      }
   }

   public static Collection forPackage(String name, ClassLoader... classLoaders) {
      return forResource(resourceName(name), classLoaders);
   }

   public static Collection forResource(String resourceName, ClassLoader... classLoaders) {
      List result = new ArrayList();
      ClassLoader[] loaders = classLoaders(classLoaders);
      ClassLoader[] var4 = loaders;
      int var5 = loaders.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ClassLoader classLoader = var4[var6];

         try {
            Enumeration urls = classLoader.getResources(resourceName);

            while(urls.hasMoreElements()) {
               URL url = (URL)urls.nextElement();
               int index = url.toExternalForm().lastIndexOf(resourceName);
               if (index != -1) {
                  result.add(new URL(url, url.toExternalForm().substring(0, index)));
               } else {
                  result.add(url);
               }
            }
         } catch (IOException var11) {
            if (Reflections.log != null) {
               Reflections.log.error("error getting resources for " + resourceName, var11);
            }
         }
      }

      return distinctUrls(result);
   }

   public static URL forClass(Class aClass, ClassLoader... classLoaders) {
      ClassLoader[] loaders = classLoaders(classLoaders);
      String resourceName = aClass.getName().replace(".", "/") + ".class";
      ClassLoader[] var4 = loaders;
      int var5 = loaders.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ClassLoader classLoader = var4[var6];

         try {
            URL url = classLoader.getResource(resourceName);
            if (url != null) {
               String normalizedUrl = url.toExternalForm().substring(0, url.toExternalForm().lastIndexOf(aClass.getPackage().getName().replace(".", "/")));
               URL var10000 = new URL(normalizedUrl);
               return var10000;
            }
         } catch (MalformedURLException var10) {
            if (Reflections.log != null) {
               Reflections.log.warn("Could not get URL", var10);
            }
         }
      }

      return null;
   }

   public static Collection forClassLoader() {
      return forClassLoader(classLoaders());
   }

   public static Collection forClassLoader(ClassLoader... classLoaders) {
      Collection result = new ArrayList();
      ClassLoader[] loaders = classLoaders(classLoaders);
      ClassLoader[] var3 = loaders;
      int var4 = loaders.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         for(ClassLoader classLoader = var3[var5]; classLoader != null; classLoader = classLoader.getParent()) {
            if (classLoader instanceof URLClassLoader) {
               URL[] urls = ((URLClassLoader)classLoader).getURLs();
               if (urls != null) {
                  result.addAll(Arrays.asList(urls));
               }
            }
         }
      }

      return distinctUrls(result);
   }

   public static Collection forJavaClassPath() {
      Collection urls = new ArrayList();
      String javaClassPath = System.getProperty("java.class.path");
      if (javaClassPath != null) {
         String[] var2 = javaClassPath.split(File.pathSeparator);
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String path = var2[var4];

            try {
               urls.add((new File(path)).toURI().toURL());
            } catch (Exception var7) {
               if (Reflections.log != null) {
                  Reflections.log.warn("Could not get URL", var7);
               }
            }
         }
      }

      return distinctUrls(urls);
   }

   public static Collection forWebInfLib(ServletContext servletContext) {
      Collection urls = new ArrayList();
      Set resourcePaths = servletContext.getResourcePaths("/WEB-INF/lib");
      if (resourcePaths == null) {
         return urls;
      } else {
         Iterator var3 = resourcePaths.iterator();

         while(var3.hasNext()) {
            Object urlString = var3.next();

            try {
               urls.add(servletContext.getResource((String)urlString));
            } catch (MalformedURLException var6) {
            }
         }

         return distinctUrls(urls);
      }
   }

   public static URL forWebInfClasses(ServletContext servletContext) {
      try {
         String path = servletContext.getRealPath("/WEB-INF/classes");
         URL var10000;
         if (path == null) {
            var10000 = servletContext.getResource("/WEB-INF/classes");
            return var10000;
         }

         File file = new File(path);
         if (file.exists()) {
            var10000 = file.toURL();
            return var10000;
         }
      } catch (MalformedURLException var3) {
      }

      return null;
   }

   public static Collection forManifest() {
      return forManifest((Iterable)forClassLoader());
   }

   public static Collection forManifest(URL url) {
      Collection result = new ArrayList();
      result.add(url);

      try {
         String part = cleanPath(url);
         File jarFile = new File(part);
         JarFile myJar = new JarFile(part);
         URL validUrl = tryToGetValidUrl(jarFile.getPath(), (new File(part)).getParent(), part);
         if (validUrl != null) {
            result.add(validUrl);
         }

         Manifest manifest = myJar.getManifest();
         if (manifest != null) {
            String classPath = manifest.getMainAttributes().getValue(new Name("Class-Path"));
            if (classPath != null) {
               String[] var8 = classPath.split(" ");
               int var9 = var8.length;

               for(int var10 = 0; var10 < var9; ++var10) {
                  String jar = var8[var10];
                  validUrl = tryToGetValidUrl(jarFile.getPath(), (new File(part)).getParent(), jar);
                  if (validUrl != null) {
                     result.add(validUrl);
                  }
               }
            }
         }
      } catch (IOException var12) {
      }

      return distinctUrls(result);
   }

   public static Collection forManifest(Iterable urls) {
      Collection result = new ArrayList();
      Iterator var2 = urls.iterator();

      while(var2.hasNext()) {
         URL url = (URL)var2.next();
         result.addAll(forManifest(url));
      }

      return distinctUrls(result);
   }

   static URL tryToGetValidUrl(String workingDir, String path, String filename) {
      try {
         URL var10000;
         if ((new File(filename)).exists()) {
            var10000 = (new File(filename)).toURI().toURL();
            return var10000;
         }

         if ((new File(path + File.separator + filename)).exists()) {
            var10000 = (new File(path + File.separator + filename)).toURI().toURL();
            return var10000;
         }

         if ((new File(workingDir + File.separator + filename)).exists()) {
            var10000 = (new File(workingDir + File.separator + filename)).toURI().toURL();
            return var10000;
         }

         if ((new File((new URL(filename)).getFile())).exists()) {
            var10000 = (new File((new URL(filename)).getFile())).toURI().toURL();
            return var10000;
         }
      } catch (MalformedURLException var4) {
      }

      return null;
   }

   public static String cleanPath(URL url) {
      String path = url.getPath();

      try {
         path = URLDecoder.decode(path, "UTF-8");
      } catch (UnsupportedEncodingException var3) {
      }

      if (path.startsWith("jar:")) {
         path = path.substring("jar:".length());
      }

      if (path.startsWith("file:")) {
         path = path.substring("file:".length());
      }

      if (path.endsWith("!/")) {
         path = path.substring(0, path.lastIndexOf("!/")) + "/";
      }

      return path;
   }

   private static String resourceName(String name) {
      if (name != null) {
         String resourceName = name.replace(".", "/");
         resourceName = resourceName.replace("\\", "/");
         if (resourceName.startsWith("/")) {
            resourceName = resourceName.substring(1);
         }

         return resourceName;
      } else {
         return null;
      }
   }

   private static Collection distinctUrls(Collection urls) {
      Map distinct = new LinkedHashMap(urls.size());
      Iterator var2 = urls.iterator();

      while(var2.hasNext()) {
         URL url = (URL)var2.next();
         distinct.put(url.toExternalForm(), url);
      }

      return distinct.values();
   }
}
