package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Throwables;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class FileDataStoreFactory extends AbstractDataStoreFactory {
   private static final Logger LOGGER = Logger.getLogger(FileDataStoreFactory.class.getName());
   private final File dataDirectory;

   public FileDataStoreFactory(File dataDirectory) throws IOException {
      dataDirectory = dataDirectory.getCanonicalFile();
      this.dataDirectory = dataDirectory;
      if (IOUtils.isSymbolicLink(dataDirectory)) {
         throw new IOException("unable to use a symbolic link: " + dataDirectory);
      } else if (!dataDirectory.exists() && !dataDirectory.mkdirs()) {
         throw new IOException("unable to create directory: " + dataDirectory);
      } else {
         setPermissionsToOwnerOnly(dataDirectory);
      }
   }

   public final File getDataDirectory() {
      return this.dataDirectory;
   }

   protected DataStore createDataStore(String id) throws IOException {
      return new FileDataStoreFactory$FileDataStore(this, this.dataDirectory, id);
   }

   static void setPermissionsToOwnerOnly(File file) throws IOException {
      try {
         Method setReadable = File.class.getMethod("setReadable", Boolean.TYPE, Boolean.TYPE);
         Method setWritable = File.class.getMethod("setWritable", Boolean.TYPE, Boolean.TYPE);
         Method setExecutable = File.class.getMethod("setExecutable", Boolean.TYPE, Boolean.TYPE);
         if (!(Boolean)setReadable.invoke(file, false, false) || !(Boolean)setWritable.invoke(file, false, false) || !(Boolean)setExecutable.invoke(file, false, false)) {
            LOGGER.warning("unable to change permissions for everybody: " + file);
         }

         if (!(Boolean)setReadable.invoke(file, true, true) || !(Boolean)setWritable.invoke(file, true, true) || !(Boolean)setExecutable.invoke(file, true, true)) {
            LOGGER.warning("unable to change permissions for owner: " + file);
         }
      } catch (InvocationTargetException var4) {
         Throwable cause = var4.getCause();
         Throwables.propagateIfPossible(cause, IOException.class);
         throw new RuntimeException(cause);
      } catch (NoSuchMethodException var5) {
         LOGGER.warning("Unable to set permissions for " + file + ", likely because you are running a version of Java prior to 1.6");
      } catch (SecurityException var6) {
      } catch (IllegalAccessException var7) {
      } catch (IllegalArgumentException var8) {
      }

   }
}
