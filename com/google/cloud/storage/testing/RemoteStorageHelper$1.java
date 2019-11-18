package com.google.cloud.storage.testing;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage$BlobField;
import com.google.cloud.storage.Storage$BlobListOption;
import com.google.cloud.storage.Storage$BucketListOption;
import java.util.Iterator;

final class RemoteStorageHelper$1 implements Runnable {
   // $FF: synthetic field
   final Storage val$storage;
   // $FF: synthetic field
   final long val$olderThan;

   RemoteStorageHelper$1(Storage var1, long var2) {
      this.val$storage = var1;
      this.val$olderThan = var2;
   }

   public void run() {
      Page buckets = this.val$storage.list(Storage$BucketListOption.prefix("gcloud-test-bucket-temp-"));
      Iterator var2 = buckets.iterateAll().iterator();

      label38:
      while(true) {
         Bucket bucket;
         do {
            if (!var2.hasNext()) {
               return;
            }

            bucket = (Bucket)var2.next();
         } while(bucket.getCreateTime() >= this.val$olderThan);

         try {
            Iterator var4 = bucket.list(Storage$BlobListOption.fields(Storage$BlobField.EVENT_BASED_HOLD, Storage$BlobField.TEMPORARY_HOLD)).iterateAll().iterator();

            while(true) {
               Blob blob;
               do {
                  if (!var4.hasNext()) {
                     RemoteStorageHelper.forceDelete(this.val$storage, bucket.getName());
                     continue label38;
                  }

                  blob = (Blob)var4.next();
               } while(!blob.getEventBasedHold() && !blob.getTemporaryHold());

               this.val$storage.update((BlobInfo)blob.toBuilder().setTemporaryHold(false).setEventBasedHold(false).build());
            }
         } catch (Exception var6) {
         }
      }
   }
}
