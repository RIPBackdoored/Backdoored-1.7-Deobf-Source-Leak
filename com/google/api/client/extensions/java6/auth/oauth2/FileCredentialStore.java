package com.google.api.client.extensions.java6.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.CredentialStore;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.FileDataStoreFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/** @deprecated */
@Deprecated
@Beta
public class FileCredentialStore implements CredentialStore {
   private static final Logger LOGGER = Logger.getLogger(FileCredentialStore.class.getName());
   private final JsonFactory jsonFactory;
   private final Lock lock = new ReentrantLock();
   private FilePersistedCredentials credentials = new FilePersistedCredentials();
   private final File file;
   private static final boolean IS_WINDOWS;

   public FileCredentialStore(File file, JsonFactory jsonFactory) throws IOException {
      this.file = (File)Preconditions.checkNotNull(file);
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
      File parentDir = file.getCanonicalFile().getParentFile();
      String var4;
      if (parentDir != null && !parentDir.exists() && !parentDir.mkdirs()) {
         var4 = String.valueOf(String.valueOf(parentDir));
         throw new IOException((new StringBuilder(35 + var4.length())).append("unable to create parent directory: ").append(var4).toString());
      } else if (this.isSymbolicLink(file)) {
         var4 = String.valueOf(String.valueOf(file));
         throw new IOException((new StringBuilder(31 + var4.length())).append("unable to use a symbolic link: ").append(var4).toString());
      } else {
         if (!file.createNewFile()) {
            this.loadCredentials(file);
         } else {
            if (!file.setReadable(false, false) || !file.setWritable(false, false) || !file.setExecutable(false, false)) {
               Logger var10000 = LOGGER;
               var4 = String.valueOf(String.valueOf(file));
               var10000.warning((new StringBuilder(49 + var4.length())).append("unable to change file permissions for everybody: ").append(var4).toString());
            }

            if (!file.setReadable(true) || !file.setWritable(true)) {
               var4 = String.valueOf(String.valueOf(file));
               throw new IOException((new StringBuilder(32 + var4.length())).append("unable to set file permissions: ").append(var4).toString());
            }

            this.save();
         }

      }
   }

   protected boolean isSymbolicLink(File file) throws IOException {
      if (IS_WINDOWS) {
         return false;
      } else {
         File canonical = file;
         if (file.getParent() != null) {
            canonical = new File(file.getParentFile().getCanonicalFile(), file.getName());
         }

         return !canonical.getCanonicalFile().equals(canonical.getAbsoluteFile());
      }
   }

   public void store(String userId, Credential credential) throws IOException {
      this.lock.lock();

      try {
         this.credentials.store(userId, credential);
         this.save();
      } finally {
         this.lock.unlock();
      }

   }

   public void delete(String userId, Credential credential) throws IOException {
      this.lock.lock();

      try {
         this.credentials.delete(userId);
         this.save();
      } finally {
         this.lock.unlock();
      }

   }

   public boolean load(String userId, Credential credential) {
      this.lock.lock();

      boolean var3;
      try {
         var3 = this.credentials.load(userId, credential);
      } finally {
         this.lock.unlock();
      }

      return var3;
   }

   private void loadCredentials(File file) throws IOException {
      FileInputStream is = new FileInputStream(file);

      try {
         this.credentials = (FilePersistedCredentials)this.jsonFactory.fromInputStream(is, FilePersistedCredentials.class);
      } finally {
         is.close();
      }

   }

   private void save() throws IOException {
      FileOutputStream fos = new FileOutputStream(this.file);

      try {
         JsonGenerator generator = this.jsonFactory.createJsonGenerator(fos, Charsets.UTF_8);
         generator.serialize(this.credentials);
         generator.close();
      } finally {
         fos.close();
      }

   }

   public final void migrateTo(FileDataStoreFactory dataStoreFactory) throws IOException {
      this.migrateTo(StoredCredential.getDefaultDataStore(dataStoreFactory));
   }

   public final void migrateTo(DataStore credentialDataStore) throws IOException {
      this.credentials.migrateTo(credentialDataStore);
   }

   static {
      IS_WINDOWS = File.separatorChar == '\\';
   }
}
