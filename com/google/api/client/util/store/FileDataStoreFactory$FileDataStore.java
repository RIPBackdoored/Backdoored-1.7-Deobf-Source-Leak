package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

class FileDataStoreFactory$FileDataStore extends AbstractMemoryDataStore {
   private final File dataFile;

   FileDataStoreFactory$FileDataStore(FileDataStoreFactory dataStore, File dataDirectory, String id) throws IOException {
      super(dataStore, id);
      this.dataFile = new File(dataDirectory, id);
      if (IOUtils.isSymbolicLink(this.dataFile)) {
         throw new IOException("unable to use a symbolic link: " + this.dataFile);
      } else {
         if (this.dataFile.createNewFile()) {
            this.keyValueMap = Maps.newHashMap();
            this.save();
         } else {
            this.keyValueMap = (HashMap)IOUtils.deserialize((InputStream)(new FileInputStream(this.dataFile)));
         }

      }
   }

   public void save() throws IOException {
      IOUtils.serialize(this.keyValueMap, new FileOutputStream(this.dataFile));
   }

   public FileDataStoreFactory getDataStoreFactory() {
      return (FileDataStoreFactory)super.getDataStoreFactory();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public DataStoreFactory getDataStoreFactory() {
      return this.getDataStoreFactory();
   }
}
