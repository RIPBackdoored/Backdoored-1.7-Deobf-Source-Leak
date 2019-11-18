package com.google.cloud.storage.testing;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage$BlobListOption;
import com.google.cloud.storage.Storage$BlobSourceOption;
import com.google.cloud.storage.Storage$BucketSourceOption;
import com.google.cloud.storage.StorageException;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class RemoteStorageHelper$DeleteBucketTask implements Callable {
   private final Storage storage;
   private final String bucket;
   private final String userProject;

   public RemoteStorageHelper$DeleteBucketTask(Storage storage, String bucket) {
      this.storage = storage;
      this.bucket = bucket;
      this.userProject = "";
   }

   public RemoteStorageHelper$DeleteBucketTask(Storage storage, String bucket, String userProject) {
      this.storage = storage;
      this.bucket = bucket;
      this.userProject = userProject;
   }

   public Boolean call() {
      while(true) {
         ArrayList ids = new ArrayList();
         Page listedBlobs;
         if (Strings.isNullOrEmpty(this.userProject)) {
            listedBlobs = this.storage.list(this.bucket, Storage$BlobListOption.versions(true));
         } else {
            listedBlobs = this.storage.list(this.bucket, Storage$BlobListOption.versions(true), Storage$BlobListOption.userProject(this.userProject));
         }

         Iterator var3 = listedBlobs.getValues().iterator();

         while(var3.hasNext()) {
            BlobInfo info = (BlobInfo)var3.next();
            ids.add(info.getBlobId());
         }

         if (!ids.isEmpty()) {
            List results = this.storage.delete((Iterable)ids);
            if (!Strings.isNullOrEmpty(this.userProject)) {
               for(int i = 0; i < results.size(); ++i) {
                  if (!(Boolean)results.get(i)) {
                     this.storage.delete(this.bucket, ((BlobId)ids.get(i)).getName(), Storage$BlobSourceOption.userProject(this.userProject));
                  }
               }
            }
         }

         Boolean var10000;
         try {
            if (Strings.isNullOrEmpty(this.userProject)) {
               this.storage.delete(this.bucket);
            } else {
               this.storage.delete(this.bucket, Storage$BucketSourceOption.userProject(this.userProject));
            }

            var10000 = true;
         } catch (StorageException var6) {
            if (var6.getCode() == 409) {
               try {
                  Thread.sleep(500L);
                  continue;
               } catch (InterruptedException var5) {
                  Thread.currentThread().interrupt();
                  throw var6;
               }
            }

            throw var6;
         }

         return var10000;
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}
